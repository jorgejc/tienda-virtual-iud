/**
 * MySQLCategoriaRepository.java
 */
package com.iudigital.app.infraestructure.repository;

import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.domain.repository.CategoriaRepository;
import com.iudigital.app.infraestructure.mapper.CategoriaMapper;
import com.iudigital.app.infraestructure.persistence.jpa.entity.CategoriaEntity;
import com.iudigital.app.infraestructure.persistence.jpa.repository.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MySQLCategoriaRepository implements CategoriaRepository {

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public List<Categoria> findAll() {
        List<CategoriaEntity> categoriaEntities = categoriaJpaRepository.findAll();
        return categoriaMapper.toCategorias(categoriaEntities);
    }

    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaMapper.toCategoriaEntity(categoria);
        categoriaEntity = categoriaJpaRepository.save(categoriaEntity);
        return categoriaMapper.toCategoria(categoriaEntity);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        Optional<CategoriaEntity> categoriaOptional = categoriaJpaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            CategoriaEntity categoriaEntity = categoriaOptional.get();
            Categoria categoria = categoriaMapper.toCategoria(categoriaEntity);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        categoriaJpaRepository.deleteById(id);
    }
}
