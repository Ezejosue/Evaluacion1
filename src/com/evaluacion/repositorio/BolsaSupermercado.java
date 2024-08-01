package com.evaluacion.repositorio;

import com.evaluacion.implementacion.ProductoImplementacion;
import com.evaluacion.modelos.*;


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

    public void getProductos() {
        System.out.println("¿Qué tiene la bolsa de productos?");
        for (T producto : listar()) {
            StringBuilder detalles = new StringBuilder();
            detalles.append("ID: ").append(producto.getProductoId()).append(", ");
            detalles.append("Nombre: ").append(producto.getNombre()).append(", ");
            detalles.append("Precio: $").append(producto.getPrecio());

            if (producto instanceof Fruta) {
                detalles.append(", Peso: ").append(((Fruta) producto).getPeso());
                detalles.append(", Color: ").append(((Fruta) producto).getColor());
            } else if (producto instanceof Limpieza) {
                detalles.append(", Componente: ").append(((Limpieza) producto).getComponentes());
                detalles.append(", Litros: ").append(((Limpieza) producto).getLitros());
            } else if (producto instanceof Lacteo) {
                detalles.append(", Cantidad: ").append(((Lacteo) producto).getCantidad());
                detalles.append(", Proteínas: ").append(((Lacteo) producto).getProteinas());
            } else if (producto instanceof NoPerecible) {
                detalles.append(", Contenido: ").append(((NoPerecible) producto).getContenido());
                detalles.append(", Calorías: ").append(((NoPerecible) producto).getCalorias());
            }

            System.out.println(detalles.toString());
        }
    }
}
