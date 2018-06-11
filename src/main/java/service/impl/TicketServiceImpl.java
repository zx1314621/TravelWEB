package service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.TicketMapperCustom;
import po.TicketCustom;
import service.TicketService;

@WebService(endpointInterface="service.TicketService",serviceName="TicketService")
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketMapperCustom ticketMapperCustom;
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("WebService sayHello " + name);
        return "Hello " + name + ", nice to meet you.";
	}

	public List<TicketCustom> getTicketEastern() throws Exception {
		// TODO Auto-generated method stub
		return ticketMapperCustom.queryEasternTicket();
	}

	public List<TicketCustom> getTicketChina() throws Exception {
		// TODO Auto-generated method stub
		return ticketMapperCustom.queryChinaTicket();
	}

	public List<TicketCustom> getTicketSouthern() throws Exception {
		// TODO Auto-generated method stub
		return ticketMapperCustom.querySouthernTicket();
	}

	public TicketCustom findEasternTicketById(String ticket_id) throws Exception {
		// TODO Auto-generated method stub
		return ticketMapperCustom.findEasternTicketById(ticket_id);
	}

	public TicketCustom findSouthernTicketById(String ticket_id) throws Exception {
		// TODO Auto-generated method stub
		return ticketMapperCustom.findSouthernTicketById(ticket_id);
	}

	public TicketCustom findChinaTicketById(String ticket_id) throws Exception {
		// TODO Auto-generated method stub
		return ticketMapperCustom.findChinaTicketById(ticket_id);
	}

	public void buyEasternTicketById(String ticket_id, int number) throws Exception {
		for(int i=0; i<number; i++)
		{
			ticketMapperCustom.buyEasternTicketById(ticket_id);	
		}
	}

	public void buySouthernTicketById(String ticket_id, int number) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0; i<number; i++)
		{
			ticketMapperCustom.buySouthernTicketById(ticket_id);	
		}
	}

	public void buyChinaTicketById(String ticket_id, int number) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0; i<number; i++)
		{
			ticketMapperCustom.buyChinaTicketById(ticket_id);	
		}
	}
	

}
