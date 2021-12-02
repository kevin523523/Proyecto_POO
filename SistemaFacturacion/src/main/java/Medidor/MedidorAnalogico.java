/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidor;
import Factura.Plan;
import Factura.Lectura;
import java.time.*;
import java.util.*;

/**
 *
 * @author cebor
 */

public class MedidorAnalogico extends Medidor {
  
  public MedidorAnalogico (Plan plan,String direccion, ArrayList<Lectura> lectura, LocalDateTime ufc, int cUF){
    super(plan, direccion, lectura,  ufc,  cUF);
  }

  //Para registrar el medidor nuevo
  public MedidorAnalogico (Plan plan,String direccion){
    super(plan, direccion, new ArrayList<Lectura>(), LocalDateTime.now(), 0);
  }
  

@Override
public double calcularConsumo(ArrayList<Lectura> lecturas){
      int n =lecturas.size();
      double c=lecturas.get(n-1).getKilovatios() - lecturas.get(0).getKilovatios();
      return c;
    }  


 @Override
  public double calcularCosto(ArrayList<Lectura> lecturas, Plan p){
    double consumo = calcularConsumo(lecturas); 
    double total= p.getCargoBase()+(p.getCostoKilovatio()*consumo);
    return total;
  }

}