package is.project3.transformer;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.ssl.SslConnector;

/**
 * Signs the byte array payload. Returns the signature byte array.
 * 
 * @author Flávio J. Saraiva
 */
public class SignatureTransformer extends AbstractTransformer {

	private String keyAlias;
	private String sslConnectorName;

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		// get keystore stuff
		final SslConnector sslConnector = (SslConnector) muleContext
				.getRegistry().lookupConnector(getSslConnectorName());
		final String keystore = sslConnector.getKeyStore();
		final char[] keystorePassword = sslConnector.getKeyStorePassword()
				.toCharArray();
		final String keyAlias = this.getKeyAlias();
		final char[] keyPassword = sslConnector.getKeyPassword().toCharArray();

		try {
			final byte[] data = (byte[]) src;
			Security.addProvider(new BouncyCastleProvider());
			final KeyStore ks = KeyStore.getInstance("JKS");
			try (FileInputStream fis = new FileInputStream(keystore)) {
				ks.load(fis, keystorePassword);
			}
			final Signature rsa = Signature.getInstance("SHA1withRSA", "BC");
			final Key key = ks.getKey(keyAlias, keyPassword);
			rsa.initSign((PrivateKey) key, new SecureRandom());
			rsa.update(data);
			return rsa.sign();
		} catch (Exception ex) {
			final Message msg = MessageFactory
					.createStaticMessage("failed to sign the byte array payload");
			throw new TransformerException(msg, ex);
		}
	}

	public String getKeyAlias() {
		return keyAlias;
	}

	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}

	public String getSslConnectorName() {
		return sslConnectorName;
	}

	public void setSslConnectorName(String sslConnectorName) {
		this.sslConnectorName = sslConnectorName;
	}

}
