package controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.rmi.Remote;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.cxf.transport.Session;
import org.apache.taglibs.standard.tag.common.core.RemoveTag;
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
	public ModelAndView queryTicket(HttpSession session,String day,String start,String end) throws Exception {
		
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
		//删除过时机票
		for(int i=0; i<easternList.size(); i++ )
		{
			String day1 = easternList.get(i).getDay();
			String[] days = day1.split("/");
			int days1 = Integer.valueOf(days[0]);
			int days2 = Integer.valueOf(days[1]);
			int days3 = Integer.valueOf(days[2]);
			if(dates1>days1) {easternList.remove(i); i--;}
			else {
				if(dates1==days1&&dates2>days2) {easternList.remove(i);i--;}
				else {
					if(dates1==days1&&dates2==days2&&dates3>days3) {easternList.remove(i);i--;}
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
			if(dates1>days1) {southernList.remove(i);i--;}
			else {
				if(dates1==days1&&dates2>days2) {southernList.remove(i);i--;}
				else {
					if(dates1==days1&&dates2==days2&&dates3>days3) {southernList.remove(i);i--;}
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
			if(dates1>days1) {chinaList.remove(i);i--;}
			else {
				if(dates1==days1&&dates2>days2) {chinaList.remove(i);i--;}
				else {
					if(dates1==days1&&dates2==days2&&dates3>days3) {chinaList.remove(i);i--;}
				}
				
			}
		}	
		
		//选择机票
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
		
		
		//删除卖光机票
		for(int i=0; i<easternList.size(); i++ )
		{
			if(easternList.get(i).getNumber()<=0) {easternList.remove(i);i--;}
		}
		for(int i=0; i<southernList.size(); i++ ) 
		{
			if(southernList.get(i).getNumber()<=0) {southernList.remove(i);i--;}
		}
		for(int i=0; i<chinaList.size(); i++ )
		{
			if(chinaList.get(i).getNumber()<=0) {chinaList.remove(i);i--;}
		}
		
		List<TicketCustom> ticketList = new ArrayList<TicketCustom>();
		for(int i=0;i<easternList.size();i++) {
			easternList.get(i).setCompany("东方航空");
			ticketList.add(easternList.get(i));
		}
		for(int i=0;i<southernList.size();i++) {
			southernList.get(i).setCompany("南方航空");
			ticketList.add(southernList.get(i));
		}
		for(int i=0;i<chinaList.size();i++) {
			chinaList.get(i).setCompany("中国航空");
			ticketList.add(chinaList.get(i));
		}
		
		
		//排序
		for(int i =0;i < ticketList.size() - 1;i++)  
        {  
            for(int j = 0;j <  ticketList.size() - 1-i;j++)// j开始等于0，  
            {  
                if(ticketList.get(j).getPrice() > ticketList.get(j+1).getPrice())  
                {  
                    int temp = ticketList.get(j).getPrice(); 
                    int temp1 = ticketList.get(j+1).getPrice();
                    ticketList.get(j+1).setPrice(temp);
                    ticketList.get(j).setPrice(temp1);
                }  
            }  
        }
		int sequence = 1;
		ModelAndView modelandview = new ModelAndView();
		/*modelandview.addObject("ticketList",ticketList);*/
		session.setAttribute("sequence", sequence);
		session.setAttribute("ticketList", ticketList);
		modelandview.setViewName("choose");
		
		return modelandview;
	}
	
	@RequestMapping("/sequence.action")
	public ModelAndView sequence(HttpSession session) throws Exception {		
		
		List<TicketCustom> ticketList = (List<TicketCustom>) session.getAttribute("ticketList");
		int sequence = (Integer) session.getAttribute("sequence");
		if(sequence==1) {
			sequence = 0;
		}
		else {
			sequence = 1;
		}
		List<TicketCustom> ticketList1 = new ArrayList<TicketCustom>();
		for(int i = ticketList.size()-1;i>=0;i--) {
			ticketList1.add(ticketList.get(i));
		}
		ModelAndView modelandview = new ModelAndView();
		session.setAttribute("ticketList", ticketList1);
		modelandview.addObject("sequence",sequence);
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
	public ModelAndView buyticket(HttpSession session,String ticket_id,String number) throws Exception {		
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
		int money = Integer.valueOf(number)*ticketCustom.getPrice();				
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("ticketCustom",ticketCustom);
		modelandview.addObject("money",money);
		modelandview.setViewName("pay");
		String account_id = (String) session.getAttribute("account_id");
		if(account_id==null) {
			ModelAndView modelandview1 = new ModelAndView();
			modelandview1.addObject("ticketCustom",ticketCustom);
			modelandview1.addObject("money",money);
			String flag1 = "1";
			modelandview1.addObject("flag1",flag1);
			modelandview1.setViewName("ticketdetail");
			
			return modelandview1;
			
		}
		return modelandview;
	}
	
	@RequestMapping("/payticket.action")
	public ModelAndView payticket(HttpSession session,String ticket_id,String money,String payway,String paywayid) throws Exception {		
		
		TicketCustom ticketCustom = new TicketCustom();
		String flag = ticket_id.substring(0, 1);	
		OrderCustom orderCustom = new OrderCustom();
		int random =(int)(1+Math.random()*5000);
		String company = null;
		String ran = String.valueOf(random);
		String order_id = "ali" + ran;
		orderCustom.setOrder_id(order_id);
		orderCustom.setTicket_id(ticket_id);
		//减票
		if(flag.equals("e")) {
			company="东方航空";
			ticketCustom = client.findEasternTicketById(ticket_id);
			int number = Integer.valueOf(money)/(ticketCustom.getPrice());
			client.buyEasternTicketById(ticket_id, number);
		}
		else if(flag.equals("s")) {
			company="南方航空";
			ticketCustom = client.findSouthernTicketById(ticket_id);
			int number = Integer.valueOf(money)/(ticketCustom.getPrice());
			client.buySouthernTicketById(ticket_id, number);
		}
		else if(flag.equals("c")) {
			company="中国航空";
			ticketCustom = client.findChinaTicketById(ticket_id);
			int number = Integer.valueOf(money)/(ticketCustom.getPrice());
			client.buyChinaTicketById(ticket_id, number);
		}
		
		
		int number = Integer.valueOf(money)/(ticketCustom.getPrice());
        int money1 = Integer.valueOf(money);
		
		orderCustom.setStart(ticketCustom.getStart());
		orderCustom.setEnd(ticketCustom.getEnd());
		orderCustom.setPrice(ticketCustom.getPrice());
		orderCustom.setDay(ticketCustom.getDay());
		orderCustom.setTime(ticketCustom.getTime());
		orderCustom.setBuynumber(Integer.valueOf(number));
		orderCustom.setCompany(company);
		orderCustom.setMoney(money1); 
		String account_id = (String) session.getAttribute("account_id");
		orderCustom.setAccount_id(account_id);
		orderService.addOrder(orderCustom);
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
			session.setAttribute("account_id",accountCustom.getAccount_id());
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
		
		session.setAttribute("account_id",accountCustom.getAccount_id());
		session.setAttribute("flag", 1); 
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("signupsuccess");
		return modelandview;
		
	}
	
	@RequestMapping("/showorder.action")
	public ModelAndView showorder(HttpSession session, String password) throws Exception
	{
		String account_id = (String) session.getAttribute("account_id");
		List<OrderCustom> orderCustomList = orderService.getOrderByid(account_id);
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("orderCustomList",orderCustomList);	
		modelandview.setViewName("showorder");
		return modelandview;
	}
	
	
	@RequestMapping("/deleteorder.action")
	public ModelAndView orderdetail(String order_id) throws Exception
	{
		orderService.deleteOrderByid(order_id);
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("deletesuccess");
		return modelandview;
	}
	
/*@RequestMapping("/quit.action")
	public ModelAndView quit(HttpSession session) throws Exception
	{
		session.setAttribute("account_id",null);
		session.setAttribute("flag", 0); 
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("index");
		return modelandview;
	}*/
	




}
