package com.iudigital.app.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Producto implements Serializable {

    static final long serialVersion = 1L;
    Long id;
    String nombre;
    BigDecimal precioUnitario;
    Integer stock;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Proveedor proveedor;
    Categoria categoria;
}
