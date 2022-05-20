package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.command.ActualizarContactoGerente;
import co.com.sofka.almacen.tienda.command.AsignarSalarioDespachador;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarContactoGerenteUseCaseTest {

    @InjectMocks
    private ActualizarContactoGerenteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarCOntactoGerenteHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("tttt");
        Contacto contactoNew = new Contacto("Bogota", "111111111", "GerenteNew@gmail.com");
        var command = new ActualizarContactoGerente(contactoNew, tiendaId);

        when(repository.getEventsBy("tttt")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ContactoGerenteActualizado)events.get(0);
        Assertions.assertEquals(command.getContacto(), event.getContacto());


    }
    private List<DomainEvent> history() {

        // se crea el historial de creacion de la tienda
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // se crea el historial de creacion del despachador
        GerenteId gerenteId = GerenteId.of("tttt");
        Nombre nombregerente = new Nombre("Boss", "Mayor");
        Contacto contacto = new Contacto("Bogota", "1111111", "gerente@gmail.com");
        var event2 = new GerenteCreado(gerenteId, nombregerente,  contacto);

        // se retornan ambos eventos del historial
        return List.of(event, event2);
    }

}