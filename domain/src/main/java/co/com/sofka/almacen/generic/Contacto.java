package co.com.sofka.almacen.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Contacto implements ValueObject<Contacto.Props> {

    private final String direccion;
    private final String telefono;
    private final String email;

    public Contacto(String direccion, String telefono, String email) {
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.email = Objects.requireNonNull(email);


        if(this.direccion.isBlank() || this.telefono.isBlank() || this.email.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public String telefono() {
                return telefono;
            }

            @Override
            public String email() {
                return email;
            }
        };
    }

    public interface Props {
        String direccion();
        String telefono();
        String email();
    }
}
