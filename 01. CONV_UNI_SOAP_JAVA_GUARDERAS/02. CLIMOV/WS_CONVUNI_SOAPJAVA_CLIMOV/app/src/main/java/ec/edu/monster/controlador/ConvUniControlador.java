package ec.edu.monster.ws_convuni_soapjava_climov.controlador;

import ec.edu.monster.ws_convuni_soapjava_climov.modelo.ConvUniModelo;

public class ConvUniControlador {

    private ConvUniModelo modelo;

    public ConvUniControlador(){
        modelo = new ConvUniModelo();
    }

    public String convertKGLB(String kg){
        double envio = Double.valueOf(kg);

        double recibo = modelo.convertKGLB(envio);

        String respuesta = "";

        if(recibo == -1.0){
            respuesta = "error";
        }else{
            respuesta = Double.toString(recibo);
        }

        return respuesta;
    }

    public String convertLBKG(String lb){
        double envio = Double.valueOf(lb);

        double recibo= modelo.convertLBKG(envio);

        String respuesta = "";

        if(recibo == -1.0){
            respuesta = "error";
        }else{
            respuesta = Double.toString(recibo);
        }

        return respuesta;
    }

}
