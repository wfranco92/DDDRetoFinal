package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.values.RazonSocial;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearProveedor extends Command {

    private final RazonSocial razonSocial;
    private final Contacto contacto;
    private final TiendaId tiendaId;

    public CrearProveedor(RazonSocial razonSocial, Contacto contacto, TiendaId tiendaId) {
        this.razonSocial = razonSocial;
        this.contacto = contacto;
        this.tiendaId = tiendaId;
    }

    public RazonSocial getRazonSocial() {
        return razonSocial;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
