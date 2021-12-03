/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Factura.Lectura;
import Medidor.Medidor;
import Medidor.MedidorAnalogico;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;

/**
 *
 * @author cebor
 *
 */
public class Operario extends Usuario {

    Scanner sc = new Scanner(System.in);

    public Operario(String usuario, String contraseña) {
        super(usuario, contraseña);
    }

    //arraylist
    //for 
    // registrarMedicion(ab.getMedidores)
    public void registrarMedicion(ArrayList<Medidor> m, ArrayList<Usuario> usuarios, Operario operario) {
        
        boolean b = true;
        int n = 0;
        String codigo = "";

        do {
            System.out.println("Ingrese el codigo del medidor: ");
            codigo = sc.nextLine();
            
            for (Medidor med : m) {
                if (med.getCodigoMedidor().equals(codigo)) {
                    if (med instanceof MedidorAnalogico) {
                        for (Usuario u : usuarios) {
                            if (u instanceof Abonado) {
                                Abonado ab = (Abonado) u;
                                if (ab.getDireccion().equals(med.getDireccion())) {
                                    
                                    System.out.println("Medidor analogico a nombre de " + ab.getNombre() + ".");///a nombre de quien??
                                    System.out.println("Ultima lectura realizada " + med.getUltimaFechaCobrado());
                                    System.out.println("Lectura anterior " + med.getConsumoUltimaFecha() + " Kw.");
                                    System.out.println("Ingrese la lectura actual: ");
                                    double lecturaActual = sc.nextInt();
                                    sc.nextLine();
                                    double kw = lecturaActual - med.getConsumoUltimaFecha();
                                    System.out.println("Kilovatios consumidos " + kw + "Kw.");
                                    System.out.println("Operario: " + operario.getUsuario());
                                    
                                    MedidorAnalogico ma = (MedidorAnalogico) m.get(n);
                                    ma.setOperario(operario);
                                    
                                    Lectura lectura = new Lectura(LocalDateTime.now(), lecturaActual);
                                    
                                    ma.getLecturas().add(lectura);
                                    
                                    b = false;
                                }
                            }
                        }
                    }
                }
            }System.out.println("Codigo del medidor invalido, vuelva a ingresar uno valido");         
        } while(b);
    }
    
}
