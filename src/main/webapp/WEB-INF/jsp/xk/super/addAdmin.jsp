<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/6
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>管理员添加</legend>
            </fieldset>
            <form id="tf" class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">管理员账号<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="text" id="account" name="account" lay-verify="required" placeholder="请输入账号"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="password" lay-verify="required" name="password"
                               placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="password_re" lay-verify="required" placeholder="请重复密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">管理员等级<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="number" id="level" name="level" lay-verify="required" placeholder="请输入管理员等级" min="0"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="demo1">添加</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>

    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(demo1)', function (formData) {
            //表单校验
            //检验是否重复了新密码
            if ($("#password").val() != $("#password_re").val() ) {
                layer.msg("两次输入的密码不同, 请重新输入!");
                return false;
            }

            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/super/admin',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("管理员添加成功");
                        setTimeout("checkContinueAddAdmin()", 500);
                    } else {
                        layer.msg("管理员添加失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

    });

    /**
     * 询问是否继续添加
     */
    function checkContinueAddAdmin() {
        layer.confirm('要继续添加管理员吗?', function(index){
            $("#tf")[0].reset();
            layer.close(index);
        },function(index){
            layer.close(index);
            loadPage("${pageContext.request.contextPath}/xk/super/adminControl");
        });
    }

</script>
