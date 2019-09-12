<%--
  Created by IntelliJ IDEA.
  User: DJF
  Date: 2019/8/30
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/taglib.jsp" %>

<head>
    <title>既有信息系统</title>
</head>
<body>
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
                    <td>既有信息系统名称：</td>
                    <td><input type="text" id="txtExistingProjectname" class="form-control input-middle"
                               placeholder=""
                               value="${ExistingProjectSearchVO.name }"></td>
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
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <table id="treeTable" class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th width=60>#</th>
                <th >既有信息系统名称</th>
                <th>归属信息系统名称</th>
                <th>建设单位名称</th>
                <th >上次修改人</th>
                <th width=160>上次修改时间</th>
                <th >操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="existingProject" varStatus="st">
                <tr>
                    <td>${st.index+1 }</td>
                    <td>${existingProject.name} </td>
                    <td>${existingProject.risName}</td>
                    <td>${existingProject.constructionDepartmentName}</td>
                    <td>${existingProject.lastEditorRealName }</td>
                    <th width=120><fmt:formatDate value="${existingProject.lastEditedAt}" pattern="yyyy-MM-dd HH:mm"/></th>
                    <td><c:if test="${critc:isP('ExistingProjectUpdate')}">
                        <a href="toUpdate.htm?id=${existingProject.id }&backUrl=${backUrl}"> 修改 </a>
                        </c:if>
                        <c:if test="${existingProject.deletable eq 1 && critc:isP('ExistingProjectDelete')}">
                        <a href="javascript:delExistingProject(${existingProject.id });"> 删除 </a>
                        </c:if>
                    </td>
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
        var addExistingProject= function () {
            window.location = 'toAdd.htm?backUrl=${backUrl }';
        }
        // 删除
        var delExistingProject = function (id) {
            bootbox.confirm("你确定要删除该既有项目吗？", function (result) {
                if (result) {
                    window.location = "delete.htm?id=" + id + "&backUrl=${backUrl}";
                }
            })
        }
    </script>
</critc-script>

