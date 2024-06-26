package com.iudigital.app.domain.repository;

import com.iudigital.app.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {

    List<Producto> findAll();

    Producto save(Producto producto);

    Optional<Producto> findById(Long id);

    Producto update(Long id, Producto producto);

    void deleteById(Long id);
}
