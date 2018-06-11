package controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.cxf.transport.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import po.AccountCustom;
import po.OrderCustom;
import po.PayAccount;
import po.TicketCustom;
import service.AccountService;
import service.OrderService;
import service.PaywayService;
import service.TicketService;

@Controller
@RequestMapping("/jsp")
public class LocalController {
	
	@Autowired
	public AccountService accountService;
	
	@Autowired
	public OrderService orderService;
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-service.xml");  
    TicketService client = (TicketService) ctx.getBean("client");  
    PaywayService paywaySercie = (PaywayService) ctx.getBean("payway");
	
	@RequestMapping("/queryTicket.action")
	public ModelAndView queryTicket(HttpServletRequest request,String day,String start,String end) throws Exception {
		
		List<TicketCustom> easternList = client.getTicketEastern();
		List<TicketCustom> southernList = client.getTicketSouthern();
		List<TicketCustom> chinaList = client.getTicketChina();
		
		
		//排除过期飞机票
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
		String date = df.format(new Date());
		String[] dates = date.split("/");
		int dates1 = Integer.valueOf(dates[0]);
		int dates2 = Integer.valueOf(dates[1]); 
		int dates3 = Integer.valueOf(dates[2]);
		for(int i=0; i<easternList.size(); i++ )
		{
			String day1 = easternList.get(i).getDay();
			String[] days = day1.split("/");
			int days1 = Integer.valueOf(days[0]);
			int days2 = Integer.valueOf(days[1]);
			int days3 = Integer.valueOf(days[2]);
			if(dates1>days1) {easternList.remove(i);}
			else {
				if(dates1==days1&&dates2>days2)easternList.remove(i);
				else {
					if(dates1==days1&&dates2==days2&&dates3>days3)easternList.remove(i);	
				}
				
			}
		}
		for(int i=0; i<southernList.size(); i++ )
		{
			String day1 = southernList.get(i).getDay();
			String[] days = day1.split("/");
			int days1 = Integer.valueOf(days[0]);
			int days2 = Integer.valueOf(days[1]);
			int days3 = Integer.valueOf(days[2]);
			if(dates1>days1) {southernList.remove(i);}
			else {
				if(dates1==days1&&dates2>days2)southernList.remove(i);
				else {
					if(dates1==days1&&dates2==days2&&dates3>days3)southernList.remove(i);	
				}
				
			}
		}
		for(int i=0; i<chinaList.size(); i++ )
		{
			String day1 = chinaList.get(i).getDay();
			String[] days = day1.split("/");
			int days1 = Integer.valueOf(days[0]);
			int days2 = Integer.valueOf(days[1]);
			int days3 = Integer.valueOf(days[2]);
			if(dates1>days1) {chinaList.remove(i);}
			else {
				if(dates1==days1&&dates2>days2)chinaList.remove(i);
				else {
					if(dates1==days1&&dates2==days2&&dates3>days3)chinaList.remove(i);	
				}
				
			}
		}	
		
		
		if(start.equals("出发地")&&end.equals("目的地"));
		else {
		for(int i=0; i<easternList.size(); i++ )
		{
			if(easternList.get(i).getDay().equals(day)&&easternList.get(i).getStart().equals(start)&&
					easternList.get(i).getEnd().equals(end)) {
				continue;
			}else {
				easternList.remove(i);
				i--;
			}
		}
		for(int i=0; i<southernList.size(); i++ )
		{
			if(southernList.get(i).getDay().equals(day)&&southernList.get(i).getStart().equals(start)&&
					southernList.get(i).getEnd().equals(end)) {
				continue;
			}else {
				southernList.remove(i);
				i--;
			}
		}
		for(int i=0; i<chinaList.size(); i++ )
		{
			if(chinaList.get(i).getDay().equals(day)&&chinaList.get(i).getStart().equals(start)&&
					chinaList.get(i).getEnd().equals(end)) {
				continue;
			}else {
				chinaList.remove(i);
				i--;
			}
		}
		}
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("easternList",easternList);
		modelandview.addObject("southernList",southernList);
		modelandview.addObject("chinaList",chinaList);
		
		modelandview.setViewName("choose");
		
		return modelandview;
	}
	
	@RequestMapping("/showticket.action")
	public ModelAndView showticket(String ticket_id) throws Exception {		
		TicketCustom ticketCustom = new TicketCustom();
		String flag = ticket_id.substring(0, 1);
		if(flag.equals("e")) {
			ticketCustom = client.findEasternTicketById(ticket_id);
		}
		else if(flag.equals("s")) {
			ticketCustom = client.findSouthernTicketById(ticket_id);
		}
		else if(flag.equals("c")) {
			ticketCustom = client.findChinaTicketById(ticket_id);
		}
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("ticketCustom",ticketCustom);
		modelandview.setViewName("ticketdetail");
		
		return modelandview;
	}

