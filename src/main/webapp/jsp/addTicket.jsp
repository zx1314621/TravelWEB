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

<form class="layui-form"  id="chooseForm" action="confirmAdd.action" method="post">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>机票信息</legend>
</fieldset>
<input type="hidden" name="company" id="company" value="${company}">
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">机票编号</label>
      <div class="layui-input-inline">
        <input type="text" name="ticket_id" lay-verify="required" autocomplete="off" placeholder="机票编号" class="layui-input" >
      </div>
    </div>
  </div>
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">出发地</label>
      <div class="layui-input-inline">
        <input type="text" name="start" lay-verify="required" autocomplete="off" placeholder="出发地" class="layui-input" >
        
      </div>
    </div>
  </div>
    <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">目的地</label>
      <div class="layui-input-inline">
        <input type="text" name="end" lay-verify="required" autocomplete="off" placeholder="目的地" class="layui-input" >
        
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">价格</label>
      <div class="layui-input-inline">
        <input type="text" name="price" lay-verify="required" autocomplete="off" placeholder="价格" class="layui-input" >     
      </div>
    </div>
  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">出发日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="day" name="day" placeholder="出发日期">
        
      </div>
    </div>
  </div>
   <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">起飞时间</label>
      <div class="layui-input-inline">
        <input type="text" name="time" lay-verify="required" autocomplete="off" placeholder="起飞时间" class="layui-input" >     
      </div>
    </div>
  </div> 
  <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">余量</label>
      <div class="layui-input-inline">
        <input type="text" name="number" lay-verify="required" autocomplete="off" placeholder="余量" class="layui-input" >     
      </div>
    </div>
  </div>     
 
 <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">确认</button>
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