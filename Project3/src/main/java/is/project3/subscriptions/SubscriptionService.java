package is.project3.subscriptions;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService
public interface SubscriptionService {

	/**
	 * Create or replace a smartphone subscription.
	 * 
	 * @param email
	 *            Email of the subscription.
	 * @param clientName
	 *            Client name.
	 * @param favoriteBrand
	 *            Favorite smartphone brand.
	 * @param minimumPrice
	 *            Minimum price.
	 * @param maximumPrice
	 *            Maximum price.
	 * @return true if a subscription was created.
	 */
	public boolean subscribe(
			@WebParam(name = "email") @XmlElement(required = true) String email,
			@WebParam(name = "clientName") @XmlElement(required = true) String clientName,
			@WebParam(name = "favoriteBrand") @XmlElement(required = true) String favoriteBrand,
			@WebParam(name = "minimumPrice") @XmlElement(required = true) double minimumPrice,
			@WebParam(name = "maximumPrice") @XmlElement(required = true) double maximumPrice);

	/**
	 * Delete a subscription.
	 * 
	 * @param uuid
	 *            Unique subscription identifier.
	 * @return true if the subscription was delete.
	 */
	public boolean unsubscribe(
			@WebParam(name = "email") @XmlElement(required = true) String email,
			@WebParam(name = "uuid") @XmlElement(required = true) String uuid);

	/**
	 * Send email with subscriptions.
	 * 
	 * @param email
	 *            Email address.
	 */
	public void emailSubscriptions(
			@WebParam(name = "email") @XmlElement(required = true) String email);

}
