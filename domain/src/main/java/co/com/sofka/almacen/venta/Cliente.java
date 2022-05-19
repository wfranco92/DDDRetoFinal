package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.ClienteId;
import co.com.sofka.almacen.venta.values.Documento;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {

    protected Nombre nombre;
    protected Documento documento;

    public Cliente(ClienteId entityId, Nombre nombre, Documento documento) {
        super(entityId);
        this.nombre = nombre;
        this.documento = documento;
    }

    public void actualizarInformacion(Nombre nombre, Documento documento){
        this.nombre = nombre;
        this.documento = documento;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Documento Documento() {
        return documento;
    }
}
