package mapper;

import po.AccountCustom;
import po.OrderCustom;

public interface PaywayMapperCustom {
	
	public void payalipay(OrderCustom orderCustom)throws Exception;
	
	public void paywechat(OrderCustom orderCustom)throws Exception;

}
