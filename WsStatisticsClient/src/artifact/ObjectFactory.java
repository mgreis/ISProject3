
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

    private final static QName _LoadStatisticsResponse_QNAME = new QName("http://soap.statistics.project3.is/", "loadStatisticsResponse");
    private final static QName _LoadStatistics_QNAME = new QName("http://soap.statistics.project3.is/", "loadStatistics");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadStatisticsResponse }
     * 
     */
    public LoadStatisticsResponse createLoadStatisticsResponse() {
        return new LoadStatisticsResponse();
    }

    /**
     * Create an instance of {@link LoadStatistics_Type }
     * 
     */
    public LoadStatistics_Type createLoadStatistics_Type() {
        return new LoadStatistics_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadStatisticsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.statistics.project3.is/", name = "loadStatisticsResponse")
    public JAXBElement<LoadStatisticsResponse> createLoadStatisticsResponse(LoadStatisticsResponse value) {
        return new JAXBElement<LoadStatisticsResponse>(_LoadStatisticsResponse_QNAME, LoadStatisticsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadStatistics_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.statistics.project3.is/", name = "loadStatistics")
    public JAXBElement<LoadStatistics_Type> createLoadStatistics(LoadStatistics_Type value) {
        return new JAXBElement<LoadStatistics_Type>(_LoadStatistics_QNAME, LoadStatistics_Type.class, null, value);
    }

}
