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

function func4() {
    //iframe层
    layer.open({
        type: 2,
        title: '正在订票',
        shadeClose: true,
        shade: 0.8,
        area: ['800px', '600px'],
        content: 'editTicket.jsp' //iframe的url
    });
}
</script>           


<form class="layui-form"  id="chooseForm" action="searchTicket.action" method="post">
 

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>东方航空</legend>
</fieldset>
<input type="hidden" name="company" id="company" value="东方航空">
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">机票编号</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="ticket_id" name="ticket_id" placeholder="请输入机票编号">
      </div>
    </div>
   
    <div class="layui-inline">
      <label class="layui-form-label">出发地</label>
      <div class="layui-input-inline">
       <select id="start" name="start"  lay-search="">
          <option value="">出发地</option>
          <option value="上海">上海</option>
          <option value="重庆">重庆</option>
          <option value="西安">西安</option>
        </select>
      </div>
    </div>
   <div class="layui-inline">
      <label class="layui-form-label">目的地</label>
      <div class="layui-input-inline">
       <select id="end" name="end"  lay-search="">
          <option value="">目的地</option>
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
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
 <form action =editTicket.action method = "post">
<input type="hidden" name="company" id="company" value="东方航空">
<c:forEach var = "easternList" items = "${easternList}">

<tr>
    <td>${easternList.ticket_id }</td>
    <td>${easternList.start }</td>
    <td>${easternList.end }</td>
    <td>${easternList.day }</td>
    <td>${easternList.time }:00</td>
    <td>${easternList.price }</td>
    <td>${easternList.number }</td>
      <td><button class="layui-btn layui-btn-normal layui-btn-mini news_del" id="ticket_id" name="ticket_id"  type="submit"  value="${easternList.ticket_id}"><i class="layui-icon">&#xe615;</i>编辑</button>
      <button class="layui-btn layui-btn-danger layui-btn-mini news_del" name="delete"  type="submit"  value="${s.getRoom_id()}"><i class="layui-icon">&#xe640;</i> 删除</button> </td>  </td>  
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
<% String flag1 = (String)request.getAttribute("flag1");
if(flag1!=null&&flag1.length()>0&&flag1.equals("1"))
	
	{%>
 <script type="text/javascript">
                window.onload=function(){
                	func4(); }
 </script>
<%  
session.setAttribute("flag1",null);
	}
%>
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