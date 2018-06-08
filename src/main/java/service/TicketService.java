package service;

import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.List;
import po.*;

import javax.jws.WebMethod;

@WebService
public interface TicketService {
	
	@WebMethod
	String sayHello(@WebParam(name="name") String name);
	
	@WebMethod
	List<TicketCustom> getTicketEastern() throws Exception;
	
	@WebMethod
	List<TicketCustom> getTicketChina() throws Exception;
	
	@WebMethod
	List<TicketCustom> getTicketSouthern() throws Exception;

}
