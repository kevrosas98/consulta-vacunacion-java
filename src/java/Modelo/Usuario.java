package Modelo;

import java.time.LocalDate;

public class Usuario extends Persona{
    private int idUsuario;
    private int intentos;
    private String pass;

    public Usuario() {
    }

    public Usuario(int idUsuario, int intentos, String pass) {
        this.idUsuario = idUsuario;
        this.intentos = intentos;
        this.pass = pass;
    }

    public Usuario(int id, int tipoPer, int tipoDoc, String nroDoc, String nom, String ape, String correo, int idUsuario, int intentos, String pass, LocalDate fecRegistro, int codUserRegistro, LocalDate fecUpdate, int codUserUpdate) {
        super(id, tipoPer, tipoDoc, nroDoc, nom, ape, correo, fecRegistro, codUserRegistro, fecUpdate, codUserUpdate);
        this.idUsuario = idUsuario;
        this.intentos = intentos;
        this.pass = pass;
    }  

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }  
        
}
