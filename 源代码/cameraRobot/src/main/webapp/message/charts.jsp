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
	        	document.getElementById("ulMenu").innerHTML= "<li><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li class='active'><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li> <li><a href='<%=path %>/user/userInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-mail'></i>用户管理 </a></li> <li><a href='<%=path %>/photos/photoInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>摄影作品 </a></li>"; 
	        	document.getElementById("selectFrom").innerHTML= "<form class='layui-form layui-col-space5' style='width: 100%;' action='<%=path %>/videos/selectVideo.action?userId=${user.id}' method='post'> <div class='layui-inline layui-show-xs-block' style='padding-left:40px;'><select id='selectType' name='selectType' lay-filter='system_role_id'><option value='0'>请选择查询方式</option><option value='1'>关键字查询</option><option value='2'>日期查询</option></select></div><div class='layui-inline layui-show-xs-block'><input type='text' name='imgDate' id='test10' placeholder='请选择日期和时间' autocomplete='off' class='layui-input'></div><div class='layui-inline layui-show-xs-block'><input type='text' name='searchInfo' value=''  placeholder='请输入图片ID、用户名称' autocomplete='off' class='layui-input'></div><div class='layui-inline layui-show-xs-block'><button class='layui-btn'  lay-submit='' lay-filter='sreach'><i class='layui-icon'>&#xe615;</i></button></div><div class='layui-inline layui-show-xs-block'><button type='button' class='layui-btn' lay-submit='' lay-filter='sreach' onclick=javascrtpt:window.location.href='<%=path %>/videos/uploadPage.action?userId=${user.id}'>上传视频</button></div></form>"
		        
	        }
	        else{
	        	document.getElementById("userType").innerHTML="普通用户";
	        	document.getElementById("ulMenu").innerHTML= "<li><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li class='active'><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li>";
	        	document.getElementById("selectFrom").innerHTML= "<form class='layui-form layui-col-space5' style='width: 100%;' action='<%=path %>/videos/selectUserVideo.action?userId=${user.id}' method='post'><div class='layui-inline layui-show-xs-block'><input type='text' name='imgDate' id='test10' placeholder='请选择日期和时间' autocomplete='off' class='layui-input'></div><div class='layui-inline layui-show-xs-block'><button class='layui-btn'  lay-submit='' lay-filter='sreach'><i class='layui-icon'>&#xe615;</i></button></div><div class='layui-inline layui-show-xs-block'><button type='button' class='layui-btn' lay-submit='' lay-filter='sreach' onclick=javascrtpt:window.location.href='<%=path %>/videos/uploadPage.action?userId=${user.id}'>上传视频</button></div></form>"
		        
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
    <!-- 分页样式 -->
    <link rel="stylesheet" href="<%=path %>/css/page.css" type="text/css" />
    <!-- 日期查询样式 -->
    <link rel="stylesheet" href="<%=path %>/css/dateTime.css" type="text/css" />
    <!-- layuicss样式 -->
    <link rel="stylesheet" href="<%=path %>/lib/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path %>/css/admin.css" media="all">
    
    <!-- button样式 -->
    <link rel="stylesheet" href="<%=path %>/css/button.css">
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
			<div class="layui-card">
				<div class="layui-card-body " id="selectFrom">
				</div>
			</div>        
          <!-- Charts Section-->
          <!-- Projects Section-->
          <section class="projects no-padding-top">
            <div class="container-fluid">
            	
            	<c:forEach var="videos" items="${videoList}" >
				<!-- Project-->
	              <div class="project">
	                <div class="row bg-white has-shadow">
	                  <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
	                    <div class="project-title d-flex align-items-center">
	                      <div class="image has-shadow"><img src="/finshImg/${videos.videoimage}" style="text-align:center;width:100%;height:100%;" alt="..." class="img-fluid"></div>
	                      <div class="text">
	                        <h3 class="h4">${videos.videoname}</h3><small>大小：${videos.videosize}</small>
	                      </div>
	                    </div>
	                    <div class="project-date"><span class="hidden-sm-down">${videos.username}</span></div>
	                  </div>
	                  <div class="right-col col-lg-6 d-flex align-items-center">
	                    <div class="time"><i class="fa fa-clock-o"></i><fmt:formatDate value="${videos.videodatetime}" pattern="yyyy年MM月dd日HH时mm分ss秒"/></div>
	                    <div class="comments"><i class="fa fa-comment-o"></i>20</div>
	                    <button class="buttonF button5" style="margin-left:auto;padding:6px;text-align:center;font-family:微软雅黑体 ;font-size: 15px;" onclick="javascrtpt:window.location.href='<%=path %>/videos/videoView.action?userId=${user.id}&videoId=${videos.videoid}'"><strong>播 放</strong></button>
	                    <button class="buttonF button5" style="margin-left:20px;padding:6px;text-align:center;font-family:微软雅黑体 ;font-size: 15px;" onclick="javascrtpt:window.location.href='<%=path %>/videos/delVideo.action?userId=${user.id}&videoId=${videos.videoid}'"><strong>删 除</strong></button>
	                  </div>
	                </div>
	              </div>
				</c:forEach>
            </div>
            <div class="container large">
  				<div class="pagination">
                	<ul>
	                	<li><a href="<%=path%>/videos/charts.action?userId=${user.id}&pageNum=${pagePojo.pageIndex-1 }">上一页</a></li>
	                	<li>第<a href="#">${pagePojo.pageIndex }</a>页</li>
	                	<li><a href="<%=path%>/videos/charts.action?userId=${user.id}&pageNum=${pagePojo.pageIndex+1 }">下一页</a></li>
	                	<li>总页数：<a href="#">${pagePojo.pageCount }</a></li>
	                	<li>总记录：<a href="#">${pagePojo.pageNumber }</a></li>
                	</ul>
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