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
  <script src="layui/layui.all.js"></script>
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<form class="layui-form"  id="chooseForm" action="comfirmEditOrder.action" method="post">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>订单信息</legend>
</fieldset>
<input type="hidden" name="payway" id="payway" value="支付宝">
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">订单编号</label>
      <div class="layui-input-inline">
        <input type="text" name="a_id" lay-verify="required" autocomplete="off" value="${aliOrder.a_id}" class="layui-input" readonly>
      </div>
    </div>
  </div>
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">机票编号</label>
      <div class="layui-input-inline">
        <input type="text" name="fly_id" lay-verify="required" autocomplete="off" value="${aliOrder.fly_id }" class="layui-input" >
        
      </div>
    </div>
  </div>
    <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">航空公司</label>
      <div class="layui-input-inline">
        <input type="text" name="company" lay-verify="required" autocomplete="off" value="${aliOrder.company }" class="layui-input" >
        
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">订单价格</label>
      <div class="layui-input-inline">
        <input type="text" name="money" lay-verify="required" autocomplete="off" value="${aliOrder.money}" class="layui-input" >     
      </div>
    </div>
  </div>
      
 <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
    </div>
  </div>
</form> 
  


 

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