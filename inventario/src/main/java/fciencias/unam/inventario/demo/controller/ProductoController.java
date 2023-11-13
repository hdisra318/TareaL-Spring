package fciencias.unam.inventario.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.entity.TipoProducto;
import fciencias.unam.inventario.demo.repository.ProductoRepository;
import fciencias.unam.inventario.demo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    private ProductoRepository repo;

    private final Logger logger = LogManager.getLogger(ProductoController.class);
    
    @ModelAttribute
    public void init(Model model) {
        Producto producto = new Producto();
        model.addAttribute("tipoProducto", TipoProducto.values());
        model.addAttribute("producto", producto);
    }

    @GetMapping("/")
    public String index() {
        return "producto/formularioAgregarIngrediente";
    }

    @GetMapping("/formularioAgregarIngrediente")
    public String agregarIngrediente() {
        return "producto/formularioAgregarIngrediente";
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
