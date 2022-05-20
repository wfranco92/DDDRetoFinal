package co.com.sofka.almacen.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<Nombre.Props> {
    private final String nombres;
    private final String apellidos;

    public Nombre(String nombres, String apellidos) {
        this.nombres = Objects.requireNonNull(nombres);
        this.apellidos = Objects.requireNonNull(apellidos);

        if(this.nombres.isBlank() || this.apellidos.isBlank() ){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombres() {
                return nombres;
            }

            @Override
            public String apellidos() {
                return apellidos;
            }
        };
    }
    public interface Props {
        String nombres();
        String apellidos();
    }
}
