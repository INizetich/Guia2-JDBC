package org.Nize.Vista;


import org.Nize.Controller.AlumnoController;
import org.Nize.Controller.DireccionController;
import org.Nize.Mod.Alumno;
import org.Nize.Mod.Direccion;
import org.Nize.Utilities.Utilities;

import java.util.*;

public class Menu {
       private final DireccionController direccionController;
    private final AlumnoController alumnoController;
    private final Scanner scanner;

    public Menu() {
        this.direccionController = new DireccionController();
        this.alumnoController = new AlumnoController();
        this.scanner = new Scanner(System.in);
    }


    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ USUARIOS ---");
            System.out.println("1. Agregar un alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Listar Alumnos con Direcciones");
            System.out.println("4. Agregar una direccion");
            System.out.println("5. Modificar un alumno");
            System.out.println("6. Eliminar un alumno por ID");
            System.out.println("7. Eliminar una direccion por ID");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer del scanner

            switch (opcion) {
                case 1 -> AgregarAlumno();
                case 2 -> listarAlumnos();
                case 3 -> listarAlumnosCompletos();
                case 4 -> agregarDireccion();
                case 5 -> modificarAlumno();
                case 6 -> eliminarAlumno();
                case 7 -> eliminarDireccion();
                case 0 -> {
                    Utilities.limpiarPantalla();
                    Utilities.mostrarCargando();
                }
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

    public void agregarDireccion(){
        System.out.println("ingrese el nombre de la calle: ");
        String calle = scanner.nextLine();
        System.out.println("ingrese la altura de la direccion: ");
        int altura = scanner.nextInt();
        scanner.nextLine();
        listarAlumnos();
        System.out.println("ingrese el id del alumno de esa direccion: ");
        int idAlumno = scanner.nextInt();
        scanner.nextLine();
        direccionController.insertarDireccion(new Direccion(calle,altura, idAlumno));

    }


    public void modificarAlumno(){
        System.out.println("ingrese el id del alumno a modificar: ");
        int idAlumno = scanner.nextInt();
        scanner.nextLine();
        Alumno alumno = alumnoController.alumnoPorId(idAlumno);
        System.out.println("ALUMNO ENCONTRADO: "+alumno.toString());
        System.out.println("ingrese la nueva edad del alumno: ");
        int edadNueva = scanner.nextInt();
        scanner.nextLine();
        if(alumnoController.modificarAlumno(idAlumno,edadNueva)){
            System.out.println("alumno modificado correctamente");
        }else {
            System.out.println("el alumno no se pudo modificar");
        }
    }


    public void eliminarAlumno(){
        listarAlumnos();
        System.out.println("ingrese el id del alumno a eliminar: ");
        int idAlumno = scanner.nextInt();
        scanner.nextLine();
        Alumno alumno = alumnoController.alumnoPorId(idAlumno);
        System.out.println("ALUMNO ENCONTRADO: "+alumno.toString());
        System.out.println("desea eliminar al alumno?");
        char eliminar = scanner.nextLine().charAt(0);
        if(eliminar == 's'){
            if(alumnoController.eliminarAlumno(idAlumno)){
                System.out.println("el alumno fue eliminado correctamente");
            }else {
                System.out.println("El alumno no se pudo eliminar");
            }
        }else{
            System.out.println("el usuario no quiso eliminar al alumno");
        }
    }


    public void eliminarDireccion(){
                mostrarListaDirecciones(direccionController.obtenerDirecciones());
        System.out.println("ingrese el id de la direccion a eliminar: ");
        int idDireccion = scanner.nextInt();
        scanner.nextLine();
         Direccion direccion = direccionController.obtenerDireccion(idDireccion);
        System.out.println("DIRECCION ENCONTRADA: "+direccion.toString());
        System.out.println("desea eliminar al direccion?");
        char eleccion = scanner.nextLine().charAt(0);

        if(eleccion == 's'){
            if(direccionController.eliminarDireccion(idDireccion)){
                System.out.println("La direccion fue eliminado correctamente");
            }else {
                System.out.println("La direccion no se pudo eliminar");
            }
        }else {
            System.out.println("El usuario no quiso eliminar la direccion");
        }

    }








    /// -----------------------METODOS PARA MOSTRAR RESULTADOS DE QUERYS----------------------
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

    public void mostrarListaDirecciones(List<Direccion> lista){
        for(Direccion direccion : lista){
            System.out.println(direccion);
        }
    }
}
