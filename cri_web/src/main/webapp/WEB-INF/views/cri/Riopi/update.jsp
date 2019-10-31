<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>

<head>
    <title>角色管理</title>
    <critc-css>
        <link href="${staticServer}/assets/treetable/treeTable.min.css?version=${versionNo}" rel="stylesheet"
              type="text/css"/>
        <link href="${staticServer }/assets/zTree3.5/css/zTreeStyle/metro.css"
              rel="stylesheet" type="text/css" />
    </critc-css>
</head>

<body class="no-skin">


<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i> <a href="${dynamicServer}/index.htm">首页</a>
        </li>
        <li>
            >系统管理
        </li>
        <li>
            >总体规划目录管理
        </li>
    </ul>
</div>
<h1 class="page-title"> 总体规划目录管理
    <small>>>修改总体规划目录</small>
</h1>


<div class="row">
    <div class="col-md-10">
        <form role="form" id="roleForm" name="roleForm" class="form-horizontal"
              action="update.htm" method="post">
            <input type="hidden" name="backUrl" value="${backUrl }"> <input type="hidden" name="id"
                                                                            value="${riopi.id}"> <input
                type="hidden" id="moduleArr" name="moduleArr" value=""> <input type="hidden" name="functionArr"
                                                                               id="functionArr" value="">
            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-2 control-label">名称：</label>
                    <div class="col-md-10">
                        <input id="name" name="name" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${riopi.name}" maxlength="20"> <label id="nameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">上级目录：</label>
                    <div class="col-md-10">
                        <div class="input-group input-xlarge">
                            <input id="parentId" type="text" name="parentId"
                                   readonly="readonly"
                                   class="form-control  "
                                   placeholder="" value="${riopi.parentId}"/>
                            <span class="input-group-btn">
                                            <button class="btn btn-primary" id="choice"
                                                    onclick="javascript:getZtree()"
                                                    type="button"><i class="fa fa-search"/></i>选择
                                        </button>
                                       </span>
                        </div>
                        <label id="departmentNameTip"></label>
                    </div>
                </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">业务管理部门主键：</label>
                        <div class="col-md-10">
                            <input id="bmDepartmentId" name="bmDepartmentId" type="text" class="form-control input-inline  input-xlarge"
                                   placeholder=""
                                   value="${riopi.bmDepartmentId}" maxlength="20"> <label id="bmDepartmentIdTip"></label>
                        </div>
                    </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">排序：</label>
                    <div class="col-md-10">
                        <input id="displayOrder" name="displayOrder" type="text"
                               class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${riopi.displayOrder}" maxlength="6"> <label id="displayOrderTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">备注：</label>
                    <div class="col-md-10">
                        <textarea rows="5" cols="60" id="description" name="note"  class="form-control input-inline  input-xlarge" maxlength="50">${riopi.note}</textarea>
                        <label id="noteTip"></label>
                    </div>
                </div>
             <div class="form-actions">
                <div class="row">
                    <div class="col-md-offset-2 col-md-9">
                        <button type="submit" class="btn btn-primary"><i class="fa fa-save"/></i> 保存</button>
                        <button type="button" class="btn default" onclick="history.back(-1)"><i
                                class="fa fa-undo"/></i>  取消
                        </button>
                    </div>
                </div>
            </div>  v
        </form>
        
    </div>
</div>
<div class="modal fade" id="systemcontentList" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">选择总体规划目录</h4>
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
</body>

<critc-script>
    <script src="${staticServer }/assets/zTree3.5/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
    <script type="text/javascript">

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
                $("#parentId").val(nodes[0].id);
                //  $("#RIOPI_NAME").val(nodes[0].name);
                $('#systemcontentList').modal('hide');
            }
            else return;

        }
    </script>
</critc-script>