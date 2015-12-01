package exe2;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TrocaString {
	@WebMethod
	public String troca (String first){
		first=first.toUpperCase();
		return first;
	}
	

}
