package fciencias.unam.inventario.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import fciencias.unam.inventario.demo.entity.Usuario;
import fciencias.unam.inventario.demo.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        List<Usuario> usuarios = repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/index";
    }

    @GetMapping("/formularioAgregarUsuario")
    public String agregarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formularioAgregarUsuario";
    }

    @PostMapping("/formularioAgregarUsuario")
    public String procesandoAgregarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result) {

        System.out.println(usuario);
        if (result.hasErrors()) {
            // Manejar errores de validación, si es necesario
            return "usuario/formularioAgregarUsuario";
        }

        repo.save(usuario);
        System.out.println("Agregado!!!");
        return "redirect:/usuario/";
    }

    @GetMapping("/formularioEditarUsuario")
    public String editarUsuario() {
        return "usuario/formularioEditarUsuario";
    }

}
