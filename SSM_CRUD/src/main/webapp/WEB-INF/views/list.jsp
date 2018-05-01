<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> <!-- 引入标签库 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!-- Bootstrap -->
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH}/static/js/jquery-3.2.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="containner">
		<!--标题-->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM_CRUD</h1>
			</div>
		</div>
		<!--按钮-->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!--表格数据-->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>#</th>
						<th>empName</th>
						<th>gender</th>
						<th>email</th>
						<th>deptName</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="emp">
						<tr>
							<th>${emp.empId}</th>
							<th>${emp.empName}</th>
							<!-- M则显示男，否则显示女 -->
							<th>${emp.gender=="M"?"男":"女"}</th>
							<th>${emp.email}</th>
							<th>${emp.dept.deptName}</th>
							<th>
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil"></span> 编辑
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span> 删除
								</button>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!--分页信息-->
		<div class="row">
		    <!--分页文字信息-->
			<div class="col-md-6">
				当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total }条记录数
			</div>
			<!--分页条信息-->
			<div class="col-md-6">
				<ul class="pagination">
					<li><a href="${APP_PATH}/emps?pn=1">首页</a></li>
					<!-- 显示上一页 -->
					<c:if test="${pageInfo.hasPreviousPage}">
						<li><a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}">&laquo;</a></li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum }">
							<!-- 页码如果等于当前页码则高亮显示 -->
							<li class="active"><a href="#">${page_Num}</a></li>
						</c:if>
						<c:if test="${page_Num !=pageInfo.pageNum}">
							<li><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
						</c:if>
					</c:forEach>
					<!-- 显示下一页 -->
					<c:if test="${pageInfo.hasNextPage}">
						<li><a href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1}">&raquo;</a></li>
					</c:if>
					<li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>