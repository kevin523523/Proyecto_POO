/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import java.util.Date;
import java.time.LocalDateTime;

import java.util.ArrayList;
/**
 *
 * @author cebor
 */
public class Administrador extends Usuario {
    Abonado abonados;
    LocalDateTime fechaFin;
    LocalDateTime fechaIn;
   // ArrayList<Factura> facturas;
    
    @Override
    public void cerrarSesion(){}
    public void registrarAbonado(){}
    public void Plan(){}
    public void registrarMedidor(){}
    public void simularMedicion(){}
    public void realizarFacturacion(){}
}
