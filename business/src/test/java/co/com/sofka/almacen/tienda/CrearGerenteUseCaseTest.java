package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.command.CrearGerente;
import co.com.sofka.almacen.tienda.event.GerenteCreado;
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
class CrearGerenteUseCaseTest {

    @InjectMocks
    private CrearGerenteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarGerenteHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("tttt");
        Nombre nombre = new Nombre("Boss", "Mayor");
        Contacto contacto = new Contacto("Bogota", "1111111", "gerente@gmail.com");
        var command = new CrearGerente(tiendaId, nombre, contacto);

        when(repository.getEventsBy("tttt")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (GerenteCreado)events.get(0);
        Assertions.assertEquals(command.getNombre(), event.getNombre());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}