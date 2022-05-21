package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.event.NumeroVentasActualizadas;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.event.VentaFinalizada;
import co.com.sofka.almacen.venta.values.VentaId;
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
class ActualizarVentasUseCaseTest {

    @InjectMocks
    private ActualizarVentasUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarVentasHappyPass(){
        //arrange
        var event = new VentaFinalizada(new VentaId(), TiendaId.of("qqqq"));

        when(repository.getEventsBy("qqqq")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var e = (NumeroVentasActualizadas)events.get(0);
        Assertions.assertEquals(event.getVentaId().value(), e.getVentas());


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