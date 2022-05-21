package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;
import java.util.HashSet;

public class TiendaEventChange extends EventChange {
    public TiendaEventChange(Tienda tienda) {
        apply((TiendaCreada event) -> {
            tienda.nombreTienda = event.getNombreTienda();
            tienda.proveedor = new HashSet<>();
            tienda.ventas = new ArrayList<>();
            tienda.domicilios = new ArrayList<>();
        });

        apply((ProveedorCreado event) -> {
          var proveedor = new Proveedor(event.getProveedorId(), event.getRazonSocial(), event.getContacto());
          tienda.proveedor.add(proveedor);
        });

        apply((GerenteCreado event) -> {
            tienda.gerente.nombre = (Nombre) event.getNombre().value();
            tienda.gerente.contacto = event.getContacto();
        });

        apply((DespachadorCreado event) -> {
            tienda.despachador.nombre= (Nombre) event.getNombre().value();
            tienda.despachador.contacto = event.getContacto();
        });

        apply((ContactoGerenteActualizado event) -> {
            tienda.gerente.actualizarContacto((Contacto) event.getContacto().value());
        });

        apply((SalarioDespachadorAsignado event) -> {
            tienda.despachador.asignarSalario((Salario) event.getSalario().value());
        });

        apply((ContactoDespachadorActualizado event) -> {
            tienda.despachador.actualizarContacto((Contacto) event.getContacto().value());
        });

        apply((NumeroVentasActualizadas event) -> {
            tienda.ventas.add(event.getVentas());
        });

        apply((NumeroDomiciliosActualizados event) -> {
            tienda.domicilios.add(event.getDomicilio());
        });

    }
}
