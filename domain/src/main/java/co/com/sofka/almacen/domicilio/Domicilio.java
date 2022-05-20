package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.generic.Factura;
import co.com.sofka.domain.generic.AggregateEvent;

public class Domicilio extends AggregateEvent<DomicilioId> {

    protected Mensajero mensajero;
    protected Vehiculo vehiculo;
    protected Pedido pedido;
    protected TiendaId tiendaId;
    protected Factura factura;

    public Domicilio(DomicilioId entityId, Pedido pedido, TiendaId tiendaId) {
        super(entityId);
        this.pedido = pedido;
        this.tiendaId = tiendaId;
    }
}
