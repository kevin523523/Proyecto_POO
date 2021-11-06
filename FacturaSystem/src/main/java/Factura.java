/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kevin
 */
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Factura {
    String nombre;
    static ArrayList<Factura> facturas = new ArrayList<>();
    
    public static void agregarFactura(Factura f1){

        facturas.add(f1);
        
    }
    public static void mostrarFacturas(){
        System.out.println(facturas);
}
    public String toString(){
        return nombre;
    }
}
