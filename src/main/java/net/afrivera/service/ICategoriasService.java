package net.afrivera.service;

import net.afrivera.model.Categoria;

import java.util.List;

public interface ICategoriasService {

    void guardar(Categoria categoria);
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);

}
