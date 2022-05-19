package co.com.sofka.almacen.venta.values;

import co.com.sofka.domain.generic.ValueObject;

public class Documento implements ValueObject<Documento.Props> {

    private final String tipo;
    private final String numero;


    public Documento(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
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
