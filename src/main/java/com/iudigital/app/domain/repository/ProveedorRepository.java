package com.iudigital.app.domain.repository;

import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.domain.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository {

    List<Proveedor> findAll();
    Proveedor save(Proveedor proveedor);
    Optional<Proveedor> findById(Long id);
    void deleteById(Long id);
}
