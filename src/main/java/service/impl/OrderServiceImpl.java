package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.OrderMapperCustom;
import po.OrderCustom;
import service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapperCustom orderMapperCustom;
	
	public void addOrder(OrderCustom orderCustom) throws Exception {
		// TODO Auto-generated method stub
		orderMapperCustom.addOrder(orderCustom);
	}

	public List<OrderCustom> getOrderByid(String account_id) throws Exception {
		// TODO Auto-generated method stub
		return orderMapperCustom.getOrderByid(account_id);
	}

	public void deleteOrderByid(String order_id) throws Exception {
		// TODO Auto-generated method stub
		orderMapperCustom.deleteOrderByid(order_id);
		
	}

}
