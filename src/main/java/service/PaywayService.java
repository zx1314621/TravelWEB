package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.ibatis.annotations.Param;

import po.AccountCustom;
import po.AliOrder;
import po.PayAccount;
import po.TicketCustom;
import po.WechatOrder;

@WebService
public interface PaywayService {
	
	@WebMethod
	public void addAlipaybao(@Param("ticketCustom")TicketCustom ticketCustom,@Param("money")int money)throws Exception;
	
	@WebMethod
	public void addWeChatbao(@Param("ticketCustom")TicketCustom ticketCustom,@Param("money")int money)throws Exception;

	@WebMethod
	public PayAccount getAlipayAccountById(@Param("payid")String payid)throws Exception;
	
	@WebMethod
	public PayAccount getWeChatAccountById(@Param("payid")String payid)throws Exception;
	
	@WebMethod
	public AliOrder findAliPayOrderById(String a_id)throws Exception;
		
	@WebMethod
    public WechatOrder findWeChatOrderById(String w_id)throws Exception;

	@WebMethod
	public void updateAlipayAccount(@Param("payaccount")PayAccount payaccount)throws Exception;
	
	@WebMethod
	public void updateWeChatAccount(@Param("payaccount")PayAccount payaccount)throws Exception;
	
	@WebMethod
    public void updateAliPayOrder(AliOrder aliOrder)throws Exception;
	
	@WebMethod
	public void updateWeChatOrder(WechatOrder wechatOrder)throws Exception;
	
	@WebMethod
    public List<AliOrder> getAliPayOrder()throws Exception;
	
	@WebMethod
	public List<WechatOrder> getWeChatOrder()throws Exception;
	
	@WebMethod
	public List<PayAccount> getAliPayAccount()throws Exception;
	
	@WebMethod
	public List<PayAccount> getWeChatAccount()throws Exception;
	
	@WebMethod
    public void deleteWechatOrder(String w_id)throws Exception;
	
	@WebMethod
	public void deleteAlipayOrder(String a_id)throws Exception;
	
	@WebMethod
    public void deleteWechatAccount(String payid)throws Exception;
	
	@WebMethod
	public void deleteAlipayAccount(String payid)throws Exception;
	
	@WebMethod
    public void addAliOrder(AliOrder aliOrder)throws Exception;
	
	@WebMethod
	public void addWechatOrder(WechatOrder wechatOrder)throws Exception;
	
	@WebMethod
    public void addAliAccount(PayAccount payAccount)throws Exception;
	
	@WebMethod
	public void addWechatAccount(PayAccount payAccount)throws Exception;
}
