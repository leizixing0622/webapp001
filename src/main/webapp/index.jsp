<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<title>主页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugin/msgbox/msgbox.css">
<script
	src="${pageContext.request.contextPath}/script/jquery-2.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/script/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/script/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/msgbox/msgbox.js"></script>
<script>
	function changeIFrame(e) {
		var url = $(e).attr("data-url");
		$("#mainIFrame").attr("src", url);
	}
	function iframeLoad() {
		document.getElementById("mainIFrame").height = 0;
		document.getElementById("mainIFrame").height = document
				.getElementById("mainIFrame").contentWindow.document.body.scrollHeight;
	}
	function showMsgBox(text, type) {
		ZENG.msgbox.show(text, type, 1500);
	}
</script>
<style>
li {
	cursor: pointer;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default" style="margin: 0px;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a onclick="changeIFrame(this)"
						data-url="${pageContext.request.contextPath}/department/list">部门列表<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">人力资源部<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a onclick="changeIFrame(this)"
								data-url="${pageContext.request.contextPath}/department/list">部门管理</a></li>
							<li><a onclick="changeIFrame(this)"
								data-url="${pageContext.request.contextPath}/employee/list">员工管理</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">欢迎您: ${sessionScope.existEmployee.ename}<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/employee/loginPage">登录</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div id="mainContent" style="padding: 30px;">
		<div class="panel panel-default">
			<div class="panel-body" style="min-height: 90%">
				<iframe onload="iframeLoad()" id="mainIFrame" frameborder="no"
					border="0" src="" style="width: 100%;"></iframe>
			</div>
		</div>
	</div>
</body>
</html>
