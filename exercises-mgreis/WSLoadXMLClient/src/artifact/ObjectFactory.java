
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

    private final static QName _GetReportResponse_QNAME = new QName("http://webservice/", "getReportResponse");
    private final static QName _LoadXML_QNAME = new QName("http://webservice/", "loadXML");
    private final static QName _GetReport_QNAME = new QName("http://webservice/", "getReport");
    private final static QName _LoadXMLResponse_QNAME = new QName("http://webservice/", "loadXMLResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadXMLResponse }
     * 
     */
    public LoadXMLResponse createLoadXMLResponse() {
        return new LoadXMLResponse();
    }

    /**
     * Create an instance of {@link GetReportResponse }
     * 
     */
    public GetReportResponse createGetReportResponse() {
        return new GetReportResponse();
    }

    /**
     * Create an instance of {@link LoadXML_Type }
     * 
     */
    public LoadXML_Type createLoadXML_Type() {
        return new LoadXML_Type();
    }

    /**
     * Create an instance of {@link Report }
     * 
     */
    public Report createReport() {
        return new Report();
    }

    /**
     * Create an instance of {@link Smartphone }
     * 
     */
    public Smartphone createSmartphone() {
        return new Smartphone();
    }

    /**
     * Create an instance of {@link GetReport }
     * 
     */
    public GetReport createGetReport() {
        return new GetReport();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link Price }
     * 
     */
    public Price createPrice() {
        return new Price();
    }

    /**
     * Create an instance of {@link LoadXMLResponse.Return }
     * 
     */
    public LoadXMLResponse.Return createLoadXMLResponseReturn() {
        return new LoadXMLResponse.Return();
    }

    /**
     * Create an instance of {@link GetReportResponse.Return }
     * 
     */
    public GetReportResponse.Return createGetReportResponseReturn() {
        return new GetReportResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getReportResponse")
    public JAXBElement<GetReportResponse> createGetReportResponse(GetReportResponse value) {
        return new JAXBElement<GetReportResponse>(_GetReportResponse_QNAME, GetReportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXML_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "loadXML")
    public JAXBElement<LoadXML_Type> createLoadXML(LoadXML_Type value) {
        return new JAXBElement<LoadXML_Type>(_LoadXML_QNAME, LoadXML_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getReport")
    public JAXBElement<GetReport> createGetReport(GetReport value) {
        return new JAXBElement<GetReport>(_GetReport_QNAME, GetReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "loadXMLResponse")
    public JAXBElement<LoadXMLResponse> createLoadXMLResponse(LoadXMLResponse value) {
        return new JAXBElement<LoadXMLResponse>(_LoadXMLResponse_QNAME, LoadXMLResponse.class, null, value);
    }

}
