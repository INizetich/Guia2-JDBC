package org.Nize.Mod;

public class Direccion {
    private int id;
    private String calle;
    private int altura;
    private int alumnoId;

    public Direccion(String calle, int altura, int alumnoId) {
        this.id = 0;
        this.calle = calle;
        this.altura = altura;
        this.alumnoId = alumnoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public void mostrarSimple(){
        System.out.println("Calle: " + getCalle());
        System.out.println("Altura: " + getAltura());
    }


    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", altura=" + altura +
                ", alumnoId=" + alumnoId +
                '}';
    }
}
