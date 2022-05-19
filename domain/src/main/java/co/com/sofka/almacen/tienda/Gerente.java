package co.com.sofka.almacen.tienda;

import co.com.sofka.almacen.tienda.values.GerenteId;
import co.com.sofka.domain.generic.Entity;

public class Gerente extends Entity<GerenteId> {
    public Gerente(GerenteId entityId) {
        super(entityId);
    }
}
