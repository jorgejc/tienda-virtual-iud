/**
 * MySQLCategoriaRepository.java
 */
package com.iudigital.app.infraestructure.repository;

import com.iudigital.app.domain.model.Proveedor;
import com.iudigital.app.domain.repository.ProveedorRepository;
import com.iudigital.app.infraestructure.mapper.ProveedorMapper;
import com.iudigital.app.infraestructure.persistence.jpa.entity.ProveedorEntity;
import com.iudigital.app.infraestructure.persistence.jpa.repository.ProveedorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLProveedorRepository implements ProveedorRepository {

    @Autowired
    private ProveedorJpaRepository proveedorJpaRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;


    @Override
    public List<Proveedor> findAll() {
        List<ProveedorEntity> proveedorEntities = proveedorJpaRepository.findAll();
        return proveedorMapper.toProveedores(proveedorEntities);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        ProveedorEntity proveedorEntity = proveedorMapper.toProveedorEntity(proveedor);
        proveedorEntity = proveedorJpaRepository.save(proveedorEntity);
        return proveedorMapper.toProveedor(proveedorEntity);
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        Optional<ProveedorEntity> proveedorOptional = proveedorJpaRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            ProveedorEntity proveedorEntity = proveedorOptional.get();
            Proveedor proveedor = proveedorMapper.toProveedor(proveedorEntity);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        proveedorJpaRepository.deleteById(id);
    }
}
