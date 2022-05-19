package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

public class Capacidad implements ValueObject<Capacidad.Props> {

    private final String unidad;
    private final Double valor;

    public Capacidad(String unidad, Double valor) {
        this.unidad = unidad;
        this.valor = valor;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String unidad() {
                return unidad;
            }

            @Override
            public Double valor() {
                return valor;
            }
        };
    }

    public interface Props {
        String unidad();
        Double valor();
    }
}
