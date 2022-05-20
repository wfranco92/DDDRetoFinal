package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.CrearTienda;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearTiendaUseCase extends UseCase<RequestCommand<CrearTienda>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTienda> crearTiendaRequestCommand) {
        var command = crearTiendaRequestCommand.getCommand();
        var tienda = new Tienda(command.getTiendaId(), command.getNombreTienda());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
