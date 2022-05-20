package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Documento implements ValueObject<Documento.Props> {

    private final String tipo;
    private final String numero;


    public Documento(String tipo, String numero) {
        this.tipo = Objects.requireNonNull(tipo);
        this.numero = Objects.requireNonNull(numero);

        if(this.tipo.isBlank() || this.numero.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio o en blanco");
        }
    }

    @Override
    public Documento.Props value() {
        return new Props() {
            @Override
            public String tipo() {
                return tipo;
            }

            @Override
            public String numero() {
                return numero;
            }
        };
    }


    public interface Props {
        String tipo();
        String numero();
    }
}
