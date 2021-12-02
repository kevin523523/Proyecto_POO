/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Medidor.Medidor;
import Medidor.MedidorAnalogico;



import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;
/**
 *
 * @author cebor

 */
public class Operario extends Usuario{
    Scanner sc = new Scanner(System.in);


    public Operario(String usuario, String contraseña){
      super(usuario,contraseña);
    }

  //arraylist
  //for 

       // registrarMedicion(ab.getMedidores)
    public void registrarMedicion(ArrayList<Medidor> m,Abonado ab, Operario operario ){
      boolean b=true;
        int n=0;
      do{
        System.out.print("Ingrese el codigo del medidor: ");
        String codigo = sc.nextLine();///-->codigo
          
        if(m.get(n).getCodigoMedidor().equals(codigo) && n<m.size()){
            if(m.get(n) instanceof MedidorAnalogico){ //medidor analogico
              System.out.println("Medidor analogico a nombre de "+ ab.getNombre()+".");///a nombre de quien??
              System.out.println("Ultima lectura realizada"+  m.get(n).getUltimaFechaCobrado());
              System.out.println("Lectura anterior"+m.get(n).getConsumoUltimaFecha()+" Kw.");
              System.out.print("Ingrese la lectura actual: ");
              double lecturaActual = sc.nextInt();
              sc.nextLine();
              double kw =lecturaActual- m.get(n).getConsumoUltimaFecha();
              System.out.println("Kilovatios consumidos"+ kw +"Kw.");
              System.out.print("Operario: "+operario.getUsuario());
              MedidorAnalogico ma =(MedidorAnalogico)m.get(n);
              ma.setOperario(operario);
              

              Lectura lectura = new Lectura(LocalDateTime.now(),lecturaActual);
              
              ma.getLecturas().add(lectura);

             b=false;
            }else{
                n=n+1;  

              }
          }
        }while(b);
        }
          /*
          else{ //medidor inteligente
            System.out.println("Medidor inteligente a nombre de "+ m.getNombre()+".");
            System.out.println("Ultima lectura realizada"+ m.getUltimaFechaCobrado());
            System.out.println("Lectura anterior "+m.getConsumoUltimaFecha()+" kw.");
            System.out.print("Lectura actual: ");
            int lecturaActual = sc.nextInt();
            sc.nextLine();
            System.out.println("Kilovatios consumidos"+ m.calcularConsumo()+".");
          }*/
  }
   