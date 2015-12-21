package is.project3.transformer;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;
import org.mule.transport.ssl.SslConnector;

public class VerifySignatureTransformer extends AbstractTransformer {

	private String keyAlias = "localhost";
	private String sslConnectorName = "SSL__TLS_";
	private byte[] signature;

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		// get keystore stuff
		final SslConnector sslConnector = (SslConnector) muleContext
				.getRegistry().lookupConnector(getSslConnectorName());
		final String keystore = sslConnector.getKeyStore();
		final char[] keystorePassword = sslConnector.getKeyStorePassword()
				.toCharArray();
		final String keyAlias = this.getKeyAlias();// sslConnector.getKeyAlias();

		try {
			final byte[] data = (byte[]) src;
			Security.addProvider(new BouncyCastleProvider());
			final KeyStore ks = KeyStore.getInstance("JKS");
			try (FileInputStream fis = new FileInputStream(keystore)) {
				ks.load(fis, keystorePassword);
			}
			final Signature rsa = Signature.getInstance("SHA1withRSA", "BC");
			final Certificate certificate = ks.getCertificate(keyAlias);
			rsa.initVerify(certificate);
			rsa.update(data);
			return rsa.verify(getSignature());
		} catch (Exception ex) {
			final Message msg = MessageFactory
					.createStaticMessage("failed to verify the byte array payload");
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

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

}
