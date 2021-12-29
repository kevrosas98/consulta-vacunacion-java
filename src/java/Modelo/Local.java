package Modelo;

public class Local {

    private int id;
    private String nombre;
    private String direccion;
    private int ubigeo;

    public Local() {
    }

    public Local(int id, String nombre, String direccion, int ubigeo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ubigeo = ubigeo;
    }

    public int getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(int ubigeo) {
        this.ubigeo = ubigeo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
