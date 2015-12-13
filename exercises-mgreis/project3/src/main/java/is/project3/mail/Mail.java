package is.project3.mail;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

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
		Properties properties = System.getProperties();
		// @see mule-app.properties
		// mail.smtp.host - mail server
		// mail.user - username
		// mail.password - password
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setText(text);

		trustEveryone(); // TODO use a proper trust keystore
		Transport.send(message);
	}

	private void trustEveryone() {
		final HostnameVerifier verifyAllHostnames = new HostnameVerifier() {

			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		final X509TrustManager trustAllCertificates = new X509TrustManager() {

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}
		};
		// change default behavior
		try {
			HttpsURLConnection.setDefaultHostnameVerifier(verifyAllHostnames);
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[] { trustAllCertificates },
					new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context
					.getSocketFactory());
		} catch (Exception ex) {
			// should never happen
			ex.printStackTrace();
		}
	}

}
