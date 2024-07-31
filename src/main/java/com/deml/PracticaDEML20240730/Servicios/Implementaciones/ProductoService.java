package com.deml.PracticaDEML20240730.Servicios.Implementaciones;

import com.deml.PracticaDEML20240730.Modelo.ProductoDEML;
import com.deml.PracticaDEML20240730.Repositorio.IProductoDEMLRepository;
import com.deml.PracticaDEML20240730.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoDEMLRepository productoDEMLRepository;

    @Override
    public Page<ProductoDEML> buscarTodosPaginados(Pageable pageable) {
        return productoDEMLRepository.findAll(pageable);
    }

    @Override
    public List<ProductoDEML> obtenerTodos() {
        return productoDEMLRepository.findAll();
    }

    @Override
    public Optional<ProductoDEML> buscarPorId(Long id) {
        return productoDEMLRepository.findById(id);
    }

    @Override
    public ProductoDEML crearOEditar(ProductoDEML productoDEML) {
        return productoDEMLRepository.save(productoDEML);
    }

    @Override
    public void eliminarPorId(Long id) {
        productoDEMLRepository.deleteById(id);
    }
}