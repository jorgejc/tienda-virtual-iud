package com.iudigital.app.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Categoria implements Serializable {

    static final Long serialVersionIUD = 1L;
    Long id;
    String nombre;
    String descripcion;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
