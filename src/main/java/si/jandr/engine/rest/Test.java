package si.jandr.engine.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class Test {

	
	@GET
	public String returnTestValue() {
		return "Jersey REST is properly configured";
	}
	
	
	
}
