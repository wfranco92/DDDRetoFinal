package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoDespachadorActualizado extends DomainEvent {
    private final Contacto contacto;

    public ContactoDespachadorActualizado(Contacto contacto) {
        super("co.com.sofka.almacen.tienda.ContactoDespachadorActualizado");
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
