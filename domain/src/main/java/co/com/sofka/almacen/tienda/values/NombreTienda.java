package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreTienda implements ValueObject<String> {

    private final String valor;

    public NombreTienda(String valor) {
        this.valor = Objects.requireNonNull(valor);
        if (this.valor.isBlank() || this.valor.isEmpty()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public String value() {
        return valor;
    }
}
