package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacidad implements ValueObject<Capacidad.Props> {

    private final String unidad;
    private final Double valor;

    public Capacidad(String unidad, Double valor) {
        this.unidad = Objects.requireNonNull(unidad);
        this.valor = Objects.requireNonNull(valor);

        if(this.unidad.isBlank() || this.valor.isNaN()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
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
