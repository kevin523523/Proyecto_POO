/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import java.util.ArrayList;
import java.util.Date;
//import Usuario.Usuario;

/**
 *
 * @author cebor
 */
public class Medidor {
   private String codigoMedidor;
   private Plan plan;
   //private Provincia provincia;
   private String direccion;
   private ArrayList<Lectura> lecturas ;
   private Date ultimaFechaCobrado;
   private int consumoUltimaFecha;
   //private UsuarioAbonado abonado;

    public String getCodigoMedidor() {
        return codigoMedidor;
    }

    public void setCodigoMedidor(String codigoMedidor) {
        this.codigoMedidor = codigoMedidor;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(ArrayList<Lectura> lecturas) {
        this.lecturas = lecturas;
    }

    public Date getUltimaFechaCobrado() {
        return ultimaFechaCobrado;
    }

    public void setUltimaFechaCobrado(Date ultimaFechaCobrado) {
        this.ultimaFechaCobrado = ultimaFechaCobrado;
    }

    public int getConsumoUltimaFecha() {
        return consumoUltimaFecha;
    }

    public void setConsumoUltimaFecha(int consumoUltimaFecha) {
        this.consumoUltimaFecha = consumoUltimaFecha;
    }
   
   
   
}
