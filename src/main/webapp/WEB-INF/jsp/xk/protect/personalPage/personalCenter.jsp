<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/19
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>个人中心</legend>
            </fieldset>
            <div class="layui-row">
                <div class="layui-col-md4 layui-col-md-offset4">
                    <div class="layui-col-md6">
                        <div class="grid-demo grid-demo-bg1 layui-bg-black">
                            <div style="position:relative;">
                                <div>当前头像原图片:</div>
                                <div style="position:relative;">
                                    <img id="headImage" src="${resourceServer}/my/headImages/${sessionScope.admin.aheadimg}" style="max-width: 100%;width:100%;height:auto;" onmouseenter="showOn(this)" />
                                    <div id="imageChange" style="position:absolute; left:0px; top:0px; background:#000;width: 100%;height:100%;opacity: 0.5;cursor: pointer;display: none;" onmouseleave="hideOn(this)"><div style="position: absolute;width:100%;top:50%;line-height:10%">点击更换头像</div></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6">
                        <div class="grid-demo grid-demo-bg1 layui-bg-black">
                            <div style="position:relative;">
                                <div>头像实际效果预览:</div>
                                <div style="position:relative;">
                                    <img id="previewHeadImage" src="${resourceServer}/my/headImages/${sessionScope.admin.aheadimg}" style="width:35px;height:35px;border-radius:35px;"/>
                                </div>
                                <button id="imageChangeBtn" class="layui-btn">更换头像</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-row" style="margin-top: 15px;">
                <div class="layui-col-md8 layui-col-md-offset3">
                    <form id="tf" class="layui-form" action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">账号<sup style="color:red;font-size:15px;">*</sup></label>
                            <div class="layui-input-inline">
                                <input type="text" id="account"value="${sessionScope.admin.aaccount}" placeholder="请输入账号"
                                       autocomplete="off" class="layui-input" disabled>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input type="text" id="aname" name="aname" value="${sessionScope.admin.aname}" placeholder="请输入昵称(小于10个字符)" lay-verify="name"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-inline" style="width: 250px">
                                <input type="radio" name="agender" value="0" title="男" ${sessionScope.admin.agender == 0?"checked":""}>
                                <input type="radio" name="agender" value="1" title="女" ${sessionScope.admin.agender == 1?"checked":""}>
                                <input type="radio" name="agender" value="2" title="保密" ${sessionScope.admin.agender == 2?"checked":""}>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">邮箱<sup style="color:red;font-size:15px;">*</sup></label>
                                <div class="layui-input-inline">
                                    <input type="text" name="amail" lay-verify="required|email" value="${sessionScope.admin.amail}" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <label class="layui-form-label">联系电话</label>
                            <div class="layui-input-inline">
                                <input type="tel" name="aphone" lay-verify="myPhone" value="${sessionScope.admin.aphone}" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-col-md4 layui-col-md-offset2">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="demo1">编辑</button>
                                    <button class="layui-btn layui-btn-primary" onclick="loadPage(lastLoadPage)">重置</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form','upload'], function () {
        var form = layui.form;
        var layer = layui.layer;
        var upload = layui.upload;

        //上传文件
        var uploadInst = upload.render({
            elem: '#imageChange,#imageChangeBtn' //绑定元素
            ,url: '/xk/protect/upload/headImage' //上传接口
            ,acceptMime:'image/jpg, image/png'//限制上传文件类型
            ,done: function(res){
                if(res.code == 200) {
                    //上传完毕回调
                    layer.msg("头像更换成功");
                    //更新头像图片
                    $("#headImage").attr("src", "${resourceServer}/my/headImages/" + res.data);
                    $("#outsideHeadImage").attr("src", "${resourceServer}/my/headImages/" + res.data);
                    $("#previewHeadImage").attr("src", "${resourceServer}/my/headImages/" + res.data);
                } else {
                    layer.msg("头像更新失败! 失败原因:" + res.msg);
                }

            }
        });

        //监听提交
        form.on('submit(demo1)', function (formData) {
            //提交表单
            var option = {
                url: '${pageContext.request.contextPath}/xk/protect/doChangeUserInfo',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(formData.field),
                async: false,//设为同步请求
                headers: {"ClientCallMode": "ajax"}, //添加请求头部
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg("用户信息修改成功!");
                        //更新导航栏用户信息显示
                        $("#currentAdminAname").html(data.data.aname);
                        //重新加载个人中心页面
                        loadPage("${pageContext.request.contextPath}/xk/protect/personalPage/personalCenter");
                    } else {
                        layer.msg("用户信息修改! 失败原因:" + data.msg);
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
     * 显示图片盖板
     */
    function showOn(obj) {
        $(obj).next().css("display","block");
    }

    /**
     * 隐藏图片盖板
     */
    function hideOn(obj) {
        $(obj).css("display","none");
    }


</script>
