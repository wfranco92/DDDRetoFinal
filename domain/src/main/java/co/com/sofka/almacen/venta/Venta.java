package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Factura;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.values.TiendaId;
import co.com.sofka.almacen.venta.event.*;
import co.com.sofka.almacen.venta.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Venta extends AggregateEvent<VentaId> {
    protected Cliente cliente;
    protected List<Producto> productos;
    protected Factura factura;
    protected TiendaId tiendaId;
    protected Cajero cajero;
    public Venta(VentaId entityId, TiendaId tiendaId) {
        super(entityId);
        appendChange(new VentaCreada(tiendaId)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaId entityId){
        super(entityId);
        subscribe(new VentaEventChange(this));
    }

    public static Venta from(VentaId entityId, List<DomainEvent> events){
        var tienda = new Venta(entityId);
        events.forEach(tienda::applyEvent);
        return tienda;
    }

    public void crearCajero(Nombre nombre, Contacto contacto){
        var cajeroId = new CajeroId();
        appendChange(new CajeroCreado(cajeroId, nombre, contacto)).apply();
    }

    public void crearCliente(Nombre nombre, Documento documento){
        var clienteId = new ClienteId();
        appendChange(new ClienteCreado(clienteId, nombre, documento)).apply();
    }

    public void crearProducto(NombreProducto nombre, Descripcion descripcion){
        var productoId = new ProductoId();
        appendChange(new ProductoCreado(productoId, nombre, descripcion)).apply();
    }

/*    public void asignarPrecioProducto(Precio precio){
        appendChange(new PrecioAsignadoProducto(precio)).apply();
    }*/

    public void asignarSalarioCajero(Salario salario) {
        appendChange(new SalarioAsignadoCajero(salario)).apply();
    }

    public void actualizarContactoCajero(Contacto contacto){
        appendChange(new ContactoActualizadoCajero(contacto)).apply();
    }

    public void actualizarInformacionCliente(Nombre nombre, Documento documento){
        appendChange(new InformacionActualizadaCliente(nombre, documento)).apply();
    }

    public Cliente Cliente() {
        return cliente;
    }

    public List<Producto> Productos() {
        return productos;
    }

    public Factura Factura() {
        return factura;
    }

    public TiendaId TiendaId() {
        return tiendaId;
    }

    public Cajero Cajero() {
        return cajero;
    }
}
