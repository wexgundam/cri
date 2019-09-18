<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../../common/taglib.jsp"%>
<head>
    <title>铁路信息系统</title>
    <critc-css>
        <link
                href="${staticServer}/assets/treetable/treeTable.min.css?version=${versionNo}"
                rel="stylesheet" type="text/css" />
    </critc-css>
</head>

<body>
<!-- BEGIN PAGE BAR -->
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li><i class="fa fa-home"></i> <a
                href="${dynamicServer}/index.htm">首页</a></li>
        <li>>应用系统</li>
        <li>>铁路信息系统</li>
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

                    <td>铁路信息系统名称：</td>
                    <td><input type="text" id="txtSysname" class="form-control "
                               placeholder=""
                               value="${railwayInformationSystemSearchVO.name}"></td>

                    <td>归属信息化总体规划目录名称：</td>
                    <td>
                        <form:select path="railwayInformationSystemSearchVO.riopiName" class="form-control input-medium"
                                     id="listContentId">
                            <form:option value="" label="--全部--"/>
                            <form:options items="${listContent}" itemValue="content" itemLabel="content"/>
                        </form:select></td>
                    </td>
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
                <th width=200>铁路信息系统名称</th>
                <th width=200>归属信息化总体规划目录主键</th>
                <th width=200>归属信息化总体规划目录名称</th>
                <th width=80>排序</th>
                <th width=100>创建人ID</th>
                <th width=100>创建人实名</th>
                <th width=100>创建时间</th>
                <th width="160">最后修改人ID</th>
                <th width=100>最后修改人实名</th>
                <th width=160>最后修改时间</th>
                <th width="241">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="systeminfo" varStatus="st">
                <tr id="${systeminfo.id}">
                    <td>${systeminfo.name}</td>
                    <td>${systeminfo.RIOPI_ID}</td>
                    <td>${systeminfo.RIOPI_NAME}</td>
                    <td>${systeminfo.ORDER_INDEX}</td>
                    <td>${systeminfo.CREATOR_ID}</td>
                    <td>${systeminfo.CREATOR_REAL_NAME}</td>
                    <td>${systeminfo.CREATED_AT}</td>
                    <td>${systeminfo.LAST_EDITOR_ID}</td>
                    <td>${systeminfo.LAST_EDITOR_REAL_NAME}</td>
                    <td>${systeminfo.LAST_EDITED_AT}</td>

                    <td>
                        <a href="toUpdate.htm?id=${systeminfo.id}&backUrl=${backUrl}">
                            修改</i>
                        </a>
                        <a href="javascript:delModule(${systeminfo.id });"> 删除 </a>
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
<critc-script> <script
        src="${staticServer }/assets/treetable/jquery.treeTable.min.js"
        type="text/javascript"></script> <script type="text/javascript">
    var selDepartmentId = 0;//定义选择的selDepartmentId
    $(function () {
        $("#btnSearch").bind('click', searchModule);
        $("#btnAdd").bind('click', addSystemInfo);
        $("#importUser").bind('click', importUser);
        $("#outportUser").bind('click', outportUser);
    })

    // 查询方法
    var searchModule = function () {
        var url = "index.htm?";
        if ($("#txtSysname").val() != '')
        {
            url += "&name=" + $("#txtSysname").val();
        }
        if ($("#listContentId").val() != '')
        {
            url += "&riopiName=" + $("#listContentId").val();
        }

        window.location = encodeURI(url);
    }
    // 删除
    var delModule = function (id) {
        debugger;
        bootbox.confirm("你确定要删除该机构吗？", function (result) {
            if(result){
                window.location = "delete.htm?id=" + id + "&backUrl=${backUrl}";
            }
        })
    }
    //新增
    var addSystemInfo = function (id) {
        window.location = 'toAdd.htm?backUrl=${backUrl }';
    }
    //导入
    var importUser = function () {

    }
    //导出
    var outportUser = function () {

    }
</script> </critc-script>