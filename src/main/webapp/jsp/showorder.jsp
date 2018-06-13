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
      <th>出发地</th>
      <th>目的地</th>
      <th>价格</th>
      <th>出发日期</th>
      <th>出发时间</th>
      <th>购买数量</th>
      <th>航空公司</th>
      <th>价格</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
<form action = deleteorder.action  method = "post">
<c:forEach var = "orderCustomList" items = "${orderCustomList}">
<tr>
    <td>${orderCustomList.order_id }</td>
    <td>${orderCustomList.ticket_id }</td>
    <td>${orderCustomList.start }</td>
    <td>${orderCustomList.end }</td>
    <td>${orderCustomList.price }</td>
    <td>${orderCustomList.day }</td>
    <td>${orderCustomList.time }:00</td>
    <td>${orderCustomList.buynumber }</td>
    <td>${orderCustomList.company }</td>
    <td>${orderCustomList.money }</td>
      <td><button 	class="layui-btn layui-btn-danger" id="order_id" name="order_id"  type="submit"  value="${orderCustomList.order_id}"><i class="layui-icon">&#x1006;</i>删除订单</button></td>  
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