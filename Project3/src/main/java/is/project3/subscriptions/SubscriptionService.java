package is.project3.subscriptions;

import java.math.BigInteger;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService
public interface SubscriptionService {

	/**
	 * Create a subscription.
	 * 
	 * @param email
	 *            Email of the subscription.
	 * @param clientName
	 *            Client name.
	 * @param favoriteBrand
	 *            Favorite brand.
	 * @param minimumPrice
	 *            Minimum price.
	 * @param maximumPrice
	 *            Maximum price.
	 * @return the result of the operation.
	 */
	public String subscribe(
			@WebParam(name = "email") @XmlElement(required = true) String email,
			@WebParam(name = "clientName") @XmlElement(required = true) String clientName,
			@WebParam(name = "favoriteBrand") @XmlElement(required = true) String favoriteBrand,
			@WebParam(name = "minimumPrice") @XmlElement(required = true) double minimumPrice,
			@WebParam(name = "maximumPrice") @XmlElement(required = true) double maximumPrice);

	/**
	 * Delete a subscription.
	 * 
	 * @param id
	 *            Subscription id.
	 * @param email
	 *            Subscription email.
	 * @param signature
	 *            Subscription signature.
	 * @return the result of the operation.
	 */
	public String unsubscribe(
			@WebParam(name = "id") @XmlElement(required = true) BigInteger id,
			@WebParam(name = "email") @XmlElement(required = true) String email);

	/**
	 * Send email with all the subscriptions.
	 * 
	 * @param email
	 *            Email address.
	 * @return the result of the operation.
	 */
	public String emailSubscriptions(
			@WebParam(name = "email") @XmlElement(required = true) String email);

}
