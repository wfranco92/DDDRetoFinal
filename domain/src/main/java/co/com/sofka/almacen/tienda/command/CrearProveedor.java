package co.com.sofka.almacen.tienda.command;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.tienda.values.ProveedorId;
import co.com.sofka.almacen.tienda.values.RazonSocial;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public class CrearProveedor extends Command {
    private final TiendaId tiendaId;
    private final RazonSocial razonSocial;
    private final Contacto contacto;


    public CrearProveedor(TiendaId tiendaId, RazonSocial razonSocial, Contacto contacto) {
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
