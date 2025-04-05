package org.Nize.Mod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {
    private Connection conn;



    public DireccionDAO(){
        this.conn=Conexion.getConexion();
    }


    public void insertarDireccion(Direccion direccion){
        String sql = "INSERT INTO direcciones(calle,altura,alumno_id) VALUES (?,?,?)";

        try(PreparedStatement pdst = conn.prepareStatement(sql)){
            pdst.setString(1,direccion.getCalle());
            pdst.setInt(2,direccion.getAltura());
            pdst.setInt(3,direccion.getAlumnoId());

            pdst.executeUpdate();
        }catch (SQLException e){
            System.out.println("error al insertar una direccion en la base de datos: "+e.getMessage());
        }
    }


    public boolean eliminarDireccion(int id){
        String sql = "DELETE FROM direcciones WHERE id=" + id;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.executeUpdate();
            return  true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public List<Direccion> listarDirecciones(){
        List<Direccion> direcciones = new ArrayList<Direccion>();
        String sql = "SELECT * FROM direcciones";
        try(Statement statement = conn.createStatement()){
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                Direccion direccion = new Direccion(rs.getInt("id"),rs.getString("calle"),rs.getInt("altura"),rs.getInt("alumno_id"));
                  direcciones.add(direccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return direcciones;
    }


    public Direccion obtenerDireccionPorId(int id){
        Direccion direccion = null;
        String sql = "SELECT * FROM direcciones WHERE id=" + id;
        try(Statement statement = conn.createStatement()){
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                direccion = new Direccion(rs.getInt("id"),rs.getString("calle"),rs.getInt("altura"),rs.getInt("alumno_id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return direccion;
    }


}
