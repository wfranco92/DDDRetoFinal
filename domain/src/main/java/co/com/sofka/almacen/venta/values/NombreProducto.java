package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreProducto implements ValueObject<String > {

    private final String valor;

    public NombreProducto(String valor) {
        this.valor = Objects.requireNonNull(valor);
        if(this.valor.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public String value() {
        return valor;
    }
}
