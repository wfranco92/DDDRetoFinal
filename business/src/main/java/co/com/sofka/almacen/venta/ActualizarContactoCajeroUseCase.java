package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.command.ActualizarContactoCajero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarContactoCajeroUseCase extends UseCase<RequestCommand<ActualizarContactoCajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarContactoCajero> actualizarContactoCajeroRequestCommand) {
        var command = actualizarContactoCajeroRequestCommand.getCommand();
        var venta = Venta.from(
                command.getVentaId(), repository().getEventsBy(command.getVentaId().value())
        );
        venta.actualizarContactoCajero(command.getContacto());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
