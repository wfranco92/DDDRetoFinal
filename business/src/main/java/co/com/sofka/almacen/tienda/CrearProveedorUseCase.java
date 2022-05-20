package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.CrearProveedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearProveedorUseCase extends UseCase<RequestCommand<CrearProveedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearProveedor> crearProveedorRequestCommand) {
        var command = crearProveedorRequestCommand.getCommand();
        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.crearProveedor(command.getRazonSocial(), command.getContacto());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
