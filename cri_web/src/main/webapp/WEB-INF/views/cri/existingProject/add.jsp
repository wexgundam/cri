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
                    <label class="col-md-2 control-label">既有信息系统名称：</label>
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
                    <label class="col-md-2 control-label">项目类型名称：</label>
                    <div class="col-md-10">
                        <input id="projectTypeName" name="projectTypeName" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="projectTypeNameTip"></label>
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
                        <input id="projectProgressName" name="projectProgressName" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="projectProgressNameTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">通过评审的需求分析报告：</label>
                    <div class="col-md-10">
                        <textarea rows="5" cols="60" id="reviewPassedDar" name="reviewPassedDar"  class="form-control input-inline  input-xlarge" maxlength="50"></textarea>
                        <label id="reviewPassedDarTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">通过评审的网络安全等级定级：</label>
                    <div class="col-md-10">
                        <input id="reviewPassedCpc" name="reviewPassedCpc" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="reviewPassedCpcTip"></label>
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
