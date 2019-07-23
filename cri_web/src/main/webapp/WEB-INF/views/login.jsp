<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>${webTitle}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="Preview page of Metronic Admin Theme #1 for " name="description" />
<meta content="" name="author" />
<link rel="stylesheet"	href="${staticServer}/assets/metronic4.7/global/plugins/font-awesome/css/font-awesome.min.css?versionNo=${versionNo}"	type="text/css" />
<link rel="stylesheet"  href="${staticServer}/assets/metronic4.7/global/plugins/simple-line-icons/simple-line-icons.min.css"  type="text/css"/>
<link rel="stylesheet"  href="${staticServer}/assets/metronic4.7/global/plugins/bootstrap/css/bootstrap.min.css"  type="text/css"/>
<link rel="stylesheet"  href="${staticServer}/assets/metronic4.7/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"  type="text/css"/>
<link rel="stylesheet"	href="${staticServer}/assets/metronic4.7/global/plugins/select2/css/select2.min.css?versionNo=${versionNo}"	type="text/css" />
<link rel="stylesheet"	href="${staticServer}/assets/metronic4.7/global/plugins/select2/css/select2-bootstrap.min.css?versionNo=${versionNo}"	type="text/css" />
<link rel="stylesheet"	href="${staticServer}/assets/metronic4.7/global/css/components.min.css?versionNo=${versionNo}"	type="text/css" />
<link rel="stylesheet"  href="${staticServer}/assets/metronic4.7/global/css/plugins.min.css" type="text/css"/>
<link rel="shortcut icon" href="${staticServer}/assets/metronic4.7/pages/scripts/favicon.ico" />
<style>
.user-login-5 {
	min-height: 100vh
}

.user-login-5 .bs-reset {
	margin: 0;
	padding: 0
}

.user-login-5 .text-right {
	text-align: right
}

.user-login-5 .login-bg {
	background-position: center;
	background-size: cover;
	background-repeat: no-repeat;
	min-height: 100vh
}

.user-login-5 .login-logo {
	position: absolute;
	top: 2.5em;
	left: 2.5em
}

.user-login-5 .login-logo.login-6 {
	left: 80px
}

.user-login-5 .login-container {
	position: relative;
	min-height: 100vh
}

.user-login-5 .login-container .login-copyright, .user-login-5 .login-container .login-social,
	.user-login-5 .login-container>.login-content {
	padding: 0 80px
}

.user-login-5 .login-container>.login-content {
	margin-top: 20%
}

.user-login-5 .login-container>.login-content>h1 {
	font-size: 30px;
	font-weight: 300;
	color: #4e5a64
}

.user-login-5 .login-container>.login-content p {
	color: #a0a9b4;
	font-size: 15px;
	line-height: 22px
}

.user-login-5 .login-container>.login-content>.login-form {
	margin-top: 80px;
	color: #a4aab2;
	font-size: 13px
}

.user-login-5 .login-container>.login-content>.login-form .form-control
	{
	width: 100%;
	padding: 10px 0;
	border: #a0a9b4;
	border-bottom: 1px solid;
	color: #868e97;
	font-size: 14px;
	margin-bottom: 30px;
	border-radius: 0 !important
}

.user-login-5 .login-container>.login-content>.login-form .form-control:focus
	{
	outline: 0
}

.user-login-5 .login-container>.login-content>.login-form .forgot-password,
	.user-login-5 .login-container>.login-content>.login-form .login-button
	{
	display: inline-block
}

.user-login-5 .login-container>.login-content>.login-form .rem-password
	{
	margin-top: 10px
}

.user-login-5 .login-container>.login-content>.login-form .rem-password>p
	{
	margin: 0
}

.user-login-5 .login-container>.login-content>.login-form .rem-password>.rem-checkbox
	{
	border-color: #a4aab2
}

.user-login-5 .login-container>.login-content>.login-form .forgot-password
	{
	margin-right: 1em
}

.user-login-5 .login-container>.login-content>.login-form .forgot-password>a
	{
	color: #a4aab2
}

.user-login-5 .login-container>.login-content>.login-form .forgot-password>a:hover
	{
	color: #337ab7;
	text-decoration: none
}

.user-login-5 .login-container>.login-content>.login-form .forgot-password>a:focus
	{
	color: #a4aab2;
	text-decoration: none
}

.user-login-5 .login-container>.login-footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	padding-bottom: 10px
}

.user-login-5 .login-container>.login-footer .login-social {
	padding-right: 0
}

.user-login-5 .login-container>.login-footer .login-social li {
	display: inline-block;
	list-style: none;
	margin-right: 1em
}

.user-login-5 .login-container>.login-footer .login-social a {
	color: #a9b5be;
	font-size: 18px
}

.user-login-5 .login-container>.login-footer .login-social a:hover {
	color: #337ab7;
	text-decoration: none
}

.user-login-5 .login-container>.login-footer .login-social a:focus {
	color: #a9b5be
}

