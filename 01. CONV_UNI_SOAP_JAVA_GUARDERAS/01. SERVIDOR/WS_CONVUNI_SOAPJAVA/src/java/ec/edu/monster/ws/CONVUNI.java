/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monster.ws;

import ec.edu.monster.servicios.ConvKgLb;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USER
 */
@WebService(serviceName = "CONVUNI")
public class CONVUNI {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "convertKGLB")
    public double convertKGLB(@WebParam(name = "kg") double kg) {
        ConvKgLb service = new ConvKgLb();
        double newLb = service.convertKGLB(kg);
        return newLb;
    }
    
    @WebMethod(operationName = "convertLBKG")
    public double convertLBKG(@WebParam(name = "lb") double lb) {
        ConvKgLb service = new ConvKgLb();
        double newKg = service.convertLBKG(lb);
        return newKg;
    }
}
