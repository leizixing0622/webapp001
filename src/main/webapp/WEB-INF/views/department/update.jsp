<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>department update</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/script/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/script/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/script/common.js"></script>
<script type="text/javascript">
$(function() {
	$("#save").on('click', function() {
		$("#departmentForm").validate({
			rules : {
				dname : {
					required : true
				},
				ddesc: {
					required : true
				}
			},
			submitHandler : function() {
				console.log(JSON.stringify($("#departmentForm").serializeObject()));
				$.ajax({
					url : "${pageContext.request.contextPath}/department/update",
					type : "POST",
					data : JSON.stringify($("#departmentForm").serializeObject()),
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(data) {
						if(data.status == 'success'){
							window.location.href = "${pageContext.request.contextPath}/department/list";
						}else{
							alert(保存失败);
						}
					},
					error : function(data) {
						alert("网络故障");
					}
				});
			}
		});
	});
})
</script>
</head>
<body>
	<div class="row" style="margin:0px;">
		<div class="col-md-12">
			<form id="departmentForm" class="form-horizontal">
				<input type="hidden" name="did" id="did" value="${requestScope.department.did}">
				<div class="row" style="margin-top:15px;">
					<label for="" class="col-md-1 control-label">部门名称</label>
					<div class="col-md-11">
						<input type="text" class="form-control" name="dname" id="dname"
							placeholder="部门名称" value="${requestScope.department.dname}">
					</div>
				</div>
				<div class="row" style="margin-top:15px;">
					<label for="" class="col-md-1 control-label">部门描述</label>
					<div class="col-md-11">
						<textarea class="form-control" rows="3" name="ddesc" id="ddesc" style="resize:none;">${requestScope.department.ddesc}</textarea>
					</div>
				</div>
				<div class="row" style="margin-top:15px;">
					<div class="col-md-12">
						<button id="save" class="btn btn-primary" type="submit" style="float:right;">保存</button>
						<a href="${pageContext.request.contextPath}/department/list" class="btn btn-default" style="float:right;margin-right:15px;">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>