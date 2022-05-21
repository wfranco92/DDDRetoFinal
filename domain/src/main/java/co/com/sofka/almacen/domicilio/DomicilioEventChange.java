package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.event.*;
import co.com.sofka.almacen.venta.event.VentaCreada;
import co.com.sofka.almacen.venta.event.VentaFinalizada;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class DomicilioEventChange extends EventChange {
    public DomicilioEventChange(Domicilio domicilio) {

        apply((DomicilioCreado event) -> {
            domicilio.tiendaId = event.getTiendaId();
            domicilio.mensajero = event.getMensajero();
            domicilio.pedido = event.getPedido();
        });

        apply((VehiculoCreado event) -> {
            domicilio.vehiculo = new Vehiculo(event.getVehiculoId(), event.getTipo());
        });

        apply((ContactoMensajeroActualizado event) -> {
            domicilio.mensajero.actualizarContacto(event.getContacto());
        });

        apply((SalarioMensajeroAsignado event) -> {
            domicilio.mensajero.asignarSalario(event.getSalario());
        });

        apply((CapacidadVehiculoAsignada event) -> {
            domicilio.vehiculo.asignarCapacidad(event.getCapacidad());
        });

        apply((DireccionPedidoActualizada event) -> {
            domicilio.pedido.asignarDireccion(event.getDireccion());
        });

        apply((DomicilioFinalizado event) -> {
        });
    }
}
