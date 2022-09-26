package net.afrivera.service;

import net.afrivera.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriasService{

    private List<Categoria> lista;

    public CategoriaServiceImpl(){
        lista = new LinkedList<>();
        Categoria c1 = new Categoria();
        c1.setId(1);
        c1.setNombre("Ventas");
        c1.setDescripcion("Categoria de Ventas");

        Categoria c2 = new Categoria();
        c2.setId(2);
        c2.setNombre("Informatica");
        c2.setDescripcion("Categoria de Informatica");

        Categoria c3 = new Categoria();
        c3.setId(3);
        c3.setNombre("Contabilidad");
        c3.setDescripcion("Categoria de Contabilidad");

        Categoria c4 = new Categoria();
        c4.setId(4);
        c4.setNombre("Construccion");
        c4.setDescripcion("Categoria de Construccion");

        Categoria c5 = new Categoria();
        c5.setId(5);
        c5.setNombre("Transporte");
        c5.setDescripcion("Categoria de Transporte");

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        lista.add(c5);

    }

    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for(Categoria c : lista){
            if(c.getId().equals(idCategoria)){
                return c;
            }
        }
        return null;
    }

}
