<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<title>登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/script/jquery-2.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/script/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/script/common.js"></script>
<script type="text/javascript">
	$(function() {
		$("#login").on('click', function() {
			$("#loginForm").validate({
				rules : {
					username : {
						required : true
					},
					password: {
						required : true
					}
				},
				submitHandler : function() {
					$.ajax({
						url : "${pageContext.request.contextPath}/employee/login",
						type : "POST",
						data : JSON.stringify($("#loginForm").serializeObject()),
						contentType : "application/json;charset=utf-8",
						dataType : "json",
						success : function(data) {
							if(data.status == "error"){
								alert(data.msg);
							}else{
								window.location.href = "${pageContext.request.contextPath}";
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
	<div style="padding: 30px;">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<form id="loginForm">
							<div class="form-group">
								<label for="username">用户名</label> <input type="text"
									class="form-control" name="username" id="username" placeholder="">
							</div>
							<div class="form-group">
								<label for="password">密码</label> <input type="password"
									class="form-control" name="password" id="password" placeholder="">
							</div>
							<button type="submit" class="btn btn-default" id="login" style="width:100%;">登录</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
