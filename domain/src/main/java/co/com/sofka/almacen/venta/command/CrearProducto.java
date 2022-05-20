package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.venta.values.Descripcion;
import co.com.sofka.almacen.venta.values.NombreProducto;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CrearProducto extends Command {

    private final NombreProducto nombre;
    private final Descripcion descripcion;
    private final VentaId ventaId;

    public CrearProducto(NombreProducto nombre, Descripcion descripcion, VentaId ventaId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ventaId = ventaId;
    }

    public NombreProducto getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
