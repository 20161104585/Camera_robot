<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>Home</title>
   	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
   	<script type="text/javascript">
	   	$(function(){ 
	        if("${user.type}"==1){
	        	document.getElementById("userType").innerHTML="管理员"; 
	        	document.getElementById("ulMenu").innerHTML= "<li class='active'><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li> <li><a href='<%=path %>/user/userInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-mail'></i>用户管理 </a></li> <li><a href='<%=path %>/photos/photoInfo.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>摄影作品 </a></li>"; 
	        }
	        else{
	        	document.getElementById("userType").innerHTML="普通用户";
	        	document.getElementById("ulMenu").innerHTML= "<li class='active'><a href='<%=path %>/signal/index.action?userId=${user.id}'> <i class='icon-home'></i>首页 </a></li> <li><a href='<%=path %>/robots/tables.action?userId=${user.id}'> <i class='icon-grid'></i>设备信息 </a></li> <li><a href='<%=path %>/videos/charts.action?userId=${user.id}&pageNum=1'> <i class='icon-screen'></i>监控视频 </a></li> <li><a href='<%=path %>/images/forms.action?userId=${user.id}&pageNum=1'> <i class='icon-picture'></i>摄影图片 </a></li>";
	        }
	   	});
   	</script>
   	<script type="text/javascript">
   	
			var direction = 1;//存放控制代码值
		    var data={
		        accessToken: 'at.ab28w2udarlcv2qp49eamwyyc82ucgmh-4g2p34nwoc-0puyncc-kyj3bsfoa',
		        deviceSerial:'D88556459',
		        channelNo:'1'
		    }//存放应用密钥
		    var yunTaiKey = false;//云台控制状态
		    var yunTaiNum = 0;//云台控制状态
        	//因为持续按键那么第一下和第二下有时间间隔；比如a aaaaaaaa  ,所以用定时器来做加减
			//keyCode 值 左上右下 65-87-68-83
			var stop;//存放setInterval函数返回值
			var stop2;//存放updateWeather函数返回值
			var ipaddress;//存放设备IP地址
			var port;//存放设备端口号
			function wheel(ipaddress,port){
				var json={'left':false,'top':false,'right':false,'bottom':false};
	 			document.onkeydown=function(ev){
					var ev=ev || event;
					if(ev.keyCode==65){
						json['left']=true;
					}
					if(ev.keyCode==87){
						json['top']=true;
					}
					if(ev.keyCode==68){
						json['right']=true;
					}
					if(ev.keyCode==83){
						json['bottom']=true;
					}
					
					if(ev.keyCode==37){
						yunTaiKey = true;
						yunTaiNum = yunTaiNum + 1;
						direction = 2;
						keycontrol();
					}
					if(ev.keyCode==38){
						yunTaiKey = true;
						yunTaiNum = yunTaiNum + 1;
						direction = 0;
						keycontrol();
					}
					if(ev.keyCode==39){
						yunTaiKey = true;
						yunTaiNum = yunTaiNum + 1;
						direction = 3;
						keycontrol();
					}
					if(ev.keyCode==40){
						yunTaiKey = true;
						yunTaiNum = yunTaiNum + 1;
						direction = 1;
						keycontrol();
					}
				}
				document.onkeyup=function(){
					var ev=ev || event;
					if(ev.keyCode==65){
						json['left']=false;
					}
					if(ev.keyCode==87){
						json['top']=false;
					}
					if(ev.keyCode==68){
						json['right']=false;
					}
					if(ev.keyCode==83){
						json['bottom']=false;
					}
					
					if(ev.keyCode==37){
						yunTaiKey = false;
						keycontrol();
					}
					if(ev.keyCode==38){
						yunTaiKey = false;
						keycontrol();
					}
					if(ev.keyCode==39){
						yunTaiKey = false;
						keycontrol();
					}
					if(ev.keyCode==40){
						yunTaiKey = false;
						keycontrol();
					}
				}	
				
				stop = setInterval(function(){
					/* console.log("bottom:"+json['bottom']); */
					$.ajax({
						type: "post",
				        url: "<%=path%>/signal/text.action?ipaddress="+ipaddress+"&port="+port,
				        data : {jsonStr:JSON.stringify(json)},
					    dataType: "json",
				        success: function (data) {
				            //alert(data[0]);
				        }
				    });
				},300);
				
				stop2 = setInterval(function(){
					/* console.log("bottom:"+json['bottom']); */
					$.ajax({
						type: "post",
				        url: "<%=path%>/weather/findWeather.action",
				        data : {},
					    dataType: "json",
				        success: function (data) {
				        	document.getElementById("temperature").innerHTML="<strong>"+data.temperature+"℃</strong>";
				        	document.getElementById("humidity").innerHTML="<strong>"+data.humidity+"%</strong>";
				        	document.getElementById("rainfall").innerHTML="<strong>"+data.rainfall+"</strong>";
				        }
				    });
				},10000);
				
				function keycontrol() {
					if(yunTaiKey){
						if(yunTaiNum==1){
							console.log("w");
					        data.direction=direction;
				            data.speed='2';
						    $.ajax({
								type: "post",
						        url: "https://open.ys7.com/api/lapp/device/ptz/start",
						        data : data,
							    dataType: "json",
						        success: function (res) {
					        	   if(res.code==200){
				        		    	
				        		   }else{
										alert(res.msg,"云台错误");
										yunTaiNum=0;
				        		   }
						        }
						    });
						}
					}else{
					    $.ajax({
							type: "post",
					        url: "https://open.ys7.com/api/lapp/device/ptz/stop",
					        data : data,
						    dataType: "json",
					        success: function (res) {
				        	   if(res.code==200){
				        		   yunTaiNum=0;
			        		   }else{
									alert(res.msg,"云台错误");
									yunTaiNum=0;
			        		   }
					        }
					    });
					}
				}			

			}

		function buildLink(ipaddress,port){
			/* alert(ipaddress+port); */
			wheel(ipaddress,port);
			//document.getElementById("trRobot").color = "#33CCFF";
			/* $("#ip").attr("disabled","disabled");
	        $("#port").attr("disabled","disabled"); */
		}
		function breakLink(){
			if(stop) clearInterval(stop);
			if(stop2) clearInterval(stop2);
			/* $("#ip").removeAttr("disabled");
			$("#port").removeAttr("disabled"); */
		}
		

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
    
    <!-- button样式 -->
    <link rel="stylesheet" href="<%=path %>/css/button.css">
    <!-- 视频播放所需css样式和js -->
    <link rel="stylesheet" href="<%=path %>/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path %>/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="<%=path %>/layuiadmin/layui/font/font_2wmcsfamra2/iconfont.css">
    <link href="<%=path %>/css/mui.min.css" rel="stylesheet">
    <script src="<%=path %>/js/ezuikit.js"></script>
    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/mui.min.js"></script>
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
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
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
          <!-- Dashboard Counts Section-->
          <section class="dashboard-counts no-padding-bottom">
            <div class="container-fluid">
              <div class="row bg-white has-shadow">
                <!-- Item -->
                  <div class="item d-flex align-items-center" >
                      <table class="table table-striped table-sm">
                        <thead>
                          <tr>
                            <th>编号</th>
                            <th>设备名称</th>
                            <th>IP地址</th>
                            <th>端口号</th>
                            <th>操作</th>
                           </tr>
                         </thead>
                        <tbody>
                         <c:forEach var="item" items="${robotList}">
                          <tr id="trRobot">
                            <th scope="row">${item.deviceid }</th>
                            <td>${item.devicename }</td>
                            <td>${item.ipaddress }</td>
                            <td>${item.port }</td>
                            <td>
                            	<button class="buttonF button5" onclick="buildLink('${item.ipaddress }',${item.port })">建立连接</button>
                            	<button class="buttonF button5" onclick="breakLink()">断开连接</button>
                            	</td>         
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                  </div>
	          
                  <div class="item d-flex align-items-center" style="width:350px; padding-left:50px;border-left-style:outset">
                  	<div><img src="<%=path %>/img/temperature.png" style="height: 40px; text-align:center;"></div>
                    <div class="title"><span>温&emsp;&emsp;&emsp;&emsp;度<br>temperature</span>
                    </div>
                    <div class="number" id="temperature" style="color:#33CCFF;"><strong>70℃</strong></div>
                  </div>
             
                  <div class="item d-flex align-items-center" style="width:280px; padding-left:20px;border-left-style:outset">
                  	<div><img src="<%=path %>/img/humidity.png" style="height: 40px; text-align:center;"></div>
                    <div class="title"><span>湿&emsp;&emsp;度<br>humidity</span>
                    </div>
                    <div class="number" id="humidity" style="color:#33CCFF;"><strong>70%</strong></div>
                  </div>

                  <div class="item d-flex align-items-center" style="width:260px;padding-left:20px; border-left-style:outset">
                  	<div><img src="<%=path %>/img/rainfall.png" style="height: 40px; text-align:center;"></div>
                    <div class="title"><span>降雨量<br>rainfall</span>
                    </div>
                    <div class="number" id="rainfall"  style="color:#33CCFF;"><strong>70</strong></div>
                  </div>

                <!-- Item -->
              </div>
            </div>
          </section>        
          <!-- Dashboard Header Section    -->
          <section class="dashboard-header">
            <div class="container-fluid">
              <div class="row">
                <!-- Statistics -->
                <div class="statistics col-lg-3 col-12">
                  <div class="statistic d-flex align-items-center bg-white has-shadow" style="height: 150px;">
                    <div><img alt="" src="<%=path %>/img/instructions.png" style="height: 40px; text-align:center;"></div>
                    <div class="text" style=" margin-left:10px ;font-family:微软雅黑体 ; color:red;">使用说明：请使用键盘WSAD控制机器人机器人行进方向；使用右侧方向键盘/视频左侧按钮控制摄像机角度，并且可以点击预设按钮使云台回到设定好的位置。</div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow" style="height: 80px;">
                  	<div><img alt="" src="<%=path %>/img/operation.png" style="height: 40px; text-align:center;"></div>
                    <div class="text" style=" margin-left:10px ;font-family:微软雅黑体 ;">
                    <button onclick="capture()" class="buttonF button5"><strong>拍照</strong></button>
                    <button id="capture2" class="buttonF button5" style="margin-left:80px"><strong>升降</strong></button>
                    </div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                  	<div><img alt="" src="<%=path %>/img/yuntai.png" style="height: 40px; text-align:center;"></div>
                    <div class="text" style=" margin-left:10px ;font-family:微软雅黑体 ;">
              			<p class="layui-text-bottom">
	                        <button style="margin-left:50px; text-align:center;" class="layui-icon layui-icon-up" lay-submit="" lay-filter="add" onclick="control(0)"></button>
	                        <label style="margin-left:60px; text-align:center;font-family:微软雅黑体 ;font-size: 18px;">预设点1：</label>
	                        <button class="layui-icon layui-icon-circle" lay-submit="" lay-filter="add" onclick="control(8)"></button>
	                        <br>
	                        <button style="margin-left:5px; text-align:center;" class="layui-icon layui-icon-left" lay-submit="" lay-filter="add" onclick="control(2)"></button>
	                        <button style=" text-align:center;" class="layui-icon layui-icon-pause" lay-submit="" lay-filter="add" onclick="stopYunTai()"></button>
	                        <button style=" text-align:center;" class="layui-icon layui-icon-right" lay-submit="" lay-filter="add" onclick="control(3)"></button>
	                        <br> 
	                        <button style="margin-left:50px; text-align:center;" class="layui-icon layui-icon-down" lay-submit="" lay-filter="add" onclick="control(1)"></button>
	                        <label style="margin-left:60px; text-align:center;font-family:微软雅黑体 ;font-size: 18px;">预设点2：</label>
	                        <button class="layui-icon layui-icon-circle" lay-submit="" lay-filter="add" onclick="control(9)"></button>
	                   	</p>
                    </div>
                  </div>
                </div>
                <!-- Line Chart            -->
                <div class="chart col-lg-6 col-12">
