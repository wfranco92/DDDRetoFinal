package co.com.sofka.almacen.venta.event;

import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.venta.values.ClienteId;
import co.com.sofka.almacen.venta.values.Documento;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteCreado extends DomainEvent {
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Documento documento;

    public ClienteCreado(ClienteId clienteId, Nombre nombre, Documento documento) {
        super("co.com.sofka.almacen.venta.ClienteCreado");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.documento = documento;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Documento getDocumento() {
        return documento;
    }
}
