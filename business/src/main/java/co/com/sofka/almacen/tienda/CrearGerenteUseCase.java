package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.CrearGerente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearGerenteUseCase extends UseCase<RequestCommand<CrearGerente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearGerente> crearGerenteRequestCommand) {
        var command = crearGerenteRequestCommand.getCommand();
        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.crearGerente(command.getNombre(), command.getContacto());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
