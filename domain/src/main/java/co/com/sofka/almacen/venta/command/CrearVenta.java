package co.com.sofka.almacen.venta.command;

import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearVenta extends Command {
    private final TiendaId tiendaId;

    public CrearVenta(TiendaId tiendaId) {
        this.tiendaId = tiendaId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
