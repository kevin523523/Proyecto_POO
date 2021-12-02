/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidor;
import java.util.*;
import java.time.*;
import Factura.*;
/**
 * @author cebor
 */
public class MedidorInteligente extends Medidor {

  public MedidorInteligente (Plan plan, String direccion, ArrayList<Lectura> lectura, LocalDateTime ufc, int cUF){
    super(plan, direccion, lectura,  ufc,  cUF);
  } 

  //Para registrar el medidor nuevo
  public MedidorInteligente (Plan plan, String direccion){
    super(plan, direccion, new ArrayList<Lectura>(), LocalDateTime.now(), 0);
  }

//[l1,l2,l3...]
//[l1.getKv,l2.getkv,l3.getk ]
//[500,530,600,....]

  @Override
  public double calcularConsumo(ArrayList<Lectura> lecturas){
    int n = lecturas.size();
    double c= lecturas.get(n-1).getKilovatios() - lecturas.get(0).getKilovatios();
    return c;
  }   
    
  public ArrayList<Double> calcularConsumocada30(ArrayList<Lectura> lecturas){
    ArrayList<Double> kw30 = new ArrayList<>();
    for (Lectura l:lecturas){
      double kw=l.getKilovatios();
      kw30.add(kw);
    }
    return kw30;
  }   

  @Override
  public double calcularCosto(ArrayList<Lectura> lecturas, Plan p){
    double consumoTotal =calcularConsumo(lecturas);
    ArrayList<HorarioPico> consumosPico =p.getPicos();
    double consumoP=0;
    double kwInicial=0;
    double kwFinal=0;

    for( HorarioPico consumoPico:consumosPico ){
      for(Lectura lectura:lecturas){
              
        if(consumoPico.getHorarioInicio().compareTo(lectura.getFechaToma().toLocalTime())==0 ){    ///fechatoma necesito solo su hora*-*
            kwInicial=lectura.getKilovatios();
        }
        else if (consumoPico.getHorarioFin().compareTo(lectura.getFechaToma().toLocalTime())==0 ){
          
            kwFinal=lectura.getKilovatios();
        }
      } consumoP+= kwFinal-kwInicial;
    }
    double consumoNoPico= consumoTotal - consumoP;
    double total= p.getCargoBase()+(p.getCostoKilovatio()*consumoNoPico)+(2*p.getCostoKilovatio()*consumoP);
    return total;
  }

  public String toString(int n){
    return getCodigoMedidor()+", "+getLecturas().get(n).getFechaToma()+", "+ getLecturas().get(n).getKilovatios();
  }
  
}
