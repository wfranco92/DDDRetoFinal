package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.venta.values.Precio;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class AsignarPrecioProducto extends Command {
    private final Precio precio;
    private final VentaId ventaId;

    public AsignarPrecioProducto(Precio precio, VentaId ventaId) {
        this.precio = precio;
        this.ventaId = ventaId;
    }

    public Precio getPrecio() {
        return precio;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
