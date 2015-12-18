package is.project3.smartphones.soap;




import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class LoadXML {

	@WebMethod
	public String loadXML(String xml) {
		
		return xml;

	}

}
