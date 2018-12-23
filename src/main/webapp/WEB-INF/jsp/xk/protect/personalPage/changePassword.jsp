<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/19
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>修改密码</legend>
            </fieldset>
            <form id="tf" class="layui-form" action="">
                <input type="hidden" name="aid" value="${sessionScope.admin.aid}">
                <div class="layui-form-item">
                    <label class="layui-form-label">账号<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="text" id="account" value="${sessionScope.admin.aaccount}" autocomplete="off" class="layui-input" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">原密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="apassword" lay-verify="required|pass" name="apassword"
                               placeholder="请输入原密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="newPassword" lay-verify="required|pass" name="newPassword"
                               placeholder="请输入新密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认新密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="newPassword_re" lay-verify="required|pass" placeholder="请重复新密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="demo1">修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    layui.use(['form'], function () {
        var form = layui.form;
        var layer = layui.layer;

        //监听提交
        form.on('submit(demo1)', function (formData) {
            //表单校验
            //检验是否重复了新密码
            if ($("#newPassword").val() != $("#newPassword_re").val() ) {
                layer.msg("两次输入的密码不同, 请重新输入!");
                return false;
            }

            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/protect/doChangePassword',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("密码修改成功, 请使用新密码重新登录!");
                        setTimeout("location.href='${pageContext.request.contextPath}/xk'", 500);
                    } else {
                        layer.msg("密码修改失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            pass: function(value){
                if(value.length < 6 || value.length>12){
                    return '密码必须为6到12位';
                }
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

</script>
