package service;

import java.util.List;

import org.springframework.stereotype.Service;

import po.AccountCustom;
import po.AccountQueryVo;

public interface AccountService {

	//账户查询
	public List<AccountCustom> queryAccountList()throws Exception;

	public AccountCustom findAccountById(String account_id)throws Exception;
	
	public void updateAccountById(String account_id, AccountCustom accountCustom)throws Exception;

}
