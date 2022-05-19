package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Venta extends AggregateEvent<VentaId> {
    protected Cliente cliente;
    protected List<Producto> productos;
    protected Factura factura;
    public Venta(VentaId entityId) {
        super(entityId);
    }
}
