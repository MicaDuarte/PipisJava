package com.proyecto.pipis.controller;

import com.proyecto.pipis.entity.User;
import com.proyecto.pipis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registro";
    }

    @PostMapping("/registrar-usuario")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "El nombre de usuario ya existe");
            return "registro";
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");  // Asigna un rol predeterminado
        }

        userService.saveUser(user);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User foundUser = userService.findByUsername(user.getUsername());

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            String role = foundUser.getRole();
            if (role == null) {
                model.addAttribute("error", "El rol del usuario no está definido");
                return "login";
            }

            if (role.equals("ADMIN")) {
                return "redirect:/productos";
            } else {
                return "redirect:/carrito";
            }
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

}