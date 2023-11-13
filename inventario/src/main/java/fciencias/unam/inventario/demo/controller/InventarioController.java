package fciencias.unam.inventario.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.repository.InventarioRepository;
import fciencias.unam.inventario.demo.service.InventarioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository repo;


    @GetMapping("/")
    public String index(Model model) {
        List<Producto> ingredientes=repo.findAll();
        model.addAttribute("ingredientes",ingredientes);
        return "inventario/inventario";
    } 
}
