package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

public class Precio implements ValueObject<Precio.Props> {
    private final String moneda;
    private final Double valor;

    public Precio(String moneda, Double valor) {
        this.moneda = moneda;
        this.valor = valor;
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
