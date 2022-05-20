package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.Identity;

public class ProveedorId extends Identity {
    public ProveedorId(String id) {
        super(id);
    }
    public static ProveedorId of(String id){
        return new ProveedorId(id);
    }

    public ProveedorId(){}
}
