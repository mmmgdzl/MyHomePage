<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2019/1/22
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>系统资源添加</legend>
            </fieldset>
            <form id="tf" class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">系统资<br>源文件<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="file" id="srfile" name="srfile" lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属栏目<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline"  style="z-index:10001;">
                        <select lay-verify="required" name="srcolumn">
                            <c:forEach items="${systemResourceColumnList}" var="systemResourceColumn" varStatus="vs">
                                <option value="${systemResourceColumn.srcid}" ${vs.count==1?"selected":""}>${systemResourceColumn.srcname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">系统资<br>源备注</label>
                        <div class="layui-input-block">
                            <textarea style="max-width: 400px;" placeholder="请输入系统资源备注(不多于255个字符)" name="srdesc" lay-verify=srdesc" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="demo1">添加</button>
                        <button type="reset" class="layui-btn layui-btn-primary" onclick="resetForm()">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/js/imagePreView.js"></script>
<script>

    //重置表单
    function resetForm() {
        //隐藏预览图片
        $("#logoPreviewDiv").css("display","none");
    }
    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(demo1)', function (formData) {
            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/super/systemResource',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("系统资源添加成功");
                        setTimeout("checkContinueAddResource()", 500);
                    } else {
                        layer.msg("系统资源添加失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            srdesc: function(value){
                if(value.length > 255){
                    return '系统资源备注长度不能超过255个字符';
                }
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    /**
     * 询问是否继续添加
     */
    function checkContinueAddResource() {
        layer.confirm('要继续添加系统资源吗?', function(index){
            $("#tf")[0].reset();
            resetForm();
            layer.close(index);
        },function(index){
            layer.close(index);
            //设置管理管理员为选中
            $("#oAddSystemResource").removeClass("layui-this");
            $("#oSystemResourceControl").addClass("layui-this");
            loadPage("${pageContext.request.contextPath}/xk/super/systemResourcePage/systemResourceControl");
        });
    }

</script>
