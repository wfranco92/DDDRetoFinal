package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.values.Capacidad;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.domain.generic.Command;

public class AsignarCapacidadVehiculo extends Command {
    private final Capacidad capacidad;
    private final DomicilioId domicilioId;

    public AsignarCapacidadVehiculo(Capacidad capacidad, DomicilioId domicilioId) {
        this.capacidad = capacidad;
        this.domicilioId = domicilioId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }
}
