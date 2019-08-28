<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<head>
    <title>操作成功 - ${webTitle }</title>
</head>
<body>

<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i> <a href="${dynamicServer}/index.htm">首页</a>
        </li>
        <li>
            >操作成功
        </li>
    </ul>
</div>

<div class="alert alert-block alert-success fade in" style="text-align: center;margin-top: 10px;">
    <h4>
        <i class="fa fa-check-circle"></i> ${msg }
    </h4>
    <a href="${backUrl}">如果你的浏览器没有自动跳转，请点击此链接</a>
    <script type="text/javascript">
        setTimeout(function () {
            location.href = "${backUrl}";
        }, 2000);

    </script>
</div>
</body>
</html>
