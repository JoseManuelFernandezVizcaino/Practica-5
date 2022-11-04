package Modelo;

import Controlador.Herramienta;
import java.util.*;

public class Vehiculo {
    
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String combustible;
    private float kmRecorridos;
    private GregorianCalendar fechaCompra;
    private String dniPropietario;
    
    public Vehiculo(){
        
    }
    
    public Vehiculo(String matricula, String marca, String modelo, String color, String combustible, float kmRecorridos,  GregorianCalendar fecha, String dniPropietario){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.combustible = combustible;
        this.kmRecorridos = kmRecorridos;
        this.fechaCompra = fecha;
        this.dniPropietario = dniPropietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public float getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(float kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public GregorianCalendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(GregorianCalendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    @Override
    public String toString(){           
            return  this.matricula+"-"+
                    this.modelo+"-"+
                    this.combustible+"-"+
                    Float.toString(this.kmRecorridos)+"-"+
                    Herramienta.gregorianCalendarToString(fechaCompra);
    }
}
