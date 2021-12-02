/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factura;

import java.time.LocalDateTime;

/**
 *
 * @author Ramses
 */
public class Lectura {
    //private Operario operario;
    private LocalDateTime fechaToma;
    private double kilovatios;

    public Lectura(LocalDateTime fechaToma,double kilovatios){
      this.fechaToma=fechaToma;
      this.kilovatios=kilovatios;

    }

    public LocalDateTime getFechaToma() {
        return fechaToma;
    }
 
    public double getKilovatios() {
      return kilovatios;
    }

    public void setKilovatios(double kilovatios) {
        this.kilovatios = kilovatios;
    }
    
}
