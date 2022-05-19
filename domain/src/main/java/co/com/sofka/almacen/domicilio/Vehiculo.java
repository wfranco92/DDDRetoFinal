package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.values.Capacidad;
import co.com.sofka.almacen.domicilio.values.Tipo;
import co.com.sofka.almacen.domicilio.values.VehiculoId;
import co.com.sofka.domain.generic.Entity;

public class Vehiculo extends Entity<VehiculoId> {

    protected Tipo Tipo;
    protected Capacidad capacidad;

    public Vehiculo(VehiculoId entityId, Tipo tipo) {
        super(entityId);
        Tipo = tipo;
        this.capacidad = capacidad;
    }

    public Tipo Tipo() {
        return Tipo;
    }

    public Capacidad Capacidad() {
        return capacidad;
    }

    public void agregarCapacidad(Capacidad capacidad){
        this.capacidad = capacidad;
    }
}
