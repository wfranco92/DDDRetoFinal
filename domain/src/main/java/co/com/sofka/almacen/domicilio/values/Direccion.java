package co.com.sofka.almacen.domicilio.values;

import co.com.sofka.domain.generic.ValueObject;

public class Direccion implements ValueObject<Direccion.Props> {

    private final String ciudad;
    private final String direccion;


    public Direccion(String ciudad, String direccion) {
        this.ciudad = ciudad;
        this.direccion = direccion;
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
