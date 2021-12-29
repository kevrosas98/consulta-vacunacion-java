package Modelo;

public class Ubigeo {
    private String idUbigeo;
    private String nomUbigeo;

    public Ubigeo() {
    }

    public Ubigeo(String idUbigeo, String nomUbigeo) {
        this.idUbigeo = idUbigeo;
        this.nomUbigeo = nomUbigeo;
    }

    public String getNomUbigeo() {
        return nomUbigeo;
    }

    public void setNomUbigeo(String nomUbigeo) {
        this.nomUbigeo = nomUbigeo;
    }

    public String getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(String idUbigeo) {
        this.idUbigeo = idUbigeo;
    }
    
    
}
