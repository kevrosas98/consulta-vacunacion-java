package Modelo;

public class Atributo {
    private int idAtributo;
    private int groupAtributo;
    private int valorAtributo;
    private int tipoAtributo;
    private String nombre;

    public Atributo() {
    }

    public Atributo(int idAtributo, int groupAtributo, int tipoAtributo, int valorAtributo, String nombre) {
        this.idAtributo = idAtributo;
        this.groupAtributo = groupAtributo;
        this.tipoAtributo = tipoAtributo;
        this.valorAtributo = valorAtributo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public int getGroupAtributo() {
        return groupAtributo;
    }

    public void setGroupAtributo(int groupAtributo) {
        this.groupAtributo = groupAtributo;
    }

    public int getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(int tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    public int getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(int valorAtributo) {
        this.valorAtributo = valorAtributo;
    }
    
    
}
