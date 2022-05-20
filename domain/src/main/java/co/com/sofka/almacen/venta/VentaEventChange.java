package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.venta.event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;
import java.util.HashSet;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {
        apply((VentaCreada event) -> {
            venta.tiendaId = event.getTiendaId();
            venta.productos = new ArrayList<>();
        });

        apply((CajeroCreado event) -> {
            venta.cajero.nombre = event.getNombre();
            venta.cajero.contacto = event.getContacto();
        });

        apply((ClienteCreado event) -> {
            venta.cliente.nombre = event.getNombre();
            venta.cliente.documento = event.getDocumento();
        });

        apply((ProductoCreado event) -> {
            var producto = new Producto(event.getProductoId(), event.getNombre(), event.getDescripcion());
            venta.productos.add(producto);
        });

        apply((SalarioAsignadoCajero event) -> {
            venta.cajero.asignarSalario(event.getSalario());
        });

        apply((ContactoActualizadoCajero event) -> {
            venta.cajero.actualizarContacto(event.getContacto());
        });

        apply((InformacionActualizadaCliente event) -> {
            venta.cliente.actualizarInformacion(event.getNombre(), event.getDocumento());
        });

    }
}
