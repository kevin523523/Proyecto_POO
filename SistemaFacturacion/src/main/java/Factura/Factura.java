package Factura;
import Usuario.Abonado;
import Medidor.Medidor;
import java.time.*;
import java.util.* ;
import java.math.BigInteger;

public class Factura{
  private LocalDateTime fechaEmision;
  private String codigoFactura; //falta- aleatorio de puros numeros
  private Medidor medidor;
  private Plan plan;
  private int diasFacturados; //falta - cada que se genere un factura a nombre del abonado el contador de dias Facturados aumenta en 1 
  private Abonado abonado; //falta - recorrer la lista de abonado y ver a quien le pertenece el medidor con el metodo equeals cada abonado tiene una lisat de medidores
  private double consumo;
  private LocalDateTime ultimaFechaCobrado;
  private double medidaUltimaLecturaCobrada; //se obtiene con la ultima lectura en el arraylist de lecturas en la clase Medidor
  private double medidaLecturActual;//el total en kilovatios que marca el medidor según la última lectura registrada.
  private double totalPagar;

  //Creo que abinado no lo utilizas
  public Factura( Medidor medidor){ // Abonado abonado 
    this.fechaEmision = LocalDateTime.now();
    //en vez de this.codigoFactura hay que generar aleatoriamente un codigo de factura asi como el codigo del medidor pero el codigo de factura son solo numeros
    this.codigoFactura= String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0,8);
    this.medidor= medidor;
    this.plan = medidor.getPlan();
    //this.abonado = abonado;
    this.consumo = medidor.calcularConsumo(medidor.getLecturas());
    //this.medidaUltimaLecturaCobrada=medidor.getLecturas().get(medidor.getLecturas().size()-1).getKilovatios() ;
    this.medidaUltimaLecturaCobrada = medidor.getConsumoUltimaFecha();
    this.medidaLecturActual = medidor.getLecturas().get(medidor.getLecturas().size()-1).getKilovatios();
    }

    public Medidor getMedidor(){
      return medidor;
    }
    public double getConsumo(){
      return consumo;
    }
/*public setFechaEmision(LocalDateTime fechaEmision){
  this.fechaEmision=fechaEmision;
}
public setCodigoFactura(String codigoFactura){
  this.codigoFactura=codigofactura;
}*/
 // public Factura generarFactura(){
   // return Factura;
 // }
//getters
}