package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import po.AccountCustom;
import po.TicketCustom;
import service.TicketService;

@Controller
@RequestMapping("/jsp")
public class LocalController {
	@Autowired
	public TicketService ticketService;
	
	@RequestMapping("/queryTicket.action")
	public ModelAndView queryTicket(HttpServletRequest request,String day,String start,String end) throws Exception {
		
		List<TicketCustom> easternList = ticketService.getTicketEastern();
		List<TicketCustom> southernList = ticketService.getTicketSouthern();
		List<TicketCustom> chinaList = ticketService.getTicketChina();
		for(int i=0; i<easternList.size(); i++ )
		{
			if(easternList.get(i).getDay().equals(day)&&easternList.get(i).getStart().equals(start)&&
					easternList.get(i).getEnd().equals(end)) {
				continue;
			}else {
				easternList.remove(i);
			}
		}
		for(int i=0; i<southernList.size(); i++ )
		{
			if(southernList.get(i).getDay().equals(day)&&southernList.get(i).getStart().equals(start)&&
					southernList.get(i).getEnd().equals(end)) {
				continue;
			}else {
				southernList.remove(i);
			}
		}
		for(int i=0; i<chinaList.size(); i++ )
		{
			if(chinaList.get(i).getDay().equals(day)&&chinaList.get(i).getStart().equals(start)&&
					chinaList.get(i).getEnd().equals(end)) {
				continue;
			}else {
				chinaList.remove(i);
			}
		}
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("easternList",easternList);
		modelandview.addObject("southernList",southernList);
		modelandview.addObject("chinaList",chinaList);
		
		modelandview.setViewName("showticket");
		
		return modelandview;
	}

}
