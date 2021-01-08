<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript">
	   	$(function(){ 
	        if("${user.type}"==1){
	        	document.getElementById("userType").innerHTML="管理员"; 
	        	document.getElementById("ulMenu").innerHTML= "<li><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li> <li><a href='<%=path %>/user/userInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-mail'></i>用户管理 </a></li> <li class='active'><a href='<%=path %>/photos/photoInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>摄影作品 </a></li>"; 
				
	        }
	        else{
	        	document.getElementById("userType").innerHTML="普通用户";
	        	document.getElementById("ulMenu").innerHTML= "<li><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li class='active'><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li>";
	        	document.getElementById("addButton").style.display="none";
	        	document.getElementById("updateBut").style.display="none";
	        	document.getElementById("deleteBut").style.display="none";
	        	
	        }
	   	});	
	   	//类型查询
		function selectByType(){
			var photoType = $("#photoType").val();
			$.ajax({
				type : "post",
				data : {"photoType" : photoType},
				url : "<%=path %>/photos/selectByPhototype.action",
				dataType : "json",
				error : function(err) {
					alert(err.code);
				},
				//success : ajaxSendCallBackinfo
			})
		};
   	</script>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="<%=path %>/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="<%=path %>/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="<%=path %>/css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="<%=path %>/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="<%=path %>/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="<%=path %>/img/favicon.ico">
    <!-- 分页样式 -->
    <link rel="stylesheet" href="<%=path %>/css/page.css" type="text/css" />
    <!-- layuicss样式 -->
    <link rel="stylesheet" href="<%=path %>/lib/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path %>/css/admin.css" media="all">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body class="stylebody">
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="<%=path %>/index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><span>Bootstrap </span><strong>Dashboard</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- 查询模块-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li>
                <!-- 通知列表-->
                <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell-o"></i></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>暂无通知</strong></a></li>
                  </ul>
                </li>
                <!--信息列表                        -->
                <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>暂无信息</strong></a></li>
                  </ul>
                </li>
                <!-- Languages dropdown语言选择框    -->
                <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle">
                <img src="<%=path %>/img/flags/16/CN.png" alt="China"><span class="d-none d-sm-inline-block">China</span></a>
                  <ul aria-labelledby="languages" class="dropdown-menu">
				  </ul>
                </li>
                <!-- 注销    -->
                <li class="nav-item"><a href="<%=path %>/user/outLogin.action" class="nav-link logout"> <span class="d-none d-sm-inline">注销</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- 边栏标题-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><a href="<%=path %>/user/information.action?userId=${user.id}"><img src="/userImg/${user.img }" alt="..." class="img-fluid rounded-circle"></a></div>
            <div class="title">
              <a href="<%=path %>/user/information.action?userId=${user.id}"><h1 class="h4">${user.username }</h1>
              <p id="userType"></p></a>
            </div>
          </div>
          <!-- 边栏导航菜单--><span class="heading">菜单</span>
          <ul class="list-unstyled" id="ulMenu">
          </ul><span class="heading">Extras</span>    
        </nav>
        <div class="content-inner">
          <!-- Page Header-->
          <header class="page-header">
            <div id="time" class="container-fluid">
	    		<script>
	        	document.getElementById('time').innerHTML = new Date().toLocaleString()+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
	        	setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
	    		</script>
            </div>
          </header>
          <!-- Breadcrumb-->
          <div class="breadcrumb-holder container-fluid">
            <ul class="breadcrumb">
              <li class="breadcrumb-item"><a href="<%=path %>/index.html">首页</a></li>
              <li class="breadcrumb-item active">摄影作品</li>
            </ul>
          </div>
