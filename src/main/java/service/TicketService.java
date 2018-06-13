package service;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.ibatis.annotations.Param;

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
	
	@WebMethod
	TicketCustom findEasternTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	
	@WebMethod
	TicketCustom findSouthernTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	
	@WebMethod
	TicketCustom findChinaTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	
	@WebMethod
	void buyEasternTicketById(@Param("ticket_id")String ticket_id,@Param("number")int number)throws Exception;
	@WebMethod
	void buySouthernTicketById(@Param("ticket_id")String ticket_id,@Param("number")int number)throws Exception;
	@WebMethod
	void buyChinaTicketById(@Param("ticket_id")String ticket_id,@Param("number")int number)throws Exception;
	
	@WebMethod
	void updateEasternTicketById(@Param("ticketCustom")TicketCustom ticketCustom)throws Exception;
	@WebMethod
	void updateSouthernTicketById(@Param("ticketCustom")TicketCustom ticketCustom)throws Exception;
	@WebMethod
	void updateChinaTicketById(@Param("ticketCustom")TicketCustom ticketCustom)throws Exception;
	

}
