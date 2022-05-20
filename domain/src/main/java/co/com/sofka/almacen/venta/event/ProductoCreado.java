package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.venta.values.Descripcion;
import co.com.sofka.almacen.venta.values.NombreProducto;
import co.com.sofka.almacen.venta.values.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ProductoCreado extends DomainEvent {
    private ProductoId productoId;
    private NombreProducto nombre;
    private Descripcion descripcion;

    public ProductoCreado(ProductoId productoId, NombreProducto nombre, Descripcion descripcion) {
        super("co.com.sofka.almacen.venta.ProductoCreado");
        this.productoId = productoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public NombreProducto getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
