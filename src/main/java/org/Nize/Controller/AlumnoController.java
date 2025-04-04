package org.Nize.Controller;

import org.Nize.Mod.Alumno;
import org.Nize.Mod.AlumnoDAO;
import org.Nize.Mod.Direccion;

import java.util.HashMap;
import java.util.List;

public class AlumnoController {

    private AlumnoDAO alumnoDAO;

    public AlumnoController(){
        alumnoDAO = new AlumnoDAO();
    }


    public void agregarAlumno(String nombre,String apellido,int edad,String email){
        alumnoDAO.insertarAlumno(new Alumno(nombre,apellido,edad,email));
    }


    public List<Alumno> mostrarAlumnos(){
       return alumnoDAO.listarAlumnos();
    }

    public HashMap<Integer, Direccion> mostrarAlumnosCompletos(){
        return alumnoDAO.listarAlumnosCompletos();
    }

    public Alumno alumnoPorId(int idalumno){
        return alumnoDAO.alumnoPorId(idalumno);
    }
}
