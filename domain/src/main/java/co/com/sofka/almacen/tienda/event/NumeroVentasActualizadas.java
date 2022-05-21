package co.com.sofka.almacen.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class NumeroVentasActualizadas extends DomainEvent {
    private String ventas;

    public NumeroVentasActualizadas(String ventas) {
        super("o.com.sofka.almacen.tienda.NumeroVentasActualizadas");
        this.ventas = ventas;
    }
    public String getVentas() {
        return ventas;
    }
}
