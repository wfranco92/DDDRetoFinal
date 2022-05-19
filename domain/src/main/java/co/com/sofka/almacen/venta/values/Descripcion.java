package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<String> {

    private final String valor;

    public Descripcion(String valor) {
        this.valor = valor;
    }

    @Override
    public String value() {
        return valor;
    }
}
