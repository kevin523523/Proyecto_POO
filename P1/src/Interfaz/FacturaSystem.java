/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
import Usuario.Administrador;
import Usuario.*;
import Medidor.*;
import Factura.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;
import java.util.UUID;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Ramses
 */

public class FacturaSystem {
    private ArrayList<Factura> facturas = new ArrayList<>();
    private ArrayList<Medidor> medidores = new ArrayList<>();
    private ArrayList<Plan> planes = new ArrayList<>();
    private ArrayList<String> provincia = new ArrayList<>();
    
    Usuario a = new Administrador("admin", "superadmin");
    Usuario b = new Operario("op", "op");
    Usuario c = new Operario("ap", "ap");
    //Plan p = new Plan("kevin-residencial-1", 12.5, {"GUAYAS"}, 3.5, {"11-2-2021"});
    
    Usuario d = new Abonado("120", "123", "correo c", "direccion A", "Ian g");
    Usuario e = new Abonado("121", "345", "correo cr", "direccion B", "R G");
    
    public ArrayList<Usuario> usuarios = new ArrayList<>(Arrays.asList(a, b, c, d, e));
    
    Scanner sc = new Scanner(System.in);
    //private Usuario[] usuarios;  
    //usuarios.add(a);
    /*
    usuarios.add(new Administrador("admin", "superadmin"));
    usuarios.add(new Operario("op", "op"));
    usuarios.add(new Operario("ap", "ap"));
    planes.add(new Plan("kevin", 12.5, "GUAYAS"));
    usuarios.add(new Abonado("120", "123", "correo c", "direccion A", "Ian g"));
    usuarios.add(new Abonado("121", "345", "correo cr", "direccion B", "R G"));
    */
    
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
                    boolean continuar = true;
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
                            continuar = false;
                        }else{
                            System.out.println("Usuario o contraseña incorrecta, vuelva a ingresar sus datos.\n");
                            continuar = true;
                        }
                    }while(continuar);                   
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
            if(u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)){
                return true;
            }
        }return false;
    }
    
    public void iniciarSesion(String usuario, String contraseña){
        if(!(usuarios.isEmpty())){
            for(Usuario u : usuarios){
                if(u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)){
                    //Si el usuario ingresado es Administrador
                    if(u instanceof Administrador){
                        System.out.println("\n1. Registrar Abonado");
                        System.out.println("2. Registrar plan");
                        System.out.println("3. Registrar medidor");
                        System.out.println("4. Simular medicion");
                        System.out.println("5. Realizar facturacion");
                        System.out.println("6. Salir");
                        String opcion = "";
                        Administrador ad = (Administrador)u;
                        
                        do{
                            System.out.print("\nIngrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();                            
                            
                            switch(opcion){                              
                                case "1":                                    
                                    //Validacion para que el numero de cedula no se repita                           
                                    ArrayList<String> cedulas = new ArrayList<>();
                                    for(Usuario ur : usuarios){//p 1
                                        if(ur instanceof Abonado){
                                            Abonado abn = (Abonado)ur;
                                            cedulas.add(abn.getCedula());
                                        }
                                    }                                    
                                    
                                    boolean bandera = true;                                    
                                    do{
                                        System.out.print("Ingrese numero de cédula: ");                                   
                                        String cedula = sc.nextLine();
                                        
                                        if(!(cedulas.contains(cedula))){
                                            System.out.println("No existe un abonado con esta cédula");
                                            ad.registrarAbonado(cedula);
                                            bandera = false;
                                        }else if(cedulas.contains(cedula)){
                                            System.out.println("Ya existe un abonado con esta cédula, ingrese otra.\n");
                                            bandera = true;
                                        }
                                    }while(bandera);                                                                                                         
                                    break;

                                case "2":                                    
                                    //OJO
                                    //if(!(planes.isEmpty())){                                                                                
                                        //Validar el nombre del plan
                                        //ArrayList de nombres de planes(String)
                                        ArrayList<String> nombresplanes = new ArrayList<>();
                                        for(Plan pl : planes){
                                            Plan p = (Plan)pl;
                                            nombresplanes.add(p.getNombrePlan());
                                        }
                                        
                                        boolean bandera1 = true;
                                        String nombrePlan = "";
                                        do{
                                            System.out.print("Ingrese el nombre del plan: ");
                                            nombrePlan = sc.nextLine();
                                            
                                            if(nombresplanes.contains(nombrePlan)){
                                                System.out.print("El nombre del plan ya existe, ingrese uno nuevo.\n");
                                                bandera1 = true;
                                            }
                                            else if(!(nombresplanes.contains(nombrePlan))){
                                                //Seguimos y se pide los otros datos y se agrega el plan 
                                                System.out.print("Ingrese el costo de kilovatios hora: $");
                                                double costo = sc.nextDouble();
                                                sc.nextLine();
                                                
                                                //Creamos un arreglo de las provincias para validarlas
                                                Provincia[] provincias = Provincia.values(); 
                                                ArrayList<String> Lprovincia = new ArrayList<>();
                                                                                               
                                                boolean bandera2 = true;
                                                System.out.println("Cuando quiere dejar de agregar provincias escriba no.");                                                
                                                
                                                //Validacion de la provincia
                                                String provincia = "";
                                                
                                                while(bandera2){
                                                  System.out.print("Ingrese la provincia que pertenezca al plan: ");
                                                  provincia = sc.nextLine();
                                                  
                                                  for (Provincia p: provincias){
                                                    if (p.toString().equals(provincia.toUpperCase())){
                                                      Lprovincia.add(provincia);
                                                    }else if((provincia.toLowerCase()).equals("no")){
                                                      bandera2 = false;
                                                    }
                                                  }
                                                }
                                                                                                
                                                //Seguimos pidiendo los otros datos
                                                System.out.print("Ingrese cargo base: $");
                                                double cargoBase = sc.nextDouble();
                                                sc.nextLine();
                                                //14:00-15:30 = 15-14 ; 30-00 = 1:30
                                                
                                                ////////////////////////////////////////////////////////AQUI
                                                System.out.print("Ingrese el numero de rangos de horas pico a ingresar: #");
                                                int repeticiones = sc.nextInt();
                                                
                                                ArrayList<HorarioPico> list_localTime = new ArrayList<>();
                                                
                                                for(int i = 1; i<=repeticiones; i++){                                                    
                                                    System.out.print("Siga el siguiente modelo(hora:minuto-hora:minuto): 14:10-15:30");
                                                    System.out.print("Ingrese el rango de la hora pico: ");
                                                    String horasPico = sc.nextLine();
                                                    String[] rangos = horasPico.split("-");
                                                    String[]  horaI = rangos[0].split(":");
                                                    String[]  horaF = rangos[1].split(":");

                                                    LocalTime hp0 = LocalTime.of(Integer.parseInt(horaI[0]), Integer.parseInt(horaI[1]));
                                                    LocalTime hp1 = LocalTime.of( Integer.parseInt(horaF[0]), Integer.parseInt(horaF[1]));

                                                    HorarioPico horario=new HorarioPico(hp0 ,hp1);
                                                    list_localTime.add(horario);
                                                }
                                                                                                              //14:00-15:00
                                                ad.registrarPlan(nombrePlan, costo, Lprovincia, cargoBase, list_localTime);
                                                bandera1 = false;
                                                break;
                                            }
                                        }while(bandera1);                                                                                                                 
                                    //}                                    
                                    break;
                                    
                                case "3":
                                    //Abonado
                                    //Validacion para que el numero de cedula no se repita 
                                    ArrayList<String> abonadoCedula = new ArrayList<>(); 
                                    
                                    for(Usuario ur : usuarios){
                                        if(ur instanceof Abonado){
                                            Abonado ab = (Abonado)ur;
                                            abonadoCedula.add(ab.getCedula());  
                                        }
                                    } 
                                                                        
                                    String cedula3 = "";
                                    boolean bandera3 = true;                                    
                                    do{
                                        System.out.print("Ingrese numero de cédula del abonado: ");                                  
                                        cedula3 = sc.nextLine();
                                        
                                        if(!(abonadoCedula.contains(cedula3))){
                                            System.out.println("No existe un abonado con esta cédula");
                                            //Se lo procede a registra
                                            System.out.println("Se lo procedera a registrar:\n");
                                            ad.registrarAbonado(cedula3);
                                            bandera3 = false;
                                        }else if(abonadoCedula.contains(cedula3)){
                                            System.out.println("Ya existe un abonado con esta cédula.");
                                            ingresarDatosRegistroMedidor(ad);
                                            bandera3 = false;
                                        }
                                    }while(bandera3);                                   
                                    ingresarDatosRegistroMedidor(ad);
                                    break;
                                    
                                case "4":
                                    System.out.print("Siga el siguiente modelo(dia-mes-año) 30-11-2021");
                                    System.out.print("Ingrese fecha de inicio: ");
                                    String fechaInicio = sc.nextLine();
                                                                      
                                    System.out.print("Ingrese fecha de fin: ");
                                    String fechaFin = sc.nextLine();

                                    LocalDateTime fInicio= LocalDate.parse(fechaInicio).atStartOfDay();
                                    LocalDateTime fFinal = LocalDate.parse(fechaFin).atStartOfDay();
                                    for(Medidor m : medidores){
                                      if( m instanceof MedidorInteligente){
                                        MedidorInteligente mi = (MedidorInteligente)m;
                                        mi.getCodigoMedidor();
                                      }
                                    }                              
                                    //ad.simularMedicion(fInicio, fFinal);
                                    break;
                                    
                                case "5":                                    
                                    for(Medidor me: medidores){
                                      if(me instanceof MedidorAnalogico){
                                        MedidorAnalogico mA =(MedidorAnalogico)me;                                     
                                        ad.realizarFacturacion(mA);                                  
                                      }
                                      else if(me instanceof MedidorInteligente){
                                        MedidorInteligente mI = (MedidorInteligente)me;                                   
                                        ad.realizarFacturacion(mI);
                                      }
                                    }
                                    break;

                                case "6":
                                    salir();
                                    break;                                  
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 y 6.");
                                    break;
                            }
                        }while(!(opcion.equals("6")));
                        break;
                    }
                    //Si el usuario ingresado es Operador
                    else if(u instanceof Operario){
                        System.out.println("\n1. Registrar medicion");
                        System.out.println("2. Salir");
                        String opcion = "";
                        
                        do{
                            System.out.print("\nIngrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();
                            Operario o = (Operario)u;

                            switch(opcion){
                                case "1":
                                   //o.registrarMedicion(codigo);
                                    break;
                                case "2":
                                    salir();
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 o 2.");
                                    break;
                            }
                        }while(!opcion.equals("2"));
                        break;
                    }
                    /*
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
                                case "4":
                                    salir();
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 y 4.");
                                    break;
                            }
                        }while(!opcion.equals("4"));
                    }*/
                }
        }
      }
    }
    
    public void salir(){
        System.out.println("Gracias por preferirnos, adiós.\n");
    }

    public void ingresarDatosRegistroMedidor(Administrador ad){
      System.out.print("\nIngrese su direccion de donde ubicara el medidor: ");
      String direccion = sc.nextLine();

      System.out.println("Tipos de medidor: ");
      System.out.println("1. Medidor Inteligente");
      System.out.println("2. Medidor Analogico\n");

      String numero = "";
      String tipo_medidor = "";

      do{ //Validar que el tipo de medidor sea analogico o inteligente
        System.out.print("\nIngrese el numero del tipo del medidor que desea (1 o 2): ");
        numero = sc.nextLine();
        switch(numero){
          case "1":
            tipo_medidor = "inteligente";
            break;
          case "2":
            tipo_medidor = "analogico";
            break;
          default:
            System.out.println("Opcion inválida. vuelva a ingresar entre 1 y 2.");
            break;
          }
        }while(!numero.equals("2"));

      System.out.print("Ingrese el nombre del tipo del plan que desea: ");
      String nombre_plan = sc.nextLine();
      boolean bandera = true;

      ArrayList<String> nombresPlan = new ArrayList<>();
      for(Plan plan : planes){//p 1
        Plan p = (Plan)plan;
        nombresPlan.add(p.getNombrePlan());
      }
      ////------------>ArrayList de nombres de planes(String)
      while(bandera){
        if (!(nombresPlan.contains(nombre_plan))){//----------->pregunta si nombre q usuario ingresa se encuentra en nombres
          System.out.print("El plan no existe ingrese de nuevo: ");
          System.out.print("Ingrese el nombre del plan: ");
          nombre_plan = sc.nextLine();
        }else{
          int indice = nombresPlan.indexOf(nombre_plan);

          //se registra el medidor se agrega a la lista de medidores el medidor que se registro
          medidores.add(ad.registrarMedidor(direccion, tipo_medidor, planes.get(indice)));
          bandera = false;
          break;
        }                                          
      }                             
    }
}