<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
       $(function () { $("[data-toggle='tooltip']").tooltip(); });
    </script>
  </head>
  
  <body>
     <div class="container">
     <div style="padding: 100px 100px 10px;">
     <form action="user/addUser.html" method="post" class="form-horizontal" role="form">
           <div class="form-group">
		       <label class="col-sm-2 control-label">编号:</label>
		       <div class="col-sm-10">
		        <input type="text" data-toggle="tooltip" data-placement="left" title="编号" name="userId" class="form-control"/> 
		       </div> 
		   </div>
		   <div class="form-group">
		       <label class="col-sm-2 control-label">姓名:</label>
		       <div class="col-sm-10">
		        <input type="text" data-toggle="tooltip" data-placement="left" title="姓名" name="userName" class="form-control"/>
		       </div> 
		   </div>   
		   <div class="form-group">
		       <label class="col-sm-2 control-label">电话:</label>
		       <div class="col-sm-10">
		        <input type="text" data-toggle="tooltip" data-placement="left" title="电话" name="userPhone" class="form-control"/>
		       </div>
		   </div>   
		   <div class="form-group">     
		       <label class="col-sm-2 control-label">积分:</label>
		       <div class="col-sm-10">
		        <input type="text" data-toggle="tooltip" data-placement="left" title="积分" name="score" class="form-control"/>
		       </div> 
		   </div> 
		   <div class="form-group">  
		    <div class="col-sm-offset-2 col-sm-10">
	         <input type="submit"  class="btn btn-default">
	        </div>
           </div>
     </form>
     </div>
   </div>  
  </body>
</html>
