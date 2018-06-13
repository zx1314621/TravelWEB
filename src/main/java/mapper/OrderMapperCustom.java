package mapper;

import java.util.List;

import po.OrderCustom;

public interface OrderMapperCustom {
	
	public void addOrder(OrderCustom orderCustom)throws Exception;
	
	public List<OrderCustom> getOrderByid(String account_id)throws Exception;
	
	public void deleteOrderByid(String order_id)throws Exception;

}