.user-login-5 .login-container>.login-footer .login-copyright {
	padding-left: 0;
	margin-top: 6px
}

.user-login-5 .login-container>.login-footer .login-copyright>p {
	margin: 0;
	font-size: 13px;
	color: #a9b5be
}

.user-login-5 .alert {
	margin-top: -60px
}

.user-login-5 .form-group.has-error {
	border-bottom: 2px solid #ed6b75 !important
}

.user-login-5 .form-group.valid {
	border-bottom: 1px solid #a0a9b4 !important
}

@media ( max-width :1365px) {
	.user-login-5 .login-logo.login-6 {
		top: 40px;
		left: 40px
	}
	.user-login-5 .login-container .login-copyright, .user-login-5 .login-container .login-social,
		.user-login-5 .login-container>.login-content {
		padding: 0 40px
	}
	.user-login-5 .login-container .login-social {
		padding-right: 0
	}
	.user-login-5 .login-container .login-copyright {
		padding-left: 0
	}
}

@media ( max-width :1023px) {
	.user-login-5, .user-login-5 .login-bg, .user-login-5 .login-container {
		min-height: 50vh
	}
	.user-login-5 .mt-login-5-bsfix {
		width: 100%
	}
	.user-login-5 .login-logo.login-6 {
		position: relative;
		margin: 0 0 40px
	}
	.user-login-5 .login-container>.login-content {
		margin-top: 60px
	}
	.user-login-5 .login-container>.login-content .login-form {
		margin-top: 40px
	}
	.user-login-5 .login-container .rem-password {
		margin-bottom: 1em
	}
	.user-login-5 .login-container>.login-footer {
		position: relative;
		margin-top: 40px;
		padding-bottom: 0
	}
	.user-login-5 .login-container>.login-footer .login-social li {
		margin-right: .5em
	}
	.user-login-5 .alert {
		margin-top: -20px
	}
}

@media ( max-width :640px) {
	.user-login-5 .login-container>.login-content .text-right {
		text-align: left
	}
}
</style>
</head>
 <body class=" login" style="overflow-y:hidden;overflow-x:hidden">
        <!-- BEGIN : LOGIN PAGE 5-2 -->
        <div class="user-login-5">
            <div class="row bs-reset">
                <div class="col-md-6 login-container bs-reset">
                    <div  class="login-logo login-6 row">
                    <div class="col-md-4">
                        <img src="${staticServer}/assets/logo/logo.jpg" alt="logo"
                                              height="50px" class="logo-default" />
                    </div>
                        <div class="col-md-5 col-md-offset-3" style="color: #ff0000;"><h3> 信息技术中心</h3></div>
                    </div>
                    <div class="login-content" >
                        <h1>信息化建设管理平台</h1>
                        <p> 支撑国铁集团及全路性信息化建设管理工作</p>
                        <form class="login-form" id="loginForm" action="" method="post">
                            <div class="alert alert-danger display-hide" id="loginAlert">
                                <button class="close" data-close="alert"></button>
                                <i class="fa-lg fa fa-warning"></i><span id="lblMessage">请输入用户名和密码！ </span>
                            </div>
                            <div class="col-xs-12" style="display: block;margin-left: auto;margin-right: auto;">
                            <div class="col-md-6 col-xs-12 col-md-offset-2" >
                                <div class="col-xs-12">
                                    <input class="form-control form-control-solid placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="账号" name="username" id="username" required/> </div>
                                <div class="col-xs-12">
                                    <input class="form-control form-control-solid placeholder-no-fix form-group" type="password" autocomplete="off" placeholder="密码" name="password" id="password" required/> </div>
                                    
									<div id="authCodeModel" class="col-xs-12" style="margin-left:-15px;display:none;">
									<div class="col-xs-8">
											<input type="text"
												id="authCode" maxlength="4" name="authCode" class="form-control form-control-solid placeholder-no-fix form-group"
												placeholder="请输入验证码" /></div>
												<div class="col-xs-4">
										 <img id="img"
											src="${dynamicServer}/authImage.htm?para=1" onclick="changeImg()"
											style="width: 100px;" /></div>
										
									</div>
									</div>
								</div>
                                <div class="col-xs-4 col-md-offset-2" >
                                    <label class="rememberme mt-checkbox mt-checkbox-outline">
                                        <input type="checkbox" name="remember" value="1"  id="chk" /> 记住我
                                        <span></span>
                                    </label>
                                </div>
                                <div class="col-xs-4 col-md-offset-0">
                                    <button class="btn blue" type="submit">登 录</button>
                                    </div>
                        </form>
                    </div>
                    <div class="login-footer">
                        <div class="row bs-reset">
                            <div class="col-xs-12 bs-reset">
                                <div class="login-copyright text-right">
                                    <p>版权所有 &copy; 中铁信弘远技术研发中心</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 bs-reset">
                    <div class="login-bg"> </div>
                </div>
            </div>
        </div>
    </body>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/metronic4.7/global/scripts/app.min.js" type="text/javascript"></script>
        <script src="${staticServer}/assets/common/js/userBrower.js" type="text/javascript"></script>
