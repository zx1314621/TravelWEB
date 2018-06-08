<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<html>
<body>
<h2>Hello World!</h2>
<table>
<tr>
    <td>飞机编号</td>
    <td>出发地</td>
    <td>目的地</td>
    <td>出发日期</td>
    <td>出发时间</td>
    <td>价格</td>
    <td>余票数</td>
</tr>

<c:forEach items="${easternList}" var = "easternList">
<tr>
    <td>${easternList.ticket_id }</td>
    <td>${easternList.start }</td>
    <td>${easternList.end }</td>
    <td>${easternList.day }</td>
    <td>${easternList.time }</td>
    <td>${easternList.price }</td>
    <td>${easternList.number }</td>
    <td><a href="${pageContext.request.contextPath }/account/editAccount.action?id=${easternList.ticket_id}">修改</a></td>
</tr>
</c:forEach> 

<c:forEach items="${southernList}" var = "southernList">
<tr>
    <td>${southernList.ticket_id }</td>
    <td>${southernList.start }</td>
    <td>${southernList.end }</td>
    <td>${southernList.day }</td>
    <td>${southernList.time }</td>
    <td>${southernList.price }</td>
    <td>${southernList.number }</td>
    <td><a href="${pageContext.request.contextPath }/account/editAccount.action?id=${southernList.ticket_id}">修改</a></td>
</tr>
</c:forEach> 
<c:forEach items="${chinaList}" var = "chinaList">
<tr>
    <td>${chinaList.ticket_id }</td>
    <td>${chinaList.start }</td>
    <td>${chinaList.end }</td>
    <td>${chinaList.day }</td>
    <td>${chinaList.time }</td>
    <td>${chinaList.price }</td>
    <td>${chinaList.number }</td>
    <td><a href="${pageContext.request.contextPath }/account/editAccount.action?id=${chinaList.ticket_id}">修改</a></td>
</tr>
</c:forEach> 
</table>
</body>
</html>
