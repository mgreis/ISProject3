package tools;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import java.util.ArrayList;
import java.util.Scanner;

import xml.Report;
import xml.Smartphone;

public class FilterScreenSize implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		Report report = (Report) eventContext.getMessage().getPayload();
		ArrayList <Smartphone>auxList =new ArrayList<>();
		System.out.println(report.getSmartphone().size());
		for (Smartphone s : report.getSmartphone()) {
			
			if (s.getDescription()!=null&&s.getDescription().size()>2) {
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
		for(Smartphone s:auxList){
			report.getSmartphone().remove(s);
		}
		System.out.println(report.getTimestamp());
		eventContext.getSession().setProperty("timestamp", report.getTimestamp().longValue());
		eventContext.getSession().setProperty("version", report.getVersion().longValue());
		eventContext.getSession().setProperty("crawler", report.getCrawler());
		return report;
	}

}
