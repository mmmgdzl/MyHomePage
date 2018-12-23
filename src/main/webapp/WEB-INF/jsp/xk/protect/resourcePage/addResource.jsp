<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/22
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>资源添加</legend>
            </fieldset>
            <form id="tf" class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">标题<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="text" id="rtitle" name="aaccount" lay-verify="required|account" placeholder="请输入账号(小于10个字符)"
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
                    <label class="layui-form-label">资源详情<sup style="color:red;font-size:15px;">*</sup></label>
                        <script id="editor" name="content" type="text/plain" style="width:600px;height:300px;"/>
                        <div id="editor" class="layui-input-inline" style="width:700px;height: 350px;">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script>
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue;

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
                url: '${pageContext.request.contextPath}/xk/protect/super/admin',
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
        ue = UE.getEditor('editor');
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
            //设置管理管理员为选中
            $("#oAddAdmin").removeClass("layui-this");
            $("#oAdminControl").addClass("layui-this");
            loadPage("${pageContext.request.contextPath}/xk/protect/super/adminControl");
        });
    }

</script>
