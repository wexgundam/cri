<%--
  Created by IntelliJ IDEA.
  User: 卢薪竹
  Date: 2019/9/2
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<html>
<head>
    <title>既有信息化项目添加</title>
</head>
<body>
<div class="row">
    <div class="col-md-10">
        <form role="form" id="roleForm" name="roleForm" class="form-horizontal"
              action="add.htm" method="post">
            <input type="hidden" name="backUrl" value="${backUrl }"><input
                type="hidden" id="moduleArr" name="moduleArr" value="">
            <input type="hidden" name="functionArr" id="functionArr" value="">
            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-2 control-label">系统名称：</label>
                    <div class="col-md-10">
                        <input id="name" name="name" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="nameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">项目类型编码：</label>
                    <div class="col-md-10">
                        <input id="projectTypeCode" name="projectTypeCode" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="projectTypeCodeTip"></label>
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
                               value="" maxlength="20"> <label id="projectProgressCodeTip"></label>
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
                <%--<div class="form-group">--%>
                    <%--<label class="col-md-2 control-label">通过评审的需求分析报告：</label>--%>
                    <%--<div class="col-md-10">--%>
                        <%--<textarea rows="5" cols="60" id="reviewPassedDar" name="reviewPassedDar"  class="form-control input-inline  input-xlarge" maxlength="50"></textarea>--%>
                        <%--<label id="reviewPassedDarTip"></label>--%>
                    <%--</div>--%>
                <%--</div>--%>
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
                               value="" maxlength="20"> <label id="constructionDepartmentIdTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">建设单位名称：</label>
                    <div class="col-md-10">
                        <input id="constructionDepartmentName" name="constructionDepartmentName" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="constructionDepartmentNameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">创建人ID：</label>
                    <div class="col-md-10">
                        <input id="creatorId" name="creatorId" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="creatorIdTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">创建人实名：</label>
                    <div class="col-md-10">
                        <input id="creatorRealName" name="creatorRealName" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="creatorRealNameTip"></label>
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

</body>
</html>
