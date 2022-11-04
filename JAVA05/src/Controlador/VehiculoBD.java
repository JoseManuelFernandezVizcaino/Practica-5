package Controlador;

import Modelo.*;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class VehiculoBD {
        private static Statement st = null;
        private static Statement st2 = null;
        private static ResultSet rs = null;
        private static ResultSet rs2 = null;

        
        public static void cargarDatos(Propietario propietario){
            ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
            float total = 0;
            try{
                st = Conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
                rs = st.executeQuery("SELECT * FROM VEHICULO WHERE dniPropietario = (SELECT DNI FROM PROPIETARIO WHERE USUARIO = '"+ propietario.getUsuario()+"' AND CONTRASEÑA = '"+ propietario.getContraseña()+"')");

                while(rs.next()){

                    Vehiculo auxVehi = new Vehiculo( rs.getString(1),
                                                    rs.getString(2),
                                                    rs.getString(3),
                                                    rs.getString(4),
                                                    rs.getString(5),
                                                    rs.getFloat(6),
                                                    Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                    rs.getString(8)

                    );

                        
                    total += rs.getFloat(6);
                    lista.add(auxVehi);
                }
                propietario.setTotalKM(total);
            }catch(SQLException e){
                System.out.println("Error consulta 1");

            }        

        }
        public static ArrayList getLista(Propietario propietario){
        
        ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
        
        try{
            st = Conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT * FROM VEHICULO WHERE dniPropietario = (SELECT DNI FROM PROPIETARIO WHERE USUARIO = '"+ propietario.getUsuario()+"' AND CONTRASEÑA = '"+ propietario.getContraseña()+"')");
             
            while(rs.next()){
                       
                Vehiculo auxVehi = new Vehiculo( rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getFloat(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                rs.getString(8)
                        
                );

                lista.add(auxVehi);
            }

        }catch(SQLException e){
            System.out.println("Error consulta 1");

        }        

        return lista;
    }
    

    public static Vehiculo getVehiculo(Propietario propietario){
        
        try{
        
                st = Conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
                rs = st.executeQuery("SELECT * FROM VEHICULO WHERE dniPropietario = (SELECT DNI FROM PROPIETARIO WHERE USUARIO = '"+ propietario.getUsuario()+"' AND CONTRASEÑA = '"+ propietario.getContraseña()+"')");
                rs.next();

                Vehiculo auxVehi = new Vehiculo( rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getFloat(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                rs.getString(8) );
               
                return auxVehi;
                            
        }catch(SQLException e){
            System.out.println("Error consulta 1");

        }catch(Exception e){
            System.out.println("ERROR");
        }        
        return null;
    }
            
    public static Vehiculo getSiguiente(){
        try{
            if(rs.next()){
                Vehiculo auxVehi = new Vehiculo( rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getFloat(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                rs.getString(8) );
               
                return auxVehi;
           }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
        public static Vehiculo getAnterior(){
        try{
            if(rs.previous()){
            rs.previous();
            Vehiculo auxVehi = new Vehiculo( rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getFloat(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                rs.getString(8) );
            
            return auxVehi;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
        
    public static boolean getPrimero(){
        try{
            if(rs.first()){
                return rs.first();
           }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
        
    public static void actualizarDato(String km, GregorianCalendar fecha,String dni,String matricula){
         try{
                        
            st2 = Conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
            if(km != null){
                st2.executeUpdate("UPDATE VEHICULO SET KMRECORRIDOS = "+ km +" WHERE MATRICULA = '"+matricula+"'");
            }
            if(fecha != null){
                st2.executeUpdate("UPDATE VEHICULO SET FECHACOMPRA = '"+(fecha.get(Calendar.MONTH)+1) +"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR)+"' WHERE MATRICULA = '"+matricula+"'");
            }
        }catch(SQLException e){
            System.out.println("Error consulta UPDATE");

        }catch(Exception e){
            System.out.println("ERROR");
        }        
    }
    
    public static Vehiculo moverPrimero(){
        try{
            if(rs.first()){
                Vehiculo auxVehi = new Vehiculo( rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5),
                                                rs.getFloat(6),
                                                Herramienta.dateToGregorianCalendar(rs.getDate(7)),
                                                rs.getString(8) );
                return auxVehi;
           }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
