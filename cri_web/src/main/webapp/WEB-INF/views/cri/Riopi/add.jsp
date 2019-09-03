<%--
  Created by IntelliJ IDEA.
  User: LXY777
  Date: 2019-08-21
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>

<head>
    <title>角色管理</title>
    <critc-css>
        <link href="${staticServer}/assets/treetable/treeTable.min.css?version=${versionNo}" rel="stylesheet"
              type="text/css"/>
    </critc-css>
</head>

<body>
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
    <small>>>新增目录</small>
</h1>


<div class="row">
    <div class="col-md-10">
        <form role="form" id="roleForm" name="roleForm" class="form-horizontal"
              action="add.htm" method="post">
            <input type="hidden" name="backUrl" value="${backUrl }"><input
                type="hidden" id="moduleArr" name="moduleArr" value="">
            <input type="hidden" name="functionArr" id="functionArr" value="">
            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-2 control-label">名称：</label>
                    <div class="col-md-10">
                        <input id="name" name="name" type="text" class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="20"> <label id="nameTip"></label>
                    </div>
                </div>
                <div class="form-body">
                    <div class="form-group">
                        <label class="col-md-2 control-label">上级目录：</label>
                        <div class="col-md-10">
                            <input id="parentId" name="parentId" type="text" class="form-control input-inline  input-xlarge"
                                   placeholder=""
                                   value="" maxlength="20"> <label id="parentIdTip"></label>
                        </div>
                    </div>
                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-2 control-label">业务管理部门主键：</label>
                            <div class="col-md-10">
                                <input id="bmDepartmentId" name="bmDepartmentId" type="text" class="form-control input-inline  input-xlarge"
                                       placeholder=""
                                       value="" maxlength="20"> <label id="bmDepartmentIdTip"></label>
                            </div>
                        </div>
                        <div class="form-body">
                            <div class="form-group">
                                <label class="col-md-2 control-label">业务管理部门名称：</label>
                                <div class="col-md-10">
                                    <input id="bmDepartmentName" name="bmDepartmentName" type="text" class="form-control input-inline  input-xlarge"
                                           placeholder=""
                                           value="" maxlength="20"> <label id="bmDepartmentNameTip"></label>
                                </div>
                            </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">排序：</label>
                    <div class="col-md-10">
                        <input id="displayOrder" name="displayOrder" type="text"
                               class="form-control input-inline  input-xlarge"
                               placeholder=""
                               value="" maxlength="6"> <label id="displayOrderTip"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">备注：</label>
                    <div class="col-md-10">
                        <textarea rows="5" cols="60" id="note" name="note"  class="form-control input-inline  input-xlarge" maxlength="50"></textarea>
                        <label id="descriptionTip"></label>
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

<critc-script>
    <script src="${staticServer }/assets/treetable/jquery.treeTable.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#treeTable").treeTable({
                expandLevel: 1
            });

            $(".child").click(function () {
                $(this).parent().parent().parent().parent().find(".father").prop("checked", true);
            })
            $(".father").click(function () {  //复选框的选中与撤销

                if($(this).parents("tr").find(".sec").find(".child").val()!=undefined){ 	//叶子结点的选中与撤销
                    if (this.checked) {
                        $(this).parent().parent().parent().find(".child").prop("checked", true);
                    } else {
                        $(this).parent().parent().parent().find(".child").prop("checked", false);
                    }
                }else{    //父级节点的选中与撤销
                    var fatherId = $(this).val();
                    if (this.checked) {
                        var objs = $("#treeTable").find("."+fatherId).find(".father");   //查找所有二级节点
                        for( var i = 0 ;i<objs.length;i++){
                            var secFatherId = objs[i].getAttribute("value");
                            if(secFatherId!=""&&secFatherId!=undefined){        //设置三级节点操作
                                $("#treeTable").find("."+secFatherId).find(".father").prop("checked", true);
                                $("#treeTable").find("."+secFatherId).find(".child").prop("checked", true);
                            }
                        }
                        $("#treeTable").find("."+fatherId).find(".father").prop("checked", true);
                        $("#treeTable").find("."+fatherId).find(".child").prop("checked", true);
                    }else{
                        var objs = $("#treeTable").find("."+fatherId).find(".father");//查找所有二级节点
                        for( var i = 0  ;i<objs.length;i++){
                            var secFatherId = objs[i].getAttribute("value");
                            if(secFatherId!=""&&secFatherId!=undefined){          //设置三级节点操作
                                $("#treeTable").find("."+secFatherId).find(".father").prop("checked", false);
                                $("#treeTable").find("."+secFatherId).find(".child").prop("checked", false);
                            }
                        }
                        $("#treeTable").find("."+fatherId).find(".father").prop("checked", false);
                        $("#treeTable").find("."+fatherId).find(".child").prop("checked", false);
                    }
                }

            })

            //全选/取消全选
            $("#checkAllChange").click(function(){
                if (this.checked == true) {
                    $(".father").each(function() {
                        this.checked = true;
                    });
                    $(".child").each(function() {
                        this.checked = true;
                    });
                }else{
                    $(".father").each(function() {
                        this.checked = false;
                    });
                    $(".child").each(function() {
                        this.checked = false;
                    });
                }
            });

            //监听复选框点击事件，当有没选中时，取消全选
            $(":checkbox").click(function () {
                var flag =  true;
                $("#treeTable").find(':checkbox').each(function(){
                    if(this.id!="checkAllChange"){
                        if (!$(this).prop("checked")) {
                            flag = false;
                            $("#checkAllChange").prop("checked",false);
                        }
                    }
                });
                if(flag){
                    $("#checkAllChange").prop("checked",true);
                }
            })

            $("#roleForm").validate({
                debug: true,
                errorElement: "label",
                errorClass: "valiError",
                errorPlacement: function (error, element) {
                    error.appendTo($("#" + element.attr('id') + "Tip"));
                },
                rules: {
                    name: {
                        required: true,
                        maxlength: 20
                    },
                    description: {
                        maxlength: 50
                    },
                    displayOrder: {
                        number: true,
                        required: true,
                        maxlength: 6
                    }
                },
                messages: {},
                submitHandler: function (form) {
                    //拼接所有选中的module和function
                    var moduleArr = "";
                    $('input:checkbox[name=module]:checked').each(function (i) {
                        moduleArr += $(this).val() + "@@";
                    });
                    $("#moduleArr").val(moduleArr);
                    var functionArr = "";
                    $('input:checkbox[name=function]:checked').each(function (i) {
                        functionArr += $(this).val() + "@@";
                    });
                    $("#functionArr").val(functionArr);

                    form.submit();
                }
            });
        });
    </script>
</critc-script>