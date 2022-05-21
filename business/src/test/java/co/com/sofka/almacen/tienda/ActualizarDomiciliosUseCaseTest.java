package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.domicilio.event.DomicilioFinalizado;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.tienda.event.NumeroDomiciliosActualizados;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
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
class ActualizarDomiciliosUseCaseTest {

    @InjectMocks
    private ActualizarDomiciliosUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarDomiciliosHappyPass(){
        //arrange
        var event = new DomicilioFinalizado(new DomicilioId(), TiendaId.of("qqqq"));

        when(repository.getEventsBy("qqqq")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var e = (NumeroDomiciliosActualizados)events.get(0);
        Assertions.assertEquals(event.getDomicilioId().value(), e.getDomicilio());


    }
    private List<DomainEvent> history() {

        // se crea el historial de creacion de la tienda
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // se retorna el evento del historial
        return List.of(event);
    }

}