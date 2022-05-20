package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final TiendaId tiendaId;

    public VentaCreada(TiendaId tiendaId) {
        super("co.com.sofka.almacen.venta.VentaCreada");
        this.tiendaId = tiendaId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
