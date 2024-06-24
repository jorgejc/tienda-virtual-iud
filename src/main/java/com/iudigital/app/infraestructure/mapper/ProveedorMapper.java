/**
 * proveedorMapper.java
 */
package com.iudigital.app.infraestructure.mapper;


import com.iudigital.app.domain.model.Proveedor;
import com.iudigital.app.infraestructure.persistence.jpa.entity.ProveedorEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//TODO: IMPLEMENTAR CON MAPSTRUCT
@Component
public class ProveedorMapper {

    public Proveedor toProveedor(ProveedorEntity proveedorEntity) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorEntity.getId());
        proveedor.setNit(proveedorEntity.getNit());
        proveedor.setNombre(proveedorEntity.getNombre());
        proveedor.setDireccion(proveedorEntity.getDireccion());
        proveedor.setTelefono(proveedorEntity.getTelefono());
        proveedor.setPaginaWeb(proveedorEntity.getPaginaWeb());
        proveedor.setCreatedAt(proveedorEntity.getCreatedAt());
        proveedor.setUpdatedAt(proveedorEntity.getUpdatedAt());
        return proveedor;
    }

    public List<Proveedor> toProveedores(List<ProveedorEntity> proveedorEntities) {
        return proveedorEntities.stream()
                .map(proveedorEntity -> toProveedor(proveedorEntity))
                .collect(Collectors.toList());
    }

    public ProveedorEntity toProveedorEntity(Proveedor proveedor) {
        ProveedorEntity proveedorEntity = new ProveedorEntity();
        proveedorEntity.setId(proveedor.getId());
        proveedorEntity.setNit(proveedor.getNit());
        proveedorEntity.setNombre(proveedor.getNombre());
        proveedorEntity.setDireccion(proveedor.getDireccion());
        proveedorEntity.setTelefono(proveedor.getTelefono());
        proveedorEntity.setPaginaWeb(proveedor.getPaginaWeb());
        proveedorEntity.setCreatedAt(proveedor.getCreatedAt());
        proveedorEntity.setUpdatedAt(proveedor.getUpdatedAt());
        return proveedorEntity;
    }
}