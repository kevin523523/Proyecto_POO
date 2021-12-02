/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Medidor.Medidor;
import Medidor.MedidorAnalogico;
import java.util.Scanner;
/**
 *
 * @author cebor
 */
public class Operario extends Usuario{
    Scanner sc = new Scanner(System.in);


public Operario(String usuario, String contraseña){
super(usuario,contraseña);
  
}

//arralist me
//for 
    public void registrarMedicion(Medidor m){
      System.out.print("Ingrese código del medidor: ");
      String codigo = sc.nextLine();
  
        if(m.getCodigoMedidor().equals(codigo)){
          if(m instanceof MedidorAnalogico){ //medidor analogico
          System.out.println("Medidor analogico a nombre de ");//+ getNombre()+".");
          System.out.println("Ultima lectura realizada"+m.getUltimaFechaCobrado()+".");
          System.out.println("Lectura anterior "+m.getConsumoUltimaFecha()+" kw.");
          System.out.print("Lectura actual: ");
          int lecturaActual = sc.nextInt();
          sc.nextLine();
          System.out.println("Kilovatios consumidos"+ m.calcularConsumo(m.getLecturas())+".");
          }
          else{ //medidor inteligente
            System.out.println("Medidor inteligente a nombre de "); //+ getNombre()+".");
            System.out.println("Ultima lectura realizada"+ m.getUltimaFechaCobrado());
            System.out.println("Lectura anterior "+m.getConsumoUltimaFecha()+" kw.");
            System.out.print("Lectura actual: ");
            int lecturaActual = sc.nextInt();
            sc.nextLine();
            //System.out.println("Kilovatios consumidos"+ m.calcularConsumo()+".");
          }
        }
      
    }
}
                                  