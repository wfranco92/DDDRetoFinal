package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.command.ActualizarInformacionCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarInformacionClienteUseCase extends UseCase<RequestCommand<ActualizarInformacionCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarInformacionCliente> actualizarInformacionClienteRequestCommand) {
        var command = actualizarInformacionClienteRequestCommand.getCommand();
        var venta = Venta.from(
                command.getVentaId(), repository().getEventsBy(command.getVentaId().value())
        );
        venta.actualizarInformacionCliente(command.getNombre(), command.getDocumento());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
