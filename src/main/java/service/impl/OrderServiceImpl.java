package service.impl;

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

}
