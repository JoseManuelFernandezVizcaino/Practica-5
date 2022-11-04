package Controlador;

import Modelo.*;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PropietarioBD {
    private static Statement st = null;
    private static ResultSet rs = null;
    
     
    public static ArrayList getLista(String query){
        ArrayList<Propietario> lista = new ArrayList<Propietario>();
        try{
            st = Conexion.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Propietario auxEmp = new Propietario( rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getString(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                rs.getFloat(8)
                );
                
                lista.add(auxEmp);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta 1");
        }        
        return lista;
    }
    
    public static Propietario getPropietario(String usuario, String contraseña){
        
        try{
            
            st = Conexion.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM PROPIETARIO WHERE USUARIO = '" + usuario +"' AND CONTRASEÑA = '" + contraseña +"'");
            rs.next();
                       
            Propietario prop = new Propietario( rs.getString(1),rs.getString(2),rs.getString(3),
                                               rs.getString(4), rs.getString(5),rs.getString(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),rs.getFloat(8));
                
            rs.close();
            st.close();
            
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent, "Login correcto");
            return prop;
        }catch(SQLException e){
            System.out.println("Error consulta 1");
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent, "Login incorrecto");
        }
        return null;
    }
    
    public static void actualizarDato(String km, String dni){
         try{
            st = Conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("UPDATE PROPIETARIO SET TOTALKM = "+ km +" WHERE DNI = '"+ dni+"'");

        }catch(SQLException e){
            System.out.println("Error consulta 1");

        }catch(Exception e){
            System.out.println("ERROR");
        }        
    }
}
