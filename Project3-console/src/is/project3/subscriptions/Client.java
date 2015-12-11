package is.project3.subscriptions;

import is.project3.subscriptions.wsimport.*;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Client de consola para gerir subscrições.
 * {@code wsimport -Xnocompile -d Project3-console\src -p is.project3.subscriptions.wsimport http://localhost:8081/soap/subscriptions?wsdl}
 * 
 * @author Flávio J. Saraiva
 */
public class Client implements Runnable {

	public static final String CLIENT_NAME = "Subscriptions SOAP Client";

	public static void main(String[] args) {
		Client app = new Client();
		app.run();
	}

	private Scanner input;
	private SubscriptionService server;
	private String email;
	private List<Subscription> list;

	@Override
	public void run() {
		try {
			// startup
			input = new Scanner(System.in);
			final SubscriptionServiceService service = new SubscriptionServiceService();
			server = service.getSubscriptionServicePort();
			email = "";
			list = null;

			// execute
			System.out.println(CLIENT_NAME);
			while (true) {
				String cmd;
				if (email.isEmpty()) {
					cmd = "email"; // email is mandatory
				} else {
					listSubscriptions(); // assume it never fails
					System.out.println("email  - Change email (" + email + ")");
					System.out.println("add    - Add subscription");
					System.out.println("remove - Remove subscription");
					System.out.println("exit   - Exit the application");
					System.out.print("> ");
					cmd = input.nextLine().trim();
				}
				try {
					switch (cmd) {
					case "email":
						changeEmail();
						break;
					case "add":
						addSubscription();
						break;
					case "remove":
						removeSubscription();
						break;
					case "exit":
						return; // exit the application
					}
				} catch (Exception ex) {
					System.out.println(ex.toString());
				}
			}
		} finally {
			input.close();
			input = null;
			server = null;
		}
	}

	private void changeEmail() {
		System.out.print("email: ");
		email = input.nextLine().trim();
	}

	private void listSubscriptions() {
		System.out.println("--BEGIN List--");
		list = server.listSubscriptions(email);
		if (list == null) {
			list = Arrays.asList(new Subscription[0]); // empty list
		}
		for (int index = 0; index < list.size(); index++) {
			final Subscription item = list.get(index);
			final String prefix = "[" + index + "] ";
			if (index > 0) {
				System.out.println();
			}
			System.out.print(prefix);
			System.out.print("Client name   : ");
			System.out.println(item.getClientName());
			System.out.print(prefix);
			System.out.print("Favorite band : ");
			System.out.println(item.getFavoriteBand());
			System.out.print(prefix);
			System.out.print("Minimum price : ");
			System.out.println(item.getMinimumPrice());
			System.out.print(prefix);
			System.out.print("Maximum price : ");
			System.out.println(item.getMaximumPrice());
		}
		System.out.println("--END List--");
	}

	private void addSubscription() {
		// input
		System.out.print("Favorite Band : ");
		final String favoriteBand = input.nextLine().trim();
		System.out.print("Minimum Price : ");
		final double minimumPrice = Double.parseDouble(input.nextLine());
		System.out.print("Maximum Price : ");
		final double maximumPrice = Double.parseDouble(input.nextLine());
		if (minimumPrice < 0.0 || maximumPrice < minimumPrice) {
			throw new InvalidParameterException("Invalid price range");
		}
		// add
		final Subscription item = new Subscription();
		item.setEmail(email);
		item.setClientName(CLIENT_NAME);
		item.setFavoriteBand(favoriteBand);
		item.setMinimumPrice(minimumPrice);
		item.setMaximumPrice(maximumPrice);
		if (server.addSubscription(item)) {
			System.out.println("Subscription added.");
		} else {
			System.out.println("Failed to add subscription.");
		}
	}

	private void removeSubscription() {
		// get
		System.out.print("Index : ");
		int index = Integer.parseInt(input.nextLine());
		final Subscription item = list.get(index);
		// remove
		server.removeSubscription(item);
		if (server.addSubscription(item)) {
			System.out.println("Subscription removed.");
		} else {
			System.out.println("Failed to remove subscription.");
		}
	}

}
