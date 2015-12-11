package is.project3.subscriptions;

import javax.jws.WebService;

@WebService
public interface SubscriptionService {

	/**
	 * List all the subscriptions of a specific email.
	 * 
	 * @return List of subscriptions.
	 */
	public Subscription[] listSubscriptions(String email);

	/**
	 * Add subscription.
	 * 
	 * @param subscription
	 *            Subscription data.
	 * @return true if it was successful.
	 */
	public boolean addSubscription(Subscription subscription);

	/**
	 * Remove subscription.
	 * 
	 * @param subscription
	 *            Subscription data.
	 * @return true if it was successful.
	 */
	public boolean removeSubscription(Subscription subscription);

}
