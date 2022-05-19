package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.values.ProveedorId;
import co.com.sofka.domain.generic.Entity;

public class Proveedor extends Entity<ProveedorId> {
    public Proveedor(ProveedorId entityId) {
        super(entityId);
    }
}
