package fciencias.unam.inventario.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.entity.TipoProducto;
import fciencias.unam.inventario.demo.repository.ProductoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository repo;
    
    @ModelAttribute
    public void init(Model model) {
        Producto producto = new Producto();
        model.addAttribute("tipoProducto", TipoProducto.values());
        model.addAttribute("producto", producto);
    }

    // CREATE
    @GetMapping("/formularioAgregarIngrediente")
    public String agregarIngrediente(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/formularioAgregarIngrediente";
    }

    @PostMapping("/formularioAgregarIngrediente")
    public String procesandoAgregarIngrediente(@Valid @ModelAttribute Producto ingrediente, BindingResult result) {

        System.out.println(ingrediente);

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "producto/formularioAgregarIngrediente";
        }

        repo.save(ingrediente);
        return "redirect:/inventario/";
        
    }

    @GetMapping("/formularioEditarIngrediente")
    public String editarIngrediente() {
        return "producto/formularioEditarIngrediente";
    }

    // @PostMapping("/save")
    // public String save() {
    //     return "redirect:/producto";
    // }
}
