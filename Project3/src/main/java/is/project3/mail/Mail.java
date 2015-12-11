package is.project3.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public String from;
	public String to;
	public String subject;
	public String text;

	/**
	 * Send mail.
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void send() throws AddressException, MessagingException {
		String host = "localhost"; // mail server
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setText(text);

		Transport.send(message);
	}
}
