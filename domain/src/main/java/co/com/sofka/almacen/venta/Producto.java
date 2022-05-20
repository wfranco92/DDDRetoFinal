package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.Descripcion;
import co.com.sofka.almacen.venta.values.NombreProducto;
import co.com.sofka.almacen.venta.values.Precio;
import co.com.sofka.almacen.venta.values.ProductoId;
import co.com.sofka.domain.generic.Entity;

public class Producto extends Entity<ProductoId> {

    protected NombreProducto nombre;
    protected Descripcion descripcion;
    protected Precio precio;

    public Producto(ProductoId entityId, NombreProducto nombre, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void asignarPrecio(Precio precio){
        this.precio = precio;
    }

    public NombreProducto Nombre() {
        return nombre;
    }

    public Descripcion Descripcion() {
        return descripcion;
    }

    public Precio Precio() {
        return precio;
    }
}
