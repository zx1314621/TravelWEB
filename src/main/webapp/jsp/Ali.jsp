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
  <script>

layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;	  
});	  
function func1() {
    //iframe层
    layer.open({
        type: 2,
        title: '',
        shadeClose: true,
        shade: 0.8,
        area: ['800px', '600px'],
        content: 'ShowAliOrder.jsp' //iframe的url
    });
}
function func2() {
    //iframe层
    layer.open({
        type: 2,
        title: '',
        shadeClose: true,
        shade: 0.8,
        area: ['800px', '600px'],
        content: 'ShowWechatOrder.jsp' //iframe的url
    });
}
function func3() {
    //iframe层
    layer.open({
        type: 2,
        title: '',
        shadeClose: true,
        shade: 0.8,
        area: ['800px', '600px'],
        content: 'addAliOrder.jsp' //iframe的url
    });
}
function func4() {
    //iframe层
    layer.open({
        type: 2,
        title: '',
        shadeClose: true,
        shade: 0.8,
        area: ['800px', '600px'],
        content: 'addWechatOrder.jsp' //iframe的url
    });
}
</script>           


<form class="layui-form"  id="chooseForm" action="GetAli.action" method="post">
 

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>支付宝</legend>
</fieldset>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">账户信息</button>
    </div>
  </div>
</form> 
<form class="layui-form"  id="chooseForm" action="manageAli.action" method="post">
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-primary" lay-submit="" lay-filter="demo1">立即查找</button>
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
      <th>订单编号</th>
      <th>机票编号</th>
      <th>航空公司</th>
      <th>订单价格</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
 <form action =editPaywayOrder.action method = "post">
<input type="hidden" name="payway" id="payway" value="支付宝">
<c:forEach var = "orderList" items = "${orderList}">

<tr>
    <td>${orderList.a_id }</td>
    <td>${orderList.fly_id }</td>
    <td>${orderList.company }</td>
    <td>${orderList.money }</td>
      <td>   <button class="layui-btn layui-btn-warm" name="add"  type="submit"  value="${orderList.a_id}"><i class="layui-icon">&#xe654;</i> 添加</button> 
      <button class="layui-btn layui-btn-normal layui-btn-mini news_del" id="edit" name="edit"  type="submit"  value="${orderList.a_id}"><i class="layui-icon">&#xe615;</i>编辑</button>
      <button class="layui-btn layui-btn-danger layui-btn-mini news_del" name="delete"    value="${orderList.a_id}"><i class="layui-icon">&#xe640;</i> 删除</button> </td>  
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
<% String flag = (String)request.getAttribute("flag");
    if(flag!=null&&flag.length()>0&&flag.equals("1"))
    	
    	{%>
     <script type="text/javascript">
                    window.onload=function(){
                    	func1(); }
     </script>
<%  
    session.setAttribute("flag",null);
    	}
%>
<% String flag2 = (String)request.getAttribute("flag2");
    if(flag2!=null&&flag2.length()>0&&flag2.equals("1"))
    	
    	{%>
     <script type="text/javascript">
                    window.onload=function(){
                    	func2(); }
     </script>
<%  
    session.setAttribute("flag2",null);
    	}
%>
<% String flag3 = (String)request.getAttribute("flag3");
    if(flag3!=null&&flag3.length()>0&&flag3.equals("1"))
    	
    	{%>
     <script type="text/javascript">
                    window.onload=function(){
                    	func3(); }
     </script>
<%  
    session.setAttribute("flag3",null);
    	}
%>
<% String flag4 = (String)request.getAttribute("flag4");
    if(flag4!=null&&flag4.length()>0&&flag4.equals("1"))
    	
    	{%>
     <script type="text/javascript">
                    window.onload=function(){
                    	func4(); }
     </script>
<%  
    session.setAttribute("flag4",null);
    	}
%>
</body>
</html>