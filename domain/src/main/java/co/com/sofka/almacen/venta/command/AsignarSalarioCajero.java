package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class AsignarSalarioCajero extends Command {

    private final Salario salario;
    private final VentaId ventaId;

    public AsignarSalarioCajero(Salario salario, VentaId ventaId) {
        this.salario = salario;
        this.ventaId = ventaId;
    }

    public Salario getSalario() {
        return salario;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
