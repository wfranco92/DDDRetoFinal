package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoProveedorActualizado extends DomainEvent {
    private final Contacto contacto;

    public ContactoProveedorActualizado(Contacto contacto) {
        super("co.com.sofka.almacen.tienda.ContactoProveedorActualizado");
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