<script>
var Login = function() {
	var r = function() {
		$("#loginForm").validate({
			errorElement : "span",
			errorClass : "help-block",
			focusInvalid : !1,
			rules : {
				username : {
					required : !0
				},
				password : {
					required : !0
				},
				authCode : {
					required : true,
					remote : {
						type : "post",
						url : "${dynamicServer}/authPicCode.htm",
						data : {
							authCode : function() {
								return $('#authCode').val();
							}
						},
						dataType : "text",
						dataFilter : function(data) {
							if (data == 1) {
								$("#loginAlert").hide();
								$("#imgTip").attr("src", "${dynamicServer}/assets/common/images/right.png");
								return true;
							} else {
								$("#lblMessage").html("验证码输入错误！");
								$("#imgTip").attr("src", "${dynamicServer}/assets/common/images/error.png");
								$("#loginAlert").show();
								return false;
							}
						}
					}
				}
			},
			messages : {
				username : {
					required : ""
				},
				password : {
					required : ""
				}
			},
			invalidHandler : function(r, e) {
				
				$(".alert-danger", $(".login-form")).show()
			},
			highlight : function(r) {
				$(r).closest(".form-group").addClass("has-error")
			},
			success : function(r) {
				r.closest(".form-group").removeClass("has-error"), r.remove()
			},
			errorPlacement : function(r, e) {
				r.insertAfter(e.closest(".input-icon"))
			},
			submitHandler : function(form) {
				checkLogin();
			}
		}), $(".login-form input").keypress(function(r) {
			if (13 == r.which)
				return $(".login-form").validate().form() && $(".login-form").submit(), !1
		}), $(".forget-form input").keypress(function(r) {
			if (13 == r.which)
				return $(".forget-form").validate().form() && $(".forget-form").submit(), !1
		})
	};
	return {
		init : function() {
			 r(),$(".login-bg").backstretch(["${staticServer}/assets/common/images/home1.jpg","${staticServer}/assets/common/images/home2.jpg","${staticServer}/assets/common/images/home4.jpg","${staticServer}/assets/common/images/home3.jpg"],{fade:1e3,duration:2000}),$(".forget-form").hide()}}}();
	jQuery(document).ready(function(){Login.init()});
	
function checkLogin() {
		if ($('#chk').is(':checked')) {
			Cookies.set('critc_chk', '1', {
				expires : 10,
				path : '/'
			});
			Cookies.set('critc_username', $('#username').val(), {
				expires : 10,
				path : '/'
			});
		} else {
			Cookies.set('critc_chk', '0', {
				expires : 10,
				path : '/'
			});
		}

		var username = $("#username").val();
		var password = $("#password").val();
		
		$.ajax({
			type : "post",
			url : "${dynamicServer}/checkLogin.htm",
			 data : {
				username : username,
				password : password
				/* terminal : getUserTerminalType(),
				explorerType : getExplorerInfo().browser,
				explorerVersion : getExplorerInfo().version */
			},
			dataType : "json",
			success : function(data) {
				if (data.msgText == 2 || data.msgText == 1) {
					if (data.msgText == 2) {
						$("#authCodeModel").css("display", "block");
						$("#lblMessage").html("账户名或密码错误，请输入验证码！");
						$("#loginAlert").show();
						changeImg();
						$('#authCode').val("");
					}
					if (data.msgText == 1) {
						$("#lblMessage").html("您输入错误的次数过多，请10分钟后再尝试登陆！");
						$("#loginAlert").show();
						changeImg();
						$('#authCode').val("");
						$("#imgTip").attr("src", "");
					}
				} else {
					if (data.success) {
						$("#loginAlert").hide();
						window.location.href = "${dynamicServer}/index.htm";
					} else {
						$("#lblMessage").html(data.msgText);
						$("#loginAlert").show();
						changeImg();
					}
				}
			}, 
			error : function(data) {
				$("#lblMessage").html('登录失败');
				$("#loginAlert").show();
			}
		});
	}
$(function(){
	var cookie_chk = Cookies.get('critc_chk');
	if (cookie_chk != '' && cookie_chk != null && cookie_chk == '1') {
		$('#chk').prop("checked", true);
		$('#username').val(Cookies.get('critc_username'));
	}
	$('#username').bind('keypress', function(event) {
		if (event.keyCode == 13) {
			$("#loginForm").submit();
		}
	});
	$('#password').bind('keypress', function(event) {
		if (event.keyCode == 13) {
			$("#loginForm").submit();
		}
	});
});

function changeImg() {
	var img = document.getElementById("img");
	img.src = "${dynamicServer}/authImage.htm?para=1&date=" + new Date();
}

</script>
</html>