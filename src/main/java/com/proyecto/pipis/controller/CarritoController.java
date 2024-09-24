package com.proyecto.pipis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarritoController {

    @GetMapping("/carrito")
    public String showCarrito(Model model) {
        // Lógica para mostrar el carrito de compras
        return "carrito";
    }
}
