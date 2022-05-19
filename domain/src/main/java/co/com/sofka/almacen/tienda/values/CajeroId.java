package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.Identity;

public class CajeroId extends Identity {
    public CajeroId(String id) {
        super(id);
    }

    public static CajeroId of(String id){
        return new CajeroId(id);
    }
}
