package co.com.sofka.almacen.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Salario implements ValueObject<Salario.Props> {

    private final String moneda;
    private final Double valor;

    public Salario(String moneda, Double valor) {
        this.moneda = moneda;
        this.valor = valor;
    }

    @Override
    public Props value() {
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
