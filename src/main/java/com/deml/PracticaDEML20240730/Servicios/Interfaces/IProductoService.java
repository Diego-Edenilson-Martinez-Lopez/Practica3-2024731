package com.deml.PracticaDEML20240730.Servicios.Interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.deml.PracticaDEML20240730.Modelo.ProductoDEML;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Page<ProductoDEML> buscarTodosPaginados(Pageable pageable);

    List<ProductoDEML> obtenerTodos();

    Optional<ProductoDEML> buscarPorId(Long id);

    ProductoDEML crearOEditar(ProductoDEML producto);

    void eliminarPorId(Long id);
}