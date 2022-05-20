package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.AsignarCapacidadVehiculo;
import co.com.sofka.almacen.domicilio.command.AsignarSalarioMensajero;
import co.com.sofka.almacen.domicilio.command.CrearVehiculo;
import co.com.sofka.almacen.domicilio.event.CapacidadVehiculoAsignada;
import co.com.sofka.almacen.domicilio.event.DomicilioCreado;
import co.com.sofka.almacen.domicilio.event.SalarioMensajeroAsignado;
import co.com.sofka.almacen.domicilio.event.VehiculoCreado;
import co.com.sofka.almacen.domicilio.values.*;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarCapacidadVehiculoUseCaseTest {
    @InjectMocks
    private AsignarCapacidadVehiculoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarCapacidadVehiculoHappyPass(){
        //arrange
        DomicilioId domicilioId = DomicilioId.of("dddd");
        Capacidad capacidad = new Capacidad("Kg", 100D);
        var command = new AsignarCapacidadVehiculo(capacidad, domicilioId);

        when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDomicilioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CapacidadVehiculoAsignada)events.get(0);
        Assertions.assertEquals(command.getCapacidad(), event.getCapacidad());

    }

    private List<DomainEvent> history() {
        // debe existir una tienda creada
        NombreTienda nombre = new NombreTienda("AlmacenAristy");
        var event = new TiendaCreada(nombre);
        event.setAggregateRootId("xxxx");

        // debe existir un vehiculo creado para asignarle su capacidad
        VehiculoId vehiculoId = VehiculoId.of("vvvv");
        Tipo tipo = new Tipo("automovil");
        var event2 = new VehiculoCreado(vehiculoId, tipo);

        return List.of(event, event2);
    }
}