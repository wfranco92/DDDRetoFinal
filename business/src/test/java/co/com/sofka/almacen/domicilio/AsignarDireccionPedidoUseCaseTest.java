package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.ActualizarContactoMensajer;
import co.com.sofka.almacen.domicilio.command.AsignarDireccionPedido;
import co.com.sofka.almacen.domicilio.event.ContactoMensajeroActualizado;
import co.com.sofka.almacen.domicilio.event.DireccionPedidoActualizada;
import co.com.sofka.almacen.domicilio.event.DomicilioCreado;
import co.com.sofka.almacen.domicilio.values.*;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarDireccionPedidoUseCaseTest {

    @InjectMocks
    private AsignarDireccionPedidoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarDireccionPedidoHappyPass(){
        //arrange
        DomicilioId domicilioId = DomicilioId.of("dddd");
        Direccion direccion = new Direccion("Bogota", "barrio centro");
        var command = new AsignarDireccionPedido(direccion, domicilioId);

        when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDomicilioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DireccionPedidoActualizada)events.get(0);
        Assertions.assertEquals(command.getDireccion(), event.getDireccion());

    }

    private List<DomainEvent> history() {
        // debe existir una tienda creada
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // debe existir un domicilio creado el cual ya trae el pedido creado para poder actualizarlo
        TiendaId tiendaId = TiendaId.of("qwert");
        Pedido pedido = new Pedido(new PedidoId("qqqq"),new NombreCliente("cliente"));
        Mensajero mensajero = new Mensajero(
                new MensajeroId("zzzz"),
                new Nombre("alfredo", "Parra"),
                new Contacto("calle 5", "3102234356", "corre@gmail.com"));
        var event2 = new DomicilioCreado(pedido, tiendaId, mensajero);

        return List.of(event, event2);
    }

}