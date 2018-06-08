package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.AccountCustom;
import po.AccountQueryVo;
import service.AccountService;
import mapper.AccountMapperCustom;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapperCustom accountMapperCustom;

	public List<AccountCustom> queryAccountList() throws Exception {
		// TODO Auto-generated method stub
		return accountMapperCustom.queryAccountList();
	}

	public AccountCustom findAccountById(String account_id) throws Exception {
		// TODO Auto-generated method stub
		return accountMapperCustom.findAccountById(account_id);
	}

	public void updateAccountById(String account_id, AccountCustom accountCustom) throws Exception {
		// TODO Auto-generated method stub
		if(account_id!=null) {
			accountCustom.setAccount_id(account_id);
			accountMapperCustom.updateAccountById(accountCustom);
		}
	}
}
