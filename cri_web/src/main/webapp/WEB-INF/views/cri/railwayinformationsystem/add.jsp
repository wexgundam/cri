<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../common/taglib.jsp"%>

<head>
	<title>铁路信息系统</title>
	<critc-css>
		<link href="${staticServer }/assets/zTree3.5/css/zTreeStyle/metro.css"
			  rel="stylesheet" type="text/css" />
	</critc-css>
</head>

<body>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li><i class="fa fa-home"></i> <a
				href="${dynamicServer}/index.htm">首页</a></li>
		<li>>应用系统</li>
		<li>>铁路信息系统</li>
	</ul>
</div>
<h1 class="page-title">
	铁路信息系统 <small>>>新增系统</small>
</h1>

<div class="row">
	<div class="col-md-10">
		<form role="form" id="departmentForm" name="departmentForm"
			  class="form-horizontal" action="add.htm" method="post">
			<input type="hidden" name="backUrl" value="${backUrl }">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-3 control-label">铁路信息系统名称：</label>
					<div class="col-md-9">
						<input id="name" name="name" type="text"
							   class="form-control input-inline  input-xlarge" placeholder=""
							   value="" maxlength="20"> <label id="nameTip"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">归属信息化总体规划目录名称：</label>
					<div class="col-md-9">
						<div class="input-group input-xlarge">
							<input type="hidden" id="RIOPI_ID" name="RIOPI_ID"
								   class="form-control" value="${railwayInformationSystem.RIOPI_ID}"/>
							<input id="RIOPI_NAME" type="text" name="RIOPI_NAME"
								   readonly="readonly"
								   class="form-control  "
								   placeholder="" value="${railwayInformationSystem.RIOPI_NAME}"/>
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
					<label class="col-md-3 control-label">排序：</label>
					<div class="col-md-9">
						<input id="ORDER_INDEX" name="ORDER_INDEX" type="text"
							   class="form-control input-inline  input-xlarge" placeholder=""
							   value="" maxlength="20"> <label id="ORDER_INDEXTip"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">项目类型：</label>
					<div class="col-md-10">
						<form:select path="railway.projectTypeCode"
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
					<label class="col-md-2 control-label">项目进度：</label>
					<div class="col-md-10">
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
					<label class="col-md-2 control-label">通过评审的网络安全等级定级：</label>
					<div class="col-md-10">
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
					<label class="col-md-2 control-label">建设单位：</label>
					<div class="col-md-9">
						<div class="input-group input-medium">
							<input type="hidden" id="constructionDepartmentId" name="constructionDepartmentId"
								   class="form-control" value="${sysUser.departmentId}"/>
							<input type="text" id="constructionDepartmentName" name="constructionDepartmentName"
								   readonly="readonly"
								   class="form-control  "
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
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" class="btn btn-primary">
							<i class="fa fa-save" /></i> 保存
						</button>
						<button type="button" class="btn default"
								onclick="history.back(-1)">
							<i class="fa fa-undo" /></i> 取消
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
            });
            $('#systemcontentList').modal('show');
        }

        function getSelected() {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                $("#RIOPI_ID").val(nodes[0].id);
                $("#RIOPI_NAME").val(nodes[0].name);
                $('#systemcontentList').modal('hide');
            }
            else return;

        }

	</script>
</critc-script>