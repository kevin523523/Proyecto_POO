/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  Factura;
import java.util.*;

/**
 *
 * @author Ramses
 */
public class Plan {
    private String nombrePlan;
    private double costoKilovatio;
    private double cargoBase;
    private ArrayList<HorarioPico> picos;
    private ArrayList<String> provincia; 
    
    public Plan(String nombrePlan, double costoKilovatio, ArrayList<String> provincia, double cargoBase, ArrayList<HorarioPico> picos){
        this.nombrePlan = nombrePlan;
        this.costoKilovatio = costoKilovatio;
        this.picos = picos;
        this.cargoBase = cargoBase;
        this.provincia = provincia;   
    }
    
    public ArrayList<HorarioPico> getPicos() {
        return picos;
    }

    public ArrayList<String> getProvincia() {
        return provincia;
    }
  
    public String getNombrePlan() {
        return nombrePlan;
    }
     public double  getCargoBase() {
        return cargoBase;
    }

    public Double getCostoKilovatio() {
        return costoKilovatio;
    }

  }
