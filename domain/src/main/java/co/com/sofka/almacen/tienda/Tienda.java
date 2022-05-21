package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.almacen.tienda.event.*;
import co.com.sofka.almacen.tienda.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Tienda extends AggregateEvent<TiendaId> {

    protected NombreTienda nombreTienda;
    protected Gerente gerente;
    protected Despachador despachador;
    protected Set<Proveedor> proveedor;
    protected List<String> ventas;
    protected List<String> domicilios;


    public Tienda(TiendaId entityId, NombreTienda nombreTienda) {
        super(entityId);
        appendChange(new TiendaCreada(nombreTienda)).apply();
        subscribe(new TiendaEventChange(this));
    }

    private Tienda(TiendaId entityId){
        super(entityId);
        subscribe(new TiendaEventChange(this));
    }

    public static Tienda from(TiendaId entityId, List<DomainEvent> events){
        var tienda = new Tienda(entityId);
        events.forEach(tienda::applyEvent);
        return tienda;
    }

    public void crearProveedor(RazonSocial razonSocial, Contacto contacto){
        var proveedorId = new ProveedorId();
        appendChange(new ProveedorCreado(proveedorId, razonSocial, contacto)).apply();
    }

    public void crearGerente(Nombre nombre, Contacto contacto){
        var gerenteId = new GerenteId();
        appendChange(new GerenteCreado(gerenteId, nombre, contacto)).apply();
    }

    public void crearDespachador(Nombre nombre, Contacto contacto){
        var despachadorId = new DespachadorId();
        appendChange(new DespachadorCreado(despachadorId, nombre, contacto)).apply();
    }

    public void actualizarContactoGerente(Contacto contacto){
        appendChange(new ContactoGerenteActualizado(contacto)).apply();
    }

    public void asignarSalarioDespachador(Salario salario){
        appendChange(new SalarioDespachadorAsignado(salario)).apply();
    }

    public void actualizarContactoDespachador(Contacto contacto) {
        appendChange(new ContactoDespachadorActualizado(contacto)).apply();
    }

    public void actualizarNumeroVentas(String venta) {
        appendChange(new NumeroVentasActualizadas(venta)).apply();
    }

    public void actualizarNumeroDomicilios(String domicilio) {
        appendChange(new NumeroDomiciliosActualizados(domicilio)).apply();
    }

    public NombreTienda NombreTienda() {
        return nombreTienda;
    }

    public Gerente Gerente() {
        return gerente;
    }

    public Despachador Despachador() {
        return despachador;
    }

    public Set<Proveedor> Proveedor() {
        return proveedor;
    }
}
