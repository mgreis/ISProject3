package is.project3.subscriptions;

import is.project3.subscriptions.wsimport.*;

import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * Client de consola para gerir subscrições.
 * {@code wsimport -Xnocompile -d Project3-console\src -p is.project3.subscriptions.wsimport http://localhost:8081/subscription_service?wsdl}
 * 
 * @author Flávio J. Saraiva
 */
public class Client implements Runnable {

	public static final String CLIENT_NAME = "Subscription SOAP Client";

	public static void main(String[] args) {
		Client app = new Client();
		app.run();
	}

	private Scanner input;
	private SubscriptionService server;

	@Override
	public void run() {
		try {
			// startup
			input = new Scanner(System.in);
			final SubscriptionServiceService service = new SubscriptionServiceService();
			server = service.getSubscriptionServicePort();

			// execute
			System.out.println(CLIENT_NAME);
			while (true) {
				System.out.println("");
				System.out.println("Commands:");
				System.out.println(" subscribe");
				System.out.println(" unsubscribe");
				System.out.println(" exit");
				System.out.print("> ");
				final String cmd = input.nextLine().trim();
				try {
					switch (cmd) {
					case "subscribe":
						subscribe();
						break;
					case "unsubscribe":
						unsubscribe();
						break;
					case "exit":
						return; // exit the application
					}
				} catch (Exception ex) {
					System.out.println("ERROR:" + ex.toString());
				}
			}
		} finally {
			input.close();
			input = null;
			server = null;
		}
	}

	private void subscribe() {
		// input
		System.out.print("Email : ");
		final String email = input.nextLine().trim();
		System.out.print("Favorite Band : ");
		final String favoriteBrand = input.nextLine().trim();
		System.out.print("Minimum Price : ");
		final double minimumPrice = Double.parseDouble(input.nextLine());
		System.out.print("Maximum Price : ");
		final double maximumPrice = Double.parseDouble(input.nextLine());
		if (minimumPrice < 0.0 || maximumPrice < minimumPrice) {
			throw new InvalidParameterException("Invalid price range");
		}
		// subscribe
		if (server.subscribe(email, CLIENT_NAME, favoriteBrand, minimumPrice,
				maximumPrice)) {
			System.out
					.println("SUCCESS: A mail was sent, click the confirmation link to start receiving smartphone updates.");
		} else {
			System.out.println("ERROR: Failed to add subscription.");
		}
	}

	private void unsubscribe() {
		// input
		System.out.print("Email : ");
		final String email = input.nextLine().trim();
		// unsubscribe
		if (server.unsubscribe(email)) {
			System.out
					.println("SUCESS: The email will not receive smartphone updates.");
		} else {
			System.out.println("ERROR: Failed to remove subscription.");
		}
	}

}
