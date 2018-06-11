package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.ibatis.annotations.Param;

import po.AccountCustom;
import po.TicketCustom;

@WebService
public interface PaywayService {
	
	@WebMethod
	public void addAlipaybao(@Param("ticketCustom")TicketCustom ticketCustom,@Param("money")int money)throws Exception;
	
	@WebMethod
	public void addWeChatbao(@Param("ticketCustom")TicketCustom ticketCustom,@Param("money")int money)throws Exception;

}
