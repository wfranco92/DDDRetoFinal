package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreProducto implements ValueObject<String > {

    private final String valor;

    public NombreProducto(String valor) {
        this.valor = valor;
    }

    @Override
    public String value() {
        return valor;
    }
}
