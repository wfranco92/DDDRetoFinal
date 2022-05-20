package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.domicilio.values.Direccion;
import co.com.sofka.domain.generic.DomainEvent;

public class DireccionPedidoActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionPedidoActualizada(Direccion direccion) {
        super("co.com.sofka.almacen.domicilio.DireccionPedidoActualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
