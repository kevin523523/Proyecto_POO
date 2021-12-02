/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Medidor.Medidor;
import Factura.Factura;

import java.util.*;

/**
 *
 * @author cebor
 */
public class Abonado extends Usuario{
    private String nombre;  
    private String cedula;
    private String correo;
    private String direccion;
    private ArrayList<Medidor> medidores;
    
    
    public Abonado(String cedula, String contraseña, String correo, String direccion, String nombre){
      super(cedula,contraseña);
      this.correo = correo;
      this.direccion = direccion;
      this.nombre = nombre;
      this.cedula = cedula;
    }

    public String getCedula(){
      return cedula;
    }

    public String getCorreo(){
      return correo;
    }
    
    public String getDireccion(){
      return direccion;
    }
    
    public String getNombre(){
      return nombre;
    }

    public void consultarFactura(Factura facturas){

    }
    
    public void consultarHistoricoFacturado(Medidor medidores){
      
    }

    public void consumoPorHoras(Medidor medidores){

    }
       
}