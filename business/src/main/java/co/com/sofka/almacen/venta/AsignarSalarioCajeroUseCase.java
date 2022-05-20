package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.command.AsignarSalarioCajero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarSalarioCajeroUseCase extends UseCase<RequestCommand<AsignarSalarioCajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarSalarioCajero> asignarSalarioCajeroRequestCommand) {
        var command = asignarSalarioCajeroRequestCommand.getCommand();
        var venta = Venta.from(
                command.getVentaId(), repository().getEventsBy(command.getVentaId().value())
        );
        venta.asignarSalarioCajero(command.getSalario());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
