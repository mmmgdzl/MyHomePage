<%@ page import="com.mmmgdzl.pojo.Resource" %>
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
                <legend>资源栏目网站编辑</legend>
            </fieldset>
            <form id="tf" class="layui-form" action="">
                <input type="hidden" name="rcwid" value="${editResourceColumnWebsite.rcwid}">
                <div class="layui-form-item">
                    <label class="layui-form-label">网站名称<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline" style="width: 500px;">
                        <input type="text" id="rcwname" name="rcwname" lay-verify="required|websiteName" placeholder="请输入网站名称(小于50个字符)"
                               autocomplete="off" class="layui-input" value="${editResourceColumnWebsite.rcwname}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">链接地址<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline" style="width: 500px;">
                        <input type="text" id="rcwhref" name="rcwhref" lay-verify="required|websiteHref" placeholder="请输入链接地址(小于50个字符)"
                               autocomplete="off" class="layui-input" value="${editResourceColumnWebsite.rcwhref}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属栏目<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline"  style="z-index:10002;">
                        <select lay-verify="required" name="rcwcid">
                            <c:forEach items="${resourceColumnList}" var="resourceColumn" varStatus="vs">
                                <option value="${resourceColumn.cid}" ${resourceColumn.cid==editResourceColumnWebsite.rcwcid?"selected":""}>${resourceColumn.cname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否可用<sup style="color:red;font-size:15px;">*</sup></label>
                    <div class="layui-input-inline"  style="z-index:10001;">
                        <select lay-verify="required" name="rcwenable">
                            <option value="1" ${editResourceColumnWebsite.rcwenable==1?"selected":""}>是</option>
                            <option value="0" ${editResourceColumnWebsite.rcwenable==0?"selected":""}>否</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">原标题图片<br>预览</label>
                    <div class="layui-input-inline">
                        <img src="${resourceServer}/my/resourceColumnWebsiteLogo/${editResourceColumnWebsite.rcwlogo}" style="width: 400px;height: 228px;">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新标题图片</label>
                    <div class="layui-input-inline">
                        <input type="file" id="rcwlogo" name="rcwlogo"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div id="logoPreviewDiv" class="layui-form-item" style="display: none">
                    <label class="layui-form-label">新标题图片<br>预览</label>
                    <div id="logoPreview" class="layui-input-inline">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="demo1">编辑</button>
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
    //实例化编辑器
    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(demo1)', function (formData) {
            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/super/resourceColumnWebsiteUpdate',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("资源栏目网站编辑成功");
                        setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/resourceColumnWebsitePage/resourceColumnWebsiteControl')", 500);
                    } else {
                        layer.msg("资源栏目网站编辑失败! 失败原因:" + data.msg);
                    }
                }
            };
            $("#tf").ajaxSubmit(option);
            return false;
        });

        //自定义验证规则
        form.verify({
            websiteName: function(value){
                if(value.length > 50){
                    return '网站名称长度不能超过50个字符';
                }
            }
            ,websiteHref: function(value){
                if(value.length > 50){
                    return '网站网址长度不能超过50个字符';
                }
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //重置表单
    function resetForm() {
        //隐藏预览图片
        $("#logoPreviewDiv").css("display","none");
    }

    //图片预览事件绑定
    $.imageFileVisible({
        wrapDiv: "#logoPreviewDiv",
        wrapSelector: "#logoPreview",
        fileSelector: "#rcwlogo",
        width: 400,
        height: 228
    });

</script>
