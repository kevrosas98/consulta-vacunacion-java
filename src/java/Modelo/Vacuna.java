package Modelo;

import java.time.LocalDate;

public class Vacuna {
    private int idVacuna;
    private int idPaciente;
    private int nroDosis;
    private String lote;
    private int idLocal;
    private int idLab;
    private int idMedico;
    private String fechaVacuna;
    private LocalDate fecRegistro;
    private int codUserReg;
    private LocalDate fecUpdate;
    private int codUserUpdate;

    public Vacuna() {
    }

    public Vacuna(int idVacuna, int idPaciente, int nroDosis, String lote, int idLocal, int idLab, int idMedico, String fechaVacuna, LocalDate fecRegistro, int codUserReg, LocalDate fecUpdate, int codUserUpdate) {
        this.idVacuna = idVacuna;
        this.idPaciente = idPaciente;
        this.nroDosis = nroDosis;
        this.lote = lote;
        this.idLocal = idLocal;
        this.idLab = idLab;
        this.idMedico = idMedico;
        this.fechaVacuna = fechaVacuna;
        this.fecRegistro = fecRegistro;
        this.codUserReg = codUserReg;
        this.fecUpdate = fecUpdate;
        this.codUserUpdate = codUserUpdate;
    }

    public int getCodUserUpdate() {
        return codUserUpdate;
    }

    public void setCodUserUpdate(int codUserUpdate) {
        this.codUserUpdate = codUserUpdate;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getNroDosis() {
        return nroDosis;
    }

    public void setNroDosis(int nroDosis) {
        this.nroDosis = nroDosis;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(String fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public LocalDate getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(LocalDate fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public int getCodUserReg() {
        return codUserReg;
    }

    public void setCodUserReg(int codUserReg) {
        this.codUserReg = codUserReg;
    }

    public LocalDate getFecUpdate() {
        return fecUpdate;
    }

    public void setFecUpdate(LocalDate fecUpdate) {
        this.fecUpdate = fecUpdate;
    }
    
    
}
