package mapper;

import java.util.List;

import po.TicketCustom;;

public interface TicketMapperCustom {
	public List<TicketCustom> queryEasternTicket()throws Exception;
	public List<TicketCustom> queryChinaTicket()throws Exception;
	public List<TicketCustom> querySouthernTicket()throws Exception;
	

}
