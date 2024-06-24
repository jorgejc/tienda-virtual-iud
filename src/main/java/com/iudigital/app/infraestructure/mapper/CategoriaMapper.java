/**
 * CategoriaMapper.java
 */
package com.iudigital.app.infraestructure.mapper;

import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.infraestructure.persistence.jpa.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//TODO: IMPLEMENTAR CON MAPSTRUCT
@Component
public class CategoriaMapper {

    public Categoria toCategoria(CategoriaEntity categoriaEntity) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaEntity.getId());
        categoria.setNombre(categoriaEntity.getNombre());
        categoria.setDescripcion(categoriaEntity.getDescripcion());
        categoria.setCreatedAt(categoriaEntity.getCreatedAt());
        categoria.setUpdatedAt(categoriaEntity.getUpdatedAt());
        return categoria;
    }

    public List<Categoria> toCategorias(List<CategoriaEntity> categoriaEntities) {
        return categoriaEntities.stream()
                .map(categoriaEntity -> toCategoria(categoriaEntity))
                .collect(Collectors.toList());
    }

    public CategoriaEntity toCategoriaEntity(Categoria categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setNombre(categoria.getNombre());
        categoriaEntity.setDescripcion(categoria.getDescripcion());
        categoriaEntity.setCreatedAt(categoria.getCreatedAt());
        categoriaEntity.setUpdatedAt(categoria.getUpdatedAt());
        return categoriaEntity;
    }
}
