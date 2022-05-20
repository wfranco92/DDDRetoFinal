package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoGerenteActualizado extends DomainEvent {
    private final Contacto contacto;
    public ContactoGerenteActualizado(Contacto contacto) {

        super("co.com.sofka.almacen.tienda.ContactoGerenteActualizado");
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
