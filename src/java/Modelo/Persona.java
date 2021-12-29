package Modelo;

import java.time.LocalDate;

public class Persona {
    private int id;
    private int tipoPer;
    private int tipoDoc;
    private String nroDoc;
    private String nom;
    private String ape;
    private String correo;
    private LocalDate fecRegistro;
    private int codUserRegistro;
    private LocalDate fecUpdate;
    private int codUserUpdate;

    public Persona() {
    }

    public Persona(int id, int tipoPer, int tipoDoc, String nroDoc, String nom, String ape, String correo, LocalDate fecRegistro, int codUserRegistro, LocalDate fecUpdate, int codUserUpdate) {
        this.id = id;
        this.tipoPer = tipoPer;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.nom = nom;
        this.ape = ape;
        this.correo = correo;
        this.fecRegistro = fecRegistro;
        this.codUserRegistro = codUserRegistro;
        this.fecUpdate = fecUpdate;
        this.codUserUpdate = codUserUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoPer() {
        return tipoPer;
    }

    public void setTipoPer(int tipoPer) {
        this.tipoPer = tipoPer;
    }

    public int getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(int tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(LocalDate fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public int getCodUserRegistro() {
        return codUserRegistro;
    }

    public void setCodUserRegistro(int codUserRegistro) {
        this.codUserRegistro = codUserRegistro;
    }

    public LocalDate getFecUpdate() {
        return fecUpdate;
    }

    public void setFecUpdate(LocalDate fecUpdate) {
        this.fecUpdate = fecUpdate;
    }

    public int getCodUserUpdate() {
        return codUserUpdate;
    }

    public void setCodUserUpdate(int codUserUpdate) {
        this.codUserUpdate = codUserUpdate;
    }
    
}
