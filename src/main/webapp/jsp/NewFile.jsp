<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "[图片]http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="layui/css/layui.css"  media="all">
<title>医生查看病人页面</title>
</head>
<body>

<div class="layui-row">
<div class="layui-col-xs3">
<div class="grid-demo grid-demo-bg1">
</div></div>
<div class="layui-col-xs3">
<div class="grid-demo grid-demo-bg1">
</div></div>
<!-- <div class="layui-col-xs3">
<div class="grid-demo grid-demo-bg1"><select name="city" lay-verify="">
  <option value=""></option>
  <option value=""></option>
  <option value=""></option>
</select></div>
 </div> -->
<form class="layui-form"  id="" action="" method="post">
 <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label"></label>
      <div class="layui-input-inline">
       <select id="start" name="start" lay-verify="required" lay-search="">
          <option value="下拉选择">下拉选择</option>
          <option value="010">已经做过手术</option>
          <option value="021">还未做过手术</option>
        </select>
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label"></label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="day" name="day" value="">
      </div>
    </div>
    
 
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>

    </div>
    
    
</form>
 
 

</div>

<table class="layui-hide" id="test"></table>
              
        
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
 
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#test'
    ,url:'/demo/table/user/'
    ,cellMinWidth: 80 
    ,cols: [[
      {field:'id', width:80, title: 'ID', sort: true}
      ,{field:'username', width:80, title: '姓名'}
      ,{field:'sex', width:80, title: '是否进行过手术', sort: true}
      ,{field:'city', width:80, title: '<button class="layui-btn layui-btn-primar">查看</button>'}
    
    ]]
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
