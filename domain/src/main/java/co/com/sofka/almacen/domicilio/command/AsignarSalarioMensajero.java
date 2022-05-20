package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.domain.generic.Command;

public class AsignarSalarioMensajero extends Command {

    private final Salario salario;
    private final DomicilioId domicilioId;

    public AsignarSalarioMensajero(Salario salario, DomicilioId domicilioId) {
        this.salario = salario;
        this.domicilioId = domicilioId;
    }

    public Salario getSalario() {
        return salario;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }
}
