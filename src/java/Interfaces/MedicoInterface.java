package Interfaces;

import Modelo.Medico;

import java.util.List;

public interface MedicoInterface {
    
    public List listar();
    public Medico list(int id);
    public boolean agregar(Medico med);
    public boolean editar(Medico med);
    public boolean eliminar(int id);
}