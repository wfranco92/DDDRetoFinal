package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreCliente implements ValueObject<String> {

    private final String valor;


    public NombreCliente(String valor) {
        this.valor = valor;
    }

    @Override
    public String value() {
        return valor;
    }
}
