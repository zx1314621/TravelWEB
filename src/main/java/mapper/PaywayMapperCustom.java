package mapper;

import java.util.List;

import po.AccountCustom;
import po.AliOrder;
import po.OrderCustom;
import po.PayAccount;
import po.WechatOrder;

public interface PaywayMapperCustom {
	
	public void payalipay(OrderCustom orderCustom)throws Exception;
	
	public void paywechat(OrderCustom orderCustom)throws Exception;
	
	public PayAccount findAliPayAccountById(String payid)throws Exception;
	
	public PayAccount findWeChatAccountById(String payid)throws Exception;
	
    public AliOrder findAliPayOrderById(String a_id)throws Exception;
	
	public WechatOrder findWeChatOrderById(String w_id)throws Exception;
	
	public void updateAliPayAccount(PayAccount payAccount)throws Exception;
	
	public void updateWeChatAccount(PayAccount payAccount)throws Exception;
	
    public void updateAliPayOrder(AliOrder aliOrder)throws Exception;
	
	public void updateWeChatOrder(WechatOrder wechatOrder)throws Exception;
	
	public List<AliOrder> getAliPay()throws Exception;
	
	public List<WechatOrder> getWeChat()throws Exception;
	
    public List<PayAccount> getAliPayAccount()throws Exception;
	
	public List<PayAccount> getWeChatAccount()throws Exception;
	
    public void deleteWechatOrder(String payid)throws Exception;
	
	public void deleteAlipayOrder(String payid)throws Exception;
	
    public void deleteWechatAccount(String w_id)throws Exception;
	
	public void deleteAlipayAccount(String a_id)throws Exception;
	
    public void addAliOrder(AliOrder aliOrder)throws Exception;
	
	public void addWechatOrder(WechatOrder wechatOrder)throws Exception;
	
    public void addAliAccount(PayAccount payAccount)throws Exception;
	
	public void addWechatAccount(PayAccount payAccount)throws Exception;
	
	
	

}
