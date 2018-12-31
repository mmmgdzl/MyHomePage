<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
 
    <title>星空の聚合</title>

	<!-- 设置标题图片 -->
	<link rel="shortcut icon" type="image/x-icon" href="${resourceServer}/images/favicon.ico" />

    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/admin/css/style.css">
    
</head>
<body style="background-color:#000000">
 
 <canvas style="float:left;z-index: -1;"></canvas>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/static/admin/js/jquery.min.js"></script>
 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/static/admin/js/loginbg.js"></script>
 <!-- 引入背景动画END -->
<div class="login-main" style="margin-top:90px">
	<div style="padding-left:10px;padding-right:10px;border-radius:20px;background-color:#f0f0f0; height:240px;">
	    <header class="layui-elip" style="margin-top:150px;padding-top:10px;">星空の聚合</header>
	    <form class="layui-form" >
	        <div class="layui-input-inline">
	            <input type="text" name="account" required lay-verify="required" value="${activeAdminAccount}" placeholder="用户名" autocomplete="off"
	                   class="layui-input">
	        </div>
	        <div class="layui-input-inline">
	            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
	                   class="layui-input">
	        </div>
	        <div class="layui-input-inline login-btn">
	            <button lay-submit lay-filter="login" class="layui-btn">登录</button>
	        </div>
			<div class="layui-input-inline">
				<a href="javascript:void(0);" style="float: right;margin-right: 15px;" onclick="doRegister()">没有账号?</a>
			</div>
	    </form>
    </div>
</div>
 
 
<script src="${pageContext.request.contextPath }/static/admin/layui/layui.js"></script>
<script type="text/javascript">
    if(${empty visitFalse ? false : true}) {
        location.href = "/xk";
    }

    layui.use(['form','layer','jquery'], function () {
        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(login)',function (data) {
            $.ajax({
                url:'${pageContext.request.contextPath}/xk/adminLogin',
                data:data.field,
                dataType:'json',
                type:'post',
                success:function (data) {
                    if(data.code=="200") {
                        layer.msg("登陆成功");
                    	setTimeout("location.href='${pageContext.request.contextPath}/xk/protect/index'",500);
                    } else {
                    	layer.msg(data.msg);
                    	$(".layui-form")[0].reset();
                    }
                }
            });
            return false;
        });
    });
    //弹出注册窗口
	function doRegister() {
        layer.open({
            type: 2,
            title: '注册用户',
            shadeClose: true,
            shade: false,
            area: ['350px', '400px'],
            content: '${pageContext.request.contextPath}/xk/register'
        });
    }

    window.onload = function() {
	  if(${empty activeResult ? false : true}) {
	      layer.msg("${activeResult}");
      }
	};
</script>
</body>
</html>