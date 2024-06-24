package com.iudigital.app.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Proveedor implements Serializable {

    private static final long serialVersionIUD = 1L;

    private Long id;
    private String nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
