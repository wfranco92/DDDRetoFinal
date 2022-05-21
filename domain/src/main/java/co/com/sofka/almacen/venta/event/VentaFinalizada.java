package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaFinalizada extends DomainEvent {
    private final VentaId ventaId;
    private final TiendaId tiendaId;
    public VentaFinalizada(VentaId ventaId, TiendaId tiendaId) {
        super("co.com.sofka.almacen.venta.VentaFinalizada");
        this.ventaId = ventaId;
        this.tiendaId = tiendaId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

}
