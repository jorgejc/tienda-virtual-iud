package com.iudigital.app.infraestructure.persistence.jpa.repository;

import com.iudigital.app.infraestructure.persistence.jpa.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorJpaRepository extends JpaRepository<ProveedorEntity, Long> {
}
