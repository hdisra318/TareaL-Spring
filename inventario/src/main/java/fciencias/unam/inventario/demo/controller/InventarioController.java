package fciencias.unam.inventario.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import fciencias.unam.inventario.demo.entity.Inventario;
import fciencias.unam.inventario.demo.service.InventarioService;

@Controller
@RequestMapping("/inventario")
public class InventarioController {
    
    private InventarioService service;

    private final Logger logger = LogManager.getLogger(InventarioController.class);

    @GetMapping("/")
    public String index(Model model) {
        //model.addAttribute("productos", service.getProductos());

        return "inventario/inventario";
    }


    @GetMapping("/create")
    public String create() {
        return "inventario/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Inventario inventario, BindingResult result) {

        return "";
    }
}
