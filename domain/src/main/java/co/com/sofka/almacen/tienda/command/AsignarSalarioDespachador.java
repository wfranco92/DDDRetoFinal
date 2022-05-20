package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class AsignarSalarioDespachador extends Command {
    private final Salario salario;
    private final TiendaId tiendaId;

    public AsignarSalarioDespachador(Salario salario, TiendaId tiendaId) {
        this.salario = salario;
        this.tiendaId = tiendaId;
    }

    public Salario getSalario() {
        return salario;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
