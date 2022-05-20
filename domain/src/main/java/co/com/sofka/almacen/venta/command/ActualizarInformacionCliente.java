package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.Documento;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarInformacionCliente extends Command {
    private final VentaId ventaId;
    private final Nombre nombre;
    private final Documento documento;


    public ActualizarInformacionCliente(VentaId ventaId, Nombre nombre, Documento documento) {
        this.ventaId = ventaId;
        this.nombre = nombre;
        this.documento = documento;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Documento getDocumento() {
        return documento;
    }
}
