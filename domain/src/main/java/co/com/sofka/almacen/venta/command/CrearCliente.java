package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.Documento;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CrearCliente extends Command {

    private final Nombre nombre;
    private final Documento documento;
    private final VentaId ventaId;

    public CrearCliente(Nombre nombre, Documento documento, VentaId ventaId) {
        this.nombre = nombre;
        this.documento = documento;
        this.ventaId = ventaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Documento getDocumento() {
        return documento;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
