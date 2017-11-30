<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>department list</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/msgbox/msgbox.css">
<script
	src="${pageContext.request.contextPath}/script/jquery-2.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/script/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/script/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/msgbox/msgbox.js"></script>
<script type="text/javascript">
	function showModal(did){
		$("#myModal").find("#confirm").attr("data-url", "${pageContext.request.contextPath}/department/delete?did=" + did);
		$("#myModal").modal();
	}
	function deleteDept(e){
		var url = $(e).attr("data-url");
		$.ajax({
			url : url,
			type : "GET",
			dataType : "json",
			success : function(data) {
				if(data.status == 'success'){
					parent.showMsgBox("删除成功", 4);
					window.location.href = "${pageContext.request.contextPath}/department/list";
				}else{
					parent.showMsgBox("删除失败", 5);
					window.location.href = "${pageContext.request.contextPath}/department/list";
				}
			},
			error : function(data) {
				alert("网络故障");
			}
		});
	}
</script>
</head>
<body>

	<table class="table table-bordered table-hover">
		<caption>
			员工管理 <a href="${pageContext.request.contextPath}/department/input"
				class="btn btn-default" type="submit" style="float: right;">添加部门</a>
		</caption>
		<thead>
			<tr>
				<th>部门名称</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.pager.datas.size() == 0}">
				<tr>
					<td colspan="2" style="text-align: center;">暂无数据</td>
				</tr>
			</c:if>
			<c:forEach items="${requestScope.pager.datas}" var="i">
				<tr>
					<td>${i.dname}</td>
					<td>
						<a
						href="${pageContext.request.contextPath}/department/updatePage?did=${i.did}"
						type="button" class="btn btn-default btn-sm">编辑</a> 
						<a
						onclick="showModal(${i.did})"
						type="button" class="btn btn-default btn-sm">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>当前第${requestScope.pager.currPageNumber}页，共${requestScope.pager.totalPageNumber}页，总记录数${requestScope.pager.totalRecord}条</p>
	<nav aria-label="Page navigation">
	<ul class="pagination">
		<c:if test="${requestScope.pager.currPageNumber != 1}">
			<li><a href="#">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/department/list?currPage=${requestScope.pager.currPageNumber - 1}">上一页</a></li>
		</c:if>
		<c:if
			test="${requestScope.pager.currPageNumber != requestScope.pager.totalPageNumber}">
			<li><a
				href="${pageContext.request.contextPath}/department/list?currPage=${requestScope.pager.currPageNumber + 1}">下一页</a></li>
			<li><a href="#">尾页</a></li>
		</c:if>
	</ul>
	</nav>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">警告</h4>
				</div>
				<div class="modal-body">你确定要删除吗？</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="confirm" type="button" class="btn btn-primary" onclick="deleteDept(this)">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>