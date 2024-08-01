package com.evaluacion.implementacion;

import com.evaluacion.repositorio.ICRUDOperations;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductoImplementacion<T> implements ICRUDOperations<T> {
    protected List<T> datasource;
    protected int siguienteId;

    public ProductoImplementacion() {
        this.datasource = new ArrayList<>();
        this.siguienteId = 1;
    }

    @Override
    public List<T> listar() {
        return datasource;
    }

    @Override
    public T porId(Integer id) {
        for (T producto : datasource) {
            if (getId(producto) == id) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public void crear(T t) {
        setId(t, siguienteId);
        siguienteId++;
        datasource.add(t);
    }

    @Override
    public void editar(T t) {
        for (int i = 0; i < datasource.size(); i++) {
            if (getId(datasource.get(i)) == getId(t)) {
                datasource.set(i, t);
                break;
            }
        }
    }

    @Override
    public void eliminar(Integer id) {
        datasource.removeIf(producto -> getId(producto) == id);
    }

    protected abstract int getId(T t);

    protected abstract void setId(T t, int id);
}
