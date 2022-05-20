package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.tienda.values.DespachadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class DespachadorCreado extends DomainEvent {
    private DespachadorId despachadorId;
    private Nombre nombre;
    private Contacto contacto;

    public DespachadorCreado(DespachadorId despachadorId, Nombre nombre, Contacto contacto) {
        super("co.com.sofka.almacen.tienda.DespachadorCreado");
        this.despachadorId = despachadorId;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public DespachadorId getDespachadorId() {
        return despachadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
