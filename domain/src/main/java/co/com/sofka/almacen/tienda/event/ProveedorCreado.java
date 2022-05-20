package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.values.ProveedorId;
import co.com.sofka.almacen.tienda.values.RazonSocial;
import co.com.sofka.domain.generic.DomainEvent;

public class ProveedorCreado extends DomainEvent {
    private final ProveedorId proveedorId;
    private final RazonSocial razonSocial;
    private final Contacto contacto;

    public ProveedorCreado(ProveedorId proveedorId, RazonSocial razonSocial, Contacto contacto) {
        super("co.com.sofka.almacen.tienda.ProveedorAgregado");
        this.proveedorId = proveedorId;
        this.razonSocial = razonSocial;
        this.contacto = contacto;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public RazonSocial getRazonSocial() {
        return razonSocial;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
