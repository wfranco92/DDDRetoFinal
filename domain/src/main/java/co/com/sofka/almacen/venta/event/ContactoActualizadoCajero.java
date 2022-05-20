package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoActualizadoCajero extends DomainEvent {
    private final Contacto contacto;

    public ContactoActualizadoCajero(Contacto contacto) {
        super("co.com.sofka.almacen.venta.ContactoActualizadoCajero");
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
