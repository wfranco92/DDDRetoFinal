package co.com.sofka.almacen.tienda.event;

import co.com.sofka.almacen.tienda.values.NombreTienda;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.DomainEvent;

public class TiendaCreada extends DomainEvent {

    private final NombreTienda nombreTienda;

    public TiendaCreada(NombreTienda nombreTienda) {
        super("co.com.sofka.almacen.tienda.TiendaCreada");
        this.nombreTienda = nombreTienda;
    }

    public NombreTienda getNombreTienda() {
        return nombreTienda;
    }

}
