/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ConvKgLbService;

/**
 *
 * @author USER
 */
public class ConvUniControlador {
    
    public double convKgLb(double kg){
        ConvKgLbService modelo = new ConvKgLbService();
        double lb = modelo.convertKGLB(kg);
        return lb;
    }
    
    public double convLbKg(double lb){
        ConvKgLbService modelo = new ConvKgLbService();
        double kg = modelo.convertLBKG(lb);
        return kg;
    }
    
}
