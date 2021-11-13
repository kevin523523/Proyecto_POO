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
