package is.project3.smartphones.tools;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import java.util.ArrayList;
import java.util.Scanner;

import is.project3.smartphones.xml.*;

public class FilterScreenSize implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		//get object from payload
		Report report = (Report) eventContext.getMessage().getPayload();
		
		//get the smartphones that have no reference to screensize of a screen shorter then 10cm
		ArrayList <Smartphone>auxList =new ArrayList<>();
		for (Smartphone s : report.getSmartphone()) {
			if (s.getDescription()!=null&&s.getDescription().size()>3) {
				String [] aux =s.getDescription().get(2).getValue().split("\"");
				aux[0].replace(",", ".");
				double size;
				Scanner scanner = new Scanner(aux[0]);
				if (scanner.hasNextDouble()) {
					size = new Scanner(aux[0]).nextDouble();
					if(size<3.95)auxList.add(s);
					
				}
				else auxList.add(s);
				scanner.close();
			}
			else auxList.add(s);

		}
		
		//remove the smarthpones that do not fit the criteria of screen size
		for(Smartphone s:auxList){
			report.getSmartphone().remove(s);
		}
		
		
		//eventContext.getSession().setProperty("timestamp", report.getTimestamp().longValue());
		//eventContext.getSession().setProperty("version", report.getVersion().longValue());
		//eventContext.getSession().setProperty("crawler", report.getCrawler());
		return report;
	}

}
