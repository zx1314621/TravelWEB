package mapper;

import po.AccountCustom;
import po.OrderCustom;
import po.PayAccount;

public interface PaywayMapperCustom {
	
	public void payalipay(OrderCustom orderCustom)throws Exception;
	
	public void paywechat(OrderCustom orderCustom)throws Exception;
	
	public PayAccount findAliPayAccountById(String payid)throws Exception;
	
	public PayAccount findWeChatAccountById(String payid)throws Exception;
	
	public void updateAliPayAccount(PayAccount payAccount)throws Exception;
	
	public void updateWeChatAccount(PayAccount payAccount)throws Exception;

}
