package net.afrivera.controller;

import net.afrivera.model.Vacante;
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

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
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

    private List<Vacante> getVacantes(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<>();
        try {
            // creación de ofertas de trabajo
            Vacante v1 = new Vacante();
            v1.setId(1);
            v1.setNombre("Ingeniero Civil");
            v1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
            v1.setSalario(8500.0);
            v1.setFecha(sdf.parse("08-02-2019"));

            Vacante v2 = new Vacante();
            v2.setId(2);
            v2.setNombre("Contador Público");
            v2.setDescripcion("Importante Empresa solicita contador con 5 años de experiencia, titulado");
            v2.setSalario(12000.0);
            v2.setFecha(sdf.parse("09-02-2019"));

            Vacante v3 = new Vacante();
            v3.setId(3);
            v3.setNombre("Ingeniero Electrico");
            v3.setDescripcion("empresa Internacional solicita ingeniero mecánico para mantenimiento de la instalación eléctrica");
            v3.setSalario(10500.0);
            v3.setFecha(sdf.parse("10-02-2019"));

            Vacante v4 = new Vacante();
            v4.setId(4);
            v4.setNombre("Diseñador Gráfico");
            v4.setDescripcion("Solicitamos diseñador Gráfico titulado para diseñar publicidad de la empresa");
            v4.setSalario(7500.0);
            v4.setFecha(sdf.parse("11-02-2019"));

            lista.add(v1);
            lista.add(v2);
            lista.add(v3);
            lista.add(v4);

        }catch (ParseException e){
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }
}
