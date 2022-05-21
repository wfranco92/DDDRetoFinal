package co.com.sofka.almacen.domicilio.command;

import co.com.sofka.almacen.domicilio.values.DomicilioId;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class FinalizarDomicilio extends Command {

    private final DomicilioId domicilioId;
    private final TiendaId tiendaId;

    public FinalizarDomicilio(DomicilioId domicilioId, TiendaId tiendaId) {
        this.domicilioId = domicilioId;
        this.tiendaId = tiendaId;
    }

    public DomicilioId getDomicilioId() {
        return domicilioId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
