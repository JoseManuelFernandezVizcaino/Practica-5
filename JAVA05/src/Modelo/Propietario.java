package Modelo;

import Controlador.*;
import java.util.*;

public class Propietario {
    
    private String dni;
    private String nombre;
    private String apellido;
    private String imagen;
    private String usuario;
    private String contraseña;
    private GregorianCalendar fecha;
    private float totalKM;
    
    public Propietario(){
        
    }
    
    public Propietario(String dni, String nombre, String apellido, 
                        String imagen, String usuario, String contraseña, GregorianCalendar fecha, float totalKM){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fecha = fecha;
        this.totalKM = totalKM;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public float getTotalKM() {
        return totalKM;
    }

    public void setTotalKM(float totalKM) {       
        this.totalKM = totalKM;
        
    }
    
    @Override
    public String toString(){           
            return  this.dni+"-"+
                    this.nombre+"-"+
                    this.apellido+"-"+
                    Float.toString(this.totalKM)+"-"+
                    Herramienta.gregorianCalendarToString(fecha);
    }
}
