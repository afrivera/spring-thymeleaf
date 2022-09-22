package net.afrivera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
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
