package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CrearCajero extends Command {

    private final Nombre nombre;
    private final Contacto contacto;
    private final VentaId ventaId;

    public CrearCajero(Nombre nombre, Contacto contacto, VentaId ventaId) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.ventaId = ventaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
