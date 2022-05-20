package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.AsignarCapacidadVehiculo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarCapacidadVehiculoUseCase extends UseCase<RequestCommand<AsignarCapacidadVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarCapacidadVehiculo> asignarCapacidadVehiculoRequestCommand) {
        var command = asignarCapacidadVehiculoRequestCommand.getCommand();
        var domicilio = Domicilio.from(
                command.getDomicilioId(), repository().getEventsBy(command.getDomicilioId().value())
        );
        domicilio.asignarCapacidadVehiculo(command.getCapacidad());
        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
