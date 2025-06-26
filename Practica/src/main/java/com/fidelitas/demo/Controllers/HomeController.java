package com.fidelitas.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarContacto(@RequestParam String nombre,
                                 @RequestParam String email,
                                 @RequestParam String mensaje,
                                 Model model) {
        // Aquí puedes guardar el mensaje o enviarlo por email
        model.addAttribute("mensajeEnviado", true);
        return "contacto";
    }
}