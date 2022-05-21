package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.event.TiendaCreada;
import co.com.sofka.almacen.venta.event.*;
import co.com.sofka.almacen.venta.values.Documento;
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
            venta.cajero.nombre = (Nombre) event.getNombre().value();
            venta.cajero.contacto = event.getContacto();
        });

        apply((ClienteCreado event) -> {
            venta.cliente.nombre = (Nombre) event.getNombre().value();
            venta.cliente.documento = event.getDocumento();
        });

        apply((ProductoCreado event) -> {
            var producto = new Producto(event.getProductoId(), event.getNombre(), event.getDescripcion());
            venta.productos.add(producto);
        });

        apply((SalarioAsignadoCajero event) -> {
            venta.cajero.asignarSalario((Salario) event.getSalario().value());
        });

        apply((ContactoActualizadoCajero event) -> {
            venta.cajero.actualizarContacto((Contacto) event.getContacto().value());
        });

        apply((InformacionActualizadaCliente event) -> {
            venta.cliente.actualizarInformacion((Nombre) event.getNombre().value(), (Documento) event.getDocumento().value());
        });

        apply((VentaFinalizada event) -> {
        });

    }
}
