package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.values.Descripcion;
import co.com.sofka.almacen.venta.values.FacturaId;
import co.com.sofka.almacen.venta.values.Fecha;
import co.com.sofka.almacen.venta.values.Precio;
import co.com.sofka.domain.generic.Entity;

public class Factura extends Entity<FacturaId> {

    protected Fecha fecha;
    protected Descripcion descripcion;
    protected Precio PrecioTotal;

    public Factura(FacturaId entityId, Fecha fecha, Descripcion descripcion, Precio precioTotal) {
        super(entityId);
        this.fecha = fecha;
        this.descripcion = descripcion;
        PrecioTotal = precioTotal;
    }
}
