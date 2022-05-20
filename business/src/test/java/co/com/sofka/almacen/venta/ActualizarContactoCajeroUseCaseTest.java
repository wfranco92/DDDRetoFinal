package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.command.ActualizarContactoCajero;
import co.com.sofka.almacen.venta.event.CajeroCreado;
import co.com.sofka.almacen.venta.event.ContactoActualizadoCajero;
import co.com.sofka.almacen.venta.event.VentaCreada;
import co.com.sofka.almacen.venta.values.CajeroId;
import co.com.sofka.almacen.venta.values.VentaId;
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
class ActualizarContactoCajeroUseCaseTest {
    @InjectMocks
    private ActualizarContactoCajeroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarContactoCajeroHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("vvvv");
        Contacto contacto = new Contacto("Bogota", "122131212", "nuevocorreo@gmail.com");
        var command = new ActualizarContactoCajero(contacto, ventaId);

        when(repository.getEventsBy("vvvv")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getVentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ContactoActualizadoCajero)events.get(0);
        Assertions.assertEquals(command.getContacto(), event.getContacto());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        TiendaId tiendaId = TiendaId.of("qwerty");
        var event2 = new VentaCreada(tiendaId);

        CajeroId cajeroId = CajeroId.of("vvvv");
        Nombre nombrecajero = new Nombre("alex", "Char");
        Contacto contacto = new Contacto("Bogota", "3213211232", "correo@gmail.com");
        var event3 = new CajeroCreado(cajeroId, nombrecajero, contacto );

        return List.of(event, event2, event3);
    }
}