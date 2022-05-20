package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.Identity;

public class DespachadorId extends Identity {
    public DespachadorId(String id) {
        super(id);
    }
    public DespachadorId(){}
    public static DespachadorId of(String id){
        return new DespachadorId(id);
    }
}
