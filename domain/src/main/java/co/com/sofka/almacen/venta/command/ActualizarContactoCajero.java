package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarContactoCajero extends Command {

    private final Contacto contacto;
    private final VentaId ventaId;

    public ActualizarContactoCajero(Contacto contacto, VentaId ventaId) {
        this.contacto = contacto;
        this.ventaId = ventaId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
