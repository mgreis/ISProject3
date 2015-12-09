
package artifact;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LoadXML", targetNamespace = "http://webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LoadXML {


    /**
     * 
     * @return
     *     returns artifact.GetReportResponse.Return
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getReport", targetNamespace = "http://webservice/", className = "artifact.GetReport")
    @ResponseWrapper(localName = "getReportResponse", targetNamespace = "http://webservice/", className = "artifact.GetReportResponse")
    public artifact.GetReportResponse.Return getReport();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadXML", targetNamespace = "http://webservice/", className = "artifact.LoadXML_Type")
    @ResponseWrapper(localName = "loadXMLResponse", targetNamespace = "http://webservice/", className = "artifact.LoadXMLResponse")
    public boolean loadXML(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}