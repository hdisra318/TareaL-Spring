package fciencias.unam.inventario.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fciencias.unam.inventario.demo.entity.Inventario;
import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.repository.InventarioRepository;
import fciencias.unam.inventario.demo.service.InventarioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/inventario")
public class InventarioController {
    
    private InventarioService service;

    private InventarioRepository repo;

    private final Logger logger = LogManager.getLogger(InventarioController.class);

    @GetMapping("/")
    public String index(Model model) {
        //model.addAttribute("productos", service.getProductos());
        List<Producto> ingredientes=repo.findAll();
        model.addAttribute("ingredientes",ingredientes);
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
