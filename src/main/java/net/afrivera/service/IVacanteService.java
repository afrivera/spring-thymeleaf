package net.afrivera.service;

import net.afrivera.model.Vacante;

import java.util.List;

public interface IVacanteService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);
    void guardar(Vacante vacante);
}
