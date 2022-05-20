package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.domicilio.Mensajero;
import co.com.sofka.almacen.domicilio.Pedido;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DomicilioCreado extends DomainEvent {
    private final Pedido pedido;
    private final Mensajero mensajero;
    private final TiendaId tiendaId;

    public DomicilioCreado(Pedido pedido, TiendaId tiendaId, Mensajero mensajero) {
        super("co.com.sofka.almacen.domicilio.DomicilioCreado");
        this.pedido = pedido;
        this.mensajero = mensajero;
        this.tiendaId = tiendaId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }
}
