package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.CrearVehiculo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearVehiculoUseCase extends UseCase<RequestCommand<CrearVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVehiculo> crearVehiculoRequestCommand) {
        var command = crearVehiculoRequestCommand.getCommand();
        var domicilio = Domicilio.from(
                command.getDomicilioId(), repository().getEventsBy(command.getDomicilioId().value())
        );
        domicilio.crearVehiculo(command.getTipo());
        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
