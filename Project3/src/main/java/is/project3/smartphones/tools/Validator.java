package is.project3.smartphones.tools;

import is.project3.smartphones.xml.XmlHelper;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

public class Validator implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String xml = (String) eventContext.getMessage().getPayload();
		try {
			XmlHelper.validate(new StreamSource(new StringReader(xml)));
		} catch (Exception ex) {
			System.out.println("ERROR: Failed to validate.");
			

		}
		return xml;
	}

	
	
}
