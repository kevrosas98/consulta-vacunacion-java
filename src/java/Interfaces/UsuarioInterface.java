package Interfaces;

import Modelo.Usuario;

import java.util.List;

public interface UsuarioInterface {
    
    public List listar();
    public Usuario list(int id);
    public boolean agregar(Usuario usu);
    public boolean editar(Usuario usu);
    public boolean resetPass(Usuario usu);
    public boolean eliminar(int id);
    public int maxId();
    public int validar(Usuario usu);
    
}
