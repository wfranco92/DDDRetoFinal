package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class finalizarVenta extends Command {

    private final VentaId ventaId;
    private final TiendaId tiendaId;

    public finalizarVenta(VentaId ventaId, TiendaId tiendaId) {
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
