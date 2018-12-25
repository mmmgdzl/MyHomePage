<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div class="layui-input-inline" style="width: 500px;">
                        <input type="text" id="rtitle" name="rtitle" lay-verify="required|title" placeholder="请输入标题(小于30个字符)"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">标题图片<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline">
                        <input type="file" id="rtitleimg" name="rtitleimg" lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div id="titleImagePreviewDiv" class="layui-form-item" style="display: none">
                    <label class="layui-form-label">标题图片<br>预览<sup style="color:red;font-size:15px;">*</sup></label>
                    <div id="titleImagePreview" class="layui-input-inline">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属栏目<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline"  style="z-index:10001;">
                        <select lay-verify="required" name="rcolumn">
                            <c:forEach items="${resourceColumnList}" var="resourceColumn" varStatus="vs">
                                <option value="${resourceColumn.cid}" ${vs.count==1?"selected":""}>${resourceColumn.cname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">资源详情<sup style="color:red;font-size:15px;">*</sup></label>
                        <script id="editor" name="rcontent" type="text/plain" style="width:600px;height:300px;"/>
                        <div id="editor"  name="rcontent" class="layui-input-inline" style="width:700px;height: 350px;"></div>
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
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/js/imagePreView.js"></script>
<script>
    //实例化编辑器
    var ue = UE.getEditor('editor');

    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(demo1)', function (formData) {
            //表单校验
            //检验是否重复了新密码
            if (ue.getContent() == "" ) {
                layer.msg("资源详情不能为空!");
                return false;
            }
            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/protect/resource',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("资源添加成功");
                        setTimeout("checkContinueAddResource()", 500);
                    } else {
                        layer.msg("资源添加失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length > 30){
                    return '标题长度不能超过30个字符';
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
    function checkContinueAddResource() {
        layer.confirm('要继续添加资源吗?', function(index){
            $("#tf")[0].reset();
            ue.setContent("");
            layer.close(index);
        },function(index){
            layer.close(index);
            //设置管理管理员为选中
            $("#oAddResource").removeClass("layui-this");
            $("#oResourceControl").addClass("layui-this");
            loadPage("${pageContext.request.contextPath}/xk/protect/resourcePage/resourceControl");
        });
    }


    //图片预览事件绑定
    $.imageFileVisible({
        wrapDiv: "#titleImagePreviewDiv",
        wrapSelector: "#titleImagePreview",
        fileSelector: "#rtitleimg",
        width: 400,
        height: 228
    });

</script>
