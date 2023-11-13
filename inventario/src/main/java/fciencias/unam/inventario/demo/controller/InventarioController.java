package fciencias.unam.inventario.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    
    private InventarioService service;

    private InventarioRepository repo;

    private final Logger logger = LogManager.getLogger(InventarioController.class);

    @GetMapping("/")
    public String index(Model model) {
        //model.addAttribute("productos", service.getProductos());
        List<Producto> ingredientes=repo.findAll();
        model.addAttribute("ingredientes",ingredientes);
        return "inventario/index";
    }


    @GetMapping("/formularioAgregarIngrediente")
    public String agregarIngrediente(Model model) {
        model.addAttribute("ingrediente",new Producto());
        return "inventario/formularioAgregarIngrediente";
    }

    @PostMapping("/formularioAgregarIngrediente")
    public String procesandoAgregarIngrediente(@Valid @ModelAttribute Producto ingrediente, BindingResult result) {

        System.out.println(ingrediente);

        if (result.hasErrors()) {
            return "inventario/formularioAgregarIngrediente";
        }

        repo.save(ingrediente);
        return "redirect:/inventario/";
        
    }

    @GetMapping("/formularioEditarIngrediente/{id}")
    public String editarIngrediente(@PathVariable long id, Model model) {

        // Obteniedo usuario
        Producto ingrediente = repo.findById(id).orElse(null);

        model.addAttribute("ingrediente", ingrediente);
        model.addAttribute("id", id);

        return "inventario/formularioEditarIngrediente";
    }

    @PostMapping("/formularioEditarIngrediente/{id}")
    public String procesandoEditarIngrediente(@PathVariable long id, @Valid @ModelAttribute Producto ingrediente, BindingResult result) {

        System.out.println(ingrediente);
        if (result.hasErrors()) {
            return "inventario/formularioEditarIngrediente";
        }

        // Actualizando los datos
        Producto ingredienteActual = repo.findById(id).orElse(null);
        ingredienteActual.setNombreProveedor(ingrediente.getNombreProveedor());
        ingredienteActual.setNombreProducto(ingrediente.getNombreProducto());
        ingredienteActual.setCosto(ingrediente.getCosto());
        ingredienteActual.setStock(ingrediente.getStock());
        ingredienteActual.setFechaAdquision(ingrediente.getFechaAdquision());
        ingredienteActual.setFechaCaducidad(ingrediente.getFechaCaducidad());
        ingredienteActual.setTipoProducto(ingrediente.getTipoProducto());
        ingredienteActual.setDescripcion(ingrediente.getDescripcion());
        ingredienteActual.setComentarios(ingrediente.getComentarios());

        repo.save(ingredienteActual);
        return "redirect:/inventario/";
    }

    @GetMapping("/eliminarIngrediente/{id}")
    public String eliminarIngrediente(@PathVariable long id) {
        repo.deleteById(id);
        return "redirect:/inventario/";
    }    
}
