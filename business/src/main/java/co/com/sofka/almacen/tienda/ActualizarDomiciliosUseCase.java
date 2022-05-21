package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.domicilio.event.DomicilioFinalizado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarDomiciliosUseCase extends UseCase<TriggeredEvent<DomicilioFinalizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DomicilioFinalizado> domicilioFinalizadoTriggeredEvent) {
        var event = domicilioFinalizadoTriggeredEvent.getDomainEvent();
        var tienda = Tienda.from(event.getTiendaId(), repository().getEventsBy(event.getTiendaId().value()));

        tienda.actualizarNumeroDomicilios(event.getDomicilioId().value());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
