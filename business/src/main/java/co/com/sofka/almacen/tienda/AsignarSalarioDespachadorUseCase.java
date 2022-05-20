package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.command.AsignarSalarioDespachador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarSalarioDespachadorUseCase extends UseCase<RequestCommand<AsignarSalarioDespachador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarSalarioDespachador> asignarSalarioDespachadorRequestCommand) {
        var command = asignarSalarioDespachadorRequestCommand.getCommand();
        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.asignarSalarioDespachador(command.getSalario());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
