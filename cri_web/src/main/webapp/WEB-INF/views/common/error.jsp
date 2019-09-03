<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="taglib.jsp" %>

<head>
    <title>操作失败 - ${webTitle }</title>
</head>

<body>
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i> <a href="${dynamicServer}/index.htm">首页</a>
        </li>
        <li>
            >操作失败
        </li>
    </ul>
</div>

<div class="alert alert-danger" style="text-align: center; margin-top: 10px;">
    <h4>
        <i class="fa fa-exclamation-circle"></i> ${msg }
    </h4>
    <a href="javascript:void(0)" onclick='history.back(-1);'>返回</a>
</div>
</body>
</html>
