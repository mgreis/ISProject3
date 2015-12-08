package webservice;

import java.io.StringReader;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import xml.ObjectFactory;
import xml.Report;
import xml.XmlHelper;

@WebService
public class LoadXML {
	private volatile Report report=null;
	

	@WebMethod
	public boolean loadXML(String xml) {
		
		//validate;
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
			return true;
		} catch (JAXBException e) {
			System.out.println("Error Unmarshalling XML");
			return false;

		}

	}
	
	@WebMethod
	public Report getReport(){
		return report;
	}
	
	private void setPayload(Report report){
		//eventContext.getMessage().setInvocationProperty("report", report);
	}

}
