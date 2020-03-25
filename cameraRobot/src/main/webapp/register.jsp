<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <script type="text/javascript">
	function checkUsername(){
		var uValue = $("#username").val();
		var span = document.getElementById("span_username");
		if(uValue.length < 6){
			span.innerHTML = "用户名长度为6-20个字符"
		}else{
			$.ajax({
				type : "post",
				data : {"username" : uValue},
				url : "${pageContext.request.contextPath}/user/checkUsername.action",
				dataType : "json",
				error : function(err) {
					alert(err.code);
				},
				success : function(data){
					if(data==0){
						span.innerHTML = "用户名已存在"
					}else{
						span.innerHTML = "用户名可用"
					}
				}
			})
		}
	}
	function checkPassword(){
		var pValue = $("#password").val();
		var span = document.getElementById("span_password");
		if(pValue.length < 6){
			span.innerHTML = "密码长度为6-20个字符"
		}else{
			span.innerHTML = ""
		}
	}
	function checkRepwd(){
		var pValue = $("#password").val();
		var pwdValue = $("#repwd").val();
		var span = document.getElementById("span_repwd");
		if(pwdValue.length < 6){
			span.innerHTML = "密码长度为6-20个字符"
		}else{
			if(pValue==pwdValue){
				span.innerHTML = ""
			}else{
				span.innerHTML = "两次密码输入不一致"
			}
		}
	}
  </script>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>远程摄影机器人控制系统</h1>
                  </div>
                  <p>Control system of telephotographing robot.</p>
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form form action="${pageContext.request.contextPath }/user/register.action" method="post" class="form-validate">
                    <div class="form-group">
                      <input id="username" type="text" name="username" required data-msg="请输入用户名" class="input-material" onkeyup="checkUsername()" ><span id="span_username"></span>
                      <label for="register-username" class="label-material">User Name</label>
                    </div>
                    <div class="form-group">
                      <input id="password" type="password" name="password" required data-msg="请输入密码" class="input-material" onkeyup="checkPassword()"><span id="span_password"></span>
                      <label for="register-email" class="label-material">Email Address      </label>
                    </div>
                    <div class="form-group">
                      <input id="repwd" type="password" name="rePassword" required data-msg="请再次输入密码" class="input-material" onkeyup="checkRepwd()"><span id="span_repwd"></span>
                      <label for="register-password" class="label-material">password        </label>
                    </div>
                    <div class="form-group terms-conditions">
                      <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
                      <label for="register-agree">Agree the terms and policy</label>
                    </div>
                    <div class="form-group">
                      <button id="regidter" type="submit" name="registerSubmit" class="btn btn-primary">注册</button>
                    </div>
                  </form><small>已经拥有帐号? </small><a href="login.jsp" class="signup">回到登陆</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="copyrights text-center">
        <p>联系我们<a href="#" class="external">1663512557@qq.com</a>
          <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
        </p>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <!-- Main File-->
    <script src="js/front.js"></script>
  </body>
</html>