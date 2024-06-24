package com.iudigital.app.domain.repository;

import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {

    List<Categoria> findAll();
    Categoria save(Categoria categoria);
    Optional<Categoria> findById(Long id);
    void deleteById(Long id);

}
