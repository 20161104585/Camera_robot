<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Photography Website Concept</title>
<meta name="description" content="A photography-inspired website layout with an expanding stack slider and a background image tilt effect" />
<meta name="keywords" content="photography, template, layout, effect, expand, image stack, animation, flickity, tilt" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="<%=path %>/favicon.ico">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/flickity.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/main.css" />
<script src="<%=path %>/js/modernizr.custom.js"></script>
</head>
<body>
	<div class="container">
		<div class="hero">
			<div class="hero__back hero__back--static"></div>
			<div class="hero__back hero__back--mover"></div>
			<div class="hero__front"></div>
		</div>
		<header class="codrops-header">
			<h1 class="codrops-title">Christian Zana <span>Photography</span></h1>
			<nav class="menu">
				<a class="menu__item" href="#"><span>About</span></a>
				<a class="menu__item menu__item--current" href="#"><span>Work</span></a>
				<a class="menu__item" href="#"><span>Contact</span></a>
			</nav>
		</header>
		<div class="stack-slider">
			<div class="stacks-wrapper">
			
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="人物"><span>人物</span></a></h2>
					<c:forEach var="item" items="${photos1}">
						<div class="item">
							<div class="item__content">
								<img src="/photos/${item.photoname }" alt="img01" />
								<h3 class="item__title">${item.introduce }<span class="item__date"><fmt:formatDate value="${item.datetime }" pattern="yyyy年MM月dd日HH时mm分ss秒"/></span></h3>
								<div class="item__details">
									<ul>
										<li><i class="icon icon-camera"></i><span>${item.title }</span></li>
										<li><i class="icon icon-focal_length"></i><span>${item.username }</span></li>
										<li><i class="icon icon-aperture"></i><span>${item.useremail }</span></li>
										<%-- <li><i class="icon icon-exposure_time"></i><span>${item.imgname }</span></li>
										<li><i class="icon icon-iso"></i><span>${item.imgname }</span></li> --%>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				
				
				
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="Landscape"><span>Landscape</span></a></h2>
					<div class="item">
						<div class="item__content">
							<img src="<%=path %>/img/type3/1.jpg" alt="img01" />
							<h3 class="item__title">Austin flannel salvia <span class="item__date">05/05/2015</span></h3>
							<div class="item__details">
								<ul>
									<li><i class="icon icon-camera"></i><span>Canon PowerShot S95</span></li>
									<li><i class="icon icon-focal_length"></i><span>22.5 mm</span></li>
									<li><i class="icon icon-aperture"></i><span>&fnof;/5.6</span></li>
									<li><i class="icon icon-exposure_time"></i><span>1/1000</span></li>
									<li><i class="icon icon-iso"></i><span>80</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="Miscellaneous"><span>Miscellaneous</span></a></h2>
					<div class="item">
						<div class="item__content">
							<img src="<%=path %>/img/type2/1.jpg" alt="img01" />
							<h3 class="item__title">Chambray fingerstache <span class="item__date">05/05/2015</span></h3>
							<div class="item__details">
								<ul>
									<li><i class="icon icon-camera"></i><span>Canon PowerShot S95</span></li>
									<li><i class="icon icon-focal_length"></i><span>22.5 mm</span></li>
									<li><i class="icon icon-aperture"></i><span>&fnof;/5.6</span></li>
									<li><i class="icon icon-exposure_time"></i><span>1/1000</span></li>
									<li><i class="icon icon-iso"></i><span>80</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="stack">
					<h2 class="stack-title"><a href="#" data-text="Wildlife"><span>Wildlife</span></a></h2>
					<div class="item">
						<div class="item__content">
							<img src="<%=path %>/img/type4/1.jpg" alt="img01" />
							<h3 class="item__title">Kickstarter keffiyeh <span class="item__date">05/05/2015</span></h3>
							<div class="item__details">
								<ul>
									<li><i class="icon icon-camera"></i><span>Canon PowerShot S95</span></li>
									<li><i class="icon icon-focal_length"></i><span>22.5 mm</span></li>
									<li><i class="icon icon-aperture"></i><span>&fnof;/5.6</span></li>
									<li><i class="icon icon-exposure_time"></i><span>1/1000</span></li>
									<li><i class="icon icon-iso"></i><span>80</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /stacks-wrapper -->
		</div>
		<!-- /stacks -->
		<img class="loader" src="<%=path %>/img/three-dots.svg" width="60" alt="Loader image" />
	</div>
	<!-- /container -->
	<!-- Flickity v1.0.0 http://flickity.metafizzy.co/ -->
	<script src="<%=path %>/js/flickity.pkgd.min.js"></script>
	<script src="<%=path %>/js/smoothscroll.js"></script>
	<script src="<%=path %>/js/main.js"></script>
</body>
</html>