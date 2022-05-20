package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.values.Direccion;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.domain.generic.Command;

public class AsignarDireccionPedido extends Command {

    private final Direccion direccion;
    private final DomicilioId domicilioId;

    public AsignarDireccionPedido(Direccion direccion, DomicilioId domicilioId) {
        this.direccion = direccion;
        this.domicilioId = domicilioId;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }
}
