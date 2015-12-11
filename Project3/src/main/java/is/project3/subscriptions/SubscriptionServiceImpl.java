package is.project3.subscriptions;

import is.project3.mail.Mail;

public class SubscriptionServiceImpl implements SubscriptionService {

	@Override
	public Subscription[] listSubscriptions(String email) {
		System.out.println("SubscriptionServiceImpl.list");
		// TODO Auto-generated method stub
		return new Subscription[0];
	}

	@Override
	public boolean addSubscription(Subscription subscription) {
		try {
			final Mail mail = new Mail();
			mail.from = "noreply@localhost";
			mail.to = subscription.getEmail();
			mail.subject = "Subject";
			mail.text = "Text";
			mail.send();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeSubscription(Subscription subscription) {
		System.out.println("SubscriptionServiceImpl.remove");
		// TODO Auto-generated method stub
		return false;
	}

}
