package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class Tienda extends AggregateEvent<TiendaId> {

    protected Gerente gerente;
    protected Despachador despachador;
    protected Set<Proveedor> proveedors;

    public Tienda(TiendaId entityId) {
        super(entityId);
    }
}
