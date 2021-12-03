/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

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
    Scanner sc = new Scanner(System.in);
    private ArrayList<Factura> facturas = new ArrayList<>();

    private ArrayList<String> provincia = new ArrayList<>();
    private ArrayList<String> provincia2 = new ArrayList<>();

    //Creacion de planes 
    HorarioPico h1 = new HorarioPico(LocalTime.parse("12:00:00"), LocalTime.parse("13:00:00"));
    HorarioPico h2 = new HorarioPico(LocalTime.parse("18:00:00"), LocalTime.parse("20:00:00"));
    HorarioPico h3 = new HorarioPico(LocalTime.parse("13:00:00"), LocalTime.parse("14:00:00"));
    HorarioPico h4 = new HorarioPico(LocalTime.parse("19:00:00"), LocalTime.parse("21:00:00"));
    private ArrayList<HorarioPico> fecha = new ArrayList<>(Arrays.asList(h1, h2));
    private ArrayList<HorarioPico> fecha2 = new ArrayList<>(Arrays.asList(h3, h4));

    Plan p = new Plan("plan1", 12.5, provincia, 3.5, fecha);
    Plan p2 = new Plan("plan2", 12.5, provincia2, 3.5, fecha2);

    //Agregamos los planes a el arreglo planes
    private ArrayList<Plan> planes = new ArrayList<>(Arrays.asList(p, p2));

    //Creacion de medidores
    Medidor m1 = new MedidorInteligente(p, "10 de Agosto");
    Medidor m2 = new MedidorAnalogico(p2, "10 de Agosto");
    Medidor m3 = new MedidorAnalogico(p2, "23 de Octubre");

    //Agregamos los medidores a el arreglo medidores
    private ArrayList<Medidor> medidores = new ArrayList<>(Arrays.asList(m1, m2, m3));

    private ArrayList<Medidor> medidor_Op1 = new ArrayList<>(Arrays.asList(m1, m2));
    private ArrayList<Medidor> medidor_Op2 = new ArrayList<>(Arrays.asList(m3));

    //Creacion de Usuarios
    Usuario a = new Administrador("admin", "superadmin");
    Usuario b = new Operario("op", "op");
    Usuario c = new Operario("ap", "ap");
    Usuario d = new Abonado("120", "123", "iang@gamil.com", "10 de Agosto", "Ian g", medidor_Op1);
    Usuario e = new Abonado("121", "345", "rig@gamil.com", "23 de Octubre", "Ri G", medidor_Op2);

    //Agregamos los usuarios a el arreglo usuarios
    private ArrayList<Usuario> usuarios = new ArrayList<>(Arrays.asList(a, b, c, d, e));


    public void presentarMenuPrincipal() {
        System.out.println("Bienvenido a nuestro Sistema de Facturas\n");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Salir\n");
    }

    public void iniciar() {
        String entrada = "";
        boolean bandera = true;
        presentarMenuPrincipal();
        do {
            System.out.println("Ingrese el número de la opción a realizar: ");
            entrada = sc.nextLine();
            switch (entrada) {
                //Ya esta
                case "1":
                    boolean continuar = true;
                    do {
                        //pide el nombre del usuario
                        System.out.println("Ingrese su usuario: ");
                        String usuario = sc.nextLine();

                        //pide la contraseña del usuario
                        System.out.println("Ingrese su contraseña: ");
                        String contraseña = sc.nextLine();

                        //Verificamos que el usuario existe
                        if (verificarUsuario(usuario, contraseña)) {
                            //llamamos a metodo iniciarSesion()
                            iniciarSesion(usuario, contraseña);
                            continuar = false;
                        } else {
                            System.out.println("Usuario o contraseña incorrecta, vuelva a ingresar sus datos.\n");
                            continuar = true;
                        }
                    } while (continuar);
                    //bandera = false;
                    break;

                case "2":
                    //mostramos mensaje de finalizacion
                    System.out.println("Gracias por preferirnos, adiós.\n");
                    //bandera = false;
                    break;

                default:
                    //la opcion ingreada no esta dentro de las opciones del menú
                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 o 2.\n");
                    //bandera = true;
                    break;
            }
        } while (!(entrada.equals("2")));
    }

    public boolean verificarUsuario(String usuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if (!(usuarios.isEmpty())) {
            for (Usuario u : usuarios) {
                if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                    //Si el usuario ingresado es Administrador
                    if (u instanceof Administrador) {
                        //Si el usuario ingresado es Administrador
                        System.out.println("\n1. Registrar Abonado");
                        System.out.println("2. Registrar plan");
                        System.out.println("3. Registrar medidor");
                        System.out.println("4. Simular medicion");
                        System.out.println("5. Realizar facturacion");
                        System.out.println("6. Salir");
                        String opcion = "";
                        Administrador ad = (Administrador) u;

                        do {
                            //Validado
                            System.out.println("\nIngrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();

                            switch (opcion) {
                                case "1":
                                    //Validacion para que el numero de cedula no se repita                           
                                    ArrayList<String> cedulas = new ArrayList<>();
                                    for (Usuario ur : usuarios) {//p 1
                                        if (ur instanceof Abonado) {
                                            Abonado abn = (Abonado) ur;
                                            cedulas.add(abn.getCedula());
                                        }
                                    }

                                    boolean bandera = true;
                                    do {
                                        System.out.println("Ingrese numero de cédula: ");
                                        String cedula = sc.nextLine();

                                        if (!(cedulas.contains(cedula))) {
                                            System.out.println("No existe un abonado con esta cédula");
                                            ad.registrarAbonado(cedula);
                                            System.out.println("Registro satisfactorio.");
                                            System.out.println("\n1. Registrar Abonado");
                                            System.out.println("2. Registrar plan");
                                            System.out.println("3. Registrar medidor");
                                            System.out.println("4. Simular medicion");
                                            System.out.println("5. Realizar facturacion");
                                            System.out.println("6. Salir");
                                            bandera = false;
                                        } else if (cedulas.contains(cedula)) {
                                            System.out.println("Ya existe un abonado con esta cédula, ingrese otra.\n");
                                            bandera = true;
                                        }
                                    } while (bandera);
                                    break;

                                case "2":
 
                                    //Validado el nombre del plan
                                    //ArrayList de nombres de planes(String)
                                    ArrayList<String> nombresplanes = new ArrayList<>();
                                    for (Plan pl : planes) {
                                        Plan p = (Plan) pl;
                                        nombresplanes.add(p.getNombrePlan());
                                    }

                                    boolean bandera1 = true;
                                    String nombrePlan = "";
                                    do {
                                        System.out.println("Ingrese el nombre del plan: ");
                                        nombrePlan = sc.nextLine();

                                        if (nombresplanes.contains(nombrePlan)) {
                                            System.out.println("El nombre del plan ya existe, ingrese uno nuevo.\n");
                                            bandera1 = true;
                                        } else if (!(nombresplanes.contains(nombrePlan))) {
                                            //Seguimos y se pide los otros datos y se agrega el plan 
                                            System.out.println("El nombre del plan no existe. Lo creamos\n");
                                            System.out.println("Ingrese el costo de kilovatios hora: $");
                                            double costo = sc.nextDouble();
                                            sc.nextLine();

                                            //Creamos un arreglo de las provincias para validarlas
                                            Provincia[] provincias = Provincia.values();
                                            ArrayList<String> Lprovincia = new ArrayList<>();

                                            boolean bandera2 = true;
                                            boolean bandera3 = false;
                                            System.out.println("\nCuando quiere dejar de agregar provincias escriba no.");

                                            //Validacion de la provincia
                                            String provincia = "";
                                            while (bandera2) {
                                                do {
                                                    System.out.println("\nIngrese la provincia que pertenezca al plan: ");
                                                    provincia = sc.nextLine();

                                                    for (Provincia p : provincias) {
                                                        if (p.toString().equals(provincia.toUpperCase())) {
                                                            Lprovincia.add(provincia);
                                                            System.out.println("Provincia válida.");
                                                            bandera3 = false;
                                                            break;
                                                        } else if ((provincia.toLowerCase()).equals("no")) {
                                                            bandera2 = false;
                                                            bandera3 = false;
                                                            break;
                                                        } else {
                                                            bandera3 = true;
                                                        }
                                                    }
                                                    if (bandera3 == true) {
                                                        System.out.println("Provincia invalida, ingresa una correcta");
                                                    }
                                                } while (bandera2);
                                            }

                                            //Seguimos pidiendo los otros datos
                                            System.out.println("Ingrese cargo base: $");
                                            double cargoBase = sc.nextDouble();
                                            sc.nextLine();
                                            //14:00-15:30 = 15-14 ; 30-00 = 1:30

                                            System.out.println("Ingrese el numero de rangos de horas pico a ingresar: #");
                                            int repeticiones = sc.nextInt();
                                            sc.nextLine();

                                            ArrayList<HorarioPico> list_localTime = new ArrayList<>();
                                            System.out.println("Siga el siguiente modelo(hora:minuto-hora:minuto): 14:10-15:30");
                                            for (int i = 1; i <= repeticiones; i++) {

                                                System.out.println("Ingrese el rango de la hora pico: ");
                                                String horasPico = sc.nextLine();
                                                String[] rangos = horasPico.split("-");
                                                String[] horaI = rangos[0].split(":");
                                                String[] horaF = rangos[1].split(":");

                                                LocalTime hp0 = LocalTime.of(Integer.parseInt(horaI[0]), Integer.parseInt(horaI[1]));
                                                LocalTime hp1 = LocalTime.of(Integer.parseInt(horaF[0]), Integer.parseInt(horaF[1]));

                                                HorarioPico horario = new HorarioPico(hp0, hp1);
                                                list_localTime.add(horario);
                                            }
                                            //14:00-15:00
                                            ad.registrarPlan(nombrePlan, costo, Lprovincia, cargoBase, list_localTime);
                                            bandera1 = false;
                                            System.out.println("Registro satisfactorio.");
                                            System.out.println("\n1. Registrar Abonado");
                                            System.out.println("2. Registrar plan");
                                            System.out.println("3. Registrar medidor");
                                            System.out.println("4. Simular medicion");
                                            System.out.println("5. Realizar facturacion");
                                            System.out.println("6. Salir");
                                            break;
                                        }
                                    } while (bandera1);
                                    break;

                                case "3":
                                    //Validado        
                                    //Validacion para que el numero de cedula no se repita 
                                    ArrayList<String> abonadoCedula = new ArrayList<>();
                                    ArrayList<Abonado> abonados = new ArrayList<>();

                                    for (Usuario ur : usuarios) {

                                        if (ur instanceof Abonado) {
                                            Abonado ab = (Abonado) ur;
                                            abonadoCedula.add(ab.getCedula());
                                            abonados.add(ab);
                                        }
                                    }

                                    String cedula3 = "";
                                    boolean bandera3 = true;
                                    do {
                                        System.out.println("Ingrese numero de cédula del abonado: ");
                                        cedula3 = sc.nextLine();

                                        if (!(abonadoCedula.contains(cedula3))) {
                                            System.out.println("No existe un abonado con esta cédula");
                                            //Se lo procede a registra
                                            System.out.println("Se lo procedera a registrar:\n");
                                            Abonado abonadNew = ad.registrarAbonado(cedula3);
                                            ingresarDatosRegistroMedidor(ad, abonadNew);
                                            System.out.println("Registro satisfactorio.");
                                            System.out.println("\n1. Registrar Abonado");
                                            System.out.println("2. Registrar plan");
                                            System.out.println("3. Registrar medidor");
                                            System.out.println("4. Simular medicion");
                                            System.out.println("5. Realizar facturacion");
                                            System.out.println("6. Salir");
                                            bandera3 = false;
                                        } else if (abonadoCedula.contains(cedula3)) {
                                            System.out.println("Si existe un abonado con esta cédula.");

                                            int pos = abonadoCedula.indexOf(cedula3);

                                            ingresarDatosRegistroMedidor(ad, abonados.get(pos));
                                            System.out.println("Registro satisfactorio.");
                                            System.out.println("\n1. Registrar Abonado");
                                            System.out.println("2. Registrar plan");
                                            System.out.println("3. Registrar medidor");
                                            System.out.println("4. Simular medicion");
                                            System.out.println("5. Realizar facturacion");
                                            System.out.println("6. Salir");
                                            bandera3 = false;
                                            
                                        }
                                    } while (bandera3);
                                    break;

                                case "4":
                                    boolean bandera4 = true;
                                    do {
                                        System.out.println("Siga el siguiente modelo(año-mes-dia) 2021-11-01");
                                        

                                        System.out.println("Fecha inicio: ");
                                        String fechaInicio = sc.nextLine();

                                        System.out.println("Fecha Fin:");
                                        String fechaFin = sc.nextLine();
 
                                        LocalDateTime fInicio = LocalDate.parse(fechaInicio).atStartOfDay();
                                        LocalDateTime fFinal = LocalDate.parse(fechaFin).atStartOfDay();
                                        
                                        if(fInicio.compareTo(fFinal)<0){
                                            ad.simularMedicion(fInicio, fFinal, medidores);
                                            bandera4 = false;
                                            
                                        }
                                        
                                    } while(bandera4);
                                    System.out.println("Simulacion satisfactoria.");
                                    System.out.println("\n1. Registrar Abonado");
                                    System.out.println("2. Registrar plan");
                                    System.out.println("3. Registrar medidor");
                                    System.out.println("4. Simular medicion");
                                    System.out.println("5. Realizar facturacion");
                                    System.out.println("6. Salir");
                                    break;

                                case "5":                                    
                                    //Validado                                   
                                    for (Usuario us : usuarios) {

                                        if (us instanceof Abonado) {
                                            Abonado ab = (Abonado) us;
                                            for (Medidor medidor : ab.getMedidores()) {
                                                ad.realizarFacturacion(medidor, ab, facturas);
                                                System.out.println("Registro satisfactorio.");
                                                System.out.println("\n1. Registrar Abonado");
                                                System.out.println("2. Registrar plan");
                                                System.out.println("3. Registrar medidor");
                                                System.out.println("4. Simular medicion");
                                                System.out.println("5. Realizar facturacion");
                                                System.out.println("6. Salir");
                                            }

                                        }
                                    }
                                    break;

                                case "6":
                                    System.out.println("Usted salio del usuario abonado\n");
                                    System.out.println("1. Iniciar Sesión");
                                    System.out.println("2. Salir\n");
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 y 6.");
                                    break;
                            }
                        } while (!(opcion.equals("6")));
                        break;
                    } //Si el usuario ingresado es Operador
                    else if (u instanceof Operario) {

                        for (Medidor m : medidores) {
                            System.out.println(m + " : " + m.getCodigoMedidor());
                        }

                        System.out.println("\n1. Registrar medicion");
                        System.out.println("2. Salir");
                        String opcion = "";
                        boolean bandera4 = true;

                        do {
                            System.out.println("\nIngrese el número de la opción a realizar: ");
                            opcion = sc.nextLine();
                            Operario o = (Operario) u;
                            switch (opcion) {
                                case "1":
                                    System.out.println("Operario: " + o.getUsuario());
                                    o.registrarMedicion(medidores, usuarios, o);
                                    break;
                                case "2":
                                    System.out.println("Usted salio del usuario Operario\n");
                                    System.out.println("1. Iniciar Sesión");
                                    System.out.println("2. Salir\n");
                                    break;
                                default:
                                    System.out.println("Opcion inválida. vuelva a ingresar entre 1 o 2.");
                                    break;
                            }
                        } while (!opcion.equals("2"));
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
                            System.out.println("Ingrese el número de la opción a realizar: ");
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
                                    System.out.println("Gracias por preferirnos, adiós.\n");
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


    public void ingresarDatosRegistroMedidor(Administrador ad, Abonado ab) {
        System.out.println("\nIngrese su direccion de donde ubicara el medidor: ");
        String direccion = sc.nextLine();

        System.out.println("\nTipos de medidor: ");
        System.out.println("1. Medidor Inteligente");
        System.out.println("2. Medidor Analogico");

        String numero = "";
        String tipo_medidor = "";
        do { //Validar que el tipo de medidor sea analogico o inteligente

            System.out.println("\nIngrese el numero del tipo del medidor que desea (1 o 2): ");
            numero = sc.nextLine();
            switch (numero) {
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
        } while (!numero.equals("2") && !numero.equals("1"));

        System.out.println("Ingrese el nombre del tipo del plan que desea: ");
        String nombre_plan = sc.nextLine();
        boolean bandera = true;

        ArrayList<String> nombresPlan = new ArrayList<>();
        for (Plan plan : planes) {//p 1
            Plan p = (Plan) plan;
            nombresPlan.add(p.getNombrePlan());
        }
        ////------------>ArrayList de nombres de planes(String)
        while (bandera) {
            if (!(nombresPlan.contains(nombre_plan))) {//----------->pregunta si nombre q usuario ingresa se encuentra en nombres
                System.out.println("El plan no existe ingrese de nuevo.");
                System.out.println("\nIngrese el nombre del plan: ");
                nombre_plan = sc.nextLine();
            } else {
                int indice = nombresPlan.indexOf(nombre_plan);

                //se registra el medidor se agrega a la lista de medidores el medidor que se registro
                medidores.add(ad.registrarMedidor(direccion, tipo_medidor, planes.get(indice), ab));
                bandera = false;
                break;
            }
        }
    }
}