<%--           <div class="breadcrumb-holder container-fluid">
            <div class="search bar6">
		        <form action="<%=path %>/videos/selectVideo.action?userId=${user.id}&pageNum=1" method="post">
		            <input type="text" placeholder="请选择日期和时间"  id="test10" name="imgDate">
		            <button type="submit" class="butcss"></button>
		        </form>
		    </div>
          </div> --%>
          <!-- Charts Section-->
          <!-- Projects Section-->
		  <section class="tables">   
            <div class="container-fluid">
              <div class="row">   
                        
	            <div class="layui-col-md12">
					<div class="layui-card">
						<div class="layui-card-body ">
							<form class="layui-form layui-col-space5" action="<%=path %>/photos/searchPhotoByLike.action?userId=${user.id}" method="post">
								<div class="layui-inline layui-show-xs-block">
									<select id="selectType" name="selectType" lay-filter="system_role_id">
										<option value="0">请选择查询方式</option>
										<option value="1">关键字查询</option>
										<option value="2">日期查询</option>
									</select>
								</div>
								<div class="layui-inline layui-show-xs-block">
									<input type="text" name="imgDate" id="test10" placeholder="请选择日期和时间" autocomplete="off" class="layui-input">
								</div>
								<div class="layui-inline layui-show-xs-block">
									<input type="text" name="searchInfo" value=""  placeholder="请输入作品ID、作品名称、作者名称" autocomplete="off" class="layui-input">
								</div>
								<div class="layui-inline layui-show-xs-block">
									<button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
								</div>
							</form>
						</div>
						<div class="layui-card-body">
							<table class="layui-table layui-form">
								<thead>
									<tr>
										<th>编号</th>
										<th>作品名称</th>
										<th>摄影作品</th>
										<th>作品描述</th>
										<th>上传时间</th>
										<th>类型</th>
										<th>作者id</th>
										<th>作者名称</th>
										<th>联系方式</th>
										<th>管理</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${photoList}">
										<tr>
											<td>${item.photoid }</td>
											<td>${item.title }</td>
											<td><img src="/photos/${item.photoname }" style="width: 50px;height: 50px;border-radius: 50%;"></td>
											<td>${item.introduce }</td>
											<td><fmt:formatDate value="${item.datetime }" pattern="yyyy年MM月dd日HH时mm分ss秒"/></td>
											<td>
												<c:if test="${item.type==1}">动物</c:if>
												<c:if test="${item.type==2}">植物</c:if>
												<c:if test="${item.type==3}">风景</c:if>
												<c:if test="${item.type==4}">其他</c:if>
											</td>
											<td>${item.userid }</td>	
											<td>${item.username }</td>
											<td>${item.useremail }</td>
											<!-- <input type="checkbox" name="switch" lay-skin="switch" data-url="" value="1" data-id="1" title="状态" lay-text="启用|禁用" checked="checked"> -->
											<td>
												<a class="layui-btn layui-btn-sm layui-btn-normal" title="编辑" href="<%=path %>/photos/updatePhotoPage.action?userId=${user.id }&photoId=${item.photoid}"><i class="layui-icon layui-icon-edit"></i>编辑</a>
												<a class="layui-btn layui-btn-sm layui-btn-danger" title="删除" href="<%=path %>/photos/deletePhoto.action?userId=${user.id }&photoId=${item.photoid}"><i class="layui-icon layui-icon-delete"></i>删除</a>
												<%-- <button id="showBut" onclick="javascrtpt:window.location.href='<%=path %>/robots/detailDevice.action?userId=${user.id}&deviceId=${item.deviceid}'">设备授权</button> --%>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="page2" style="text-align:center;">
							<ul class="pagination2">
								<li><a href="<%=path%>/photos/photoInfo.action?userId=${user.id}&pageNum=${pagePojo.pageIndex-1 }">上一页</a></li>
			                	<li class="active">第<a href="#">${pagePojo.pageIndex }</a>页</li>
			                	<li><a href="<%=path%>/photos/photoInfo.action?userId=${user.id}&pageNum=${pagePojo.pageIndex+1 }">下一页</a></li>
			                	<li>总页数：<a href="#">${pagePojo.pageCount }</a></li>
			                	<li>总记录：<a href="#">${pagePojo.pageNumber }</a></li>
							</ul>
						</div>
					</div>
				</div>
                
              </div>
            </div>
          </section>
          <!-- Page Footer-->
          <footer class="main-footer">
            <div class="container-fluid">
              <div class="row">
                <div class="col-sm-6">
                  <p>联系我们<a href="#" class="external">1663512557@qq.com</a></p>
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="<%=path %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=path %>/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="<%=path %>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="<%=path %>/vendor/chart.js/Chart.min.js"></script>
    <script src="<%=path %>/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="<%=path %>/js/charts-custom.js"></script>
    <!-- Main File-->
    <script src="<%=path %>/js/front.js"></script>
    <!--   日期查询类 -->
    <script src="<%=path %>/layDate-v5.0.9/laydate/laydate.js"></script>
    <script type="text/javascript">
	  //日期时间范围
	    laydate.render({
	      elem: '#test10'
	      ,type: 'date'
	      ,range: true
	    }); 
    </script>
    <script src="<%=path %>/lib/layui/layui.js"></script>
	<script src="<%=path %>/js/admin.js"></script>
  </body>
</html>