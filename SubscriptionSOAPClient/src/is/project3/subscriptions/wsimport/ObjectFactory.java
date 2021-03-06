
package is.project3.subscriptions.wsimport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the is.project3.subscriptions.wsimport package. 
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

    private final static QName _UnsubscribeResponse_QNAME = new QName("http://subscriptions.project3.is/", "unsubscribeResponse");
    private final static QName _Subscribe_QNAME = new QName("http://subscriptions.project3.is/", "subscribe");
    private final static QName _Unsubscribe_QNAME = new QName("http://subscriptions.project3.is/", "unsubscribe");
    private final static QName _SubscribeResponse_QNAME = new QName("http://subscriptions.project3.is/", "subscribeResponse");
    private final static QName _EmailSubscriptions_QNAME = new QName("http://subscriptions.project3.is/", "emailSubscriptions");
    private final static QName _EmailSubscriptionsResponse_QNAME = new QName("http://subscriptions.project3.is/", "emailSubscriptionsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: is.project3.subscriptions.wsimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmailSubscriptions }
     * 
     */
    public EmailSubscriptions createEmailSubscriptions() {
        return new EmailSubscriptions();
    }

    /**
     * Create an instance of {@link EmailSubscriptionsResponse }
     * 
     */
    public EmailSubscriptionsResponse createEmailSubscriptionsResponse() {
        return new EmailSubscriptionsResponse();
    }

    /**
     * Create an instance of {@link Subscribe }
     * 
     */
    public Subscribe createSubscribe() {
        return new Subscribe();
    }

    /**
     * Create an instance of {@link Unsubscribe }
     * 
     */
    public Unsubscribe createUnsubscribe() {
        return new Unsubscribe();
    }

    /**
     * Create an instance of {@link SubscribeResponse }
     * 
     */
    public SubscribeResponse createSubscribeResponse() {
        return new SubscribeResponse();
    }

    /**
     * Create an instance of {@link UnsubscribeResponse }
     * 
     */
    public UnsubscribeResponse createUnsubscribeResponse() {
        return new UnsubscribeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subscriptions.project3.is/", name = "unsubscribeResponse")
    public JAXBElement<UnsubscribeResponse> createUnsubscribeResponse(UnsubscribeResponse value) {
        return new JAXBElement<UnsubscribeResponse>(_UnsubscribeResponse_QNAME, UnsubscribeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subscriptions.project3.is/", name = "subscribe")
    public JAXBElement<Subscribe> createSubscribe(Subscribe value) {
        return new JAXBElement<Subscribe>(_Subscribe_QNAME, Subscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Unsubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subscriptions.project3.is/", name = "unsubscribe")
    public JAXBElement<Unsubscribe> createUnsubscribe(Unsubscribe value) {
        return new JAXBElement<Unsubscribe>(_Unsubscribe_QNAME, Unsubscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subscriptions.project3.is/", name = "subscribeResponse")
    public JAXBElement<SubscribeResponse> createSubscribeResponse(SubscribeResponse value) {
        return new JAXBElement<SubscribeResponse>(_SubscribeResponse_QNAME, SubscribeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailSubscriptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subscriptions.project3.is/", name = "emailSubscriptions")
    public JAXBElement<EmailSubscriptions> createEmailSubscriptions(EmailSubscriptions value) {
        return new JAXBElement<EmailSubscriptions>(_EmailSubscriptions_QNAME, EmailSubscriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailSubscriptionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subscriptions.project3.is/", name = "emailSubscriptionsResponse")
    public JAXBElement<EmailSubscriptionsResponse> createEmailSubscriptionsResponse(EmailSubscriptionsResponse value) {
        return new JAXBElement<EmailSubscriptionsResponse>(_EmailSubscriptionsResponse_QNAME, EmailSubscriptionsResponse.class, null, value);
    }

}
