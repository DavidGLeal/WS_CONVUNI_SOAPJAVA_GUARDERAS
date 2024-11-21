
package ec.edu.monster.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.monster.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConvertLBKGResponse_QNAME = new QName("http://ws.monster.edu.ec/", "convertLBKGResponse");
    private final static QName _ConvertKGLBResponse_QNAME = new QName("http://ws.monster.edu.ec/", "convertKGLBResponse");
    private final static QName _ConvertKGLB_QNAME = new QName("http://ws.monster.edu.ec/", "convertKGLB");
    private final static QName _ConvertLBKG_QNAME = new QName("http://ws.monster.edu.ec/", "convertLBKG");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.monster.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertLBKGResponse }
     * 
     */
    public ConvertLBKGResponse createConvertLBKGResponse() {
        return new ConvertLBKGResponse();
    }

    /**
     * Create an instance of {@link ConvertKGLBResponse }
     * 
     */
    public ConvertKGLBResponse createConvertKGLBResponse() {
        return new ConvertKGLBResponse();
    }

    /**
     * Create an instance of {@link ConvertKGLB }
     * 
     */
    public ConvertKGLB createConvertKGLB() {
        return new ConvertKGLB();
    }

    /**
     * Create an instance of {@link ConvertLBKG }
     * 
     */
    public ConvertLBKG createConvertLBKG() {
        return new ConvertLBKG();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertLBKGResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "convertLBKGResponse")
    public JAXBElement<ConvertLBKGResponse> createConvertLBKGResponse(ConvertLBKGResponse value) {
        return new JAXBElement<ConvertLBKGResponse>(_ConvertLBKGResponse_QNAME, ConvertLBKGResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertKGLBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "convertKGLBResponse")
    public JAXBElement<ConvertKGLBResponse> createConvertKGLBResponse(ConvertKGLBResponse value) {
        return new JAXBElement<ConvertKGLBResponse>(_ConvertKGLBResponse_QNAME, ConvertKGLBResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertKGLB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "convertKGLB")
    public JAXBElement<ConvertKGLB> createConvertKGLB(ConvertKGLB value) {
        return new JAXBElement<ConvertKGLB>(_ConvertKGLB_QNAME, ConvertKGLB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertLBKG }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "convertLBKG")
    public JAXBElement<ConvertLBKG> createConvertLBKG(ConvertLBKG value) {
        return new JAXBElement<ConvertLBKG>(_ConvertLBKG_QNAME, ConvertLBKG.class, null, value);
    }

}
