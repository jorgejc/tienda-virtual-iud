package com.iudigital.app.infraestructure.persistence.jpa.repository;

import com.iudigital.app.infraestructure.persistence.jpa.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
}
