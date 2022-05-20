package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.values.GerenteId;
import co.com.sofka.domain.generic.DomainEvent;

public class GerenteCreado extends DomainEvent {
    private GerenteId gerenteId;
    private Nombre nombre;
    private Contacto contacto;

    public GerenteCreado(GerenteId gerenteId, Nombre nombre, Contacto contacto) {
        super("co.com.sofka.almacen.tienda.GerenteCreado");
        this.gerenteId = gerenteId;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public GerenteId getGerenteId() {
        return gerenteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
