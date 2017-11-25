<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/script/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/jquery.validate.min.js"></script>
    <script type="text/javascript">
        $.fn.serializeObject = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
        $(function () {
            $("#login").on('click', function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/login/goLogin",
                    type: "POST",
                    data: JSON.stringify($("#loginForm").serializeObject()),
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                    },
                    error: function (msg) {
                        console.log(msg);
                    }
                });
                $("#loginForm").validate({
                    rules: {
                        username: {
                            required: true
                        }
                    },
                    submitHandler: function () {

                    }
                });
            });
        })

    </script>
</head>
<body>
<div style="padding:30px;">
    <div class="panel panel-default">
        <div class="panel-body">
            <form id="loginForm">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="">
                </div>
                <div class="form-group">
                    <label for="nickname">昵称</label>
                    <input type="text" class="form-control" name="nickname" id="nickname" placeholder="">
                </div>
                <div class="form-group">
                    <label for="departmentId">部门</label>
                    <input type="text" class="form-control" name="departmentId" id="departmentId" placeholder="">
                </div>
                <div class="form-group">
                    <label for="xxx">xxx</label>
                    <input type="text" class="form-control" name="xxx" id="xxx" placeholder="">
                </div>
                <button type="submit" class="btn btn-default" id="login">login</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
