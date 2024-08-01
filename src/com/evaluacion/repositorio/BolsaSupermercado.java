package com.evaluacion.repositorio;

import com.evaluacion.implementacion.ProductoImplementacion;
import com.evaluacion.modelos.*;

import java.util.List;


public class BolsaSupermercado<T extends Producto> extends ProductoImplementacion<T> {
    private static final int MAX_PRODUCTOS = 5;

    @Override
    public void crear(T producto) {
        if (listar().size() <= MAX_PRODUCTOS) {
            super.crear(producto);
        } else {
            System.out.println("Limite máximo alcanzado");
        }
    }

    @Override
    protected int getId(T producto) {
        return producto.getProductoId();
    }

    @Override
    protected void setId(T producto, int id) {
        producto.setProductoId(id);
    }

    public List<T> getProductos() {
        return listar();
    }

    public void imprimirProductos() {
        System.out.println("¿Qué tiene la bolsa de productos?");
        for (T producto : getProductos()) {
            System.out.println("ID: " + producto.getProductoId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", " + producto.getDetalles());
        }
    }
}
