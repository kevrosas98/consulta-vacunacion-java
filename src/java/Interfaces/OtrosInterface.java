package Interfaces;

import Modelo.Atributo;
import Modelo.Laboratorio;
import Modelo.Local;
import Modelo.Ubigeo;
import java.util.List;

public interface OtrosInterface {
    
    /* Local */
    public List listarLocal();
    public Local listLocal(int id);
    public boolean agregarLocal(Local loc);
    public boolean editarLocal(Local loc);
    public boolean eliminarLocal(int id);
    
    /* Laboratorio */
    public List listarLab();
    public Laboratorio listLab(int id);
    public boolean agregarLab(Laboratorio lab);
    public boolean editarLab(Laboratorio lab);
    public boolean eliminarLab(int id);
    
    /* Ubigeo */
    public List listarUbigeo();
    public Ubigeo listUbigeo(int id);
    
    /* Atributos */
    public List listarAtributo(int tipo, int grupo);
    public Atributo listAtributo(int tipo, int valor, int grupo);
    
}
