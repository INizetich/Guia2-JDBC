package org.Nize.Mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://shinkansen.proxy.rlwy.net:21319/";
    private static final String DB_NAME = "railway";
    private static final String USER = "root";
    private static final String PASS = "sGUVFxlVsHsJjQbfjxRPCMoByvfrSEPf";


    public static Connection getConexion(){

        try{
            return DriverManager.getConnection(URL + DB_NAME + "?useSSL=false&ServerTimezone=UTC", USER,PASS);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }




    }

}
