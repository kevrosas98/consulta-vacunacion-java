package Modelo;

import java.time.LocalDate;

public class Paciente extends Persona{
    private int edad;
    private int ubigeo;
    private String celular;
    private String fNac;
    private String fEmision;
    private String fCaducidad;
    private String direccion;
    private String codQr;

    public Paciente() {
    }

    public Paciente(int edad, int ubigeo, String celular, String fNac, String fEmision, String fCaducidad, String direccion, String codQr) {
        this.edad = edad;
        this.ubigeo = ubigeo;
        this.celular = celular;
        this.fNac = fNac;
        this.fEmision = fEmision;
        this.fCaducidad = fCaducidad;
        this.direccion = direccion;
        this.codQr = codQr;
    }

    public Paciente(int id, int tipoPer, int tipoDoc, String nroDoc, String nom, String ape, String correo, int edad, int ubigeo, String celular, String fNac, String fEmision, String fCaducidad, String direccion, String codQr, LocalDate fecRegistro, int codUserRegistro, LocalDate fecUpdate, int codUserUpdate) {
        super(id, tipoPer, tipoDoc, nroDoc, nom, ape, correo, fecRegistro, codUserRegistro, fecUpdate, codUserUpdate);
        this.edad = edad;
        this.ubigeo = ubigeo;
        this.celular = celular;
        this.fNac = fNac;
        this.fEmision = fEmision;
        this.fCaducidad = fCaducidad;
        this.direccion = direccion;
        this.codQr = codQr;
    }
    
    

    public String getCodQr() {
        return codQr;
    }

    public void setCodQr(String codQr) {
        this.codQr = codQr;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(int ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getfNac() {
        return fNac;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
    }

    public String getfEmision() {
        return fEmision;
    }

    public void setfEmision(String fEmision) {
        this.fEmision = fEmision;
    }

    public String getfCaducidad() {
        return fCaducidad;
    }

    public void setfCaducidad(String fCaducidad) {
        this.fCaducidad = fCaducidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }    
    
}
