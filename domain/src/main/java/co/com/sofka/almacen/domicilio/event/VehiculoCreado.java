package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.domicilio.values.Tipo;
import co.com.sofka.almacen.domicilio.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoCreado extends DomainEvent {
    private final Tipo tipo;
    private final VehiculoId vehiculoId;
    public VehiculoCreado(VehiculoId vehiculoId, Tipo tipo) {
        super("co.com.sofka.almacen.domicilio.VehiculoCreado");
        this.tipo = tipo;
        this.vehiculoId = vehiculoId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }
}
