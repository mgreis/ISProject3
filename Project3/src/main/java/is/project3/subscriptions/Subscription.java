package is.project3.subscriptions;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name = "id")
	private BigInteger id;

	@Basic
	@Column(name = "email")
	private String email;

	@Basic
	@Column(name = "clientName")
	private String clientName;

	@Basic
	@Column(name = "channel")
	private String channel;

	@Basic
	@Column(name = "favoriteBrand")
	private String favoriteBrand;

	@Basic
	@Column(name = "minimumPrice")
	private double minimumPrice;

	@Basic
	@Column(name = "maximumPrice")
	private double maximumPrice;

	@Basic
	@Column(name = "uuid", columnDefinition = "varchar(255) CHARACTER SET latin1 NOT NULL", unique = true)
	private String uuid;

	@Basic
	@Column(name = "active", columnDefinition = "tinyint(1) NOT NULL DEFAULT 0")
	private boolean active;

	@Column(name = "created", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Override
	public String toString() {
		final StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("{id=");
		s.append(getId());
		s.append(",email=");
		s.append(getEmail());
		s.append(",clientName=");
		s.append(getClientName());
		s.append(",favoriteBrand=");
		s.append(getFavoriteBrand());
		s.append(",minimumPrice=");
		s.append(getMinimumPrice());
		s.append(",maximumPrice=");
		s.append(getMaximumPrice());
		s.append(",created=");
		s.append(getCreated());
		s.append(",uuid=");
		s.append(getUuid());
		s.append(",active=");
		s.append(isActive());
		s.append("}");
		return s.toString();
	}

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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
