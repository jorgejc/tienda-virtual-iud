package com.iudigital.app.domain.service;

import com.iudigital.app.domain.dto.categoria.CategoriaRequestDTO;
import com.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import com.iudigital.app.domain.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<CategoriaResponseDTO> getCategorias();
    CategoriaResponseDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO updateCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO getCategoriaById(Long id);
    void deleteCategoriaById(Long id);
}
