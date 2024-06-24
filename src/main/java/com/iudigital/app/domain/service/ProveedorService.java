package com.iudigital.app.domain.service;

import com.iudigital.app.domain.dto.categoria.CategoriaRequestDTO;
import com.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import com.iudigital.app.domain.dto.proveedor.ProveedorRequestDTO;
import com.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;
import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.domain.model.Producto;
import com.iudigital.app.domain.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<ProveedorResponseDTO> getProveedores();
    ProveedorResponseDTO createProveedor(ProveedorRequestDTO proveedorRequestDTO);
    ProveedorResponseDTO updateProveedor(Long id, ProveedorRequestDTO proveedorRequestDTO);
    ProveedorResponseDTO getProveedorById(Long id);
    void deleteProveedorById(Long id);
}
