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
                    <label class="layui-form-label">账号<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="text" id="account" name="aaccount" lay-verify="required|account" placeholder="请输入账号(小于10个字符)"
                               autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">等级<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <select lay-verify="required" name="alevel">
                            <option value="0">超级管理员</option>
                            <option value="1">管理员</option>
                            <option value="2" selected>普通用户</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="password" lay-verify="required|pass" name="apassword"
                               placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">确认密码<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="password" id="password_re" lay-verify="required|pass" placeholder="请重复密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="aname" name="aname" lay-verify="name" placeholder="请输入昵称(小于10个字符)"
                               autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-inline" style="width: 250px">
                        <input type="radio" name="agender" value="0" title="男">
                        <input type="radio" name="agender" value="1" title="女">
                        <input type="radio" name="agender" value="2" title="保密" checked>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">邮箱<sup style="color:red;font-size:15px;">*</sup></label>
                        <div class="layui-input-inline">
                            <input type="text" name="amail" lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">联系电话</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="aphone" lay-verify="myPhone" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
                        </div>
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
            ,name: function(value){
                if(value.length > 10){
                    return '昵称不能超过10个字符';
                }
            }
            ,myPhone: function (value) {
                if(value!="") {
                    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
                    if (!myreg.test(value)) {
                        return "请输入正确的手机号";
                    }
                }
            }

        });
        //在页面完成加载后再次渲染
        form.render();
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