	@RequestMapping("/buyticket.action")
	public ModelAndView buyticket(String ticket_id,String number) throws Exception {		
		TicketCustom ticketCustom = new TicketCustom();
		String flag = ticket_id.substring(0, 1);
		OrderCustom orderCustom = new OrderCustom();
		int random =(int)(1+Math.random()*5000);
		String company = null;
		String ran = String.valueOf(random);
		String order_id = "ali" + ran;
		orderCustom.setOrder_id(order_id);
		orderCustom.setTicket_id(ticket_id);
		if(flag.equals("e")) {
			ticketCustom = client.findEasternTicketById(ticket_id);
			company="东方航空";
		}
		else if(flag.equals("s")) {
			ticketCustom = client.findSouthernTicketById(ticket_id);
			company="南方航空";
		}
		else if(flag.equals("c")) {
			ticketCustom = client.findChinaTicketById(ticket_id);
			company="中国航空";
		}
		int money = Integer.valueOf(number)*ticketCustom.getPrice();
		
		orderCustom.setStart(ticketCustom.getStart());
		orderCustom.setEnd(ticketCustom.getEnd());
		orderCustom.setPrice(ticketCustom.getPrice());
		orderCustom.setDay(ticketCustom.getDay());
		orderCustom.setTime(ticketCustom.getTime());
		orderCustom.setBuynumber(Integer.valueOf(number));
		orderCustom.setCompany(company);
		orderCustom.setMoney(money);
		orderService.addOrder(orderCustom);
		
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("ticketCustom",ticketCustom);
		modelandview.addObject("money",money);
		modelandview.setViewName("pay");
		
		return modelandview;
	}
	
	@RequestMapping("/payticket.action")
	public ModelAndView payticket(String ticket_id,String money,String payway,String paywayid) throws Exception {		
		TicketCustom ticketCustom = new TicketCustom();
		String flag = ticket_id.substring(0, 1);	
			
		//减票
		if(flag.equals("e")) {
			ticketCustom = client.findEasternTicketById(ticket_id);
			int number = Integer.valueOf(money)/(ticketCustom.getPrice());
			client.buyEasternTicketById(ticket_id, number);
		}
		else if(flag.equals("s")) {
			ticketCustom = client.findSouthernTicketById(ticket_id);
			int number = Integer.valueOf(money)/(ticketCustom.getPrice());
			client.buySouthernTicketById(ticket_id, number);
		}
		else if(flag.equals("c")) {
			ticketCustom = client.findChinaTicketById(ticket_id);
			int number = Integer.valueOf(money)/(ticketCustom.getPrice());
			client.buyChinaTicketById(ticket_id, number);
		}	
		//付钱
		if(payway.equals("支付宝")) {
			PayAccount payAccount = paywaySercie.getAlipayAccount(paywayid);
			if(payAccount==null)
			{
				ModelAndView modelandview = new ModelAndView();
			    modelandview.setViewName("failed1");
			    return modelandview;		
				
			}
			
			if(payAccount.getBalance()>Integer.valueOf(money))
			{
				paywaySercie.addAlipaybao(ticketCustom, Integer.valueOf(money));
				payAccount.setBalance((payAccount.getBalance())-(Integer.valueOf(money)));
				paywaySercie.updateAlipayAccount(payAccount);
				
			}else {
				ModelAndView modelandview = new ModelAndView();
				modelandview.setViewName("failed");
				return modelandview;		
			}
			
		}else {
			PayAccount payAccount = paywaySercie.getWeChatAccount(paywayid);
			if(payAccount==null)
			{
				ModelAndView modelandview = new ModelAndView();
			    modelandview.setViewName("failed1");
			    return modelandview;		
				
			}
			if(payAccount!=null&&payAccount.getBalance()>Integer.valueOf(money))
			{
				paywaySercie.addWeChatbao(ticketCustom, Integer.valueOf(money));
				payAccount.setBalance((payAccount.getBalance())-(Integer.valueOf(money)));
				paywaySercie.updateWeChatAccount(payAccount);
				
			}else {
				ModelAndView modelandview = new ModelAndView();
				modelandview.setViewName("failed");
				return modelandview;		
			}
			
		}
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("ticketCustom",ticketCustom);
		modelandview.setViewName("success");
		
		return modelandview;
	}

	@RequestMapping("/signin.action")
	public ModelAndView signin(HttpSession session,String account_id, String password) throws Exception
	{
		AccountCustom accountCustom = accountService.findAccountById(account_id);
		if(accountCustom==null)
		{
			ModelAndView modelandview = new ModelAndView();
			modelandview.setViewName("signupfailed");
			return modelandview;
		}
		if(accountCustom.getPassword().equals(password)) {
			
			int flag = 1;
			session.setAttribute("flag", flag); 
			ModelAndView modelandview = new ModelAndView();
			modelandview.setViewName("signinsuccess");
			return modelandview;
		}else {
			ModelAndView modelandview = new ModelAndView();
			modelandview.setViewName("signinfailed");
			return modelandview;
		}
		
	
		
	}
	
	@RequestMapping("/signup.action")
	public ModelAndView signup(HttpSession session,String account_id, String password) throws Exception
	{
		AccountCustom accountCustom = new AccountCustom();
		accountCustom.setAccount_id(account_id);
		accountCustom.setPassword(password);
		accountService.addAccount(accountCustom);
		int flag = 1;
		session.setAttribute("flag", flag); 
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("signupsuccess");
		return modelandview;
		
	}
	
	/*@RequestMapping("/checkorder.action")
	public ModelAndView checkorder(String account_id, String password) throws Exception
	{
		AccountCustom accountCustom = new AccountCustom();
		accountCustom.setAccount_id(account_id);
		accountCustom.setPassword(password);
		accountService.addAccount(accountCustom);
		int flag = 1;
		session.setAttribute("flag", flag); 
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("signupsuccess");
		return modelandview;
		
	}*/



}
