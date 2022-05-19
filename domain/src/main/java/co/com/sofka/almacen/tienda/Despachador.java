package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.values.DespachadorId;
import co.com.sofka.almacen.generic.Contacto;
import co.com.sofka.almacen.generic.Nombre;
import co.com.sofka.almacen.generic.Salario;
import co.com.sofka.domain.generic.Entity;

public class Despachador extends Entity<DespachadorId> {

    protected Contacto contacto;
    protected Nombre nombre;
    protected Salario salario;
    public Despachador(DespachadorId entityId, Nombre nombre, Contacto contacto) {
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
