package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.domain.generic.DomainEvent;

public class SalarioAsignadoCajero extends DomainEvent {
    private final Salario salario;

    public SalarioAsignadoCajero(Salario salario) {
        super("co.com.sofka.almacen.venta.SalarioAsignadoCajero");
        this.salario = salario;
    }

    public Salario getSalario() {
        return salario;
    }
}
