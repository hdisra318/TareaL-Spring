package fciencias.unam.inventario.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @GetMapping("/")
    public String index() {
        return "producto/index";
    }

    @GetMapping("/create")
    public String create() {
        return "producto/create";
    }

    @PostMapping("/save")
    public String save() {
        return "redirect:/producto";
    }
}
