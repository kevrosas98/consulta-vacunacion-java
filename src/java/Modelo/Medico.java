package Modelo;

import java.time.LocalDate;

public class Medico extends Persona{
    private int tipMedico;
    private String licencia;
    private int codEspecialidad;

    public Medico() {
    }

    public Medico(int tipMedico, String licencia, int codEspecialidad) {
        this.tipMedico = tipMedico;
        this.licencia = licencia;
        this.codEspecialidad = codEspecialidad;
    }

    public Medico(int id, int tipoPer, int tipoDoc, String nroDoc, String nom, String ape, String correo, int tipMedico, String licencia, int codEspecialidad, LocalDate fecRegistro, int codUserRegistro, LocalDate fecUpdate, int codUserUpdate) {
        super(id, tipoPer, tipoDoc, nroDoc, nom, ape, correo, fecRegistro, codUserRegistro, fecUpdate, codUserUpdate);
        this.tipMedico = tipMedico;
        this.licencia = licencia;
        this.codEspecialidad = codEspecialidad;
    }



    public int getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(int codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public int getTipMedico() {
        return tipMedico;
    }

    public void setTipMedico(int tipMedico) {
        this.tipMedico = tipMedico;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
}
