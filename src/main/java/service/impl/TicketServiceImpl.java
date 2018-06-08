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
	

}
