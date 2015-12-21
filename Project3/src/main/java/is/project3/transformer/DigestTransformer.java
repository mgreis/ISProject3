package is.project3.transformer;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;

/**
 * Creates a hexadecimal hash from the binary data.
 * 
 * @author Flávio J. Saraiva
 */
public class DigestTransformer extends AbstractTransformer {

	/**
	 * MD5, SHA-1, SHA-256, or other supported algorithms.
	 */
	private String algorithm;

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		try {
			final byte[] data = (byte[]) src;
			if (algorithm == null) {
				throw new IllegalArgumentException("algorithm is not defined");
			}
			final MessageDigest m = MessageDigest.getInstance(algorithm);
			m.reset();
			m.update(data);
			final byte[] digest = m.digest();
			return DatatypeConverter.printHexBinary(digest);
		} catch (Exception ex) {
			final Message msg = MessageFactory
					.createStaticMessage("failed to digest");
			throw new TransformerException(msg, ex);
		}
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
