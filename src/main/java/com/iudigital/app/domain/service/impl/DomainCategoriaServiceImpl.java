/**
 * DomainCategoriaServiceImpl.java
 */
package com.iudigital.app.domain.service.impl;

import com.iudigital.app.domain.dto.categoria.CategoriaRequestDTO;
import com.iudigital.app.domain.dto.categoria.CategoriaResponseDTO;
import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.domain.repository.CategoriaRepository;
import com.iudigital.app.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DomainCategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // funcional
    @Override
    public List<CategoriaResponseDTO> getCategorias() {
       List<Categoria> categorias = categoriaRepository.findAll();

       /* imperativa
        List<CategoriaResponseDTO> categoriaResponseDTOS = new LinkedList<>();
        for (Categoria categoria : categorias) {
            CategoriaResponseDTO categoriaResponseDTO = CategoriaResponseDTO.builder()
                    .id(categoria.getId())
                    .nombre(categoria.getNombre())
                    .descripcion(categoria.getDescripcion())
                    .createdAt(categoria.getCreatedAt())
                    .updatedAt(categoria.getUpdatedAt())
                    .build();
            categoriaResponseDTOS.add(categoriaResponseDTO);
        }
        return categoriaResponseDTOS;*/

       return categorias.stream().map(categoria ->
               CategoriaResponseDTO.builder()
                       .id(categoria.getId())
                       .nombre(categoria.getNombre())
                       .descripcion(categoria.getDescripcion())
                       .createdAt(categoria.getCreatedAt())
                       .updatedAt(categoria.getUpdatedAt())
                       .build()).collect(Collectors.toList());
    }

    @Override
    public CategoriaResponseDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDTO.getNombre());
        categoria.setDescripcion(categoriaRequestDTO.getDescripcion());
        categoria = categoriaRepository.save(categoria);

        return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .createdAt(categoria.getCreatedAt())
                .updatedAt(categoria.getUpdatedAt())
                .build();
    }

    @Override
    public CategoriaResponseDTO updateCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoria.setNombre(
                    categoriaRequestDTO.getNombre() != null ? categoriaRequestDTO.getNombre() : categoria.getNombre()
            );
            categoria.setDescripcion(
                    categoriaRequestDTO.getDescripcion() != null ? categoriaRequestDTO.getDescripcion() : categoria.getDescripcion()
            );
            categoria = categoriaRepository.save(categoria);
            //TODO: IMPLEMENTAR MAPSTRUCT
            return CategoriaResponseDTO.builder()
                    .id(categoria.getId())
                    .nombre(categoria.getNombre())
                    .descripcion(categoria.getDescripcion())
                    .createdAt(categoria.getCreatedAt())
                    .updatedAt(categoria.getUpdatedAt())
                    .build();
        } else {
            //TODO: IMPLEMENTAR EXCEPCIONES PERSONALIZADAS
            throw new RuntimeException(("No existe Categoria que intente actualizar"));
        }
    }

    @Override
    public CategoriaResponseDTO getCategoriaById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        //TODO: REFACTORING DE REPETICION DE CODIGO
        return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .createdAt(categoria.getCreatedAt())
                .updatedAt(categoria.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
