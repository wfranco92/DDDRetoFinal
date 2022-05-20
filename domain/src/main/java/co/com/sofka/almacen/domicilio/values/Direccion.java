package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Props> {

    private final String ciudad;
    private final String direccion;


    public Direccion(String ciudad, String direccion) {
        this.ciudad = Objects.requireNonNull(ciudad);
        this.direccion = Objects.requireNonNull(direccion);

        if(this.ciudad.isBlank() || this.direccion.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String ciudad() {
                return ciudad;
            }

            @Override
            public String direccion() {
                return direccion;
            }
        };
    }


    public interface Props {
        String ciudad();
        String direccion();
    }


}
