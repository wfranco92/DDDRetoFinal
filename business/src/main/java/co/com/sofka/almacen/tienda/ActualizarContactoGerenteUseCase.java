package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.ActualizarContactoGerente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarContactoGerenteUseCase extends UseCase<RequestCommand<ActualizarContactoGerente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarContactoGerente> actualizarContactoGerenteRequestCommand) {
        var command = actualizarContactoGerenteRequestCommand.getCommand();
        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.actualizarContactoGerente( command.getContacto());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
