package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.AsignarSalarioMensajero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarSalarioMensajeroUseCase extends UseCase<RequestCommand<AsignarSalarioMensajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarSalarioMensajero> asignarSalarioMensajeroRequestCommand) {
        var command = asignarSalarioMensajeroRequestCommand.getCommand();
        var domicilio = Domicilio.from(
                command.getDomicilioId(), repository().getEventsBy(command.getDomicilioId().value())
        );
        domicilio.asignarSalarioMensajero(command.getSalario());
        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
