package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.command.AsignarSalarioDespachador;
import co.com.sofka.almacen.tienda.command.CrearDespachador;
import co.com.sofka.almacen.tienda.event.DespachadorCreado;
import co.com.sofka.almacen.tienda.event.SalarioDespachadorAsignado;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.DespachadorId;
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
class AsignarSalarioDespachadorUseCaseTest {
    @InjectMocks
    private AsignarSalarioDespachadorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void asignarSalarioDespachadorHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("tttt");
        Salario salario = new Salario("COP", 2000D);
        var command = new AsignarSalarioDespachador(salario, tiendaId);

        when(repository.getEventsBy("tttt")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SalarioDespachadorAsignado)events.get(0);
        Assertions.assertEquals(command.getSalario(), event.getSalario());


    }
    private List<DomainEvent> history() {

        // se crea el historial de creacion de la tienda
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // se crea el historial de creacion del despachador
        DespachadorId despachadorId = DespachadorId.of("tttt");
        Contacto contacto = new Contacto("Bogota", "0987654", "despachador@gmail.com");
        Nombre nombredespachador = new Nombre("Despachador", "Bodega-Pedidos");
        var event2 = new DespachadorCreado(despachadorId, nombredespachador,  contacto);

        // se retornan ambos eventos del historial
        return List.of(event, event2);
    }


}