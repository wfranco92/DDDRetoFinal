package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String tipo;

    public Tipo(String tipo) {
        this.tipo = Objects.requireNonNull(tipo);


        if(this.tipo.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public String value() {
        return tipo;
    }
}
