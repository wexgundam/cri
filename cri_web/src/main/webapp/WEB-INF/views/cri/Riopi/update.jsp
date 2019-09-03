<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>

<head>
    <title>角色管理</title>
    <critc-css>
        <link href="${staticServer}/assets/treetable/treeTable.min.css?version=${versionNo}" rel="stylesheet"
              type="text/css"/>
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
                            <input id="parentId" name="parentId" type="text" class="form-control input-inline  input-xlarge"
                                   placeholder=""
                                   value="${riopi.parentId}" maxlength="20"> <label id="parentIdTip"></label>
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
                 expandLevel: 1,
                
             });
        	

        	 $(".child").click(function () {
        		 var flag= false;
        		 var count=0;       		 
        		 var id = $(this).parent().parent().parent().parent().attr("id"); //function复选框所在tr的id
        		 var pid = $(this).parent().parent().parent().parent().attr("class");//二级节点
        		 var obj = $(this).parent().parent().parent(); //function复选框所在的td
        		 var firstId = $("#"+pid).attr('class');//一级节点
        	      		 
        		 if(this.checked){ 
        			 $("#mod_"+firstId).prop('checked',true); 
        			 $("#mod_"+id).prop('checked',true);
        			 $("#mod_"+pid).prop('checked',true);
        		 }else{
        			 //判断同级function有没有被选中       			
         			var func = obj.find("input[name='function']");
         			 for(var i=0;i<func.length;i++){
         				 var funcId = func[i].getAttribute('value');
         				 if(flag==$("#function_"+funcId).prop('checked')){
         					 count=count+1;         					
         				 }             				
         			 }
         			 
         			//查看三级同级节点状态是否全部未被选中
      				var secFather = $("."+pid); 
      				var count2=1;
      				var flag1= false;
         			for(var i=0;i<secFather.length;i++){   
         				var secId = secFather[i].getAttribute("id");            			
         				if(flag1==$("#mod_"+secId).prop('checked')){
         					count2=count2+1;
         				}
         				                 				
         			}   
         			         			
         			 if(count==func.length){           				         
            			 if(count2==secFather.length){ //设置二级节点动作               				              				   				
               				$("#mod_"+pid).prop('checked',false);              				
               			}
         				$("#mod_"+id).prop('checked',false); //设置三级节点动作                  				
         			 }
        			
        		 }
        		 //设置一级节点动作
        			var flag2= false;
          			var count3=0;
          			var secFather2 = $("."+firstId);             			
          			for(var i=0;i<secFather2.length;i++){   
          				var secId = secFather2[i].getAttribute("id");            			
          				if(flag2==$("#mod_"+secId).prop('checked')){
          					count3=count3+1;
          				}          				                 				
          			}   
          			if(count3==secFather2.length){
    			    	$("#mod_"+firstId).prop('checked',false);
    			     }          		 
            }) 
            $(".father").click(function () {  //复选框的选中与撤销
            	
            	<!--设置联动开始-->
            	//点击子节点，设置父级节点选中
            	var parentId = $(this).parent().parent().parent().attr('class'); //二级节点id   
            	var parentId2 = $("#"+parentId).attr('class');//一级节点
            	
            	if (this.checked) { 
            		 $("#mod_"+parentId).prop('checked',true);
            		 $("#mod_"+parentId2).prop('checked',true);
            	}else{
            		
            		var flag = false; //代表checked没选中
            		var count = 0;
            		var count2 = 0;
            		if(parentId!=0){//判断二级节点
            			var secFather = $("."+parentId);             			
            			for(var i=0;i<secFather.length;i++){   
            				var secId = secFather[i].getAttribute("id");            			
            				if(flag==$("#mod_"+secId).prop('checked')){
            					count=count+1;
            				}           				                 				
            			}              			
            			if(count==secFather.length){ //三级节点全部没有选中               				
               				var secId2 = $("#mod_"+parentId).attr("id");           				
               				$("#"+secId2).prop('checked',false);               				
               			}
            		}  
            		if(parentId2!=0){  //判断一级节点
            			var firstFather = $("."+parentId2);             			
            			for(var i=0;i<firstFather.length;i++){   
            				var secId = firstFather[i].getAttribute("id");            			
            				if(flag==$("#mod_"+secId).prop('checked')){
            					count2=count2+1;
            				}
            				                 				
            			}              			
            			if(count2==firstFather.length){ //二级节点没有选中               				
               				var secId2 = $("#mod_"+parentId2).attr("id");           				
               				$("#"+secId2).prop('checked',false);
               				
               			}
            		}  
            		     
            	}
            	<!--设置联动结束-->
            	
            	
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
             //全选/取消全选的按钮
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
        	 var cancelChecked = function() {
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
            }
        	$(function () { 
        		cancelChecked();
        	})
    		//监听复选框点击事件，当有没选中时，取消全选
        	 $(":checkbox").click(function () {
        		 cancelChecked();
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
            ///设置按钮选中
            ${checkButton}
        });
    </script>
</critc-script>