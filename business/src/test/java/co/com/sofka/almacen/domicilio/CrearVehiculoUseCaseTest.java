package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.CrearVehiculo;
import co.com.sofka.almacen.domicilio.event.DomicilioCreado;
import co.com.sofka.almacen.domicilio.event.VehiculoCreado;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearVehiculoUseCaseTest {

    @InjectMocks
    private CrearVehiculoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearVehiculoHappyPass(){
        //arrange
        DomicilioId domicilioId = DomicilioId.of("dddd");
        Tipo tipo = new Tipo("automovil");
        var command = new CrearVehiculo(tipo,  domicilioId);

        when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDomicilioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (VehiculoCreado)events.get(0);
        Assertions.assertEquals("automovil", event.getTipo().value());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        TiendaId tiendaId = TiendaId.of("qwerty");
        Pedido pedido = new Pedido(new PedidoId("123"), new NombreCliente("Cliente"));
        Mensajero mensajero = new Mensajero(new MensajeroId("1"), new Nombre("carlos", "sanchez"),
                new Contacto("Bogota", "12313", "correo@correo.com"));
        var event2 = new DomicilioCreado(pedido, tiendaId, mensajero);

        return List.of(event, event2);
    }

}