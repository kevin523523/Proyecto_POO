/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.util.Scanner;

/**
 *
 * @author Ramses
 */

public class Interfaz {
    Scanner sc = new Scanner(System.in);
    
    public void presentarMenuPrincipal(){
        System.out.println("Bienvenido a nuestro Sistema de Facturas\n");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Salir\n");
    }
    public void iniciar(){
        String entrada = "";
        do{
            presentarMenuPrincipal();
            System.out.print("Ingrese el número de la opción: ");
            entrada = sc.nextLine();
            switch(entrada){
                case "1":
                    //llamamos a metodo iniciarSesion()
                    iniciarSesion();
                    break;
                case "2":
                    //mostramos mensaje de finalizacion
                    System.out.println("Gracias por preferirnos, adiós.");
                    break;
                default:
                    //la opcion ingreada no esta dentro de las opciones del menú
                    System.out.println("Opcion inválida");
                    break;
            }
        }while(!entrada.equals("2"));
    }
    
    public void iniciarSesion(){
        //pide el nombre del usuario
        System.out.print("Ingrese su usuario: ");
        String usuario = sc.nextLine();
        
        //pide la contraseña del usuario
        System.out.print("Ingrese su contraseña: ");
        String contraseña = sc.nextLine();
        
        /*
        for(:){
            if(usuario.equals()){
            }
        }
        */
    }
}