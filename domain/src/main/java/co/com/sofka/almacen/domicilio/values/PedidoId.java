package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.almacen.domicilio.Pedido;
import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {
    public PedidoId(String id) {
        super(id);
    }
    public static PedidoId of(String id){
        return new PedidoId(id);
    }
}
