package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.domain.generic.Command;

public class ActualizarContactoMensajer extends Command {

    private final Contacto contacto;
    private final DomicilioId domicilioId;

    public ActualizarContactoMensajer(Contacto contacto, DomicilioId domicilioId) {
        this.contacto = contacto;
        this.domicilioId = domicilioId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }
}
