package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreTienda implements ValueObject<String> {

    private final String valor;

    public NombreTienda(String valor) {
        this.valor = valor;
    }

    @Override
    public String value() {
        return valor;
    }
}
