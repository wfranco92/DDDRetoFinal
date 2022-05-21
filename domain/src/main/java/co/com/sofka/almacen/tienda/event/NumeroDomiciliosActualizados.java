package co.com.sofka.almacen.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;

public class NumeroDomiciliosActualizados extends DomainEvent {
    private String domicilio;

    public NumeroDomiciliosActualizados(String domicilio) {
        super("co.com.sofka.almacen.tienda.NumeroDomiciliosActualizados");
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }
}
