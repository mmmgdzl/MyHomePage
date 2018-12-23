<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <legend>资源栏目添加</legend>
            </fieldset>
            <form id="tf" class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">资源栏目名<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="text" id="cname" name="cname" lay-verify="required|cname" placeholder="请输入栏目名(小于10个字符)"
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
            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/super/resourceColumn',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("栏目添加成功");
                        setTimeout("checkContinueAddAdmin()", 500);
                    } else {
                        layer.msg("栏目添加失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            cname: function(value){
                if(value.length > 10){
                    return '资源栏目名不能超过10个字符';
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
        layer.confirm('要继续添加栏目吗?', function(index){
            $("#tf")[0].reset();
            layer.close(index);
        },function(index){
            layer.close(index);
            //设置管理资源栏目为选中
            $("#oAddResourceColumn").removeClass("layui-this");
            $("#oResourceColumnControl").addClass("layui-this");
            loadPage("${pageContext.request.contextPath}/xk/super/resourceColumnPage/resourceColumnControl");
        });
    }

</script>
