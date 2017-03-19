<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<meta charset="utf-8"> 
	<title>添加信息</title>
	<link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.static.runoob.com/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- 引入Validate插件验证信息合法性 -->
	<!-- script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script -->
	<script type="text/javascript">
	$(document).ready(function(){
    	$(".form-horizontal").css({
    	"left":"500px",
    	"top":"100px",
    	"position":"absolute"});
    	
    	$("#back").css({
    	"left":"100px",
    	"top":"30px",
    	"position":"absolute"});
	});
	
</script>
</head>
<body>
				 <button id="back" type="button" class="btn btn-lg btn-primary" onclick="window.location.href='../users/Users_login_success.jsp'">返回主菜单</button>
					<form class="form-horizontal" method="post">
						<div class="control-group">
							    <label class="control-label" for="sid">学号:</label>
								<input id="sid" name="sid" type="text" />
								
							
						</div><br>
						<div class="control-group">
							 <label class="control-label" for="sname">姓名:</label>
							
								<input id="sname" name="sname" type="text" />
							
						</div><br>
						<div class="control-group">
							 <label class="control-label" for="gender">性别:</label>
							
								<input id="gender" name="gender" type="text" />
							
						</div><br>
						<div class="control-group">
							 <label class="control-label" for="birthday">生日:</label>
							
								<input id="birthday" name="birthday" type="text" />
							
						</div><br>
						<div class="control-group">
							 <label class="control-label" for="address">地址:</label>
							
								<input id="address" name="address" type="text" />
							
						</div><br>
						
						<div class="control-group">
						
							<div class="controls">
								 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button id="add_students" type="submit" class="btn btn-sm btn-info">提交</button>
							</div>
						</div>
					</form>
	<script type="text/javascript">
		//| 日期有效性验证 
		//| 格式为：YYYY-MM-DD或YYYY/MM/DD   
		function IsValidDate(DateStr){ 
    	
        	var result = DateStr.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        	if(result==null) {
            	return false;
        	}
        	return true;
		} 
	</script>
 	<script type="text/javascript">
    	$("#add_students").on("click",function(event) {
    		//event.preventDefault();
    		var sid = $("#sid").val();
    		var sname = $("#sname").val();
    		var gender = $("#gender").val();
    		var birthday = $("#birthday").val();
    		var address = $("#address").val();
    		
    		
    		if(sid == "" || sname == "" || gender== "" ||
    		birthday == "" || address == ""){
    			alert("请输入完整信息!");
    			return false;
    		}
    		if(IsValidDate(birthday)==false) {
    			alert("请输入正确的日期格式");
    			return false;
    		}
    		//提交表单
    		$.ajax({
    			type:"POST",
    			url:"addAction.action",
    			anync:true,
    			data:{"sid":sid,"sname":sname,"gender":gender,"birthday":birthday,"address":address},
    			dataType: "json", 
    			contentType:"application/x-www-form-urlencoded"
    			
    		});
    		alert("添加成功~!");	
    	});
    </script>
    

</body>
</html>