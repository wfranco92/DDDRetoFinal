package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RazonSocial implements ValueObject<RazonSocial.Props> {

    private final String tipo;
    private final String value;

    public RazonSocial(String tipo, String value) {
        this.tipo = Objects.requireNonNull(tipo);
        this.value = Objects.requireNonNull(value);

        if(this.tipo.isBlank() || this.value.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipo() {
                return tipo;
            }

            @Override
            public String value() {
                return value;
            }
        };
    }

    public interface Props {
        String tipo();
        String value();
    }
}
