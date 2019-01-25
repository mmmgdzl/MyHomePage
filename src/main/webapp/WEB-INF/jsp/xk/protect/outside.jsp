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

    <!-- 设置标题图片 -->
    <link rel="shortcut icon" type="image/x-icon" href="${resourceServer}/images/favicon.ico" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css?t=1542630986927" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/global.css?t=1542630986927-6" media="all">
    <style>
        .layui-layout-admin .site-demo-body{top: 107px;}
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo" winter>
        <div class="layui-main">
            <a class="logo" href="javascript:void(0);" onclick="loadPage('${pageContext.request.contextPath}/xk/welcome')" style="font-size: 15px;display: inline-block;height: 34px;line-height: 30px; ">
                <b>星空の聚合</b>
            </a>
            <div class="layui-form component" lay-filter="LAY-site-header-component"></div>
            <ul class="layui-nav">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:void(0);">
                        <img id="outsideHeadImage" src="${resourceServer}/my/headImages/${sessionScope.admin.aheadimg}" style="width:35px;height:35px;border-radius:35px;"/>
                        &nbsp;&nbsp;<span id="currentAdminAname">${sessionScope.admin.aname}</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class=" layui-show-xs" lay-unselect>
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/personalPage/personalCenter">个人中心</a>
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/personalPage/adminLoginInfo">登陆记录</a>
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/personalPage/changePassword">修改密码</a>
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
                    <a class="javascript:;" href="javascript:;">资源管理</a>
                    <dl class="layui-nav-child">
                        <dd id="oAddResource" style="text-align: center;">
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/resourcePage/addResource">资源添加</a>
                        </dd>
                        <dd id="oResourceControl" style="text-align: center;">
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/resourcePage/resourceControl">资源管理</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">评论管理</a>
                    <dl class="layui-nav-child">
                        <dd id="oResourceCommon" style="text-align: center;">
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/resourceCommentPage/resourceCommentControl">评论管理</a>
                        </dd>
                        <dd id="oMyResourceCommon" style="text-align: center;">
                            <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/resourceCommentPage/myResourceCommentControl">我的评论</a>
                        </dd>
                    </dl>
                </li>
                <c:if test="${sessionScope.admin.alevel<=0}">
                    <li class="layui-nav-item">
                        <a class="javascript:;" href="javascript:;">资源栏目管理</a>
                        <dl class="layui-nav-child">
                            <dd id="oAddResourceColumn" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/resourceColumnPage/addResourceColumn">资源栏目添加</a>
                            </dd>
                            <dd id="oResourceColumnControl" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/resourceColumnPage/resourceColumnControl">资源栏目管理</a>
                            </dd>
                            <dd id="oAddResourceColumnWebsite" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/resourceColumnWebsitePage/addResourceColumnWebsite">资源栏目网站添加</a>
                            </dd>
                            <dd id="oResourceColumnWebsiteControl" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/resourceColumnWebsitePage/resourceColumnWebsiteControl">资源栏目网站管理</a>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${sessionScope.admin.alevel<=0}">
                    <li class="layui-nav-item">
                        <a class="javascript:;" href="javascript:;">用户管理</a>
                        <dl class="layui-nav-child">
                            <dd id="oAddAdmin" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/adminPage/addAdmin">用户添加</a>
                            </dd>
                            <dd id="oAdminControl" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/adminPage/adminControl">用户管理</a>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${sessionScope.admin.alevel<=0}">
                    <li class="layui-nav-item">
                        <a class="javascript:;" href="javascript:;">网站详情</a>
                        <dl class="layui-nav-child">
                            <dd style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/addAdmin">站点统计</a>
                            </dd>
                            <dd style="text-align: center;">
                                <a href="http://www.mmmgdzl.cn:19999/" target="_blank">服务器状态</a>
                            </dd>
                            <dd style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/protect/personalPage/adminLoginInfo">用户登录记录</a>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${sessionScope.admin.alevel<=0}">
                    <li class="layui-nav-item">
                        <a class="javascript:;" href="javascript:;">系统资源管理</a>
                        <dl class="layui-nav-child">
                            <dd id="oAddSystemResource" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/systemResourcePage/addSystemResource">系统资源添加</a>
                            </dd>
                            <dd id="oSystemResourceControl" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/systemResourcePage/systemResourceControl">系统资源管理</a>
                            </dd>
                            <dd id="oAddSystemResourceColumn" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/systemResourceColumnPage/addSystemResourceColumn">系统资源栏目添加</a>
                            </dd>
                            <dd id="oSystemResourceColumnControl" style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/systemResourceColumnPage/systemResourceColumnControl">系统资源栏目管理</a>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${sessionScope.admin.alevel<=0}">
                    <li class="layui-nav-item">
                        <a class="javascript:;" href="javascript:;">系统设置</a>
                        <dl class="layui-nav-child">
                            <dd style="text-align: center;">
                                <a href="javascript:void(0);" onclick="toLoadPage(this)" value="${pageContext.request.contextPath}/xk/super/systemConfigPage/indexConfig">主页设置</a>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
            </ul>
        </div>
    </div>
    <div id="loadBody" class="layui-body layui-tab-content site-demo site-demo-body" style="top: 70px;"></div>
    <jsp:include page="../footer.jsp"></jsp:include>
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
            url:"${pageContext.request.contextPath}/xk/protect/adminLogout",
            dataType:"json",
            success:function(data) {
                //无论成功失败都要跳回到登录界面
                layer.msg("退出登录成功!");
                setTimeout("location.href='${pageContext.request.contextPath}/xk'", 500);
            }
        })
    }

    //根据a标签的value属性加载页面
    function toLoadPage(a) {
        loadPage($(a).attr("value"))
    }
    var lastLoadPage;
    //加载页面
    function loadPage(page) {
        $("#loadBody").html("");
        lastLoadPage = page;
        $("#loadBody").load(page);
    }

    window.onload = function() {
        //加载个人中心页面
        loadPage("${pageContext.request.contextPath}/xk/protect/personalPage/personalCenter");
    }

</script>
</body>
</html>