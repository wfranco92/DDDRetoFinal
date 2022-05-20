package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoMensajeroActualizado extends DomainEvent {
    private final Contacto contacto;

    public ContactoMensajeroActualizado(Contacto contacto) {
        super("co.com.sofka.almacen.domicilio.ContactoMensajeroActualizado");
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
