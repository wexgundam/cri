<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../common/taglib.jsp"%>

<head>
	<title>铁路信息系统</title>
	<critc-css>
		<link rel="stylesheet"
			  href="${staticServer}/assets/datetimepicker2.1.9/jquery.datetimepicker.css" />
	</critc-css>
</head>

<body>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li><i class="fa fa-home"></i> <a
				href="${dynamicServer}/index.htm">首页</a></li>
		<li>>应用系统</li>
		<li>>铁路信息化项目台账</li>
	</ul>
</div>
<h1 class="page-title">
	铁路信息化项目台账 <small>>>新增项目</small>
</h1>

<div class="row">
	<div class="col-md-10">
		<form role="form" id="projectForm" name="projectForm"
			  class="form-horizontal" action="add.htm" method="post">
			<input type="hidden" name="backUrl" value="${backUrl }">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-3 control-label">项目名称：</label>
					<div class="col-md-9">
						<input id="name" name="name" type="text"
							   class="form-control input-inline  input-xlarge" placeholder=""
							   value="" maxlength="20">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">项目负责人：</label>
					<div class="col-md-9">
						<input id="leadingPeople" name="ORDER_INDEX" type="text"
							   class="form-control input-inline  input-xlarge" placeholder=""
							   value="" maxlength="20">
					</div>
				</div>
				<div class="form-group ">
					<label for="name">项目开始时间*</label>
					<div class="myrow">
						<div class='input-group date' style="width: 14em;" id='startTime'>
							<input type='text' class="timeInput form-control" />
							<span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
					</span>
						</div>
					</div>
				</div>
				<div class="form-group ">
					<label for="name">项目结束时间*</label>
					<div class="myrow">
						<div class='input-group date' style="width: 14em;" id='endTime'>
							<input type='text' class="timeInput form-control" />
							<span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
					</span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">项目状态：</label>
					<div class="col-md-9">
						<label class="radio-inline">
							<input type="radio" name="optionsRadios" id="Nostarted" value="option1">未开始
						</label>
						<label class="radio-inline">
							<input type="radio" name="optionsRadios" id="onGoing" value="option2">进行中
						</label>
						<label class="radio-inline">
							<input type="radio" name="optionsRadios" id="Completed" value="option1">已完成
						</label>
					</div>
				</div>
				<h5 class="page-header"></h5>
				<div class="form-group">
					<div class="col-md-9">
						<label class="checkbox-inline">
							<input type="checkbox" id="inlineCheckbox2" value="option2">继续创建下一个
						</label>
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

	<script src="${staticServer}/assets/datetimepicker2.1.9/jquery.datetimepicker.js"></script>

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