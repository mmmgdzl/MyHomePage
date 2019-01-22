<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/1/8
  Time: 0:48
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

    <!-- 设置标题图片 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css?t=1542630986927" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/global.css?t=1542630986927-6" media="all">
    <style>
        .layui-layout-admin .site-demo-body{top: 107px;}
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-tab-item layui-show">
        <div class="layui-main">
            <div id="LAY_preview">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend></legend>
                </fieldset>
                <form id="tf" class="layui-form" action="">
                    <input id="resourceId" name="rcresource" type="hidden">
                    <input id="replyId" type="hidden">
                    <div id="replyContentDiv" class="layui-form-item" style="display: none">
                        <label class="layui-form-label">评论内容:</label>
                        <div class="layui-input-inline">
                            <textarea id='replyContent' class="layui-textarea" disabled></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">回复内容:<sup style="color:red;font-size:15px;">*</sup></label>
                        <div class="layui-input-inline">
                            <textarea placeholder="请输入评论内容(不多于500个字符)" name="rccontent" lay-verify=rccontent" class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="demo2">添加</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.4.4.min.js"></script>
<script async src="${pageContext.request.contextPath}/static/admin/layui/fromOtherWebSite/adsbygoogle.js"></script>
<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js?t=1542630986927" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-form.js" charset="utf-8"></script>
<script>

    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(demo2)', function (formData) {

            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/protect/resourceComment',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("评论添加成功");
                        parent.getResourceComments(1,5);
                        setTimeout("afterAddResourceComment();", 500);

                    } else {
                        layer.msg("评论添加失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            rccontent: function(value){
                if(value.length > 500){
                    return '评论不能超过500个字符';
                }
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //关闭窗口
    function afterAddResourceComment() {
        var index1 = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index1);//关闭窗口
    }

    window.onload = function() {
        //获取资源内容
        $("#resourceId").val(parent.$("#resourceId").val());
        //判断是否为回复
        if(parent.$("#replyId").val() != "") {
            $("#replyId").attr("name", "rcreply");
            $("#replyId").val(parent.$("#replyId").val());
            //显示回复内容
            $("#replyContent").html(parent.$("#reply-" + parent.$("#replyId").val()).html());
            $("#replyContentDiv").css("display", "block");
        }
    };
</script>
</html>
