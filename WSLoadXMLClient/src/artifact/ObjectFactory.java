
package artifact;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the artifact package. 
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

    private final static QName _LoadXMLResponse_QNAME = new QName("http://soap.smartphones.project3.is/", "loadXMLResponse");
    private final static QName _LoadXML_QNAME = new QName("http://soap.smartphones.project3.is/", "loadXML");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadXML_Type }
     * 
     */
    public LoadXML_Type createLoadXML_Type() {
        return new LoadXML_Type();
    }

    /**
     * Create an instance of {@link LoadXMLResponse }
     * 
     */
    public LoadXMLResponse createLoadXMLResponse() {
        return new LoadXMLResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.smartphones.project3.is/", name = "loadXMLResponse")
    public JAXBElement<LoadXMLResponse> createLoadXMLResponse(LoadXMLResponse value) {
        return new JAXBElement<LoadXMLResponse>(_LoadXMLResponse_QNAME, LoadXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXML_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.smartphones.project3.is/", name = "loadXML")
    public JAXBElement<LoadXML_Type> createLoadXML(LoadXML_Type value) {
        return new JAXBElement<LoadXML_Type>(_LoadXML_QNAME, LoadXML_Type.class, null, value);
    }

}
