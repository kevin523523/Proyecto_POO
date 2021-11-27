/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.util.Scanner;
import java.util.ArrayList;
import Usuario.Usuario;
import Usuario.Administrador;
import Usuario.Abonado;
import Usuario.Operador;
import Medidores.Plan;
import Medidores.Medidor;
import java.time.*;
/**
 *
 * @author Ramses
 */

public class FacturaSystem {
    
    private ArrayList<Factura> facturas;
    private ArrayList<Medidor> medidores;
    private ArrayList<Plan> planes;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;
    private 
    
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
            System.out.print("Ingrese el número de la opción a realizar: ");
            entrada = sc.nextLine();
            switch(entrada){
                case "1":
                    boolean continuar = false;
                    do{
                        //pide el nombre del usuario
                        System.out.print("Ingrese su usuario: ");
                        String usuario = sc.nextLine();

                        //pide la contraseña del usuario
                        System.out.print("Ingrese su contraseña: ");
                        String contraseña = sc.nextLine();
                        
                        //Verificamos que el usuario existe
                        if(verificarUsuario(usuario, contraseña)){
                            //llamamos a metodo iniciarSesion()
                            iniciarSesion(usuario, contraseña);
                            continuar = true;
                        }else{
                            System.out.println("Usuario o contraseña incorrecta, vuelva a ingresar sus datos.");
                            continuar = false;
                        }
                    }while(continuar == false);                   
                    break;
                     
                case "2":
                    //mostramos mensaje de finalizacion
                    salir();
                    break;
                    
                default:
                    //la opcion ingreada no esta dentro de las opciones del menú
                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 o 2.");
                    break;
            }
        }while(!entrada.equals("2"));
    }
    
    public boolean verificarUsuario(String usuario, String contraseña){
        for(Usuario u : usuarios){
            if(usuario.equals(u.getUsuario()) && usuario.equals(u.getContraseña())){
                return true;
            }
        }
        return false;
    }
    
    public void iniciarSesion(String usuario, String contraseña){
        if(!(usuarios.isEmpty())){
            for(Usuario u : usuarios){
                if(verificarUsuario(usuario, contraseña)){
                    //Si el usuario ingresado es Administrador
                    if(u instanceof Administrador){
                        System.out.println("1. Registrar Abonado");
                        System.out.println("2. Registrar plan");
                        System.out.println("3. Registrar medidor");
                        System.out.println("4. Simular medicion");
                        System.out.println("5. Realizar facturacion");
                        System.out.println("6. Salir");
                        String opcion = "";
                        Administrador ad = (Administrador)u;
                        
                        do{
                            System.out.print("Ingrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();                            
                            
                            switch(opcion){
                                
                                case "1":
                                    System.out.print("Ingrese cedula: ");
                                    String cedula = sc.nextLine();
                                    
                                    System.out.print("Ingrese correo: ");
                                    String correo = sc.nextLine();
                                    
                                    System.out.print("Ingrese nombre: ");
                                    String nombre = sc.nextLine();
                                    
                                    System.out.print("Ingrese el nombre de usuario: ");
                                    String usuario_2 = sc.nextLine();
                                    
                                    System.out.print("Ingrese contraseña: ");
                                    String contraseña_2 = sc.nextLine();
                                    
                                    ad.registrarAbonado(cedula, correo, nombre, usuario_2, contraseña_2);
                                    break;
                                case "2":
                                    System.out.print("Ingrese el nombre del plan: ");
                                    String nombrePlan = sc.nextLine();
                                    
                                    System.out.print("Ingrese el costo: ");
                                    double costo = sc.nextDouble();
                                    sc.nextLine();
                                    
                                    System.out.print("Ingrese cargo base: ");
                                    double cargoBase = sc.nextDouble();
                                    sc.nextLine();
                                    
                                    System.out.print("Ingrese las horas pico: ");
                                    int horasPico = sc.nextInt();
                                    sc.nextLine();
                                    
                                    ad.registrarPlan(nombrePlan, costo, provincia, cargoBase, horasPico);
                                    break;
                                case "3":
                                    System.out.print("Ingrese direccion: ");
                                    String direccion = sc.nextLine();
                                    
                                    System.out.print("Ingrese el nombre del medidor: ");
                                    String medidor = sc.nextLine();
                                    
                                    System.out.print("Ingrese el nombre del plan: ");
                                    String plan = sc.nextLine();
                                    
                                    ad.registrarMedidor(direccion, medidor, plan);
                                    break;
                                case "4":
                                    System.out.print("Ingrese fecha de inicio: ");
                                    int fechaInicio = sc.nextInt();
                                    sc.nextLine();
                                    
                                    System.out.print("Ingrese fecha de fin: ");
                                    int fechaFin = sc.nextInt();
                                    sc.nextLine();
                                    
                                    ad.simularMedicion(fechaInicio, fechaFin);
                                    break;
                                case "5":
                                    ad.realizarFacturacion();
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 y 4.");
                            }
                        }while(!opcion.equals("4"));
                    }
                    
                    //Si el usuario ingresado es Abonado
                    else if(u instanceof Abonado){
                        System.out.println("1. Consultar factura");
                        System.out.println("2. Consultar historico facturado");
                        System.out.println("3. Consultar consumo por hora");
                        System.out.println("4. Salir");
                        String opcion = "";
                        Abonado a = (Abonado)u;
                        do{
                            System.out.print("Ingrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();
                                                        
                            switch(opcion){
                                
                                case "1":                                                                  
                                    a.consultarFactura(facturas);
                                    break;
                                case "2":                                    
                                    a.consultarHistoricoFacturado(medidores);
                                    break;
                                case "3":
                                    a.consumoPorHoras(medidores);
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 y 4.");
                                    break;
                            }
                        }while(!opcion.equals("4"));
                    }
                    
                    //Si no es ninguna de los anteriores el usuario ingresado es Operador
                    else{
                        System.out.println("1. Registrar medicion");
                        System.out.println("2. Salir");

                        String opcion = "";
                        do{
                            System.out.print("Ingrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();
                            Operador o = (Operador)u;

                            switch(opcion){
                                case "1":
                                    System.out.print("Ingrese la medicion en KWH: ");
                                    double medicion = sc.nextDouble();
                                    o.registrarMedicion(medicion);
                                    break;
                                case "2":
                                    salir();
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 o 2.");
                                    break;
                            }
                        }while(!opcion.equals("2"));
                    }
                }
            }
        }System.out.println("No hay usuarios registrados.");
    }
    
    public void salir(){
        System.out.println("Gracias por preferirnos, adiós.");
    }
}