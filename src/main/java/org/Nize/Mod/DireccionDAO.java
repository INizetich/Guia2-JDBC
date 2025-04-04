package org.Nize.Mod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DireccionDAO {
    private Connection conn;



    public DireccionDAO(){
        this.conn=Conexion.getConexion();
    }


    public void insertarDireccion(Direccion direccion){
        String sql = "INSERT INTO direccion(calle,altura,alumno_id) VALUES (?,?,?)";

        try(PreparedStatement pdst = conn.prepareStatement(sql)){
            pdst.setString(1,direccion.getCalle());
            pdst.setInt(2,direccion.getAltura());
            pdst.setInt(3,direccion.getAlumnoId());

            pdst.executeUpdate();
        }catch (SQLException e){
            System.out.println("error al insertar una direccion en la base de datos: "+e.getMessage());
        }
    }


}
