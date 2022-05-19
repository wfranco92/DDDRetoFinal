package co.com.sofka.almacen.venta;

import co.com.sofka.almacen.venta.values.CajeroId;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.domain.generic.Entity;

public class Cajero extends Entity<CajeroId> {

    protected Contacto contacto;
    protected Nombre nombre;
    protected Salario salario;
    public Cajero(CajeroId entityId, Nombre nombre, Contacto contacto) {
        super(entityId);
        this.contacto = contacto;
        this.nombre = nombre;
    }

    public void asignarSalario(Salario salario){
        this.salario = salario;
    }

    public void actualizarContacto(Contacto contacto){
        this.contacto = contacto;
    }

    public Contacto Contacto() {
        return contacto;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Salario Salario() {
        return salario;
    }
}
