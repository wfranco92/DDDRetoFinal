package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.values.Capacidad;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.domicilio.values.Tipo;
import co.com.sofka.domain.generic.Command;

public class CrearVehiculo extends Command {

    private final Tipo tipo;
    private final DomicilioId domicilioId;

    public CrearVehiculo(Tipo tipo, DomicilioId domicilioId) {
        this.tipo = tipo;
        this.domicilioId = domicilioId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }
}
