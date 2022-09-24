package net.afrivera.controller;

import net.afrivera.model.Vacante;
import net.afrivera.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);
        model.addAttribute("vacante", vacante);

        return "detalle";
    }
    @GetMapping("/listado")
    public String MostrarListado(Model model){
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");
        model.addAttribute("empleos", lista);
        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model){
        // model.addAttribute("mensaje", "Bienvenidos a Empleos App");
        // model.addAttribute("fecha", new Date());
        String nombre = "Auxiliar de Contabilidad";
        Date fechapub = new Date();
        double salario = 900.0;
        boolean vigente = true;

        model.addAttribute("nombre", nombre)
                .addAttribute("fecha", fechapub)
                .addAttribute("salarii", salario)
                .addAttribute("vigente", vigente);

        return "home";
    }

}
