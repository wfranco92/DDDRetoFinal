package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.Mensajero;
import co.com.sofka.almacen.domicilio.Pedido;
import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearDomicilio extends Command {

    private final Pedido pedido;
    private final Mensajero mensajero;
    private final TiendaId tiendaId;
    private final DomicilioId domicilioId;

    public CrearDomicilio(Pedido pedido, Mensajero mensajero, TiendaId tiendaId, DomicilioId domicilioId) {
        this.pedido = pedido;
        this.mensajero = mensajero;
        this.tiendaId = tiendaId;
        this.domicilioId = domicilioId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }
}
