package net.afrivera.controller;

import net.afrivera.model.Categoria;
import net.afrivera.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

    @Autowired
    private ICategoriasService serviceCategorias;

    //@GetMapping("/index")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mostrarIndex(Model model){
        List<Categoria> lista = serviceCategorias.buscarTodas();
        model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }

    //@GetMapping("/create")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrió un error: " + error.getDefaultMessage());
            }
            return "categorias/formCategoria";
        }
        serviceCategorias.guardar(categoria);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        System.out.println(categoria);
        return "redirect:/categorias/index";
    }

    //@PostMapping("/save")
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion){
//        System.out.println("Categoria: " + nombre);
//        System.out.println("descripcion: " + descripcion);
//        return "categorias/listCategorias";
//    }

    @GetMapping("/create")
    public String crear(Categoria categoria){
        return "categorias/formCategoria";
    }
}
