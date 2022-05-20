package co.com.sofka.almacen.domicilio;

import co.com.sofka.almacen.domicilio.event.*;
import co.com.sofka.almacen.domicilio.values.*;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.generic.Factura;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Domicilio extends AggregateEvent<DomicilioId> {

    protected Mensajero mensajero;
    protected Vehiculo vehiculo;
    protected Pedido pedido;
    protected TiendaId tiendaId;
    protected Factura factura;

    public Domicilio(DomicilioId entityId, Pedido pedido, TiendaId tiendaId, Mensajero mensajero) {
        super(entityId);
        appendChange(new DomicilioCreado(pedido, tiendaId, mensajero)).apply();
        subscribe(new DomicilioEventChange(this));
    }

    private Domicilio(DomicilioId entityId){
        super(entityId);
        subscribe(new DomicilioEventChange(this));
    }

    public static Domicilio from(DomicilioId entityId, List<DomainEvent> events){
        var domicilio = new Domicilio(entityId);
        events.forEach(domicilio::applyEvent);
        return domicilio;
    }

    public void crearVehiculo(Tipo tipo){
        var vehiculoId = new VehiculoId();
        appendChange(new VehiculoCreado(vehiculoId, tipo)).apply();
    }
    public void actualizarContactoMensajero(Contacto contacto){
        appendChange(new ContactoMensajeroActualizado(contacto)).apply();
    }

    public void asignarSalarioMensajero(Salario salario){
        appendChange(new SalarioMensajeroAsignado(salario)).apply();
    }

    public void asignarCapacidadVehiculo(Capacidad capacidad){
        appendChange(new CapacidadVehiculoAsignada(capacidad)).apply();
    }

    public void asignarDireccionPedido(Direccion direccion){
        appendChange(new DireccionPedidoActualizada(direccion)).apply();
    }


    public Mensajero Mensajero() {
        return mensajero;
    }

    public Vehiculo Vehiculo() {
        return vehiculo;
    }

    public Pedido Pedido() {
        return pedido;
    }

    public TiendaId TiendaId() {
        return tiendaId;
    }

    public Factura Factura() {
        return factura;
    }
}
