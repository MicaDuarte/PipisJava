package com.proyecto.pipis.controller;

import org.springframework.ui.Model;
import com.proyecto.pipis.entity.Producto;
import com.proyecto.pipis.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/nuevo-producto")
    public String showNewProductForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "nuevo-producto";
    }

    @PostMapping("/guardar-producto")
    public String saveProduct(@ModelAttribute Producto producto) {
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos")
    public String listProducts(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "lista-productos";
    }
}
