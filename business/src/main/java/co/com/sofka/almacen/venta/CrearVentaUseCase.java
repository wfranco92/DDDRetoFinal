package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.command.CrearVenta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVenta> crearVentaRequestCommand) {
        var command = crearVentaRequestCommand.getCommand();
        var venta = new Venta(command.getVentaId(), command.getTiendaId());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
