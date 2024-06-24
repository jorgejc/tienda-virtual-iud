/**
 * DomainProductoServiceImpl.java
 */
package com.iudigital.app.domain.service.impl;

import com.iudigital.app.domain.model.Categoria;
import com.iudigital.app.domain.model.Producto;
import com.iudigital.app.domain.model.Proveedor;
import com.iudigital.app.domain.repository.CategoriaRepository;
import com.iudigital.app.domain.repository.ProductoRepository;
import com.iudigital.app.domain.repository.ProveedorRepository;
import com.iudigital.app.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DomainProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) {
        Categoria categoria = categoriaRepository
                .findById(producto.getCategoria().getId())
                .orElseThrow(RuntimeException::new);
        Proveedor proveedor = proveedorRepository
                .findById(producto.getProveedor().getId())
                .orElseThrow(RuntimeException::new);
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);
        return productoRepository.save(producto);

    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);

    }

    @Override
    public Producto updateProductoById(Long id, Producto producto) {
        producto = productoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
