package net.afrivera.controller;

import net.afrivera.model.Vacante;
import net.afrivera.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService serviceVacante;

    @PostMapping("/save")
    public String guardar(Vacante vacante){
        serviceVacante.guardar(vacante);
        System.out.println(vacante);
        return "vacantes/listVacantes";
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
    public String crear(){
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
        Vacante vacante = serviceVacante.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        System.out.println("vacante: " + vacante);
        //TODO: Buscar los detalles de la vacante en la bd
        return "detalle";
    }
}
