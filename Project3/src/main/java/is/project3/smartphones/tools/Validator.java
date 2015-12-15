package is.project3.smartphones.tools;

import is.project3.smartphones.xml.XmlHelper;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

public class Validator implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String xml = (String) eventContext.getMessage().getPayload();
		try {
			XmlHelper.validate(new StreamSource(new StringReader(xml)));
		} catch (IOException ex) {
			System.out.println("ERROR: Failed to validate. IOException");
			return null;

		}
		 catch (SAXException ex) {
				System.out.println("ERROR: Failed to validate. SAXException");
				return null;

			}
		return xml;
	}

	
	
}