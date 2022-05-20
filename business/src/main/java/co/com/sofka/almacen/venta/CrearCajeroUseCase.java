package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.command.CrearCajero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCajeroUseCase extends UseCase<RequestCommand<CrearCajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCajero> crearCajeroRequestCommand) {
        var command = crearCajeroRequestCommand.getCommand();
        var venta = Venta.from(
                command.getVentaId(), repository().getEventsBy(command.getVentaId().value())
        );
        venta.crearCajero(command.getNombre(), command.getContacto());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
