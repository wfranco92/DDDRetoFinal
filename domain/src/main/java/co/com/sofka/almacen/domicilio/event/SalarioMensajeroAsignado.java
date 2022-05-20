package co.com.sofka.almacen.domicilio.event;

import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.domain.generic.DomainEvent;

public class SalarioMensajeroAsignado extends DomainEvent {
    private final Salario salario;

    public SalarioMensajeroAsignado(Salario salario) {
        super("co.com.sofka.almacen.domicilio.SalarioMensajeroAsignado");
        this.salario = salario;
    }

    public Salario getSalario() {
        return salario;
    }
}
