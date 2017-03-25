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
												href="${ctx }/${twoMenu.powerUrl }?loginName=${loginName}"> <i
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
						<li class="active">GoodsManage - select</li>
					</ol>
					<div class="input-group line left">
						<span class="input-group-addon" id="basic-addon2"><span
							class="glyphicon glyphicon-search"></span></span> <input type="text"
							class="form-control" placeholder="输入关键字搜索"
							value="${serachParam }" aria-describedby="basic-addon2">
					</div>
					<select class="form-control line left">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select> <a href="#" class=" btn btn-primary "><span
						class="glyphicon glyphicon-search"></span></a> <a
						href="javascrpt:search()" class=" btn btn-primary "><span
						onclick="search()" class="glyphicon glyphicon-download"></span></a> <br />
					<br />
					<table
						class="table table-bordered table-striped text-center bg-info">
						<thead>
							<tr class="info">
								<th class="text-center">编号</th>
								<th class="text-center">水果名</th>
								<th class="text-center">价格</th>
								<th class="text-center">库存</th>
								<th class="text-center">原产地</th>
								<th class="text-center">进货时间</th>
								<th class="text-center">属性</th>
								<th class="text-center">颜色</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list}" var="f">
								<tr>
									<td>${f.number}</td>
									<td>${f.name}</td>
									<td>${f.price}</td>
									<td>${f.stock}</td>
									<td>${f.place}</td>
									<td>${f.time}</td>
									<td>${f.nature}</td>
									<td>${f.color}</td>
									<td><a href="${ctx }/fruit/edit?number=${f.number}"
										class="btn btn-primary btn-sm" data-toggle="modal"
										data-target="#edit">修改</a> <a
										href="${ctx }/fruit/delete?number=${f.number}"
										class="btn btn-primary btn-sm">删除</a></td>
									<!-- Modal begin-->
									<div class="modal fade" id="edit" tabindex="-1" role="dialog"
										aria-labelledby="edit">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="edit"
														aria-label="Close"></button>
													<h4 class="modal-title" id="myModalLabel1">编辑</h4>
												</div>
												<form action="${ctx }/fruit/edit?number=${f.number}"
													method="post">
													<div class="modal-body">

														<ul>
															<li><label><span>水果名：</span></label> <input
																type="text" value="${f.name }" name="name" /></li>
															<li><label><span>价格 ：</span></label> <input
																type="text" value="${f.price }" name="price" /></li>
															<li><label><span>库存：</span></label> <input
																type="text" value="${f.stock }" name="stock" /></li>
															<li><label><span>原产地：</span></label> <input
																type="text" value="${f.place }" name="place" /></li>
															<li><label><span>进货时间 ：</span></label> <input
																type="text" value="${f.time }" name="time" /></li>
															<li><label><span>属性：</span></label> <input
																type="text" value="${f.nature }" name="nature" /></li>
															<li><label><span>颜色 ：</span></label> <input
																type="text" value="${f.color }" name="color" /></li>
														</ul>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default btn-sm"
															data-dismiss="modal">取消</button>
														<input type="submit" class="btn btn-primary btn-sm"
															value="保存" />
													</div>
												</form>
											</div>
										</div>
									</div>
									<!--Modal end-->
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<ul class="pagination right">
						<li class="disabled"><a href="#" aria-label="Previous"><span
								aria-hidden="true">&laquo;</span></a></li>
						<c:forEach begin="1" end="${page.totalPageNum }" var="pageNum">
							<li class="active"><a name="pagen"
								href="${ctx }/fruit/list?pageNum=${pageNum}">${pageNum}<!-- <span class="sr-only">(current)</span> --></a></li>
						</c:forEach>
						<li><a href="#" aria-label="Next"><span
								aria-hidden="true">&raquo;</span></a></li>
					</ul>
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
