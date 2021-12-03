/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidor;

import java.util.*;
import java.util.UUID;
import Factura.*;
import java.time.*;

/**
 *
 * @author cebor
 */
public abstract class Medidor {

    private String codigoMedidor;
    private Plan plan;
    private String direccion;
    private ArrayList<Lectura> lecturas;
    private LocalDateTime ultimaFechaCobrado;
    private double consumoUltimaFecha;//consumoUltimaFacturade KW

    public Medidor(Plan plan, String direccion, ArrayList<Lectura> lecturas, LocalDateTime ufc, double cUF) {
        codigoMedidor = UUID.randomUUID().toString().toLowerCase().substring(0, 6); ///aleatorio alfanumerico
        this.plan = plan;
        this.direccion = direccion;
        this.lecturas = lecturas;
        this.ultimaFechaCobrado = ufc;
        this.consumoUltimaFecha = cUF;
    }

    public Medidor(Plan plan, String direccion, ArrayList<Lectura> lecturas, double cUF) {
        codigoMedidor = UUID.randomUUID().toString().toLowerCase().substring(0, 6); ///aleatorio alfanumerico
        this.plan = plan;
        this.direccion = direccion;
        this.lecturas = lecturas;
        ultimaFechaCobrado = LocalDateTime.now();
        this.consumoUltimaFecha = cUF;
    }

    public String getCodigoMedidor() {
        return codigoMedidor;
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

    public LocalDateTime getUltimaFechaCobrado() {
        return ultimaFechaCobrado;
    }

    public void setUltimaFechaCobrado(LocalDateTime ultimaFechaCobrado) {
        this.ultimaFechaCobrado = ultimaFechaCobrado;
    }

    public double getConsumoUltimaFecha() {
        return consumoUltimaFecha;
    }

    public void setConsumoUltimaFecha(double consumoUltimaFecha) {
        this.consumoUltimaFecha = consumoUltimaFecha;
    }

    public abstract double calcularConsumo(ArrayList<Lectura> lecturas);

    public abstract double calcularCosto(ArrayList<Lectura> lecturas, Plan p);

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Medidor) {
                Medidor me = (Medidor) obj;
                if (codigoMedidor.equals(me.codigoMedidor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "codigo medidor: " + codigoMedidor;
    }
}
   


