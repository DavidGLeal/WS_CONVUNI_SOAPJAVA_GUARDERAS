package ec.edu.monster.ws_convuni_soapjava_climov.prueba;

import ec.edu.monster.ws_convuni_soapjava_climov.controlador.ConvUniControlador;

public class Prueba01 {
    public static void main(String[] args) {
        //Datos
        double kg = 100;
        double lb = 100;

        //Proceso
        ConvUniControlador servicio = new ConvUniControlador();
        String convLb = servicio.convertKGLB(String.valueOf(kg));
        String convKg = servicio.convertLBKG(String.valueOf(lb));

        //Reporte
        System.out.println(kg + "Kg = " + convLb + "lb");
        System.out.println(lb + "lb = " + convKg + "Kg");
    }
}
