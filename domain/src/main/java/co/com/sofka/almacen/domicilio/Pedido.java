package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.values.Direccion;
import co.com.sofka.almacen.domicilio.values.NombreCliente;
import co.com.sofka.almacen.domicilio.values.PedidoId;
import co.com.sofka.almacen.domicilio.values.Peso;
import co.com.sofka.domain.generic.Entity;

public class Pedido extends Entity<PedidoId> {

    protected NombreCliente nombreCliente;
    protected Direccion direccion;
    protected Peso peso;

    public Pedido(PedidoId entityId, NombreCliente nombreCliente) {
        super(entityId);
        this.nombreCliente = nombreCliente;
    }

    public void asignarPeso(Peso peso){
        this.peso = peso;
    }

    public NombreCliente NombreCliente() {
        return nombreCliente;
    }

    public Direccion Direccion() {
        return direccion;
    }

    public Peso Peso() {
        return peso;
    }
}
