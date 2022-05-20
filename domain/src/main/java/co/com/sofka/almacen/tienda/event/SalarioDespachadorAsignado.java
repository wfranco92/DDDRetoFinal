package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.domain.generic.DomainEvent;

public class SalarioDespachadorAsignado extends DomainEvent {
    private final Salario salario;

    public SalarioDespachadorAsignado(Salario salario) {
        super("co.com.sofka.almacen.tienda.SalarioDespachadorAsignado");
        this.salario = salario;
    }

    public Salario getSalario() {
        return salario;
    }
}
