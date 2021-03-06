<%--
  Created by IntelliJ IDEA.
  User: 卢薪竹
  Date: 2019/9/2
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<head>
    <title>既有信息化项目添加</title>
</head>
<critc-css>
    <link rel="stylesheet" href="${staticServer}/assets/cropper3.0/cropper.min.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/cropper3.0/main.css"/>
    <link href="${staticServer }/assets/zTree3.5/css/zTreeStyle/metro.css" rel="stylesheet" type="text/css"/>
</critc-css>
<body>
<div class="row">
    <div class="col-md-10">
        <form role="form" id="roleForm" name="roleForm" class="form-horizontal"
              action="add.htm" method="post">
            <input type="hidden" name="backUrl" value="${backUrl}"><input
                type="hidden" id="moduleArr" name="moduleArr" value="">
            <input type="hidden" name="functionArr" id="functionArr" value="">
            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-3 control-label">系统名称：</label>
                    <div class="col-md-9">
                        <input id="name" name="name" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="nameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">归属信息化总体规划目录：</label>
                    <div class="col-md-9">
                        <div class="input-group input-xlarge">
                            <input type="hidden" id="risId" name="risId"
                                   class="form-control" value="${existingProject.risId}"/>
                            <input type="text" id="risName" name="risName"
                                   readonly="readonly"
                                   class="form-control"
                                   placeholder="" value="${existingProject.risName}"/>
                            <span class="input-group-btn">
                                    <button class="btn btn-primary" id="choice"
                                                    onclick="javascript:getZtreeRis()"
                                                    type="button"><i class="fa fa-search"/></i>选择
                                    </button>
                            </span>
                        </div>
                        <label id="risNameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">项目类型：</label>
                    <div class="col-md-9">
                        <form:select path="existingProject.projectTypeCode"
                                     class="form-control input-inline  input-xlarge" name="projectTypeCode"
                                     id="type">
                            <option value="">请选择项目类型</option>
                            <form:options items="${listProjectType}" itemValue="code"
                                          itemLabel="name"  data="${listProjectType}"/>
                        </form:select>
                        <label id="projectTypeCodeTip"></label>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">项目进度：</label>
                    <div class="col-md-9">
                        <form:select path="existingProject.projectProgressCode"
                                     class="form-control input-inline  input-xlarge" name="projectProgressCode"
                                     id="type">
                            <option value="">请选择项目进度</option>
                            <form:options items="${listProjectProgress}" itemValue="code"
                                          itemLabel="name" />
                        </form:select>
                    </div>
                    <label id="projectProgressNameTip"></label>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">通过评审的网络安全等级定级：</label>
                    <div class="col-md-9">
                        <form:select path="existingProject.reviewPassedCpc"
                                     class="form-control input-inline  input-xlarge" name="reviewPassedCpc"
                                     id="type">
                            <option value="">请确定网络安全等级</option>
                            <form:options items="${listNetworkSecurity}" itemValue="name"
                                          itemLabel="name" />
                        </form:select>
                    </div>
                    <label id="reviewPassedCpcTip"></label>
                </div>
                <div class="form-group" id="constructionDepartmentList">
                    <label class="col-md-3 control-label">建设单位：</label>
                    <div class="col-md-9">
                        <div class="input-group input-xlarge">
                            <input type="hidden" id="constructionDepartmentId" name="constructionDepartmentId"
                                   class="form-control" value="${sysUser.departmentId}"/>
                            <input type="text" id="constructionDepartmentName" name="constructionDepartmentName"
                                   readonly="readonly"
                                   class="form-control"
                                   placeholder="" value="${sysUser.departmentName}"/>
                            <span class="input-group-btn">
                                            <button class="btn btn-primary" id="choiceConstructionDepartment"
                                                    onclick="javascript:getZtreeConstructionDepartment()"
                                                    type="button"><i class="fa fa-search"/></i>选择
                                            </button>
                            </span>
                        </div>
                    </div>
                    <label id="constructionDepartmentTip"></label>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label class="col-md-2 control-label">创建人ID：</label>--%>
                    <%--<div class="col-md-10">--%>
                        <%--<input id="creatorId" name="creatorId" type="text" class="form-control input-inline  input-xlarge"--%>
                               <%--placeholder=""--%>
                               <%--value="" maxlength="20"> <label id="creatorIdTip"></label>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label class="col-md-2 control-label">创建人实名：</label>--%>
                    <%--<div class="col-md-10">--%>
                        <%--<input id="creatorRealName" name="creatorRealName" type="text" class="form-control input-inline  input-xlarge"--%>
                               <%--placeholder=""--%>
                               <%--value="" maxlength="20"> <label id="creatorRealNameTip"></label>--%>
                    <%--</div>--%>
                <%--</div>--%>
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
            </div>
        </form>
    </div>
</div>
<div class="modal fade" id="risList" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">选择归属既有信息系统</h4>
            </div>
            <div class="modal-body">
                <ul id="treeRis" class="ztree" style="width: 560px; overflow: auto;"></ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="javascript:getSelectedRis();">确认</button>
                <button type="button" class="btn " data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="constDepartmentList" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">选择建设单位</h4>
            </div>
            <div class="modal-body">
                <ul id="treeConstructionDepartment" class="ztree" style="width: 560px; overflow: auto;"></ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="javascript:getSelectedConstructionDepartment();">确认</button>
                <button type="button" class="btn " data-dismiss="modal">取消</button>
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
        function getZtreeRis(){
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
            var zNodes = [${ztreeRis}];
            jQuery(document).ready(function () {
                var t = $("#treeRis");
                t = $.fn.zTree.init(t, setting, zNodes);
                var zTree = $.fn.zTree.getZTreeObj("treeRis");
            });
            $('#risList').modal('show');
        }
        function getZtreeConstructionDepartment(){
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
            var zNodes = [${ztreeConstructionDepartment}];
            jQuery(document).ready(function () {
                var t = $("#treeConstructionDepartment");
                t = $.fn.zTree.init(t, setting, zNodes);
                var zTree = $.fn.zTree.getZTreeObj("treeConstructionDepartment");
            });
            $('#constDepartmentList').modal('show');
        }

        function getSelectedRis() {
            var treeObj = $.fn.zTree.getZTreeObj("treeRis");
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                $("#risId").val(nodes[0].id);
                $("#risName").val(nodes[0].name);
                $('#risList').modal('hide');
            }
            else return;
        }
        function getSelectedConstructionDepartment() {
            var treeObj = $.fn.zTree.getZTreeObj("treeConstructionDepartment");
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                $("#constructionDepartmentId").val(nodes[0].id);
                $("#constructionDepartmentName").val(nodes[0].name);
                $('#constDepartmentList').modal('hide');
            }
            else return;
        }
    </script>
</critc-script>

