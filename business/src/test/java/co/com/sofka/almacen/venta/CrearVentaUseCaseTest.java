package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.command.CrearVenta;
import co.com.sofka.almacen.venta.event.VentaCreada;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearVentaUseCaseTest {

    private CrearVentaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearVentaUseCase();
    }

    @Test
    public void crearVentaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("zxcvb");
        TiendaId tiendaId = TiendaId.of("qwerty");
        var command = new CrearVenta( ventaId,  tiendaId);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var ventaCreada = (VentaCreada)events.get(0);
        Assertions.assertEquals("zxcvb", ventaCreada.aggregateRootId());
        Assertions.assertEquals("qwerty", ventaCreada.getTiendaId().value());

    }

}