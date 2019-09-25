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
              action="update.htm?id=${existingProject.id}" method="post">
            <input type="hidden" name="backUrl" value="${backUrl }"><input
                type="hidden" id="moduleArr" name="moduleArr" value="">
            <input type="hidden" name="functionArr" id="functionArr" value="">
            <div class="form-body">
                <div class="form-group">
                    <div class="col-md-10">
                        <label class="col-md-2 control-label">既有信息系统名称：</label>
                        <input id="name" name="name" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.name}" maxlength="20"> <label id="nameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">归属信息化总体规划目录名称：</label>
                    <div class="col-md-9">
                        <div class="input-group input-medium">
                            <input type="text" id="risId" name="risId"
                                   class="form-control" value="${existingProject.risId}"/>
                            <input type="text" id="risName" name="risName"
                                   readonly="readonly"
                                   class="form-control  "
                                   placeholder="" value="${existingProject.risName}"/>
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
                    <label class="col-md-2 control-label">项目类型编码：</label>
                    <div class="col-md-10">
                        <input id="projectTypeCode" name="projectTypeCode" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.projectTypeCode}" maxlength="20"> <label id="projectTypeCodeTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">项目类型：</label>
                    <div class="col-md-10">
                        <form:select path="existingProject.projectTypeName"
                                     class="form-control input-inline  input-xlarge" name="projectTypeName"
                                     id="type">
                            <option value="">请选择项目类型</option>
                            <form:options items="${listProjectType}" itemValue="name"
                                          itemLabel="name" />
                        </form:select>
                        <label id="typeTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">项目进度编码：</label>
                    <div class="col-md-10">
                        <input id="projectProgressCode" name="projectProgressCode" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.projectProgressCode}" maxlength="20"> <label id="projectProgressCodeTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">项目进度名称：</label>
                    <div class="col-md-10">
                        <form:select path="existingProject.projectProgressName"
                                     class="form-control input-inline  input-xlarge" name="projectProgressName"
                                     id="type">
                            <option value="">请选择项目进度</option>
                            <form:options items="${listProjectProgress}" itemValue="name"
                                          itemLabel="name" />
                        </form:select>
                        <label id="typeTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">通过评审的网络安全等级定级：</label>
                    <div class="col-md-10">
                        <form:select path="existingProject.reviewPassedCpc"
                                     class="form-control input-inline  input-xlarge" name="reviewPassedCpc"
                                     id="type">
                            <option value="">请确定网络安全等级</option>
                            <form:options items="${listNetworkSecurity}" itemValue="name"
                                          itemLabel="name" />
                        </form:select>
                        <label id="typeTip"></label>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label">建设单位ID：</label>
                    <div class="col-md-10">
                        <input id="constructionDepartmentId" name="constructionDepartmentId" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.constructionDepartmentId}" maxlength="20"> <label id="constructionDepartmentIdTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">建设单位名称：</label>
                    <div class="col-md-10">
                        <input id="constructionDepartmentName" name="constructionDepartmentName" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.constructionDepartmentName}" maxlength="20"> <label id="constructionDepartmentNameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">创建人ID：</label>
                    <div class="col-md-10">
                        <input id="creatorIndex" name="creatorIndex" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.creatorId}" maxlength="20"> <label id="creatorIndexTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">创建人实名：</label>
                    <div class="col-md-10">
                        <input id="creatorRealName" name="creatorRealName" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="${existingProject.creatorRealName}" maxlength="20"> <label id="creatorRealNameTip"></label>
                    </div>
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
            </div>
        </form>
    </div>
</div>
<div class="modal fade" id="systemcontentList" tabindex="-1" role="basic" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">选择归属既有信息系统</h4>
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
    <script src="${staticServer}/assets/cropper3.0/cropper.min.js"></script>
    <script src="${staticServer}/assets/cropper3.0/main.js"></script>
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
                var zTree = $.fn.zTree.getZTreeObj("tree");
            });
            $('#systemcontentList').modal('show');
        }
        function getSelected() {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                $("#risId").val(nodes[0].id);
                $("#risName").val(nodes[0].name);
                $('#systemcontentList').modal('hide');
            }
            else return;
        }
    </script>
</critc-script>


