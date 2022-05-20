package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.CrearDespachador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearDespachadorUseCase extends UseCase<RequestCommand<CrearDespachador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearDespachador> crearDespachadorRequestCommand) {
        var command = crearDespachadorRequestCommand.getCommand();
        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.crearDespachador(command.getNombre(), command.getContacto());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
