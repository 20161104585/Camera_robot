<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 生成日期所需类 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript">
	   	$(function(){ 
	        if("${user.type}"==1){
	        	document.getElementById("userType").innerHTML="管理员"; 
	        	document.getElementById("ulMenu").innerHTML= "<li><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li> <li><a href='<%=path %>/user/userInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-mail'></i>用户管理 </a></li> <li class='active'><a href='<%=path %>/photos/photoInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>摄影作品 </a></li>"; 
				
	        }
	        else{
	        	document.getElementById("userType").innerHTML="普通用户";
	        	document.getElementById("ulMenu").innerHTML= "<li><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li class='active'><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li>";

	        	
	        }
	   	});
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
          <section class="tables">   
            <div class="container-fluid">
              <div class="row"> 
                <!-- Form Elements -->
                <div class="col-lg-12">
                  <div class="card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard5" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">编辑摄影图片</h3>
                    </div>
                    <div class="card-body">
                      <form action="<%=path %>/photos/updatePhoto.action?userId=${user.id}" id="photoForm" method="post"  enctype="multipart/form-data" class="form-horizontal">
                      	<!--1.作品ID-->
                      	<div class="form-group row">
                          <label class="col-sm-3 form-control-label">作品编号</label>
                          <div class="col-sm-9">
                            <input type="text" id="photoid" name="photoid" value="${photo.photoid}" disabled="disabled" class="form-control">
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--2.作品名称-->
                      	<div class="form-group row">
                          <label class="col-sm-3 form-control-label">作品名称</label>
                          <div class="col-sm-9">
                            <input type="text" id="photoname" name="photoname" value="${photo.photoname}" disabled="disabled" class="form-control">
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--3.作品分类-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">作品类型</label>
                          <div class="col-sm-9">
                            <select id="type" name="type" data-placeholder="选择类别" class="form-control mb-3">
                              <option value="0">-请选择-</option>
                              <option value="1" <c:if test="${photo.type==1}">selected</c:if>>动物</option>
                              <option value="2" <c:if test="${photo.type==2}">selected</c:if>>植物</option>
                              <option value="3" <c:if test="${photo.type==3}">selected</c:if>>风景</option>
                              <option value="4" <c:if test="${photo.type==4}">selected</c:if>>其他</option>
                            </select>
                          </div>
                        </div>
                        <div class="line"></div>
                      	<!--4.作品标题-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">作品标题</label>
                          <div class="col-sm-9">
                            <input type="text" id="title" name="title" value="${photo.title}" class="form-control">
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--5.作品描述-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">作品描述</label>
                          <div class="col-sm-9">
                            <input type="text" id="introduce" name="introduce" value="${photo.introduce}" class="form-control"><small class="help-block-none"></small>
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--6.作者ID-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">作者ID</label>
                          <div class="col-sm-9">
                            <input type="text" id="userid" name="userid" value="${photo.userid}" disabled="disabled" class="form-control">
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--7.作者-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">作者</label>
                          <div class="col-sm-9">
                            <input type="text" id="username"  name="username" value="${photo.username}" disabled="disabled" class="form-control">
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--8.联系方式-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">联系方式</label>
                          <div class="col-sm-9">
                            <input type="text" id="useremail" name="useremail" value="${photo.useremail}" class="form-control">
                          </div>
                        </div>
                        <div class="line"></div>
                        <!--9.作品展示-->
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">作品展示</label>
                          <div class="col-sm-9">
	                          <img alt="图片加载失败" src="/photos/${photo.photoname }">
                          </div>
                        </div>
                        <div class="line"></div>
                        <div class="form-group row">
                          <div class="col-sm-4 offset-sm-3">
                            <button type="button" onclick="javascrtpt:window.location.href='<%=path %>/photos/photoInfo.action?userId=${user.id}&pageNum=1'" class="btn btn-secondary">取消</button>
                            <button type="button" onclick="doSubmit()" class="btn btn-primary">修改</button>
                          </div>
                        </div>
                      </form>
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
    <script type="text/javascript">
	    function doSubmit(){//去除deviceid的disabled属性
	    	$("#photoid").removeAttr("disabled");
	    	$("#photoname").removeAttr("disabled");
	    	$("#userid").removeAttr("disabled");
	    	$("#username").removeAttr("disabled");
	    	$("#photoForm").submit();
		}
    </script>
    <script src="<%=path %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=path %>/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="<%=path %>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="<%=path %>/vendor/chart.js/Chart.min.js"></script>
    <script src="<%=path %>/vendor/jquery-validation/jquery.validate.min.js"></script>
    <!-- Main File-->
    <script src="<%=path %>/js/front.js"></script>
  </body>
</html>