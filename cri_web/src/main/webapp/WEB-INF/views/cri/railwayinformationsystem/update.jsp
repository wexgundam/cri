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
		铁路信息系统 <small>>>修改系统</small>
	</h1>

	<div class="row">
		<div class="col-md-10">
			<form role="form" id="departmentForm" name="departmentForm"
				class="form-horizontal" action="update.htm?id=${systeminfo.id }"
				method="post">
				<input type="hidden" name="backUrl" value="${backUrl }">
				<div class="form-body">
					<div class="form-group">
						<label class="col-md-3 control-label">名称：</label>
						<div class="col-md-9">
							<input id="name" name="name" type="text"
								class="form-control input-inline  input-xlarge" placeholder=""
								value="${systeminfo.name }" maxlength="20">
								<label id="nameTip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">归属信息化总体规划目录主键：</label>
						<div class="col-md-9">
							<input id="RIOPI_ID" name="RIOPI_ID" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.RIOPI_ID }" maxlength="20">
							<label id="RIOPI_IDTip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">归属信息化总体规划目录名称：</label>
						<div class="col-md-9">
							<input id="RIOPI_NAME" name="name" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.RIOPI_NAME }" maxlength="20">
							<label id="RIOPI_NAMETip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">排序：</label>
						<div class="col-md-9">
							<input id="ORDER_INDEX" name="ORDER_INDEX" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.ORDER_INDEX }" maxlength="20">
							<label id="ORDER_INDEXTip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">创建人ID：</label>
						<div class="col-md-9">
							<input id="CREATOR_ID" name="CREATOR_ID" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.CREATOR_ID }" maxlength="20">
							<label id="CREATOR_IDTip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">创建人实名：</label>
						<div class="col-md-9">
							<input id="CREATOR_REAL_NAME" name="CREATOR_REAL_NAME" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.CREATOR_REAL_NAME }" maxlength="20">
							<label id="CREATOR_REAL_NAMETip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">创建时间：</label>
						<div class="col-md-9">
							<input id="CREATED_AT" name="CREATED_AT" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.CREATED_AT }" maxlength="20">
							<label id="CREATED_ATTip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">最后修改人ID：</label>
						<div class="col-md-9">
							<input id="LAST_EDITOR_ID" name="LAST_EDITOR_ID" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.LAST_EDITOR_ID }" maxlength="20">
							<label id="LAST_EDITOR_IDTip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">最后修改人实名：</label>
						<div class="col-md-9">
							<input id="LAST_EDITOR_REAL_NAME" name="LAST_EDITOR_REAL_NAME" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.LAST_EDITOR_REAL_NAME }" maxlength="20">
							<label id="LAST_EDITOR_REAL_NAMETip"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">最后修改时间：</label>
						<div class="col-md-9">
							<input id="LAST_EDITED_AT" name="LAST_EDITED_AT" type="text"
								   class="form-control input-inline  input-xlarge" placeholder=""
								   value="${systeminfo.LAST_EDITED_AT }" maxlength="20">
							<label id="LAST_EDITED_ATTip"></label>
						</div>
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

</body>
