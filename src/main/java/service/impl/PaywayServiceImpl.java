package service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.PaywayMapperCustom;
import po.OrderCustom;
import po.TicketCustom;
import service.PaywayService;

@WebService(endpointInterface="service.PaywayService",serviceName="PaywayService")
public class PaywayServiceImpl implements PaywayService{

	
	@Autowired
	private PaywayMapperCustom paywayMapperCustom;
	
	public void addAlipaybao(TicketCustom ticketCustom,int money) throws Exception {
		// TODO Auto-generated method stub
		OrderCustom orderCustom = new OrderCustom();
		orderCustom.setTicket_id(ticketCustom.getTicket_id());
		orderCustom.setStart(ticketCustom.getStart());
		orderCustom.setEnd(ticketCustom.getEnd());
		orderCustom.setPrice(ticketCustom.getPrice());
		orderCustom.setDay(ticketCustom.getDay());
		orderCustom.setTime(ticketCustom.getTime());
		int buynumber = money/ticketCustom.getPrice();
		orderCustom.setBuynumber(buynumber);
		
		String flag = ticketCustom.getTicket_id().substring(0, 1);
		if(flag.equals("e")) {
			orderCustom.setCompany("东方航空");
		}
		else if(flag.equals("s")) {
			orderCustom.setCompany("南方航空");	
		}
		else if(flag.equals("c")) {
	  	    orderCustom.setCompany("中国航空");		
		}
		orderCustom.setMoney(money);
		
		paywayMapperCustom.payalipay(orderCustom);
		
	}

	public void addWeChatbao(TicketCustom ticketCustom,int money) throws Exception {
		// TODO Auto-generated method stub
		OrderCustom orderCustom = new OrderCustom();
		orderCustom.setTicket_id(ticketCustom.getTicket_id());
		orderCustom.setStart(ticketCustom.getStart());
		orderCustom.setEnd(ticketCustom.getEnd());
		orderCustom.setPrice(ticketCustom.getPrice());
		orderCustom.setDay(ticketCustom.getDay());
		orderCustom.setTime(ticketCustom.getTime());
		int buynumber = money/ticketCustom.getPrice();
		orderCustom.setBuynumber(buynumber);
		
		String flag = ticketCustom.getTicket_id().substring(0, 1);
		if(flag.equals("e")) {
			orderCustom.setCompany("东方航空");
		}
		else if(flag.equals("s")) {
			orderCustom.setCompany("南方航空");	
		}
		else if(flag.equals("c")) {
	  	    orderCustom.setCompany("中国航空");		
		}
		orderCustom.setMoney(money);
		paywayMapperCustom.paywechat(orderCustom);
		
	}

}