<%-- 	            <video id="video" poster="<%=path %>/img/mockup2.jpg" width="800px" height="600px" controls playsInline webkit-playsinline [autoplay]>
						<source src="ezopen://open.ys7.com/d8ff800011a149b4924e43b39e6b6762.live" type="" />
					</video> --%>
					<iframe
				      src="https://open.ys7.com/ezopen/h5/iframe_se?url=ezopen://open.ys7.com/D88556459/1.live&autoplay=0&accessToken=at.ab28w2udarlcv2qp49eamwyyc82ucgmh-4g2p34nwoc-0puyncc-kyj3bsfoa&templete=2"
				      width="800"
				      height="534"
				      id="ysOpenDevice"
				      name="ysOpenDevice"
				      allowfullscreen
				    >
				    </iframe>
                </div>
                <div class="chart col-lg-3 col-12">
                  <!-- Bar Chart   -->
                  <div class="bar-chart has-shadow bg-white">
                    <div class="title" style="text-align:center;"><strong class="text-violet" style="text-align:center; color:black; font-size: 20px; font-weight: bold;">摄影图片预览</strong></div>
                    <!-- 照片显示 -->
                    <canvas id="canvas" width="480" height="320"></canvas>
                  </div>
                  <!-- Numbers-->
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="text" style="font-family:微软雅黑体 ;font-size: 15px;"><strong>操作：</strong></div>
                    <button style="text-align:center; font-family:微软雅黑体 ; font-size: 15px;" onclick="uploadPic()" class="buttonF button5">保存图片</button><br>
                    <small style="margin:auto ;font-family:微软雅黑体 ;font-size: 20px;"><span id="span_img" ></span></small>
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
<!--     <script type="text/javascript">
  		alert("提示：请使用键盘WSAD控制机器人上下左右");
  	</script> -->
    <script src="<%=path %>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=path %>/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="<%=path %>/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="<%=path %>/vendor/chart.js/Chart.min.js"></script>
    <script src="<%=path %>/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="<%=path %>/js/charts-home.js"></script>
    <!-- Main File-->
    <script src="<%=path %>/js/front.js"></script>
    <script src="<%=path %>/layuiadmin/layui/layui.js"></script>
    <script type="text/javascript">


	    /* 获取播放器元素 */
	    var player = document.getElementById('ysOpenDevice').contentWindow;
	    /* iframe 支持方法 */
	    player.postMessage("play", "https://open.ys7.com/ezopen/h5/iframe") /* 播放 */
	    player.postMessage("stop", "https://open.ys7.com/ezopen/h5/iframe") /* 结束 */
	    player.postMessage("capturePicture", "https://open.ys7.com/ezopen/h5/iframe") /* 截图 */
	    player.postMessage("openSound", "https://open.ys7.com/ezopen/h5/iframe") /* 开启声音 */
	    player.postMessage("closeSound", "https://open.ys7.com/ezopen/h5/iframe") /* 关闭声音 */
	    player.postMessage("startSave", "https://open.ys7.com/ezopen/h5/iframe") /* 开始录制 */
	    player.postMessage("stopSave", "https://open.ys7.com/ezopen/h5/iframe") /* 结束录制 */

    </script>  
    <script type="text/javascript">
    var data={
	        accessToken: 'at.ab28w2udarlcv2qp49eamwyyc82ucgmh-4g2p34nwoc-0puyncc-kyj3bsfoa',
	        deviceSerial:'D88556459',
	        channelNo:'1'
	    }//存放应用密钥
    layui.config({
        base: '<%=path %>/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'sample']);
    //开始控制
    var control=function (direction) {
        data.direction=direction;
        data.speed='2';
        layui.use(['jquery', 'layer'], function(){
            var $ = layui.$
                ,layer = layui.layer;
            $.post('https://open.ys7.com/api/lapp/device/ptz/start',data,function(res){
                if(res.code==200){
                    layer.msg(res.msg, {time: 2000});
                }else{
                    layer.msg(res.msg, {time: 2000});
                }
            },'json');
            return false;
        });
    }
    //停止转动
    var stopYunTai=function () {
        layui.use(['jquery', 'layer'], function(){
            var $ = layui.$ //重点处
                ,layer = layui.layer;
            $.post('https://open.ys7.com/api/lapp/device/ptz/stop',data,function(res){
                if(res.code==200){
                    layer.msg(res.msg, {time: 2000});
                }else{
                    layer.msg(res.msg, {time: 2000});
                }
            },'json');
            return false;
        });

    }
    </script>
    <script>
    
		var player = new EZUIPlayer('video');
		player.play();
		
		
		let video = document.getElementById('video');
	    let canvas = document.getElementById('canvas');
	    let context = canvas.getContext('2d');
 		
	    var imgsrc;
	    layui.config({
	        base: '<%=path %>/layuiadmin/' //静态资源所在路径
	    }).extend({
	        index: 'lib/index' //主入口模块
	    }).use(['index', 'sample']);
	    data={
		        accessToken: 'at.ab28w2udarlcv2qp49eamwyyc82ucgmh-4g2p34nwoc-0puyncc-kyj3bsfoa',
		        deviceSerial:'D88556459',
		        channelNo:'1'
		    }//存放应用密钥
		function capture(){
		 layui.use(['jquery', 'layer'], function(){
			var $ = layui.$ //重点处
		          	,layer = layui.layer;
		     		$.post('https://open.ys7.com/api/lapp/device/capture',data,function(res){
		     			if(res.code==200){
		     			  imgsrc = res.data.picUrl;
		                  layer.msg(res.msg, {time: 2000});
		                  console.log(res.data.picUrl);
		                  
		                  var canvas = document.getElementById('canvas');
						  var context = canvas.getContext('2d');
		                  var img = new Image();


		                  //img.src = res.data.picUrl + '?' + timestamp;
		                  //img.crossOrigin = 'Anonymous';
		                  //img.setAttribute('crossOrigin','anonymous');
		                 
	   	                  img.onload = function() {
	  	                	  context.drawImage(img, 0, 0, 480, 320);
	  	                	//base64 = canvas.toDataURL("image/jpg");
		                  };
		                  //img.src= res.data.picUrl + '?time=' + new Date()
		                  img.src = res.data.picUrl;
		              }else{
		                  layer.msg(res.msg, {time: 2000});
		              }
		          },'json');
			});
		}
	    
/*         document.getElementById('capture').addEventListener('click', function () {
          	context.drawImage(video, 0, 0, 480, 320);
        }) */

        //上传图片到后台
        function uploadPic() {
            // Generate the image data（将Canvas的内容保存为图片借助toDataURL来实现） 方法返回一个包含图片展示的 data URI 。
            //var Pic = window.frames["ysOpenDevice"].document.getElementById("canvas").toDataURL("image/jpg");
            //var Pic = document.getElementById("canvas").toDataURL("image/jpg");
            var span = document.getElementById("span_img");
            //对其进行base64编 之后的字符串
            //Pic = Pic.replace(/^data:image\/(png|jpg);base64,/,"");

            // Sending the image data to Server
            $.ajax({
                type: 'POST',
                url:  "<%=path %>/images/uploadImage.action?userId=${user.id}",
                data: { "picUrl" : imgsrc},
				success : function(data){
					console.log(data);
					if(data=="success"){
						span.innerHTML = "图片保存成功"
					}else{
						span.innerHTML = "图片保存失败"
					}
				},
				error : function(err) {
					span.innerHTML = "图片保存失败"
				}
            });
        }
    </script>
  </body>
</html>