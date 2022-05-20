package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.Documento;
import co.com.sofka.domain.generic.DomainEvent;

public class InformacionActualizadaCliente extends DomainEvent {
    private final Nombre nombre;
    private final Documento documento;

    public InformacionActualizadaCliente(Nombre nombre, Documento documento) {
        super("co.com.sofka.almacen.venta.InformacionActualizadaCliente");
        this.nombre = nombre;
        this.documento = documento;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Documento getDocumento() {
        return documento;
    }
}
