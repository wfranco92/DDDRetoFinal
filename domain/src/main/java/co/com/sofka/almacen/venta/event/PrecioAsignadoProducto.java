package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.venta.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class PrecioAsignadoProducto extends DomainEvent {
    private final Precio precio;

    public PrecioAsignadoProducto(Precio precio) {
        super("co.com.sofka.almacen.venta.PrecioAsignadoProducto");
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
