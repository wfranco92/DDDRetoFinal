package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.domicilio.values.Capacidad;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadVehiculoAsignada extends DomainEvent {
    private final Capacidad capacidad;

    public CapacidadVehiculoAsignada(Capacidad capacidad) {
        super("co.com.sofka.almacen.domicilio.CapacidadVehiculoAsignada");
        this.capacidad = capacidad;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
