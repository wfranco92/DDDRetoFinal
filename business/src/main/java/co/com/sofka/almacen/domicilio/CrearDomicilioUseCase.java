package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.CrearDomicilio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearDomicilioUseCase extends UseCase<RequestCommand<CrearDomicilio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearDomicilio> crearDomicilioRequestCommand) {
        var command = crearDomicilioRequestCommand.getCommand();
        var domicilio = new Domicilio(command.getDomicilioId(), command.getPedido(), command.getTiendaId(), command.getMensajero());
        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
