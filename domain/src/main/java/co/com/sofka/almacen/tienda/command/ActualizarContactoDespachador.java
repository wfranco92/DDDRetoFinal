package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarContactoDespachador extends Command {

    private final Contacto contacto;
    private final TiendaId tiendaId;

    public ActualizarContactoDespachador(Contacto contacto, TiendaId tiendaId) {
        this.contacto = contacto;
        this.tiendaId = tiendaId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
