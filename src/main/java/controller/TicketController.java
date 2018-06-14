package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import po.TicketCustom;
import service.TicketService;


@Controller
@RequestMapping("/jsp")
public class TicketController {
	
	@Autowired
	public TicketService ticketService;
	
	@RequestMapping("/manageEasternTicket.action")
	public ModelAndView manageEasternTicket() throws Exception {
		List<TicketCustom> easternList = ticketService.getTicketEastern();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("easternList",easternList);
		modelandview.setViewName("ManageTicket");
		return modelandview;
		
	}
	@RequestMapping("/manageSouthernTicket.action")
	public ModelAndView manageSouthernTicket() throws Exception {
		List<TicketCustom> easternList = ticketService.getTicketSouthern();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("easternList",easternList);
		modelandview.setViewName("ManageSouthernTicket");
		return modelandview;
		
	}
	@RequestMapping("/manageChinaTicket.action")
	public ModelAndView manageChinaTicket() throws Exception {						
		
		List<TicketCustom> easternList = ticketService.getTicketChina();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("easternList",easternList);
		modelandview.setViewName("ManageChinaTicket");
		return modelandview;
		
	}
	@RequestMapping("/searchTicket.action")
	public ModelAndView searchTicket(String company,String ticket_id,String start,String end) throws Exception {	
		
		List<TicketCustom> easternList = null;
		if(company.equals("东方航空"))
		{ easternList = ticketService.getTicketEastern();}
		else if(company.equals("南方航空")) {
		  easternList = ticketService.getTicketSouthern();
		}else if(company.equals("中国航空")) {
	      easternList = ticketService.getTicketChina();
		}
		ModelAndView modelandview = new ModelAndView();
		//如果编号 不为空返回该机票信息
		if(ticket_id!=null&&(ticket_id.equals("")==false)) {
		    for(int i=0; i<easternList.size(); i++) {
		    	if(easternList.get(i).getTicket_id().equals(ticket_id)) {
		    		continue;
		    	}else {
		    		easternList.remove(i);
		    		i--;
		    	}
		    }
		    if(company.equals("东方航空"))
			{modelandview.setViewName("ManageTicket"); }
			else if(company.equals("南方航空")) {
			modelandview.setViewName("ManageSouthernTicket");
			}else if(company.equals("中国航空")) {
			modelandview.setViewName("ManageChinaTicket");
			}
			modelandview.addObject("easternList",easternList);
			return modelandview;
		}
		if(start!=null&&(start.equals("")==false)) {
			for(int i=0; i<easternList.size(); i++) {
		    	if(easternList.get(i).getStart().equals(start)) {
		    		continue;
		    	}else {
		    		easternList.remove(i);
		    		i--;
		    	}
		    }
		}
		if(end!=null&&(end.equals("")==false)) {
			for(int i=0; i<easternList.size(); i++) {
		    	if(easternList.get(i).getEnd().equals(end)) {
		    		continue;
		    	}else {
		    		easternList.remove(i);
		    		i--;
		    	}
		    }
		}
		 if(company.equals("东方航空"))
			{modelandview.setViewName("ManageTicket"); }
			else if(company.equals("南方航空")) {
			modelandview.setViewName("ManageSouthernTicket");
			}else if(company.equals("中国航空")) {
			modelandview.setViewName("ManageChinaTicket");
			}
		modelandview.addObject("easternList",easternList);
		return modelandview;
	}

	@RequestMapping("/editTicket.action")
	public ModelAndView editTicket(HttpSession session,String ticket_id,String company) throws Exception {
		TicketCustom ticketCustom = null;
		ModelAndView modelandview = new ModelAndView();
		List<TicketCustom> easternList = null; 
		if(company.equals("东方航空"))
		{ticketCustom = ticketService.findEasternTicketById(ticket_id); 
		easternList = ticketService.getTicketEastern();
		 modelandview.setViewName("ManageTicket");}
		else if(company.equals("南方航空")) {
		 ticketCustom = ticketService.findSouthernTicketById(ticket_id);
		 easternList = ticketService.getTicketSouthern();
		 modelandview.setViewName("ManageSouthernTicket");
		}else if(company.equals("中国航空")) {
		 ticketCustom = ticketService.findChinaTicketById(ticket_id);
		 easternList = ticketService.getTicketChina();
		 modelandview.setViewName("ManageChinaTicket");
		}
		modelandview.addObject("flag1","1");
		modelandview.addObject("easternList",easternList);
		session.setAttribute("ticketCustom", ticketCustom);
		session.setAttribute("company", company);
		
		return modelandview;
		
	}
	

	@RequestMapping("/confirmEdit.action")
	public ModelAndView confirmEdit(String ticket_id,String company,String start,String end,String price,String day
			,String time,String number) throws Exception {
		TicketCustom ticketCustom = new TicketCustom();
		ticketCustom.setTicket_id(ticket_id);
		ticketCustom.setStart(start);
		ticketCustom.setEnd(end);
		ticketCustom.setPrice(Integer.valueOf(price));
		ticketCustom.setDay(day);
		String[] times = time.split(":");
		int time1 = Integer.valueOf(times[0]);
		ticketCustom.setTime(time1);
		ticketCustom.setNumber(Integer.valueOf(number));
		if(company.equals("东方航空"))
		{ ticketService.updateEasternTicketById(ticketCustom);}
		else if(company.equals("南方航空")) {
		  ticketService.updateSouthernTicketById(ticketCustom);
		}else if(company.equals("中国航空")) {
		  ticketService.updateChinaTicketById(ticketCustom);
		}
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("editsuccess");
		return modelandview;
		
	}
	

	@RequestMapping("/deleteTicket.action")
	public ModelAndView deleteTicket(String ticket_id,String company) throws Exception {
		
		if(company.equals("东方航空"))
		{ ticketService.deleteEasternTicket(ticket_id);}
		else if(company.equals("南方航空")) {
		ticketService.deleteSouthernTicket(ticket_id);
		}else if(company.equals("中国航空")) {
		ticketService.deleteChinaTicket(ticket_id);
		}
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("deletesuccess");
		return modelandview;
		
	}

}
