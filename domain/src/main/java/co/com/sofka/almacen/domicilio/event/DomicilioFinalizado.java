package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DomicilioFinalizado extends DomainEvent {
    private DomicilioId domicilioId;
    private TiendaId tiendaId;

    public DomicilioFinalizado(DomicilioId domicilioId, TiendaId tiendaId) {
        super("co.com.sofka.almacen.domicilio.DomicilioFinalizado");
        this.domicilioId = domicilioId;
        this.tiendaId = tiendaId;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
