package is.project3.subscriptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

/**
 * Dados de uma subscrição.
 * 
 * @author Flávio J. Saraiva
 */
@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private BigInteger id;

	@Basic
	private String email;

	@Basic
	private String clientName;

	@Basic
	private String favoriteBrand;

	@Basic
	private double minimumPrice;

	@Basic
	private double maximumPrice;

	@Basic
	private boolean validated;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

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

	public String getFavoriteBrand() {
		return favoriteBrand;
	}

	public void setFavoriteBrand(String favoriteBrand) {
		this.favoriteBrand = favoriteBrand;
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

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("{id=");
		s.append(id);
		s.append(",email=");
		s.append(email);
		s.append(",clientName=");
		s.append(clientName);
		s.append(",favoriteBrand=");
		s.append(favoriteBrand);
		s.append(",minimumPrice=");
		s.append(minimumPrice);
		s.append(",maximumPrice=");
		s.append(maximumPrice);
		s.append(",validated=");
		s.append(validated);
		s.append(",hash=");
		try {
			s.append(hash());
		} catch (Exception ex) {
			s.append(ex.toString());
		}
		s.append("}");
		return s.toString();
	}

	/**
	 * Generates a hash of this object.
	 * 
	 * @return Hash of the this object.
	 * @throws NoSuchAlgorithmException
	 *             if SHA-1 is not available.
	 * @throws IOException
	 *             if an IO error occurs.
	 */
	public String hash() throws NoSuchAlgorithmException, IOException {
		final MessageDigest digest = MessageDigest.getInstance("SHA-1");
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(bos)) {
			out.writeObject(this);
			final byte[] hash = digest.digest(bos.toByteArray());
			return DatatypeConverter.printHexBinary(hash);
		}
	}
}
