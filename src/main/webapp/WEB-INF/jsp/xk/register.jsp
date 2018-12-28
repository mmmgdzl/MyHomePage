<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/23
  Time: 1:48
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
                    <legend>注册用户</legend>
                </fieldset>
                <form id="tf" class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号<sup style="color:red;font-size:15px;">*</sup></label>
                        <div class="layui-input-inline">
                            <input type="text" id="rtitle" name="aaccount" lay-verify="required|account" placeholder="请输入账号(小于10个字符)"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码<sup style="color:red;font-size:15px;">*</sup></label>
                        <div class="layui-input-inline">
                            <input type="password" id="password" name="apassword" lay-verify="required|pass" placeholder="请输入密码(6-12个字符)"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">确认密码<sup style="color:red;font-size:15px;">*</sup></label>
                        <div class="layui-input-inline">
                            <input type="password" id="password_re" lay-verify="required|pass" placeholder="请重复密码(6-12个字符)"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱<sup style="color:red;font-size:15px;">*</sup></label>
                        <div class="layui-input-inline">
                            <input type="text" id="amail" name="amail" lay-verify="required|email" placeholder="请输入邮箱"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="demo2">注册</button>
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
            //表单校验
            //检验是否重复了新密码
            if ($("#password").val() != $("#password_re").val() ) {
                layer.msg("两次输入的密码不同, 请重新输入!");
                return false;
            }

            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/doRegister',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("注册成功");
                        setTimeout("checkOpenMailPage('" + data.data + "')", 500);
                    } else {
                        layer.msg("注册失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            account: function(value){
                if(value.length > 10){
                    return '管理员账号不能超过10个字符';
                }
            }
            ,pass: function(value){
                if(value.length < 6 || value.length>12){
                    return '密码必须为6到12位';
                }
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    /**
     * 打开邮箱页面
     */
    function checkOpenMailPage(url){
        layer.confirm('我猜你的邮箱登陆页面网址为' + url + ',尝试打开?', function(index){
            window.open(url);
            layer.close(index);
            var index1 = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index1);//关闭窗口
        },function(index){
            layer.close(index);
            var index1 = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index1);//关闭窗口
        });
    }
</script>
</html>
