/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.servicios.ConvKgLb;

/**
 *
 * @author USER
 */
public class Prueba01 {
    public static void main(String[] args){
        //Datos
        double kg = 10;
        double lb = 22.05;
        
        //Proceso        
        ConvKgLb service = new ConvKgLb();
        double convLb = service.convertKGLB(kg);
        double convKg = service.convertLBKG(lb);
        
        //Reporte
        System.out.println(kg + "Kg = " + convLb + "lb");
        System.out.println(lb + "lb = " + convKg + "Kg");
    }
}
