package co.com.sofka.almacen.generic;

import co.com.sofka.almacen.venta.values.Descripcion;
import co.com.sofka.almacen.venta.values.Fecha;
import co.com.sofka.almacen.venta.values.Precio;
import co.com.sofka.domain.generic.ValueObject;

public class Factura implements ValueObject<Factura.Props> {

    private final Fecha fecha;
    private final Descripcion descripcion;
    private final Precio PrecioTotal;

    public Factura(Fecha fecha, Descripcion descripcion, Precio precioTotal) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        PrecioTotal = precioTotal;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Fecha fecha() {
                return fecha;
            }

            @Override
            public Descripcion descripcion() {
                return descripcion;
            }

            @Override
            public Precio PrecioTotal() {
                return PrecioTotal;
            }
        };
    }

    public interface Props {
        Fecha fecha();
        Descripcion descripcion();
        Precio PrecioTotal();
    }
}
