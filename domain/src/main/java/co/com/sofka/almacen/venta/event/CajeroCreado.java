package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.CajeroId;
import co.com.sofka.domain.generic.DomainEvent;

public class CajeroCreado extends DomainEvent {
    private final CajeroId cajeroId;
    private final Nombre nombre;
    private final Contacto contacto;

    public CajeroCreado(CajeroId cajeroId, Nombre nombre, Contacto contacto) {
        super("co.com.sofka.almacen.venta.CajeroCreado");
        this.cajeroId = cajeroId;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public CajeroId getCajeroId() {
        return cajeroId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
