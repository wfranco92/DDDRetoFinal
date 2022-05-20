package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearGerente extends Command {

    private final Nombre nombre;
    private final Contacto contacto;
    private final TiendaId tiendaId;

    public CrearGerente(TiendaId tiendaId, Nombre nombre, Contacto contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.tiendaId = tiendaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
