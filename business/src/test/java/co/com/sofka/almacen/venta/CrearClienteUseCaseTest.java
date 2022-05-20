package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.command.CrearCliente;
import co.com.sofka.almacen.venta.event.ClienteCreado;
import co.com.sofka.almacen.venta.event.ProductoCreado;
import co.com.sofka.almacen.venta.event.VentaCreada;
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
class CrearClienteUseCaseTest {
    @InjectMocks
    private CrearClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarProductoHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("vvvv");
        Nombre nombre = new Nombre("alex", "Char");
        Documento documento = new Documento("CC", "123456");
        var command = new CrearCliente(nombre, documento,  ventaId);

        when(repository.getEventsBy("vvvv")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getVentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClienteCreado)events.get(0);
        Assertions.assertEquals(command.getDocumento(), event.getDocumento());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        TiendaId tiendaId = TiendaId.of("qwerty");
        var event2 = new VentaCreada(tiendaId);

        return List.of(event, event2);
    }


}