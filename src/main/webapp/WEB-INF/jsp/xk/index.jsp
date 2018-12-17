<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/11/28
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <jsp:include page="outside.jsp"></jsp:include>

            <div class="layui-tab layui-tab-brief site-demo-table" lay-filter="demoTitle">
                <ul class="layui-tab-title site-demo-title">
                    <li class="layui-this">预览</li>
                    <li>查看代码</li>
                    <li>帮助</li>
                </ul>
                <div class="layui-body layui-tab-content site-demo site-demo-body">
                    <div class="layui-tab-item layui-show">
                        <div class="layui-main">
                            <div id="LAY_preview">
                                <table class="layui-hide" id="test"></table>
                            </div>
                        </div>
                    </div>
                    <div class="layui-tab-item">
                        <div class="layui-main">
                            <p></p>
                            <div style="margin: 15px 0;">
                                <ins class="adsbygoogle"
                                     style="display:inline-block;width:970px;height:90px"
                                     data-ad-client="ca-pub-6111334333458862"
                                     data-ad-slot="6835627838"></ins>
                            </div>
                            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                                <legend>相关</legend>
                            </fieldset>
                            <a class="layui-btn layui-btn-normal" href="/doc/modules/table.html" target="_blank">表格模块文档</a>
                        </div>
                    </div>
                </div>
                <jsp:include page="footer.jsp"></jsp:include>
            </div>

            <script>
                var _hmt = _hmt || [];
                (function() {
                    var hm = document.createElement("script");
                    hm.src = "${pageContext.request.contextPath}/static/admin/layui/fromOtherWebSite/hm.js";
                    var s = document.getElementsByTagName("script")[0];
                    s.parentNode.insertBefore(hm, s);
                })();
            </script>
        </div>
        <div id="LAY_democodejs">
            <script>
                layui.use('table', function(){
                    var table = layui.table;
                    table.render({
                        elem: '#test'
                        ,url:'/demo/table/user/'
                        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                        ,cols: [[
                            {field:'id', width:80, title: 'ID', sort: true}
                            ,{field:'username', width:80, title: '用户名'}
                            ,{field:'sex', width:80, title: '性别', sort: true}
                            ,{field:'city', width:80, title: '城市'}
                            ,{field:'sign', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                            ,{field:'experience', title: '积分', sort: true}
                            ,{field:'score', title: '评分', sort: true}
                            ,{field:'classify', title: '职业'}
                            ,{field:'wealth', width:137, title: '财富', sort: true}
                        ]]
                    });
                });
            </script>
        </div>
    </body>
</html>