<%--
  Created by IntelliJ IDEA.
  User: 卢薪竹
  Date: 2019/8/30
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@include file="../../common/taglib.jsp" %>
<head>
    <title>既有信息系统</title>
    <critc-css>
        <link rel="stylesheet" href="${staticServer}/assets/cropper3.0/cropper.min.css"/>
        <link rel="stylesheet" href="${staticServer}/assets/cropper3.0/main.css"/>
        <link href="${staticServer }/assets/zTree3.5/css/zTreeStyle/metro.css" rel="stylesheet" type="text/css"/>
    </critc-css>
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
                    <td><input type="text" id="ExistingProjectname" class="form-control input-middle"
                               placeholder=""
                               value="${ExistingProjectSearchVO.name }"></td>
                    <td>
                        <button class="btn btn-primary" id="btnSearch">
                            <i class="ace-icon fa fa-search"></i> 查询
                        </button>
                        <c:if test="${critc:isP('ExistingProjectAdd')}">
                            <button type="button" class="btn btn-success" id="btnAdd">
                                <i class="fa fa-plus bigger-110"></i> 新增
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
                <%--<th width=60>#</th>--%>
                <th>系统名称</th>
                <%--<th>更名后系统名称</th>--%>
                <th>归属信息系统名称</th>
                <th>项目类型</th>
                <th>项目进度</th>
                <th>通过评审的网络安全定级</th>
                <th>建设单位</th>
                <th>创建人实名</th>
                <th>最后修改人</th>
                <th>最后修改时间</th>
                    <th>归属目录</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="existingProject" varStatus="st">
                <tr>
                    <td><a href="../railwayinformationsystem/datalist.htm?id=${existingProject.risId}" target="_blank">${existingProject.name}</a></td>
                    <td id="row${existingProject.id}">${existingProject.risName}</td>
                    <td>${existingProject.projectTypeName}</td>
                    <td>${existingProject.projectProgressName}</td>
                    <td>${existingProject.reviewPassedCpc}</td>
                    <td>${existingProject.constructionDepartmentName}</td>
                    <td>${existingProject.creatorRealName}</td>
                    <td>${existingProject.lastEditorRealName }</td>
                    <td><fmt:formatDate value="${existingProject.lastEditedAt}" pattern="yyyy-MM-dd HH:mm"/></td>
                    <td>
                        <button class="btn btn-primary" id="btnAttach"
                                onclick="javascript:getZtree(${existingProject.id})"
                                type="button">归属
                        </button>
                    </td>
                    <td>
                        <%--id为400之前为总体目录，400之后为信息系统--%>
                        <c:if test="${existingProject.risId < 200}">
                            <button class="btn btn-primary" id="btnimport${existingProject.id}"
                                    onclick="javascript:importData(${existingProject.id})"
                                    type="button">导入
                            </button>
                        </c:if>
                        <c:if test="${existingProject.deletable eq 1 && critc:isP('ExistingProjectDelete')}">
                        <a href="javascript:delExistingProject(${existingProject.id});">删除</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-12">${pageNavigate.pageModel}</div>
</div>
<div class="modal fade" id="risList" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">选择归属既有信息系统</h4>
            </div>

            <div class="modal-body">
                <div>
                    <ul id="tree" class="ztree" style="width: 560px; overflow: auto;"></ul>
                </div>
                <div class="row">
                        <label class="col-md-4 control-label">是否修改项目名称:</label>
                        <div class="col-md-6">
                            <input id="name" name="name" type="text" class="form-control"
                                placeholder="" value="" maxlength="20"> <label id="nameTip"></label>
                        </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="javascript:getSelected();">归档</button>
            </div>
        </div>
    </div>
</div>
</body>
<critc-script>
    <script src="${staticServer}/assets/cropper3.0/cropper.min.js"></script>
    <script src="${staticServer}/assets/cropper3.0/main.js"></script>
    <script src="${staticServer }/assets/zTree3.5/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("#btnSearch").bind('click', searchModule);
            $("#btnAdd").bind('click', addExistingProject);
        })
        function getZtree(id){
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
            var zNodes = [${ztree}];
            jQuery(document).ready(function () {
                var t = $("#tree");
                t = $.fn.zTree.init(t, setting, zNodes);
                var zTree = $.fn.zTree.getZTreeObj("tree");
            });
            $('#risList').modal('show');
            $('#risList')[0].contentdata = id;
        }
        function getSelected() {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getSelectedNodes();
            var id = $('#risList')[0].contentdata;
            if (nodes.length > 0) {
                $("#row"+id)[0].contentid = nodes[0].id;
                $("#row"+id)[0].contentname = nodes[0].name;
                $('#risList').modal('hide');
                // 更新所属信息化名称
                $.ajax({
                    type : 'POST',
                    url : 'updateData.htm',
                    dataType : 'json',
                    data : {
                        no:$('#risList')[0].contentdata,
                        riopiId: $("#row"+id)[0].contentid||0,
                        riopiName:$("#row"+id)[0].contentname||''
                    },
                    success : function(result) {
                        //  按钮修改成已导入

                        return;
                    },
                    failure:function(){
                        //按钮不变
                    }
                });
            }
            else return;
        }

        // 查询方法
        var searchModule = function () {
            var url = "index.htm?";
            if ($("#txtExistingProjectname").val() != '')
                url += "&name=" + $("#ExistingProjectname").val();
            window.location = encodeURI(url);
        }
        //新增
        var addExistingProject= function () {
            window.location = 'toAdd.htm?backUrl=${backUrl}';
        }
        // 删除
        var delExistingProject = function (id) {
            bootbox.confirm("你确定要删除该既有项目吗？", function (result) {
                if (result) {
                    window.location = "delete.htm?id=" + id + "&backUrl=${backUrl}";
                }
            })
        }
        //导入数据
        var  importData = function (id) {
            $.ajax({
                type : 'POST',
                url : 'importData.htm',
                dataType : 'json',
                data : {
                    no:id,
                    riopiId: $("#row"+id)[0].contentid||0,
                    riopiName:$("#row"+id)[0].contentname||''
                },
                success : function(result) {
                 //  按钮修改成已导入
                    var result =result;
                    if(result == 1){
                     $('#btnimport'+id).innerHTML = '已导入';
                    }
                    return;
                },
                failure:function(){
                 //按钮不变
                }
            });
        }
    </script>
</critc-script>

