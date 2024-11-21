package ec.edu.monster.ws_convuni_soapjava_climov.modelo;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ConvUniModelo {
    private static final String NAMESPACE = "http://ws.monster.edu.ec/";
    private static final String METHOD_NAME1 = "convertKGLB", METHOD_NAME2 = "convertLBKG";
    private static final String SOAP_ACTION1 = "http://ws.monster.edu.ec/CONVUNI/convertKGLBRequest",
            SOAP_ACTION2 = "http://ws.monster.edu.ec/CONVUNI/convertLBKGRequest";
    private static final String URL = "http://192.168.100.22:8080/WS_CONVUNI_SOAPJAVA/CONVUNI";

    public double convertKGLB(double kg){
        double respuesta = -1;

        try{
            SoapObject solicitud = new SoapObject(NAMESPACE,METHOD_NAME1);
            solicitud.addProperty("kg",String.valueOf(kg));

            SoapSerializationEnvelope paquete = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            paquete.implicitTypes = true;
            paquete.dotNet = false;
            paquete.encodingStyle = SoapSerializationEnvelope.XSD;
            paquete.setOutputSoapObject(solicitud);

            HttpTransportSE transporte = new HttpTransportSE(URL);
            transporte.debug = true;

            Log.d("SOAP_REQUEST", solicitud.toString());
            transporte.call(SOAP_ACTION1, paquete);
            Log.d("SOAP_RESPONSE", paquete.getResponse().toString());


            SoapPrimitive res = (SoapPrimitive) paquete.getResponse();
            respuesta = Double.parseDouble(res.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }

    public double convertLBKG(double lb){
        double respuesta = -1;

        try{
            SoapObject solicitud = new SoapObject(NAMESPACE,METHOD_NAME2);
            solicitud.addProperty("lb",String.valueOf(lb));

            SoapSerializationEnvelope paquete = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            paquete.implicitTypes = true;
            paquete.dotNet = false;
            paquete.encodingStyle = SoapSerializationEnvelope.XSD;
            paquete.setOutputSoapObject(solicitud);

            HttpTransportSE transporte = new HttpTransportSE(URL);
            Log.d("SOAP_REQUEST", solicitud.toString());
            transporte.call(SOAP_ACTION2, paquete);
            Log.d("SOAP_RESPONSE", paquete.getResponse().toString());

            SoapPrimitive res = (SoapPrimitive) paquete.getResponse();
            respuesta = Double.parseDouble(res.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
}
