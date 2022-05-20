package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.command.CrearDespachador;
import co.com.sofka.almacen.tienda.command.CrearProveedor;
import co.com.sofka.almacen.tienda.event.DespachadorCreado;
import co.com.sofka.almacen.tienda.event.ProveedorCreado;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.RazonSocial;
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
class CrearDespachadorUseCaseTest {

    @InjectMocks
    private CrearDespachadorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDespachadorHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("tttt");
        Contacto contacto = new Contacto("Bogota", "0987654", "despachador@gmail.com");
        Nombre nombre = new Nombre("Despachador", "Bodega-Pedidos");
        var command = new CrearDespachador(tiendaId, contacto,  nombre);

        when(repository.getEventsBy("tttt")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DespachadorCreado)events.get(0);
        Assertions.assertEquals(command.getNombre(), event.getNombre());
        Assertions.assertEquals(command.getContacto(), event.getContacto());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}