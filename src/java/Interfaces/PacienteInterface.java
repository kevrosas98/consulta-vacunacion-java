package Interfaces;

import Modelo.Paciente;
import java.util.List;

public interface PacienteInterface {
    
    public List listar();
    public Paciente list(int id);
    public int agregar(Paciente pac);
    public int editar(Paciente pac);
    public boolean eliminar(int id);
    public Paciente listBusq(int dni, String fnac, String femi);
    
}
