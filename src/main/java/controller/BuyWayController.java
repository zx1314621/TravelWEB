package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import po.AccountCustom;
import po.AliOrder;
import po.PayAccount;
import po.WechatOrder;
import service.PaywayService;

@Controller
@RequestMapping("/jsp")
public class BuyWayController {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-service.xml");
	PaywayService paywaySercie = (PaywayService) ctx.getBean("payway");
	
	
	@RequestMapping("/manageAli.action")
	public ModelAndView manageAli() throws Exception {
		List<AliOrder> orderList = paywaySercie.getAliPayOrder();			
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("orderList",orderList);
		modelandview.setViewName("Ali");	
		return modelandview;
		
	}
	@RequestMapping("/manageWechat.action")
	public ModelAndView manageWechat() throws Exception {
		List<WechatOrder> orderList = paywaySercie.getWeChatOrder();			
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("orderList",orderList);
		modelandview.setViewName("Wechat");	
		return modelandview;
		
	}
	
	@RequestMapping("/GetAli.action")
	public ModelAndView GetAli() throws Exception {
		List<PayAccount> accountist = paywaySercie.getAliPayAccount();			
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("accountist",accountist);
		modelandview.setViewName("AliAccount");	
		return modelandview;
		
	}
	@RequestMapping("/GetWechat.action")
	public ModelAndView GetWechat() throws Exception {
		List<PayAccount> accountist = paywaySercie.getWeChatAccount();			
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("accountist",accountist);
		modelandview.setViewName("WechatAccount");	
		return modelandview;
		
	}
	
	@RequestMapping("/editPaywayAccount.action")
	public ModelAndView editPaywayAccount(HttpSession session,String add,String edit,String delete,String payway) throws Exception {
		if(add!=null) {
			if(payway.equals("支付宝")) {
				ModelAndView modelandview = new ModelAndView();
				List<PayAccount> accountist = paywaySercie.getAliPayAccount();
				modelandview.addObject("accountist",accountist);
				modelandview.addObject("flag3","1");
				modelandview.setViewName("AliAccount");	
				return modelandview;
				
			}else if(payway.equals("微信")) {
				ModelAndView modelandview = new ModelAndView();
				List<PayAccount> accountist = paywaySercie.getAliPayAccount();	
				modelandview.addObject("accountist",accountist);
				modelandview.addObject("flag4","1");
				modelandview.setViewName("AliAccount");	
				return modelandview;
			}
			
		}else if(edit!=null) {
			if(payway.equals("支付宝")) {
				PayAccount aliOrder = paywaySercie.getAlipayAccountById(edit);
				ModelAndView modelandview = new ModelAndView();
				session.setAttribute("aliOrder", aliOrder);
				List<PayAccount> accountist = paywaySercie.getAliPayAccount();
				modelandview.addObject("accountist",accountist);
				modelandview.addObject("flag","1");
				modelandview.setViewName("AliAccount");	
				return modelandview;
			}else if(payway.equals("微信")) {
				PayAccount wechatOrder = paywaySercie.getWeChatAccountById(edit);
				ModelAndView modelandview = new ModelAndView();
                session.setAttribute("wechatOrder", wechatOrder);
                List<PayAccount> accountist = paywaySercie.getAliPayAccount();
				modelandview.addObject("accountist",accountist);
				modelandview.addObject("flag2","1");
				modelandview.setViewName("AliAccount");	
				return modelandview;
			}
			
		}else if(delete!=null) {
			if(payway.equals("支付宝")) {
				paywaySercie.deleteAlipayAccount(delete);
			}else if(payway.equals("微信")) {
				paywaySercie.deleteWechatOrder(delete);
			}
		}
		
		List<PayAccount> accountist = paywaySercie.getAliPayAccount();			
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("accountist",accountist);
		modelandview.setViewName("AliAccount");	
		return modelandview;
		
	}
	
	@RequestMapping("/addAliAccount.action")
	public ModelAndView addAliAccount(String payway,String payid,int balance) throws Exception {
		ModelAndView modelandview = new ModelAndView();
		PayAccount payAccount = new PayAccount();
		payAccount.setBalance(balance);
		payAccount.setPayid(payid);
		if(payway.equals("支付宝")) {
			paywaySercie.addAliAccount(payAccount);	
			modelandview.setViewName("addsuccess");
		}else if(payway.equals("微信")){
			paywaySercie.addWechatAccount(payAccount);
			modelandview.setViewName("addsuccess");
		}
		
		return modelandview;
		
	}
	@RequestMapping("/addAliOrder.action")
	public ModelAndView addAliOrder(String payway,String a_id,String w_id,String fly_id,String company,int money) throws Exception {
		ModelAndView modelandview = new ModelAndView();
		if(payway.equals("支付宝")) {
			AliOrder aliOrder = new AliOrder();
			aliOrder.setA_id(a_id);
			aliOrder.setFly_id(fly_id);
			aliOrder.setCompany(company);
			aliOrder.setMoney(money);
			paywaySercie.addAliOrder(aliOrder);		
			modelandview.setViewName("addsuccess");
		}else if(payway.equals("微信")){
			WechatOrder wechatOrder = new WechatOrder();
			wechatOrder.setW_id(w_id);
			wechatOrder.setFly_id(fly_id);
			wechatOrder.setCompany(company);
			wechatOrder.setMoney(money);
			paywaySercie.addWechatOrder(wechatOrder);
			modelandview.setViewName("addsuccess");		
		}
		
		return modelandview;
		
	}
	
