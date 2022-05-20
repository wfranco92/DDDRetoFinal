package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.domicilio.values.Capacidad;
import co.com.sofka.almacen.domicilio.values.Tipo;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoCreado extends DomainEvent {
    private final Tipo tipo;
    private final Capacidad capacidad;

    public VehiculoCreado(Tipo tipo, Capacidad capacidad) {
        super("co.com.sofka.almacen.domicilio.VehiculoCreado");
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
