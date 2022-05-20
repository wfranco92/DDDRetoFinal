package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.ActualizarContactoMensajer;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarContactoMensajeroUseCase extends UseCase<RequestCommand<ActualizarContactoMensajer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarContactoMensajer> actualizarContactoMensajerRequestCommand) {
        var command = actualizarContactoMensajerRequestCommand.getCommand();
        var domicilio = Domicilio.from(
                command.getDomicilioId(), repository().getEventsBy(command.getDomicilioId().value())
        );
        domicilio.actualizarContactoMensajero(command.getContacto());
        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
