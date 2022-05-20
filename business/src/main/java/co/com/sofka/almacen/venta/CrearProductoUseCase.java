package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.command.CrearProducto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearProductoUseCase extends UseCase<RequestCommand<CrearProducto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearProducto> crearProductoRequestCommand) {
        var command = crearProductoRequestCommand.getCommand();
        var venta = Venta.from(
                command.getVentaId(), repository().getEventsBy(command.getVentaId().value())
        );
        venta.crearProducto(command.getNombre(), command.getDescripcion());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
