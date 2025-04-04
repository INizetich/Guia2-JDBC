package org.Nize.Mod;

public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;

    public Alumno() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.email = "";
    }

    public Alumno(int id, String nombre, String apellido, int edad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
        this.email = email;
    }

    public Alumno(String nombre, String apellido, int edad, String email) {
        this.id = 0;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarSimple(){
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Apellido: "+ getApellido());
    }


    @Override
    public String toString() {
        return "Id: " + id + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Edad: " + edad + '\n' +
                "Email: " + email + '\n';
    }
}
