
package is.project3.subscriptions.wsimport;

import java.math.BigInteger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SubscriptionService", targetNamespace = "http://subscriptions.project3.is/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SubscriptionService {


    /**
     * 
     * @param favoriteBrand
     * @param clientName
     * @param maximumPrice
     * @param minimumPrice
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "subscribe", targetNamespace = "http://subscriptions.project3.is/", className = "is.project3.subscriptions.wsimport.Subscribe")
    @ResponseWrapper(localName = "subscribeResponse", targetNamespace = "http://subscriptions.project3.is/", className = "is.project3.subscriptions.wsimport.SubscribeResponse")
    public String subscribe(
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "clientName", targetNamespace = "")
        String clientName,
        @WebParam(name = "favoriteBrand", targetNamespace = "")
        String favoriteBrand,
        @WebParam(name = "minimumPrice", targetNamespace = "")
        double minimumPrice,
        @WebParam(name = "maximumPrice", targetNamespace = "")
        double maximumPrice);

    /**
     * 
     * @param id
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "unsubscribe", targetNamespace = "http://subscriptions.project3.is/", className = "is.project3.subscriptions.wsimport.Unsubscribe")
    @ResponseWrapper(localName = "unsubscribeResponse", targetNamespace = "http://subscriptions.project3.is/", className = "is.project3.subscriptions.wsimport.UnsubscribeResponse")
    public String unsubscribe(
        @WebParam(name = "id", targetNamespace = "")
        BigInteger id,
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "emailSubscriptions", targetNamespace = "http://subscriptions.project3.is/", className = "is.project3.subscriptions.wsimport.EmailSubscriptions")
    @ResponseWrapper(localName = "emailSubscriptionsResponse", targetNamespace = "http://subscriptions.project3.is/", className = "is.project3.subscriptions.wsimport.EmailSubscriptionsResponse")
    public String emailSubscriptions(
        @WebParam(name = "email", targetNamespace = "")
        String email);

}