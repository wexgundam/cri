<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>

<head>
    <title>铁路信息化总体规划目录</title>
</head>

<body>
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li><i class="fa fa-home"></i> <a
                href="${dynamicServer}/index.htm">首页</a></li>
        <li>>系统管理</li>
        <li>>铁路信息化总体规划目录</li>
    </ul>
</div>
<div class="portlet box blue">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-cogs"></i>操作面板
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"> </a>
        </div>
    </div>
    <div class="portlet-body">
        <div class="table-responsive">
            <table class="searchTable">
                <tr>
                    <td>系统名称：</td>
                    <td><input type="text" id="name" class="form-control input-small"
                               placeholder=""
                               value="${riopiSearchVO.name}"></td>
                    <%--<td>版本号：</td>
                    <td><input type="text" id="version" class="form-control input-middle"--%>
                               <%--placeholder=""--%>
                               <%--value="${sysReleaseSearchVO.version }"></td>--%>

                    <%--&lt;%&ndash; <td>发布日期：</td>--%>
                    <%--<td><input type="text" id="releaseDate" class="form-control input-middle"--%>
                               <%--placeholder=""--%>
                               <%--value="${sysReleaseSearchVO.releaseDate }"></td> &ndash;%&gt;--%>

                    <%--<td>发布人：</td>--%>
                    <%--<td><input type="text" id="releaseBy"  class="form-control input-middle"--%>
                               <%--placeholder=""--%>
                               <%--value="${sysReleaseSearchVO.releaseBy }"></td>--%>
                </tr>
            </table>
            <hr class="divider-vertical"/>
            <div>
                <button class="btn btn-primary" id="btnSearch">
                    <i class="ace-icon fa fa-search"></i> 查询
                </button>
                <c:if test="${critc:isP('SysUserAdd')}">
                    <button type="button" class="btn btn-success" id="btnAdd">
                        <i class=" fa fa-plus bigger-110"></i> 新增
                    </button>
                </c:if>

                <button class="btn btn-file" id="importUser">
                    <i class="fa fa-cloud-upload"></i> 导入
                </button>
                <button class="btn btn-file" id="outportUser">
                    <i class="fa fa-cloud-download"></i> 导出
                </button>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <table id="treeTable"
               class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th width=200>名称</th>
                <th width=100>上级目录</th>
                <th width=120>业务管理部门主键</th>
                <th width=80>业务管理部门名称</th>
                <th width=100>排序</th>
                <th width=100>备注</th>
                <th width="241">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="riopi" varStatus="st">
                <tr id="${riopi.id}" pId="${riopi.parentId}">
                    <td>${riopi.name}</td>
                    <td>${riopi.parentId}</td>
                    <td>${riopi.bmDepartmentId}</td>
                    <td>${riopi.bmDepartmentName}</td>
                    <td>${riopi.displayOrder}</td>
                    <td>${riopi.note}</td>
                    <td><c:if test="${critc:isP('SysDepartmentUpdate')}">
                        <a href="toUpdate.htm?id=${riopi.id}&backUrl=${backUrl}">
                            修改</i>
                        </a>
                    </c:if> <c:if test="${critc:isP('SysDepartmentDelete')}">
                        <a href="javascript:delModule(${riopi.id });"> 删除 </a>
                    </c:if></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-12">${ pageNavigate.pageModel}</div>
</div>

</body>
<critc-script>
    <script type="text/javascript">
        $(function () {
            $("#btnSearch").bind('click', searchRole);
            $("#btnAdd").bind('click', addRole);
        })

        // 查询方法
        var searchRole = function () {
            var url = "index.htm?";
            if ($("#name").val() != '')
                url += "&name=" + $("#name").val();
            window.location = encodeURI(url);
        }
        // 删除
        var delModule = function (id) {
            bootbox.confirm("你确定要删除该目录吗？", function (result) {
                if (result) {
                    window.location = "delete.htm?id=" + id + "&backUrl=${backUrl}";
                }
            })
        }
        //新增
        var addRole = function (id) {
            window.location = 'toAdd.htm?backUrl=${backUrl }';
        }

    </script>
</critc-script>