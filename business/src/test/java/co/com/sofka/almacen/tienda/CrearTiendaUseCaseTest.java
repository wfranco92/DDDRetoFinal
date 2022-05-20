package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.CrearTienda;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CrearTiendaUseCaseTest {

    private CrearTiendaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearTiendaUseCase();
    }

    @Test
    public void crearTiendaHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("qwerty");
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var command = new CrearTienda( tiendaId,  nombre);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var tiendaCreada = (TiendaCreada)events.get(0);
        Assertions.assertEquals("qwerty", tiendaCreada.aggregateRootId());
        Assertions.assertEquals("AlmacenAristy", tiendaCreada.getNombreTienda().value());

    }

}