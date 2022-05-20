package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearDespachador extends Command {
    private final Contacto contacto;
    private final Nombre nombre;
    private final TiendaId tiendaId;

    public CrearDespachador(Contacto contacto, Nombre nombre, TiendaId tiendaId) {
        this.contacto = contacto;
        this.nombre = nombre;
        this.tiendaId = tiendaId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Nombre getNombre() {
        return nombre;
    }


    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
