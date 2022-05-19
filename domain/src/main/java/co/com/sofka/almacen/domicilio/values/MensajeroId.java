package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.Identity;

public class MensajeroId extends Identity {
    public MensajeroId(String uuid) {
        super(uuid);
    }

    public static MensajeroId of(String id){
        return new MensajeroId(id);
    }
}
