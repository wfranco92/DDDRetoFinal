package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.values.ProveedorId;
import co.com.sofka.almacen.tienda.values.RazonSocial;
import co.com.sofka.domain.generic.Entity;

public class Proveedor extends Entity<ProveedorId> {

    protected RazonSocial razonSocial;
    protected Contacto contacto;
    public Proveedor(ProveedorId entityId, RazonSocial razonSocial, Contacto contacto) {
        super(entityId);
        this.razonSocial = razonSocial;
        this.contacto = contacto;
    }
    public void actualizarContacto(Contacto contacto){
        this.contacto = contacto;
    }
    public RazonSocial RazonSocial() {
        return razonSocial;
    }
    public Contacto Contacto() {
        return contacto;
    }
}
