<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户消息</title>
</head>
<body>
<font size="5" >账户信息</font><br/>
<form id="accountForm" action="editAccountSubmit.action" method="post" >
<input type="hidden" id="password" name="password" value="${accountCustom.password }"/>
<table>
<tr>
<td><font size="3" >账户</font></td>
<td><input type="text" id="account_id" name="account_id" value="${accountCustom.account_id}" /></td>
</tr>
<!-- <tr>
<td><font size="3" >密码</font></td>
<td><input type="text" name="password" value=${accountCustom.password} /></td>
</tr> -->
<tr>
<td><font size="3" >余额</font></td>
<td><input type="text" id="balance" name="balance" value="${accountCustom.balance}" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</tr>
</table>
</form>
</body>
</html>