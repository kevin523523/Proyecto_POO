/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;
import Medidores.Provincia;
import java.util.List;

/**
 *
 * @author Ramses
 */
public class Plan {
    private String nombre;
    private Double costoKilovatio;
    private List<HorarioPico> picos;
    private List<Provincia> provincia; 
    
    public Plan(String nombre,Double costoKilovatio,List<HorarioPico> picos, List<Provincia> provincia){
        this.nombre = nombre;
        this.costoKilovatio = costoKilovatio;
        this.picos = picos;
        this.provincia = provincia;
        
    }
    
    public Plan(){
    }

    public List<HorarioPico> getPicos() {
        return picos;
    }

    public void setPicos(List<HorarioPico> picos) {
        this.picos = picos;
    }

    public List<Provincia> getProvincia() {
        return provincia;
    }

    public void setProvincia(List<Provincia> provincia) {
        this.provincia = provincia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoKilovatio() {
        return costoKilovatio;
    }

    public void setCostoKilovatio(Double costoKilovatio) {
        this.costoKilovatio = costoKilovatio;
    }  
}