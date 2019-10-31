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

                    <td>铁路信息系统名称：</td>
                    <td><input type="text" id="txtSysname" class="form-control "
                               placeholder=""
                               value="${railwayInformationSystemSearchVO.name}"></td>

                    <td>归属信息化总体规划名称:</td>
                    <td>
                        <div class="input-group " style=" width: 260px">
                            <input id="RIOPI_ID" type="hidden" name="departmentId"
                                   value="${railwayInformationSystemSearchVO.riopiId}">
                            <div id="nodeDiv" type="text" name="riopiName" readonly="readonly"
                                 class="form-control" value="${railwayInformationSystemSearchVO.riopiName}">
                                <span id="RIOPI_NAME">${railwayInformationSystemSearchVO.riopiName}</span>
                            </div>
                            <span class="input-group-btn"/>
                            <button class="btn btn-default" onclick="javascript:getZtree()"
                                    type="button"><i
                                    class="fa fa-search"/></i>选择
                            </button>
                            </span>
                        </div>
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
                <th width=240>铁路信息系统名称</th>
                <th width=160>项目类型名称</th>
                <th width=160>项目进度名称</th>
                <th width=200>通过评审的需求分析报告</th>
                <th width=200>通过评审的网络安全等级定级</th>
                <th width=200>通过评审的总体技术方案</th>
                <th width=200>通过评审的可行性研究报告</th>
                <th width=120>建设单位名称</th>
                <th width=100>创建人实名</th>
                <th width=100>最后修改人实名</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="systeminfo" varStatus="st">
                <tr id="${systeminfo.id}"  pId="${systeminfo.RIOPI_ID}">
                    <td>${systeminfo.name}</td>
                    <td>${systeminfo.PROJECT_TYPE_NAME}</td>
                    <td>${systeminfo.PROJECT_PROGRESS_NAME}</td>
                    <td>${systeminfo.REVIEW_PASSED_CPC}</td>
                    <td>${systeminfo.REVIEW_PASSED_DAR}</td>
                    <td>${systeminfo.REVIEW_PASSED_TTS}</td>
                    <td>${systeminfo.REVIEW_PASSED_FSR}</td>
                    <td>${systeminfo.CONSTRUCTION_DEPARTMENT_NAME}</td>
                    <td>${systeminfo.CREATOR_REAL_NAME}</td>
                    <td>${systeminfo.LAST_EDITOR_REAL_NAME}</td>
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
<div class="modal fade" id="systemcontentList" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">选择归属信息化总体规划目录名称</h4>
            </div>
            <div class="modal-body">
                <ul id="tree" class="ztree" style="width: 560px; overflow: auto;"></ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="javascript:getSelected();">确认</button>
                <button type="button" class="btn " data-dismiss="modal">取消</button>
            </div>
        </div>
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
        if ($("#RIOPI_NAME").text() != '')
        {
            url += "&riopiName=" + $("#RIOPI_NAME").text();
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