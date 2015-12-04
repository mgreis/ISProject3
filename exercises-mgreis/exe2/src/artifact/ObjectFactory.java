
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

    private final static QName _Troca_QNAME = new QName("http://exe2/", "troca");
    private final static QName _TrocaResponse_QNAME = new QName("http://exe2/", "trocaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TrocaResponse }
     * 
     */
    public TrocaResponse createTrocaResponse() {
        return new TrocaResponse();
    }

    /**
     * Create an instance of {@link Troca }
     * 
     */
    public Troca createTroca() {
        return new Troca();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Troca }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exe2/", name = "troca")
    public JAXBElement<Troca> createTroca(Troca value) {
        return new JAXBElement<Troca>(_Troca_QNAME, Troca.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrocaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exe2/", name = "trocaResponse")
    public JAXBElement<TrocaResponse> createTrocaResponse(TrocaResponse value) {
        return new JAXBElement<TrocaResponse>(_TrocaResponse_QNAME, TrocaResponse.class, null, value);
    }

}
