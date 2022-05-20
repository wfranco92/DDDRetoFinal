package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.command.AsignarDireccionPedido;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarDireccionPedidoUseCase extends UseCase<RequestCommand<AsignarDireccionPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarDireccionPedido> asignarDireccionPedidoRequestCommand) {
        var command = asignarDireccionPedidoRequestCommand.getCommand();
        var domicilio = Domicilio.from(
                command.getDomicilioId(), repository().getEventsBy(command.getDomicilioId().value())
        );
        domicilio.asignarDireccionPedido(command.getDireccion());
        emit().onResponse(new ResponseEvents(domicilio.getUncommittedChanges()));
    }
}
