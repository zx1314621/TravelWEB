<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
            

 <%@page import="java.util.Date"%>
 <%@page import="java.text.SimpleDateFormat"%>  
  
 <%
 SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
 String date = df.format(new Date());
 %>

<form class="layui-form"  id="chooseForm" action="queryTicket.action" method="post">
 

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>基本信息</legend>
</fieldset>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">出发日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="day" name="day" value="<%=date %>">
      </div>
    </div>
  </div>
   
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">出发地</label>
      <div class="layui-input-inline">
       <select id="start" name="start" lay-verify="required" lay-search="">
          <option value="出发地">出发地</option>
          <option value="上海">上海</option>
          <option value="重庆">重庆</option>
          <option value="西安">西安</option>
        </select>
      </div>
    </div>
    </div>
<div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">目的地</label>
      <div class="layui-input-inline">
       <select id="end" name="end" lay-verify="required" lay-search="">
          <option value="目的地">目的地</option>
          <option value="上海">上海</option>
          <option value="重庆">重庆</option>
          <option value="西安">西安</option>
        </select>
      </div>
    </div>
</div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form> 

 <table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>机票编号</th>
      <th>出发地</th>
      <th>目的地</th>
      <th>出发日期</th>
      <th>出发时间</th>
      <th>价格</th>
      <th>余票数</th>
      <th>航空公司</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  <form action =showticket.action method = "post">

<c:forEach var = "easternList" items = "${easternList}">

<tr>
    <td>${easternList.ticket_id }</td>
    <td>${easternList.start }</td>
    <td>${easternList.end }</td>
    <td>${easternList.day }</td>
    <td>${easternList.time }:00</td>
    <td>${easternList.price }</td>
    <td>${easternList.number }</td>
    <td>东方航空</td>
      <td><button class="layui-btn layui-btn-normal layui-btn-mini news_del" id="ticket_id" name="ticket_id"  type="submit"  value="${easternList.ticket_id}"><i class="layui-icon">&#xe615;</i> 购买</button></td>  
</tr>
</c:forEach>
<form class="layui-form" action =HandleOrderManager method = "post">
<c:forEach var = "southernList" items = "${southernList}">

<tr>
    <td>${southernList.ticket_id }</td>
    <td>${southernList.start }</td>
    <td>${southernList.end }</td>
    <td>${southernList.day }</td>
    <td>${southernList.time }:00</td>
    <td>${southernList.price }</td>
    <td>${southernList.number }</td>
    <td>南方航空</td>
      <td><button class="layui-btn layui-btn-danger layui-btn-mini news_del" id="ticket_id" name="ticket_id"  type="submit"  value="${southernList.ticket_id}"><i class="layui-icon">&#xe615;</i> 购买</button></td>
</c:forEach>
<c:forEach var = "chinaList" items = "${chinaList}">

<tr>
    <td>${chinaList.ticket_id }</td>
    <td>${chinaList.start }</td>
    <td>${chinaList.end }</td>
    <td>${chinaList.day }</td>
    <td>${chinaList.time }:00</td>
    <td>${chinaList.price }</td>
    <td>${chinaList.number }</td>
    <td>中国航空</td>
      <td><button class="layui-btn layui-btn-warm" id="ticket_id" name="ticket_id"  type="submit"  value="${chinaList.ticket_id}"><i class="layui-icon">&#xe615;</i> 购买</button></td>  
</tr>
</c:forEach>
</form>
  </tbody>
</table>   

 

          



          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        var day = laydate.render({
            elem: '#day'
            ,format: 'yyyy/MM/dd'
            ,min: 0
        });
    });

</script>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>