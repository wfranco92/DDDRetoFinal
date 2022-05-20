package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Precio.Props> {
    private final String moneda;
    private final Double valor;

    public Precio(String moneda, Double valor) {
        this.moneda = Objects.requireNonNull(moneda);
        this.valor = Objects.requireNonNull(valor);

        if(this.moneda.isBlank() || this.valor.isNaN()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public  Props value() {
        return new Props() {
            @Override
            public String moneda() {
                return moneda;
            }

            @Override
            public Double valor() {
                return valor;
            }
        };
    }

    public interface Props {
        String moneda();
        Double valor();
    }
}
