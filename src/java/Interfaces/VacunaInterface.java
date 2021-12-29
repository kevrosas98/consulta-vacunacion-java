package Interfaces;

import Modelo.Vacuna;
import java.util.List;

public interface VacunaInterface {
    public List listar(int id);
    public Vacuna listVacuna(int id);
    public int agregar(Vacuna vac);
    public int editar(Vacuna vac);
    public boolean eliminar(int id, int idp);
}
