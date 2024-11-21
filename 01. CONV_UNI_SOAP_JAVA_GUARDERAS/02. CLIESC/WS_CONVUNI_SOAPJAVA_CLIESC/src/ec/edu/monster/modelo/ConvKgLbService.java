/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.net.SocketTimeoutException;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author USER
 */
public class ConvKgLbService {

    //Kilos a Libras
    public double convertKGLB(double kg) {
        
        try{
            ec.edu.monster.ws.CONVUNI_Service service = new ec.edu.monster.ws.CONVUNI_Service();
            ec.edu.monster.ws.CONVUNI port = service.getCONVUNIPort();
            return port.convertKGLB(kg);
        }
        catch(WebServiceException e){
            System.err.println("Error: El servicio web no está disponible o falló la conexión.");
            return -1;
        }
        catch(Exception e){
            System.err.println("Se produjo un error inesperado: " + e.getMessage());
            return -2;
        }
    }
    
    //Libras a Kilos    
    public double convertLBKG(double lb) {
        try{
            ec.edu.monster.ws.CONVUNI_Service service = new ec.edu.monster.ws.CONVUNI_Service();
            ec.edu.monster.ws.CONVUNI port = service.getCONVUNIPort();
            return port.convertLBKG(lb);
        }
        catch(WebServiceException e){
            System.err.println("Error: El servicio web no está disponible o falló la conexión.");
            return -1;
        }
        catch(Exception e){
            System.err.println("Se produjo un error inesperado: " + e.getMessage());
            return -2;
        }
    }
    
}
