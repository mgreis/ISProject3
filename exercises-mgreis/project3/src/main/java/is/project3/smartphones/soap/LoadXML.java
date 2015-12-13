package is.project3.smartphones.soap;

import java.io.StringReader;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import is.project3.smartphones.xml.*;

@WebService
public class LoadXML {// implements Callable {
	private volatile Report report = null;

	// @Payload
	// MuleEventContext eventContext;

	@WebMethod
	public String loadXML(String xml) {

		// validate;
		try {
			XmlHelper.validate(new StreamSource(new StringReader(xml)));
		} catch (Exception ex) {
			System.out.println("ERROR: Failed to validate.");

		}
		System.out.println(xml);

		return xml;

	}

	/*
	 * @Override public Object onCall(MuleEventContext eventContext) throws
	 * Exception { eventContext.getMessage().setInvocationProperty("report",
	 * report.getSmartphone()); return eventContext.getMessage().getPayload(); }
	 */

}
