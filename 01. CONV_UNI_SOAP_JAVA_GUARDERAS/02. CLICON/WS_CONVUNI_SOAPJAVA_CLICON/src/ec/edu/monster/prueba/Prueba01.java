/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.prueba;

import ec.edu.monster.modelo.ConvKgLbService;

/**
 *
 * @author USER
 */
public class Prueba01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Datos
        double kg = 100;
        double lb = 100;

        //Proceso
        ConvKgLbService servicio = new ConvKgLbService();
        double convLb = servicio.convertKGLB(kg);
        double convKg = servicio.convertLBKG(lb);

        //Reporte
        System.out.println(kg + "Kg = " + convLb + "lb");
        System.out.println(lb + "lb = " + convKg + "Kg");
    }
    
}
