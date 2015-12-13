package is.project3.subscriptions;

/**
 * Dados de uma subscrição.
 * 
 * @author Flávio J. Saraiva
 */
public class Subscription {

	private String email;

	private String clientName;

	private String favoriteBand;

	private double minimumPrice;

	private double maximumPrice;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getFavoriteBand() {
		return favoriteBand;
	}

	public void setFavoriteBand(String favoriteBand) {
		this.favoriteBand = favoriteBand;
	}

	public double getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	public double getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

}
