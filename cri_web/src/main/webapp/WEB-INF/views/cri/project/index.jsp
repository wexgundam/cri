<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../../common/taglib.jsp"%>
<head>
    <title>铁路信息系统</title>
    <critc-css>
        <link
                href="${staticServer}/assets/treetable/treeTable.min.css?version=${versionNo}"
                rel="stylesheet" type="text/css" />
        <link href="${staticServer }/assets/zTree3.5/css/zTreeStyle/metro.css"
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

                    <td>项目名称：</td>
                    <td><input type="text" id="txtSysname" class="form-control "
                               placeholder=""
                               value="${projectSearchVO.name}"></td>
                </tr>
            </table>
            <hr class="divider-vertical"/>
            <div>
                <button class="btn btn-primary" id="btnSearch">
                    <i class="ace-icon fa fa-search"></i> 查询
                </button>
                <c:if test="${critc:isP('SysUserAdd')}">
                    <button type="button" class="btn btn-success" id="btnAdd">
                        <i class=" fa fa-plus bigger-110"></i> 新建项目
                    </button>
                </c:if>
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
                <th width=300>项目名称</th>
                <th width=160>项目类型</th>
                <th width=160>项目状态</th>
                <th width=200>项目开始时间</th>
                <th width=200>项目结束时间</th>
                <th width=160>工作项完成度</th>
                <th width=200>项目建设单位</th>
                <th width=200>项目创建人实名</th>
                <th width=100>项目负责人</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="project" varStatus="st">
                <tr id="${project.id}">
                    <td>${project.name}</td>
                    <td>${project.projectTypeName}</td>
                    <td>${project.projectProgressName}</td>
                    <td>${project.projectStartat}</td>
                    <td>${project.projectEndat}</td>
                    <td>${project.projectProgressName}</td>
                    <td>${project.constructionDepartmentName}</td>
                    <td>${project.creatorRealName}</td>
                    <td>${project.leadingPeople}</td>
                    <td>
                        <a href="toUpdate.htm?id=${project.id}&backUrl=${backUrl}">
                            修改</i>
                        </a>
                        <a href="javascript:delModule(${project.id });"> 删除 </a>
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
    <script src="${staticServer }/assets/treetable/jquery.treeTable.min.js" type="text/javascript"></script>
    <script src="${staticServer}/assets/cropper3.0/cropper.min.js"></script>
    <script src="${staticServer}/assets/cropper3.0/main.js"></script>
    <script src="${staticServer }/assets/zTree3.5/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        var selDepartmentId = 0;//定义选择的selDepartmentId

        $(function () {
            $("#btnSearch").bind('click', searchModule);
            $("#btnAdd").bind('click', addSystemInfo);
            $("#outportUser").bind('click', outportUser);
            $("#treeTable").treeTable({
                expandLevel: 1
            });
        })

        // 查询方法
        var searchModule = function () {
            var url = "index.htm?";
            if ($("#txtSysname").val() != '')
            {
                url += "&name=" + $("#txtSysname").val();
            }
            window.location = encodeURI(url);
        }
        // 删除
        var delModule = function (id) {
            debugger;
            bootbox.confirm("你确定要删除该项目吗？", function (result) {
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
        function getZtree() {
            var setting = {
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "pId",
                        rootPId: ""
                    }
                }
            };
            var zNodes = [${zTree}]
            jQuery(document).ready(function () {
                var t = $("#tree");
                t = $.fn.zTree.init(t, setting, zNodes);
            });
            $('#systemcontentList').modal('show');
        }

        function getSelected() {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                $("#RIOPI_ID").val(nodes[0].id);
                $("#RIOPI_NAME").text(nodes[0].name);
                $('#systemcontentList').modal('hide');
                $("#clearNode").remove();
                //设置叉号在上级节点有值才出现
                $("#RIOPI_NAME").append("<i id='clearNode'  class=' fa fa-remove  pull-right' style='margin-top:2px' onclick='clearDepartment()'></i>");

            }
            else return;

        }
        //清空选择部门
        var clearDepartment = function () {
            $("#RIOPI_NAME").text("");
            $("#RIOPI_ID").val("");
            $("#clearNode").remove();
        };

    </script> </critc-script>