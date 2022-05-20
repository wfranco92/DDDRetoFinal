package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.AsignarSalarioMensajero;
import co.com.sofka.almacen.domicilio.event.DomicilioCreado;
import co.com.sofka.almacen.domicilio.event.SalarioMensajeroAsignado;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.domicilio.values.MensajeroId;
import co.com.sofka.almacen.domicilio.values.NombreCliente;
import co.com.sofka.almacen.domicilio.values.PedidoId;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarSalarioMensajeroUseCaseTest {
    @InjectMocks
    private AsignarSalarioMensajeroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarSalarioMensajeroHappyPass(){
        //arrange
        DomicilioId domicilioId = DomicilioId.of("dddd");
        Salario salario = new Salario("COP", 2000D);
        var command = new AsignarSalarioMensajero(salario, domicilioId);

        when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDomicilioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SalarioMensajeroAsignado)events.get(0);
        Assertions.assertEquals(command.getSalario(), event.getSalario());

    }

    private List<DomainEvent> history() {
        // debe existir una tienda creada
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // debe existir un domicilio creado el cual ya trae el mensajero creadao para poder asignarle salario
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