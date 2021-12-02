/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factura;

import java.time.*;

/**
 *
 * @author Ramses
 */*/
public class HorarioPico {
   private LocalTime horarioInicio;
   private LocalTime horarioFin;

   public HorarioPico(LocalTime horarioInicio ,LocalTime horarioFin){
   this.horarioInicio=horarioInicio;
   this.horarioFin=horarioFin;
   }

   public LocalTime getHorarioInicio(){
     return horarioInicio;
   }

   public LocalTime getHorarioFin(){
     return horarioFin;
   }

}