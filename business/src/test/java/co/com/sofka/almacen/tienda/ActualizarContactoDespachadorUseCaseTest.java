package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.command.ActualizarContactoDespachador;
import co.com.sofka.almacen.tienda.command.ActualizarContactoGerente;
import co.com.sofka.almacen.tienda.event.*;
import co.com.sofka.almacen.tienda.values.DespachadorId;
import co.com.sofka.almacen.tienda.values.GerenteId;
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
class ActualizarContactoDespachadorUseCaseTest {

    @InjectMocks
    private ActualizarContactoDespachadorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarContactoDespachadorHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("tttt");
        Contacto contactoNew = new Contacto("Bogota", "0987654321", "DespachosNew@gmail.com");
        var command = new ActualizarContactoDespachador(contactoNew, tiendaId);

        when(repository.getEventsBy("tttt")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ContactoDespachadorActualizado)events.get(0);
        Assertions.assertEquals(command.getContacto(), event.getContacto());


    }
    private List<DomainEvent> history() {

        // se crea el historial de creacion de la tienda
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // se crea el historial de creacion del despachador
        DespachadorId despachadorId = DespachadorId.of("qqqq");
        Nombre nombredespacho= new Nombre("Despachador", "Bodega");
        Contacto contacto = new Contacto("Bogota", "1111111", "Despachos@gmail.com");
        var event2 = new DespachadorCreado(despachadorId, nombredespacho,  contacto);

        // se retornan ambos eventos del historial
        return List.of(event, event2);
    }
}