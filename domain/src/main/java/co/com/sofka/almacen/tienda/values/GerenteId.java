package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.Identity;

public class GerenteId extends Identity {
    public GerenteId(String id) {
        super(id);
    }

    public static GerenteId of(String id){
        return  new GerenteId(id);
    }
}
