package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import po.Account;
import po.AccountCustom;
import service.AccountService;
import service.impl.AccountServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	public AccountService accountService;
	
	//账户查询
	@RequestMapping("/queryAccount.action")
	public ModelAndView queryStudents() throws Exception {
		
		List<AccountCustom> accountList = accountService.queryAccountList();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("accountList",accountList);
		
		modelandview.setViewName("index");
		
		return modelandview;
	}
	
	@RequestMapping("/editAccount.action")
	public ModelAndView editAccount(@RequestParam("id")String account_id) throws Exception{
		AccountCustom accountCustom = accountService.findAccountById(account_id);
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("accountCustom",accountCustom);
		
		modelandview.setViewName("account/editAccount");
		
		return modelandview;
		
		
	}
	@RequestMapping("/editAccountSubmit.action")
	public String editAccountSubmit(HttpServletRequest request,String account_id,AccountCustom accountCustom) throws Exception{
		
		accountService.updateAccountById(account_id, accountCustom);
			
		return "success";
		
		
	}
}
