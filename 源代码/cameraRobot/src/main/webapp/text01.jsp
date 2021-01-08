<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript">
			//因为持续按键那么第一下和第二下有时间间隔；比如a aaaaaaaa  ,所以用定时器来做加减
			//keyCode 值 左上右下 37--40
			window.onload=function(){
				var json={'left':false,'top':false,'right':false,'bottom':false};
 	 			document.onkeydown=function(ev){
					var ev=ev || event;
					if(ev.keyCode==37){
						json['left']=true;
					}
					if(ev.keyCode==38){
						json['top']=true;
					}
					if(ev.keyCode==39){
						json['right']=true;
					}
					if(ev.keyCode==40){
						json['bottom']=true;
					}
				}
				document.onkeyup=function(){
					var ev=ev || event;
					if(ev.keyCode==37){
						json['left']=false;
					}
					if(ev.keyCode==38){
						json['top']=false;
					}
					if(ev.keyCode==39){
						json['right']=false;
					}
					if(ev.keyCode==40){
						json['bottom']=false;
					}
				}
				setInterval(function(){
					$.ajax({
						type: "post",
				        url: "<%=request.getContextPath()%>/signal/text.action",
				        data : {jsonStr:JSON.stringify(json)},
 				        dataType: "json",
				        success: function (data) {
				            //alert(data[0]);
				        }
				    });
				},300);
			}
		</script>
	</head>
	<body>
		<div id="threadControl">
			<input id="ip" type="text" text="ip地址">
			<input id="port" type="text">
			<input id="ip" type="text">
			<input id="ip" type="text">
		</div>
	</body>
</html>