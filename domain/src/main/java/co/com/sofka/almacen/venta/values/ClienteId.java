package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {

    public ClienteId(String uuid) {
        super(uuid);
    }

    public static ClienteId of(String id){
        return new ClienteId(id);
    }
}
