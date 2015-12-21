package is.project3.subscriptions;

import is.project3.subscriptions.wsimport.SubscriptionService;
import is.project3.subscriptions.wsimport.SubscriptionServiceService;

import java.math.BigInteger;
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
			throw new IllegalArgumentException("The minimum price must be equal or lower than the maximum price.");
		}
		// subscribe
		System.out.println(server.subscribe(email, CLIENT_NAME, favoriteBrand,
				minimumPrice, maximumPrice));
	}

	private void unsubscribe() {
		// input
		System.out.print("Id : ");
		final BigInteger id = new BigInteger(input.nextLine().trim());
		System.out.print("Email : ");
		final String email = input.nextLine().trim();
		// unsubscribe
		System.out.println(server.unsubscribe(id, email));
	}

	private void emailSubscriptions() {
		// input
		System.out.print("Email : ");
		final String email = input.nextLine().trim();
		// email subscriptions
		System.out.println(server.emailSubscriptions(email));
	}

}
