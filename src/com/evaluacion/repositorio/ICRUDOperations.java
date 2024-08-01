package com.evaluacion.repositorio;

import java.util.List;

public interface ICRUDOperations<T> {
    List<T> listar();

    T porId(Integer id);

    void crear(T t);

    void editar(T t);

    void eliminar(Integer id);
}
