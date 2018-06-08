package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.TicketCustom;
import service.TicketService;;  
  
public class Test {  
    public static void main(String[] args) throws Exception {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-service.xml");  
        TicketService client = (TicketService) ctx.getBean("client");  
        String result = client.sayHello("刘翔宇");  
        List<TicketCustom> ticketList = new ArrayList<TicketCustom>();
        ticketList = client.getTicketEastern();
        for(TicketCustom i : ticketList) {
        	System.out.println(i.getTicket_id()); 
        	System.out.println(i.getStart()); 
        	System.out.println(i.getEnd()); 
        	System.out.println(i.getPrice()); 
        	System.out.println(i.getDay()); 
        	System.out.println(i.getTime()); 
        	System.out.println(i.getNumber()); 
        }
        System.out.println(result);  
    }  
}  