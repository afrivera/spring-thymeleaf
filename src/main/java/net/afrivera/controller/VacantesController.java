package net.afrivera.controller;

import net.afrivera.model.Vacante;
import net.afrivera.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService serviceVacante;

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
