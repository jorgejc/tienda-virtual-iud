/**
 * DomainProveedorServiceImpl.java
 */
package com.iudigital.app.domain.service.impl;

import com.iudigital.app.domain.dto.proveedor.ProveedorRequestDTO;
import com.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;
import com.iudigital.app.domain.model.Proveedor;
import com.iudigital.app.domain.repository.ProveedorRepository;
import com.iudigital.app.domain.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DomainProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorResponseDTO> getProveedores() {

        List<Proveedor> proveedores = proveedorRepository.findAll(); // select * from proveedores

        return proveedores.stream().map(proveedor ->
                ProveedorResponseDTO.builder()
                        .id(proveedor.getId())
                        .nit(proveedor.getNit())
                        .nombre(proveedor.getNombre())
                        .direccion(proveedor.getDireccion())
                        .telefono(proveedor.getTelefono())
                        .paginaWeb(proveedor.getPaginaWeb())
                        .createdAt(proveedor.getCreatedAt())
                        .updatedAt(proveedor.getUpdatedAt())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public ProveedorResponseDTO createProveedor(ProveedorRequestDTO proveedorRequestDTO) {

        Proveedor proveedor = new Proveedor();
        proveedor.setNit(proveedor.getNit());
        proveedor.setNombre(proveedorRequestDTO.getNombre());
        proveedor.setDireccion(proveedorRequestDTO.getDireccion());
        proveedor.setTelefono(proveedorRequestDTO.getTelefono());
        proveedor.setPaginaWeb(proveedorRequestDTO.getPaginaWeb());
        proveedor = proveedorRepository.save(proveedor);

        return ProveedorResponseDTO.builder()
                .id(proveedor.getId())
                .nit(proveedor.getNit())
                .nombre(proveedor.getNombre())
                .direccion(proveedor.getDireccion())
                .telefono(proveedor.getTelefono())
                .paginaWeb(proveedor.getPaginaWeb())
                .createdAt(proveedor.getCreatedAt())
                .updatedAt(proveedor.getUpdatedAt())
                .build();
    }

    @Override
    public ProveedorResponseDTO updateProveedor(Long id, ProveedorRequestDTO proveedorRequestDTO) {

        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id); //select * from proveedor where id = ?;
        if(proveedorOptional.isPresent()) {
            Proveedor proveedor = proveedorOptional.get();
            proveedor.setNit(
                    proveedorRequestDTO.getNit() != null ? proveedorRequestDTO.getNit() : proveedor.getNit()
            );
            proveedor.setNombre(
                    proveedorRequestDTO.getNombre() != null ? proveedorRequestDTO.getNombre() : proveedor.getNombre()
            );
            proveedor.setDireccion(
                    proveedorRequestDTO.getDireccion() != null ? proveedorRequestDTO.getDireccion() : proveedor.getDireccion()
            );
            proveedor.setTelefono(
                    proveedorRequestDTO.getTelefono() != null ? proveedorRequestDTO.getTelefono() : proveedor.getTelefono()
            );
            proveedor.setPaginaWeb(
                    proveedorRequestDTO.getPaginaWeb() != null ? proveedorRequestDTO.getPaginaWeb() : proveedor.getPaginaWeb()
            );
            proveedor = proveedorRepository.save(proveedor); //insert into proveedor () values ()
            //TODO: IMPLEMENTAR MAPSTRUCT
            return ProveedorResponseDTO.builder()
                    .id(proveedor.getId())
                    .nit(proveedor.getNit())
                    .nombre(proveedor.getNombre())
                    .direccion(proveedor.getDireccion())
                    .telefono(proveedor.getTelefono())
                    .paginaWeb(proveedor.getPaginaWeb())
                    .createdAt(proveedor.getCreatedAt())
                    .updatedAt(proveedor.getUpdatedAt())
                    .build();
        } else {
            //TODO: IMPLEMENTAR EXCEPCIONES PERSONALIZADAS
            throw new RuntimeException(("No existe proveedor que intente actualizar"));
        }
    }

    @Override
    public ProveedorResponseDTO getProveedorById(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        //TODO: REFACTORING DE REPETICION DE CODIGO
        return ProveedorResponseDTO.builder()
                .id(proveedor.getId())
                .nit(proveedor.getNit())
                .nombre(proveedor.getNombre())
                .direccion(proveedor.getDireccion())
                .telefono(proveedor.getTelefono())
                .paginaWeb(proveedor.getPaginaWeb())
                .createdAt(proveedor.getCreatedAt())
                .updatedAt(proveedor.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteProveedorById(Long id) {
        proveedorRepository.deleteById(id);
    }
}
