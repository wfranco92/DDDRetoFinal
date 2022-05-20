package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class TiendaEventChange extends EventChange {
    public TiendaEventChange(Tienda tienda) {
        apply((TiendaCreada event) -> {
            tienda.nombreTienda = event.getNombreTienda();
            tienda.proveedor = new HashSet<>();
        });

        apply((ProveedorCreado event) -> {
          var proveedor = new Proveedor(event.getProveedorId(), event.getRazonSocial(), event.getContacto());
          tienda.proveedor.add(proveedor);
        });

        apply((GerenteCreado event) -> {
            tienda.gerente.nombre = event.getNombre();
            tienda.gerente.contacto = event.getContacto();
        });

        apply((DespachadorCreado event) -> {
            tienda.despachador.nombre= event.getNombre();
            tienda.despachador.contacto = event.getContacto();
        });

        apply((ContactoGerenteActualizado event) -> {
            tienda.gerente.actualizarContacto(event.getContacto());
        });

        apply((SalarioDespachadorAsignado event) -> {
            tienda.despachador.asignarSalario(event.getSalario());
        });

        apply((ContactoDespachadorActualizado event) -> {
            tienda.despachador.actualizarContacto(event.getContacto());
        });

    }
}
