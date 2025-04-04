package org.Nize.Mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://172.16.1.64:3306/";
    private static final String DB_NAME = "Guia2_JDBC";
    private static final String USER = "bdd1";
    private static final String PASS = "bdd1";


    public static Connection getConexion(){

        try{
            return DriverManager.getConnection(URL + DB_NAME + "?useSSL=false&ServerTimezone=UTC", USER,PASS);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }




    }

}
