package co.com.sofka.almacen.tienda.values;

import co.com.sofka.domain.generic.ValueObject;

public class RazonSocial implements ValueObject<RazonSocial.Props> {

    private final String tipo;
    private final String value;

    public RazonSocial(String tipo, String value) {
        this.tipo = tipo;
        this.value = value;
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
