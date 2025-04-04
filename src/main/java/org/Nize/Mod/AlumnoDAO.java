package org.Nize.Mod;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AlumnoDAO {
    private  Connection conn;

    public AlumnoDAO(){
        this.conn = Conexion.getConexion();
    }


    public  void insertarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumnos(nombre,apellido,edad,email) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setString(1,alumno.getNombre());
           stmt.setString(2,alumno.getApellido());
           stmt.setInt(3,alumno.getEdad());
           stmt.setString(4,alumno.getEmail());
           stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("error al insertar el alumno en la base de datos: "+e.getMessage());
        }
    }


    public List<Alumno> listarAlumnos(){
        List<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try(Statement pdst = conn.createStatement()){
        ResultSet rs = pdst.executeQuery(sql);
        while(rs.next()){
            Alumno alumno = new Alumno(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),
                    rs.getInt("edad"),rs.getString("email"));
            listaAlumnos.add(alumno);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }


        return listaAlumnos;
    }

    public Alumno alumnoPorId(int id){
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE id=" + id;
        try(Statement stm = conn.createStatement()){
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                 alumno = new Alumno(rs.getString("nombre"),rs.getString("apellido"),rs.getInt("edad"),rs.getString("email"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return alumno;
    }

    public HashMap<Integer, Direccion> listarAlumnosCompletos(){
        String sql2 = "SELECT d.calle as nombreCalle, d.altura as alturaCalle, d.alumno_id as alumno from direcciones as d join alumnos as a where d.alumno_id=a.id";
        HashMap<Integer, Direccion> mapAlumnos = new HashMap<>();
        try (Statement pdst = conn.createStatement()){
            ResultSet rs = pdst.executeQuery(sql2);
            while (rs.next()){
                Direccion direccion = new Direccion(rs.getString("nombreCalle"), rs.getInt("alturaCalle"), rs.getInt("alumno"));
                mapAlumnos.put(direccion.getAlumnoId(), direccion);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return mapAlumnos;
    }










}
