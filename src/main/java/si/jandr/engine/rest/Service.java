package si.jandr.engine.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("service")
public class Service {
	
	@POST
	@Consumes ("application/xml; charset=UTF-8")
    @Produces ("application/xml; charset=UTF-8")
	public String WSCommunicator(String request, @HeaderParam("method") String method) {
		
		
		String response = "Class to call: " + method + "\n" + request;
		
		return response;
	}

}
