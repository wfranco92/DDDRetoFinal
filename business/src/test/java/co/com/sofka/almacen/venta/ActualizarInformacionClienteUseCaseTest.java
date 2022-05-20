package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.command.ActualizarInformacionCliente;
import co.com.sofka.almacen.venta.command.AsignarSalarioCajero;
import co.com.sofka.almacen.venta.event.*;
import co.com.sofka.almacen.venta.values.CajeroId;
import co.com.sofka.almacen.venta.values.ClienteId;
import co.com.sofka.almacen.venta.values.Documento;
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
class ActualizarInformacionClienteUseCaseTest {

    @InjectMocks
    private ActualizarInformacionClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarSalarioCajeroHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("vvvv");
        Nombre nombre = new Nombre("nombrecliente", "apellido");
        Documento documento = new Documento("TI", "7654321");
        var command = new ActualizarInformacionCliente(ventaId, nombre, documento);

        when(repository.getEventsBy("vvvv")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getVentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (InformacionActualizadaCliente)events.get(0);
        Assertions.assertEquals(command.getDocumento(), event.getDocumento());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        TiendaId tiendaId = TiendaId.of("qwerty");
        var event2 = new VentaCreada(tiendaId);

        ClienteId clienteId = ClienteId.of("vvvv");
        Nombre nombrecliente = new Nombre("alex", "Char");
        Documento documento = new Documento("CC", "1234231");
        var event3 = new ClienteCreado(clienteId, nombrecliente, documento );

        return List.of(event, event2, event3);
    }
}