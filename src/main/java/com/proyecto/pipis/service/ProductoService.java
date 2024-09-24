package com.proyecto.pipis.service;

import com.proyecto.pipis.entity.Producto;
import com.proyecto.pipis.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    public void saveProduct(Producto producto) {
        productoRepository.save(producto);
    }
}
