package Controlador;

import java.sql.*;

public class Conexion {
    
    private static Connection con = null;

    public static void open() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");	
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }
               
        String url = "jdbc:derby://localhost:1527/Practica5";
        try {
            con = DriverManager.getConnection(url,"usuario","usuario");
        } catch (SQLException ex) {
            System.out.println("ERROR: conexion");
        }
        
    }

    public static Connection getConnection() throws SQLException {
        return con;
    } 
    
    public static void close() {
        try {
            con.close();
        } catch (Exception ignored) {}
    } 
}
