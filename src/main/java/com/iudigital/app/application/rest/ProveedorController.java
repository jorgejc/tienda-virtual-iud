/**
 * ProveedorController.java
 */
package com.iudigital.app.application.rest;

import com.iudigital.app.domain.dto.proveedor.ProveedorRequestDTO;
import com.iudigital.app.domain.dto.proveedor.ProveedorResponseDTO;
import com.iudigital.app.domain.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorResponseDTO>> index() {
        return ResponseEntity.ok(proveedorService.getProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(proveedorService.getProveedorById(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorResponseDTO> save(@RequestBody ProveedorRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proveedorService.createProveedor(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> update(@PathVariable(value = "id") Long id,
                                                       @RequestBody ProveedorRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.updateProveedor(id, request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        proveedorService.deleteProveedorById(id);
    }
}
