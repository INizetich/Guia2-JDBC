package org.Nize.Vista;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.Nize.Controller.AlumnoController;
import org.Nize.Mod.Alumno;
import org.Nize.Mod.AlumnoDAO;
import org.Nize.Mod.Direccion;

import java.util.*;

public class Menu {

    private final AlumnoController alumnoController;
    private final Scanner scanner;

    public Menu() {
        this.alumnoController = new AlumnoController();
        this.scanner = new Scanner(System.in);
    }


    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ USUARIOS ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Listar Alumnos con Direcciones");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer del scanner

            switch (opcion) {
                case 1 -> AgregarAlumno();
               case 2 -> listarAlumnos();
               case 3 -> listarAlumnosCompletos();
//                case 4 -> actualizar();
//                case 5 -> eliminar();
                case 0 -> System.out.println("¡Chau!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }


    public void AgregarAlumno() {
        System.out.println("ingrese el nombre del alumno: ");
        String nombreAlumno = scanner.nextLine();
        System.out.println("ingrese el apellido del alumno: ");
        String apellidoAlumno = scanner.nextLine();
        System.out.println("ingrese la edad del alumno: ");
        int edadAlumno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ingrese el email del alumno: ");
        String emailAlumno = scanner.nextLine();

        alumnoController.agregarAlumno(nombreAlumno, apellidoAlumno, edadAlumno, emailAlumno);
    }


    public void listarAlumnos(){
        List<Alumno> listaAlumnos = alumnoController.mostrarAlumnos();
        mostrarLista(listaAlumnos);

    }

    public void listarAlumnosCompletos(){
        HashMap<Integer, Direccion> alumnosComp = alumnoController.mostrarAlumnosCompletos();
        mostrarListaCompleta(alumnosComp);

    }

    public void mostrarListaCompleta(HashMap<Integer, Direccion> mapa){
        Alumno alumno = new Alumno();
        for (Map.Entry<Integer, Direccion> entrada : mapa.entrySet()) {
            Integer clave = entrada.getKey();
            alumno = alumnoController.alumnoPorId(clave);
            Direccion direccion = entrada.getValue();
            alumno.mostrarSimple();
            System.out.println("Direcciones: ");
            direccion.mostrarSimple();
            System.out.println("\n");
        }
    }


    public void mostrarLista(List<Alumno> lista){
        for(Alumno alumno : lista){
            System.out.println(alumno);
        }
    }
}
