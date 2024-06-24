package com.iudigital.app.domain.service;

import com.iudigital.app.domain.model.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getProductos();
    Producto createProducto(Producto producto);
    Producto getProductoById(Long id);
    Producto updateProductoById(Long id, Producto producto);
    void deleteById(Long id);
}
