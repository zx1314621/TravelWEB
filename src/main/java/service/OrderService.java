package service;

import java.util.List;

import po.OrderCustom;

public interface OrderService {
	
	public void addOrder(OrderCustom orderCustom)throws Exception;
	
	public List<OrderCustom> getOrderByid(String account_id)throws Exception;
	
	public void deleteOrderByid(String order_id)throws Exception;

}
