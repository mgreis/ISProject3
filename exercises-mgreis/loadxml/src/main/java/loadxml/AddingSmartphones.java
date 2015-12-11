package loadxml;

import org.mule.api.MuleEventContext;

import org.mule.api.lifecycle.Callable;


import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.transform.stream.StreamSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import xml.XmlHelper;
import xml.Report;
import xml.ObjectFactory;

/**
 *
 * @author mgreis
 */
public class AddingSmartphones implements Callable {


	public AddingSmartphones() {

	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		// receive data from topic
		String xml;
		Report report = null;

		xml = new String(eventContext.getMessage().getPayloadAsBytes(),
				StandardCharsets.UTF_8);

		// validate message
		// @xxx doesn't check timestamp
		try {
			XmlHelper.validate(new StreamSource(new StringReader(xml)));
		} catch (Exception ex) {
			System.out.println("ERROR: Failed to validate.");

		}
		System.out.println(xml);
		
		// replace data
		JAXBContext context;
		try {
			context = JAXBContext
					.newInstance(Report.class, ObjectFactory.class);
			Unmarshaller unmarshaller;

			unmarshaller = context.createUnmarshaller();

			StringReader reader = new StringReader(xml);

			report = (Report) unmarshaller.unmarshal(reader);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventContext.getMessage().setInvocationProperty("report", report);
		return eventContext.getMessage().getPayload();
	}

}
