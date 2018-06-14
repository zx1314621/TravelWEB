package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.TicketCustom;;

public interface TicketMapperCustom {
	
	//查出所有票
	public List<TicketCustom> queryEasternTicket()throws Exception;
	public List<TicketCustom> queryChinaTicket()throws Exception;
	public List<TicketCustom> querySouthernTicket()throws Exception;
	
	//根据id查票
	public TicketCustom findEasternTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	public TicketCustom findSouthernTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	public TicketCustom findChinaTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	
	//买一张票
	public void buyEasternTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	public void buySouthernTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	public void buyChinaTicketById(@Param("ticket_id")String ticket_id)throws Exception;
	
	//更新数据库的票
	public void updateEasternTicketById(TicketCustom ticketCustom)throws Exception;
	public void updateSouthernTicketById(TicketCustom ticketCustom)throws Exception;
	public void updateChinaTicketById(TicketCustom ticketCustom)throws Exception;
	
	//删除票
	public void deleteEasternTicket(@Param("ticket_id")String ticket_id)throws Exception;
	public void deleteSouthernTicket(@Param("ticket_id")String ticket_id)throws Exception;
	public void deleteChinaTicket(@Param("ticket_id")String ticket_id)throws Exception;
	
}
