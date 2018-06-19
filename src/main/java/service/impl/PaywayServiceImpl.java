package service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.PaywayMapperCustom;
import po.AliOrder;
import po.OrderCustom;
import po.PayAccount;
import po.TicketCustom;
import po.WechatOrder;
import service.PaywayService;

@WebService(endpointInterface="service.PaywayService",serviceName="PaywayService")
public class PaywayServiceImpl implements PaywayService{

	
	@Autowired
	private PaywayMapperCustom paywayMapperCustom;
	
	public void addAlipaybao(TicketCustom ticketCustom,int money) throws Exception {
		// TODO Auto-generated method stub
		OrderCustom orderCustom = new OrderCustom();
		int random =(int)(1+Math.random()*5000);
		String ran = String.valueOf(random);
		String order_id = "ali" + ran;
		orderCustom.setOrder_id(order_id);
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
		int random =(int)(1+Math.random()*5000);
		String ran = String.valueOf(random);
		String order_id = "wc" + ran;
		orderCustom.setOrder_id(order_id);
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

	public PayAccount getAlipayAccountById(String payid) throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.findAliPayAccountById(payid);
		
	}

	public PayAccount getWeChatAccountById(String payid) throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.findWeChatAccountById(payid);
		
	}

	public void updateAlipayAccount(PayAccount payaccount) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.updateAliPayAccount(payaccount);
		
	}

	public void updateWeChatAccount(PayAccount payaccount) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.updateWeChatAccount(payaccount);
		
	}

	public List<AliOrder> getAliPayOrder() throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.getAliPay();
	}

	public List<WechatOrder> getWeChatOrder() throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.getWeChat();
	}

	public List<PayAccount> getAliPayAccount() throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.getAliPayAccount();
	}

	public List<PayAccount> getWeChatAccount() throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.getWeChatAccount();
	}

	public void deleteWechatOrder(String w_id) throws Exception {
		
		paywayMapperCustom.deleteWechatOrder(w_id);
		
	}

	public void deleteAlipayOrder(String a_id) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.deleteAlipayOrder(a_id);
	}

	public void deleteWechatAccount(String payid) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.deleteWechatAccount(payid);
	}

	public void deleteAlipayAccount(String payid) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.deleteAlipayAccount(payid);
	}

	public AliOrder findAliPayOrderById(String a_id) throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.findAliPayOrderById(a_id);
	}

	public WechatOrder findWeChatOrderById(String w_id) throws Exception {
		// TODO Auto-generated method stub
		return paywayMapperCustom.findWeChatOrderById(w_id);
	}

	public void updateAliPayOrder(AliOrder aliOrder) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.updateAliPayOrder(aliOrder);
	}

	public void updateWeChatOrder(WechatOrder wechatOrder) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.updateWeChatOrder(wechatOrder);
	}

	public void addAliOrder(AliOrder aliOrder) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.addAliOrder(aliOrder);
	}

	public void addWechatOrder(WechatOrder wechatOrder) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.addWechatOrder(wechatOrder);
	}

	public void addAliAccount(PayAccount payAccount) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.addAliAccount(payAccount);
	}

	public void addWechatAccount(PayAccount payAccount) throws Exception {
		// TODO Auto-generated method stub
		paywayMapperCustom.addWechatAccount(payAccount);
	}

}
