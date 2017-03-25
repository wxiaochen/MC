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

<style>
</style>
<script type="text/javascript">
	function search() {
		var p = $("#searchParam").val();
		window.location.href = "${ctx}/fruit/list?searchParam=" + p;
		$("[name='pagen']").each(
				function(key, value) {
					$(this).attr("href",
							$(this).attr("href") + "&searchParam='" + p + "'");
				});
	}
</script>
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
							<a data-toggle="collapse" data-parent="#accordion"
								href="index.html" aria-expanded="true"
								aria-controls="collapseOne"> <i class="icon-home icon-large"></i>
								主页
							</a>
						</div>

						<c:forEach items="${menus}" var="ms">
							<div class="panel panel-default menu-first">
								<a data-toggle="collapse" data-parent="#accordion" href=""
									aria-expanded="true" aria-controls="collapseOne"> <i
									class="icon-user-md icon-large"></i> ${ms.key.powerName}
								</a>
								<div id="collapseOne" class="panel-collapse collapse in">
									<ul class="nav nav-list menu-second">
										<c:forEach items="${ms.value}" var="twoMenu" begin="0">
											<li class="menu-second-selected"><a
												href="${ctx }/${twoMenu.powerUrl }"> <i
													class="icon-user"></i>${twoMenu.powerName}
											</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<!--左侧导航结束-->
				<!----------------------------------------------------------------------------------------------------->
				<!--右侧内容开始-->
				<div class="col-xs-10">
					<br />
					<ol class="breadcrumb">
						<li><a href="${ctx }/index.jsp"><span
								class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
						<li class="active">PersonalManage - updatePassword</li>
					</ol>
					<form action="${ctx }/loginuser/update?loginName=${loginName}" method="post">
						<table
							class="table table-bordered table-striped text-center bg-info">
							<thead>
								<tr class="info">
									<th class="text-center" colspan="2" align="center">登录信息</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>登录名：</td>
									<td>${loginName}</td>
								</tr>
								<tr>
									<td>旧密码：</td>
									<td><input name="oldpwd" type="password" class="form-control"
										placeholder="密码" aria-describedby="basic-addon2" /></td>
								</tr>
								<tr>
									<td>新密码：</td>
									<td><input name="newpwd" type="password" class="form-control"
										placeholder="新密码" aria-describedby="basic-addon2" /></td>
								</tr>
								<tr>
									<td>确认密码：</td>
									<td><input name="rnewpwd" type="password" class="form-control"
										placeholder="确认密码" aria-describedby="basic-addon2" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="submit"
										class="btn btn-primary btn-sm" /></td>
								</tr>
							</tbody>
						</table>
					</form>
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

		//    添加编辑模态框
		$('#add').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			var modal = $(this)
			modal.find('.modal-title').text('' + recipient)
			modal.find('.modal-body input').val(recipient)
		})
	</script>
</body>
</html>
