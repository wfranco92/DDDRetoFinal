package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.values.GerenteId;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Gerente extends Entity<GerenteId> {

    protected Nombre nombre;
    protected Contacto contacto;

    public Gerente(GerenteId entityId, Nombre nombre, Contacto contacto) {
        super(entityId);
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Contacto Contacto() {
        return contacto;
    }
}
