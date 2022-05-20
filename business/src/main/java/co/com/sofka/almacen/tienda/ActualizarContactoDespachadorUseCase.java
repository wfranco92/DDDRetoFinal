package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.ActualizarContactoDespachador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarContactoDespachadorUseCase extends UseCase<RequestCommand<ActualizarContactoDespachador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarContactoDespachador> actualizarContactoDespachadorRequestCommand) {
        var command = actualizarContactoDespachadorRequestCommand.getCommand();
        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.actualizarContactoDespachador( command.getContacto());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
