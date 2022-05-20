package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearTienda extends Command{

    private final TiendaId tiendaId;
    private final NombreTienda nombreTienda;

    public CrearTienda(TiendaId tiendaId, NombreTienda nombreTienda) {
        this.tiendaId = tiendaId;
        this.nombreTienda = nombreTienda;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public NombreTienda getNombreTienda() {
        return nombreTienda;
    }
}
