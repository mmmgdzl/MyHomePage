<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/11/28
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>星空の聚合</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css?t=1542630986927"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/global.css?t=1542630986927-6" media="all">
    <style>
        .layui-layout-admin .site-demo-body{top: 107px;}
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo" winter>
        <div class="layui-main">
            <a class="logo" href="javascript:void(0);" style="font-size: 15px;display: inline-block;height: 34px;line-height: 30px; ">
                <b>星空の聚合</b>
            </a>
            <div class="layui-form component" lay-filter="LAY-site-header-component"></div>
            <ul class="layui-nav">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:void(0);">管理员:${admin.account}</a>
                    <dl class="layui-nav-child">
                        <dd class=" layui-show-xs" lay-unselect>
                            <a href="javascript:void(0);">修改密码</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:void(0);" onclick="logout()">退出登录</a>
                </li>

            </ul>
        </div>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree site-demo-nav">
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">数据管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="/demo/">预览数据管理</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">系统设置</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="${pageContext.request.contextPath}/xk/indexConfig">主界面设置</a>
                        </dd>
                    </dl>
                </li>
                <c:if test="${! (admin.level>0)}">
                    <li class="layui-nav-item">
                        <a class="javascript:;" href="javascript:;">权限管理</a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/addAdmin">添加管理员</a>
                            </dd>
                            <dd>
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/adminControl">管理员管理</a>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
            </ul>
        </div>
    </div>
    <div id="loadBody" class="layui-body layui-tab-content site-demo site-demo-body" style="top: 70px;"></div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.4.4.min.js"></script>
<script async src="${pageContext.request.contextPath}/static/admin/layui/fromOtherWebSite/adsbygoogle.js"></script>
<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js?t=1542630986927" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-form.js" charset="utf-8"></script>

<script>
    window.global = {
        pageType: 'demo'
        ,preview: function(){
            var preview = document.getElementById('LAY_preview');
            return preview ? preview.innerHTML : '';
        }()
    };
    layui.config({
        base: '${pageContext.request.contextPath}/static/admin/layui/fromOtherWebSite/'
        ,version: '1542630986927'
    }).use('global');
</script>
<script>
    function logout() {
        $.ajax({
            url:"/xk/adminLogout",
            dataType:"json",
            success:function(data) {
                if(data.code == "200") {
                    layer.msg("退出登录成功!");
                    setTimeout("location.href='${pageContext.request.contextPath}/xk'", 500);
                } else {
                    layer.msg("退出登录失败!");
                }
            }
        })
    }

    function toLoadPage(a) {
        loadPage($(a).attr("value"))
    }

    function loadPage(page) {
        $("#loadBody").html("");
        $("#loadBody").load(page);
    }

</script>
</body>
</html>