<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
	
    <title>后台管理系统</title>

 	
    
    
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 模板css或者自己的css -->
    <link href="dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]> 
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
  					<!-- 导航栏 -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">学生管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
           
            <li><a href="Users_login.jsp">退出</a></li>
            
           
          </ul>
          
          <!-- 实现搜索功能  
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
          -->
          
        </div>
      </div>
    </nav>
	<!-- 列导航 -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="#" id="query_all">学生列表</a></li>
            <li><a href="../students/add_students.jsp" id="add_students">添加学生</a></li>
            <li><a href="http://www.sdut.edu.cn/">学校概况</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="#">友情链接</a></li>
            <li><a href="http://www.ayyll.com">个人博客</a></li>
            <li><a href="http://blog.csdn.net/qq_16255321">csdn</a></li>
            <li><a href="https://github.com/ayyll">github</a></li>
            <li><a href="https://www.v2ex.com/">v2EX</a></li>
          </ul>
          <!--  
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
          -->
        </div>
        <div id="page" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        	<div class="table-responsive">
            <table id="query_table" class="table table-striped">
            	<thead id="query_table_head"></thead>
            	<tbody id="query_table_body"></tbody>
            </table>
             
        </div>
      </div>
      </div>

    <!-- Bootstrap core JavaScript  CDN引入bootstrap
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="bootstrap-paginator.js"></script>
    
    <!-- 引入 粒子特效js -->
    <script type="text/javascript" src="particle.js"></script>
    <canvas id="c_n27" width="449" height="690" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;"></canvas>
    
    <!-- ajax请求学生列表 -->
    <script type="text/javascript">
    	$("#query_all").on("click",function(event){
    	 //使a自带的方法失效，即无法调整到href中的URL
   		 event.preventDefault();
	    	$.ajax({
	           type:"GET",
	           anync:true,
	           url:"queryAction.action",
	           //contentType:"application/json",
	           dataType:"json",
	           success: function(result){
	              //请求正确之后的操作
	              
	              //console.log(result);
	              //伪分页
	             /*var options = {
            		currentPage: 1,
           	 		totalPages: 2,
        			numberOfPages:3
        		 };*/
        		 //$("#page").bootstrapPaginator(options);
	             $("#query_table_head").empty();
	             $("#query_table_body").empty();
	             //插入表头
	             $("#query_table_head").append("<tr><th>学号</th><th>姓名</th><th>性别</th><th>生日</th><th>地址</th><th> </th></tr>");
	             for(key in result) {
	               
	                $("#query_table_body").append("<tr><th>" + result[key].sid + "</th><th>" + result[key].sname + "</th><th>" + result[key].gender +"</th><th>" + result[key].birthday + "</th><th>" + result[key].address + "</th><th><button type='button' class='btn btn-sm btn-danger' onClick='delete_students(this)'>删除</button></th></tr>");

	             }
	            
	           },
	           error: function(result){
	              //请求失败之后的操作
	              alert("服务器没有返回数据，可能服务器忙，请重试");  
	           }
	    	});
		});
    </script>	
    <!-- 删除请求 -->
    <script type="text/javascript">
    	function delete_students(obj) {
    		var res = confirm('确认要删除吗？');
    		if(res == true) {
    			$(obj).parents("tr").remove();
    			//alert($(obj).parents("tr").children().eq(0).html());
    			$.ajax({
    				type:"POST",
    				url:"deleteAction.action",
    				anync:true,
    				data:{"sid":$(obj).parents("tr").children().eq(0).html()}
    				//发送数据的类型,可以不写此项
    				//contentType:"application/x-www-form-urlencoded"
    			});
    		}
    	}
    </script>  
    
   
    </body>
</html>