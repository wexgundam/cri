<%--
  Created by IntelliJ IDEA.
  User: luxinzhu
  Date: 2019/8/23
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/taglib.jsp" %>

<head>
    <title>既有信息化项目</title>
</head>
<body>
<div class="table-responsive">
<table class="searchTable">
    <tr>
        <td>既有信息系统名称：</td>
        <td><input type="text" id="txtExistingProjectname" class="form-control input-middle"
                   placeholder=""
                   value="${existingProjectSearchVO.name}"></td>
        <td>
            <button class="btn btn-primary" id="btnSearch">
                <i class="ace-icon fa fa-search"></i> 查询
            </button>
            <c:if test="${critc:isP('ExistingProjectAdd')}">
                <button type="button" class="btn btn-success" id="btnAdd">
                    <i class=" fa fa-plus bigger-110"></i> 新增
                </button>
            </c:if>
        </td>
    </tr>
</table>
</div>

<div class="col-md-12">
    <table id="treeTable" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th width=60>#</th>
            //<th >角色名称</th>
            //<th>描述</th>
            //<th >上次修改人</th>
            //<th width=160>上次修改时间</th>

            <th >既有信息系统</th>
            <th>建设单位</th>
            <th >操作</th>
        </tr>
        </thead>
    </table>
</div>

</body>

<critc-script>
    <script type="text/javascript">
        $(function () {
            $("#btnSearch").bind('click', searchExistingProject);
            $("#btnAdd").bind('click', addExistingProject);
        })

        // 查询方法
        var searchExistingProject = function () {
            var url = "index.htm?";
            if ($("#txtExistingProjectname").val() != '')
                url += "&name=" + $("#txtExistingProjectname").val();
            window.location = encodeURI(url);
        }

        //新增
        var addExistingProject = function (id) {
            window.location = 'toAdd.htm?backUrl=${backUrl }';
        }

    </script>
</critc-script>
