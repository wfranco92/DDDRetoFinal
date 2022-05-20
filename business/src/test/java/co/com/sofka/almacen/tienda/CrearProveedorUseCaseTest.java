package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.command.CrearProveedor;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearProveedorUseCaseTest {


    @InjectMocks
    private CrearProveedorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarProveedorHappyPass(){
        //arrange
        TiendaId tiendaId = TiendaId.of("tttt");
        RazonSocial razonSocial = new RazonSocial("NIT", "12345-1");
        Contacto contacto = new Contacto("Bogota", "37603453", "correo@gmail.com");
        var command = new CrearProveedor(tiendaId, razonSocial,  contacto);

        when(repository.getEventsBy("tttt")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProveedorCreado)events.get(0);
        Assertions.assertEquals(command.getRazonSocial(), event.getRazonSocial());

    }

    private List<DomainEvent> history() {

        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }


}