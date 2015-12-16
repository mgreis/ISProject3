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
				System.out.println("1) subscribe");
				System.out.println("2) unsubscribe");
				System.out.println("3) email_subscriptions");
				System.out.println("4) exit");
				System.out.print("> ");
				final String cmd = input.nextLine().trim();
				try {
					switch (cmd) {
					case "1":
					case "subscribe":
						subscribe();
						break;
					case "2":
					case "unsubscribe":
						unsubscribe();
						break;
					case "3":
					case "email_subscriptions":
						emailSubscriptions();
						break;
					case "4":
					case "exit":
						return; // exit the application
					default:
						System.out.println("ERROR: Unknown command \""
								+ String.valueOf(cmd) + "\".");
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
		System.out.print("Favorite Brand : ");
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
					.println("SUCCESS: A mail was sent with an activation link to start receiving smartphone updates.");
		} else {
			System.out.println("ERROR: Failed to subscribe.");
		}
	}

	private void unsubscribe() {
		// input
		System.out.print("Email : ");
		final String email = input.nextLine().trim();
		System.out.print("UUID : ");
		final String uuid = input.nextLine().trim();
		// unsubscribe
		if (server.unsubscribe(email, uuid)) {
			System.out.println("SUCESS: The subscription was deleted.");
		} else {
			System.out.println("ERROR: Failed to unsubscribe.");
		}
	}

	private void emailSubscriptions() {
		// input
		System.out.print("Email : ");
		final String email = input.nextLine().trim();
		// email subscriptions
		server.emailSubscriptions(email);
		System.out.println("SUCCESS: A mail was sent only if the email had subscriptions. No futher feedback is given here to protect the subscriber's privacy.");
	}

}