	@RequestMapping("/editPaywayOrder.action")
	public ModelAndView editPaywayOrder(HttpSession session,String add,String edit,String delete,String payway) throws Exception {
		if(add!=null) {
			if(payway.equals("支付宝")) {
				ModelAndView modelandview = new ModelAndView();
				List<AliOrder> orderList = paywaySercie.getAliPayOrder();	
				modelandview.addObject("orderList",orderList);
				modelandview.addObject("flag3","1");
				modelandview.setViewName("Ali");	
				return modelandview;
				
			}else if(payway.equals("微信")) {
				ModelAndView modelandview = new ModelAndView();
                List<AliOrder> orderList = paywaySercie.getAliPayOrder();	
				modelandview.addObject("orderList",orderList);
				modelandview.addObject("flag4","1");
				modelandview.setViewName("Ali");	
				return modelandview;
			}
			
		}else if(edit!=null) {
			if(payway.equals("支付宝")) {
				AliOrder aliOrder = paywaySercie.findAliPayOrderById(edit);
				ModelAndView modelandview = new ModelAndView();
				session.setAttribute("aliOrder", aliOrder);
				List<AliOrder> orderList = paywaySercie.getAliPayOrder();	
				modelandview.addObject("orderList",orderList);
				modelandview.addObject("flag","1");
				modelandview.setViewName("Ali");	
				return modelandview;
			}else if(payway.equals("微信")) {
				WechatOrder wechatOrder = paywaySercie.findWeChatOrderById(edit);
				ModelAndView modelandview = new ModelAndView();
                session.setAttribute("wechatOrder", wechatOrder);
                List<AliOrder> orderList = paywaySercie.getAliPayOrder();	
				modelandview.addObject("orderList",orderList);
				modelandview.addObject("flag2","1");
				modelandview.setViewName("Ali");	
				return modelandview;
			}
			
		}else if(delete!=null) {
			if(payway.equals("支付宝")) {
				paywaySercie.deleteAlipayOrder(delete);
			}else if(payway.equals("微信")) {
				paywaySercie.deleteWechatOrder(delete);
			}
		}
		
		List<AliOrder> orderList = paywaySercie.getAliPayOrder();			
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("orderList",orderList);
		modelandview.setViewName("Ali");	
		return modelandview;
		
	}
	
	@RequestMapping("/comfirmEditAccount.action")
	public ModelAndView comfirmEditAccount(String payway,String payid,int balance) throws Exception {
		
		PayAccount payaccount = new PayAccount();
		payaccount.setPayid(payid);
		payaccount.setBalance(balance);
		ModelAndView modelandview = new ModelAndView();
		if(payway.equals("支付宝")) {
			
			paywaySercie.updateAlipayAccount(payaccount);		
			modelandview.setViewName("editsuccess");
		}else if(payway.equals("微信")){
			
			paywaySercie.updateWeChatAccount(payaccount);
			modelandview.setViewName("editsuccess");		
		}
		
		return modelandview;
		
	}
	
	@RequestMapping("/comfirmEditOrder.action")
	public ModelAndView comfirmEditOrder(String payway,String a_id,String w_id,String fly_id,String company,int money) throws Exception {
		
		ModelAndView modelandview = new ModelAndView();
		if(payway.equals("支付宝")) {
			AliOrder aliOrder = new AliOrder();
			aliOrder.setA_id(a_id);
			aliOrder.setFly_id(fly_id);
			aliOrder.setCompany(company);
			aliOrder.setMoney(money);
			paywaySercie.updateAliPayOrder(aliOrder);		
			modelandview.setViewName("editsuccess");
		}else if(payway.equals("微信")){
			WechatOrder wechatOrder = new WechatOrder();
			wechatOrder.setW_id(w_id);
			wechatOrder.setFly_id(fly_id);
			wechatOrder.setCompany(company);
			wechatOrder.setMoney(money);
			paywaySercie.updateWeChatOrder(wechatOrder);
			modelandview.setViewName("editsuccess");		
		}
		
		return modelandview;
		
	}
	
}
