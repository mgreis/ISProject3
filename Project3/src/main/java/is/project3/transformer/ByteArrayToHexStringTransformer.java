package is.project3.transformer;

import javax.xml.bind.DatatypeConverter;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class ByteArrayToHexStringTransformer extends AbstractTransformer {

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		return DatatypeConverter.printHexBinary((byte[]) src);
	}

}
