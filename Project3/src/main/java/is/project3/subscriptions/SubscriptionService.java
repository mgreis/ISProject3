package is.project3.subscriptions;

import javax.jws.WebParam;
import javax.jws.WebService;

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
	public boolean subscribe(@WebParam(name = "email") String email,
			@WebParam(name = "clientName") String clientName,
			@WebParam(name = "favoriteBrand") String favoriteBrand,
			@WebParam(name = "minimumPrice") double minimumPrice,
			@WebParam(name = "maximumPrice") double maximumPrice);

	/**
	 * Remove subscription.
	 * 
	 * @param subscription
	 *            Subscription data.
	 * @return true if it was successful.
	 */
	public boolean unsubscribe(@WebParam(name = "email") String email);

}
