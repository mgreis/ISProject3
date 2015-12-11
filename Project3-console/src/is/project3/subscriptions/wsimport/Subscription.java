
package is.project3.subscriptions.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="favoriteBand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maximumPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minimumPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscription", propOrder = {
    "clientName",
    "email",
    "favoriteBand",
    "maximumPrice",
    "minimumPrice"
})
public class Subscription {

    protected String clientName;
    protected String email;
    protected String favoriteBand;
    protected double maximumPrice;
    protected double minimumPrice;

    /**
     * Gets the value of the clientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the value of the clientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the favoriteBand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFavoriteBand() {
        return favoriteBand;
    }

    /**
     * Sets the value of the favoriteBand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFavoriteBand(String value) {
        this.favoriteBand = value;
    }

    /**
     * Gets the value of the maximumPrice property.
     * 
     */
    public double getMaximumPrice() {
        return maximumPrice;
    }

    /**
     * Sets the value of the maximumPrice property.
     * 
     */
    public void setMaximumPrice(double value) {
        this.maximumPrice = value;
    }

    /**
     * Gets the value of the minimumPrice property.
     * 
     */
    public double getMinimumPrice() {
        return minimumPrice;
    }

    /**
     * Sets the value of the minimumPrice property.
     * 
     */
    public void setMinimumPrice(double value) {
        this.minimumPrice = value;
    }

}
