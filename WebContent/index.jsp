<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="${ctx }/img/logo.png" />
<title>水果管理系统</title>
<link href="${ctx }/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="${ctx }/css/mmss.css" />
<link rel="stylesheet" href="${ctx }/css/font-awesome.min.css" />
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<style>
</style>
</head>
<body>
	<header>
		<div class="container-fluid navbar-fixed-top bg-primary">
			<ul class="nav navbar-nav  left">
				<li class="text-white h4">&nbsp;&nbsp;&nbsp;&nbsp;<span
					class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>水果管理系统</b>
				</li>
			</ul>
			<ul class="nav navbar-nav nav-pills right ">
				<li class="bg-warning "><a href="#"><span
						class="glyphicon glyphicon-tasks"></span><span class="badge">1</span></a>
				</li>
				<li class="bg-success"><a href="#"><span
						class="glyphicon glyphicon-envelope"></span><span class="badge">2</span></a>
				</li>
				<li class="bg-danger"><a href="#"><span
						class="glyphicon glyphicon-bell"></span></a></li>
				<li class="bg-info dropdown"><a class="dropdown-toggle"
					href="#" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-user"></span>&nbsp;<span>${loginRole}</span><span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li class="text-center"><a href="#"><span
								class="text-primary">账号设置</span></a></li>
						<li class="text-center"><a href="#"><span
								class="text-primary">消息设置</span></a></li>
						<li class="text-center"><a href="#"><span
								class="text-primary">帮助中心</span></a></li>
						<li class="divider"><a href="#"></a></li>
						<li class="text-center"><a href="login.html"><span
								class="text-primary">退出</span></a></li>
					</ul></li>
			</ul>
		</div>
	</header>

	<section>
		<div class="container-fluid">
			<div class="row ">
				<!--左侧导航开始-->
				<div class="col-xs-2 bg-blue">
					<br />
					<div class="panel-group sidebar-menu" id="accordion"
						aria-multiselectable="true">
						<div class="panel panel-default menu-first menu-first-active">
							
							<!-- 链接到servlet，并进行角色的验证，根据不同的角色，显示不同的菜单 -->
							<a href="${ctx }/product.jsp">
							<!-- data-toggle="collapse"
							data-parent="#accordion"
							aria-expanded="true"
							aria-controls="collapseOne"> --> <i class="icon-home icon-large"></i>
								主页
							</a>
						</div>
					</div>
				</div>
				<!--左侧导航结束-->
				<!----------------------------------------------------------------------------------------------------->
				<!--右侧内容开始-->
				<div class="col-xs-10">
					<br />
					<ol class="breadcrumb">
						<li class="active"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</li>
					</ol>
					<h1 class="text-center text-white">水果管理系统</h1>
					<!----------------------------------------------------------    ------------------------------------------->
				</div>
				<!--右侧内容结束-->
			</div>
		</div>
	</section>

	<footer class="bg-primary navbar-fixed-bottom">
		<p class="text-center text-white">版权所有&copy;WJC</p>
	</footer>

	<script src="${ctx }/js/jquery-1.11.3.js"></script>
	<script src="${ctx }/js/bootstrap.js"></script>
	<script>
		/*Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测*/
		(function() {
			var s = document.createElement("script");
			s.onload = function() {
				bootlint.showLintReportForCurrentDocument([]);
			};
			s.src = "js/bootlint.js";
			document.body.appendChild(s)
		})();

		$(function() {
			$('dt').click(
					function() {
						$(this).parent().find('dd').show().end().siblings()
								.find('dd').hide();
					});
		});
	</script>
</body>
</html>
