package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.AccountQueryVo;
import po.AccountCustom;

public interface AccountMapperCustom {
	//商品查询列表
	public List<AccountCustom> queryAccountList()throws Exception;
	
	public AccountCustom findAccountById(@Param("account_id")String account_id)throws Exception;

	public void updateAccountById(AccountCustom accountCustom)throws Exception;
}

