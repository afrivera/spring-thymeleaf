package net.afrivera.service;

import net.afrivera.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServiceImpl implements IVacanteService{

    private List<Vacante> lista;

    public VacantesServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();
        try {
            // creación de ofertas de trabajo
            Vacante v1 = new Vacante();
            v1.setId(1);
            v1.setNombre("Ingeniero Civil");
            v1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
            v1.setSalario(14500.0);
            v1.setFecha(sdf.parse("08-02-2019"));
            v1.setDestacado(1);
            v1.setImagen("empresa1.png");

            Vacante v2 = new Vacante();
            v2.setId(2);
            v2.setNombre("Contador Público");
            v2.setDescripcion("Importante Empresa solicita contador con 5 años de experiencia, titulado");
            v2.setSalario(12000.0);
            v2.setFecha(sdf.parse("09-02-2019"));
            v2.setDestacado(0);
            v2.setImagen("empresa2.png");

            Vacante v3 = new Vacante();
            v3.setId(3);
            v3.setNombre("Ingeniero Electrico");
            v3.setDescripcion("empresa Internacional solicita ingeniero mecánico para mantenimiento de la instalación eléctrica");
            v3.setSalario(10500.0);
            v3.setFecha(sdf.parse("10-02-2019"));
            v3.setDestacado(0);

            Vacante v4 = new Vacante();
            v4.setId(4);
            v4.setNombre("Diseñador Gráfico");
            v4.setDescripcion("Solicitamos diseñador Gráfico titulado para diseñar publicidad de la empresa");
            v4.setSalario(7500.0);
            v4.setFecha(sdf.parse("11-02-2019"));
            v4.setDestacado(1);
            v4.setImagen("empresa3.png");

            lista.add(v1);
            lista.add(v2);
            lista.add(v3);
            lista.add(v4);

        }catch (ParseException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Vacante> buscarTodas() {
        return this.lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        for(Vacante v: lista){
            if(v.getId().equals(idVacante)){
                return v;
            }
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        lista.add(vacante);
    }
}
