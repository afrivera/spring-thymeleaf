package net.afrivera.controller;

import net.afrivera.model.Categoria;
import net.afrivera.model.Vacante;
import net.afrivera.service.ICategoriasService;
import net.afrivera.service.IVacanteService;
import net.afrivera.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService serviceVacantes;

    @Autowired
    private ICategoriasService serviceCategorias;


    @GetMapping("/index")
    private String mostrarIndex(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "/vacantes/listVacantes";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multipart){
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("ocurrió un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }

        // if para validar la imagen
        if(!multipart.isEmpty()){
            // String ruta = "/empleos/img-vacantes"; // linux - mac
            String ruta = "c:/empleos/img-vacantes/"; // windows
            String nombreImagen = Utileria.guardarArchivo(multipart, ruta);
            if (nombreImagen != null) { // la imagen si se subio
                // procesamos la variable nombreImagen
                vacante.setImagen(nombreImagen);
            }
        }
        serviceVacantes.guardar(vacante);
        // el flashAttribute para cuando se redirecciona o otra pagina pero se envía info
        attributes.addFlashAttribute("msg", "Registro Guardado");
        System.out.println(vacante);
        return "redirect:/vacantes/index";
    }

    @InitBinder // para controlar como se envia la fecha
    public void initBinder(WebDataBinder wdb){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        wdb.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }

    /*@PostMapping("/save")
    public String guardar(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("estatus") String estatus,
            @RequestParam("fecha") String fecha,
            @RequestParam("destacado") int destacado,
            @RequestParam("salario") double salario,
            @RequestParam("detalles") String detalles
            ){
        System.out.println("nombre = " + nombre);
        System.out.println("descripcion = " + descripcion);
        System.out.println("estatus = " + estatus);
        System.out.println("fecha = " + fecha);
        System.out.println("destacado = " + destacado);
        System.out.println("salario = " + salario);
        System.out.println("detalles = " + detalles);

        return "vacantes/listVacantes";
    }*/

    @GetMapping("/create")
    public String crear(Vacante vacante, Model model){
        List<Categoria> lista = serviceCategorias.buscarTodas();
        model.addAttribute("categorias", lista);
        return "vacantes/formVacante";
    }
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        model.addAttribute("idVacante", idVacante);
        System.out.println("borrando vacante con id = " + idVacante);
        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        System.out.println("vacante: " + vacante);
        //TODO: Buscar los detalles de la vacante en la bd
        return "detalle";
    }
}
