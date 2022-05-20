package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.CrearDomicilio;
import co.com.sofka.almacen.domicilio.event.DomicilioCreado;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.domicilio.values.MensajeroId;
import co.com.sofka.almacen.domicilio.values.NombreCliente;
import co.com.sofka.almacen.domicilio.values.PedidoId;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearDomicilioUseCaseTest {

    private CrearDomicilioUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearDomicilioUseCase();
    }

    @Test
    public void crearDomicilioHappyPass(){
        //arrange
        DomicilioId domicilioId = DomicilioId.of("qwert");
        Pedido pedido = new Pedido(new PedidoId("qqqq"),new NombreCliente("cliente"));
        Mensajero mensajero = new Mensajero(
                new MensajeroId("zzzz"),
                new Nombre("alfredo", "Parra"),
                new Contacto("calle 5", "3102234356", "corre@gmail.com"));
        TiendaId tiendaId = TiendaId.of("asdf");
        var command = new CrearDomicilio(domicilioId, pedido, mensajero, tiendaId);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var domicilio= (DomicilioCreado)events.get(0);
        Assertions.assertEquals(command.getDomicilioId().value(), domicilio.aggregateRootId());
        Assertions.assertEquals(command.getMensajero(), domicilio.getMensajero());

    }

}