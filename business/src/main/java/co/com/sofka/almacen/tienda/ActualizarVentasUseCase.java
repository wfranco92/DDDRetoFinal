package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.venta.event.VentaFinalizada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarVentasUseCase extends UseCase<TriggeredEvent<VentaFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<VentaFinalizada> ventaFinalizadaTriggeredEvent) {
        var event = ventaFinalizadaTriggeredEvent.getDomainEvent();
        var tienda = Tienda.from(event.getTiendaId(), repository().getEventsBy(event.getTiendaId().value()));

        tienda.actualizarNumeroVentas(event.getVentaId().value());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
