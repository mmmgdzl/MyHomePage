<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2019/1/3
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>主页设置</legend>
            </fieldset>
            <form id="musictf" class="layui-form" action="">
                <label class="layui-form-label">主页背<br>景音乐:</label>
                <div class="layui-input-inline">
                    <input type="hidden" name="srid" xkfilter="musicid">
                    <input type="text" placeholder="筛选主页背景音乐"  xkfilter="musicname"
                           autocomplete="off" class="layui-input" value="${backgroundMusicName}" disabled>
                </div>
                <button type="button" class="layui-btn" onclick="doSelectSr('选择背景音乐', 'music')">选择背景音乐</button>
                <button type="button" class="layui-btn" onclick="commitUpdate('${pageContext.request.contextPath}/xk/super/indexConfig/updateIndexMusic', 'music')">提交修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </form>
            <br>
            <form id="videotf" class="layui-form" action="">
                <label class="layui-form-label">主页背<br>景视频:</label>
                <div class="layui-input-inline">
                    <input type="hidden" name="srid" xkfilter="videoid">
                    <input type="text" placeholder="筛选主页背景视频"  xkfilter="videoname"
                           autocomplete="off" class="layui-input" value="${backgroundVideoName}" disabled>
                </div>
                <button type="button" class="layui-btn" onclick="doSelectSr('选择背景音乐', 'video')">选择背景视频</button>
                <button type="button" class="layui-btn" onclick="commitUpdate('${pageContext.request.contextPath}/xk/super/indexConfig/updateIndexVideo', 'video')">提交修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </form>
            <form class="layui-form" action="">
                <button type="button" class="layui-btn" onclick="restartTomcatServer()">重启服务器</button>
            </form>

        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/admin/js/imagePreView.js"></script>
<script>

    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //在页面完成加载后再次渲染
        form.render();
    });

    //提交更新
    function commitUpdate(url, xkfilter) {
        //获取提交的值
        var srid = $("input[xkfilter='" + xkfilter + "id']").val();

        if(srid == "") {
            layer.msg("请先选择对应的更改项再点击提交更改!");
            return false;
        }
        //提交表单
        var option = {
            url: url,
            type: 'POST',
            dataType: 'json',
            data: {srid:srid},
            async: false,//设为同步请求
            headers: {"ClientCallMode": "ajax"}, //添加请求头部
            success: function (data) {
                if (data.code == 200) {
                    layer.msg("更新成功");
                    setTimeout("loadPage(lastLoadPage);", 500);
                } else {
                    layer.msg("更新失败! 失败原因:" + data.msg);
                }
            }
        };
        $("#" + xkfilter + "tf").ajaxSubmit(option);
    }

    var loadingIndex;
    /**
     * 执行重启服务器
     */
    function restartTomcatServer() {
        $.post("${pageContext.request.contextPath}/xk/restartTomcatServer",
            {},function(data) {
                if(data.code == 200) {
                    //显示加载层
                    layer.msg('服务器重启中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: 'auto', time:10000000});
                    //测试服务器是否重启成功
                    setTimeout("testServer();", 5000);
                }
            }
        );
    }

    /**
     * 测试服务器是否重启成功
     */
    function testServer() {
        $.ajax({
            url:"${pageContext.request.contextPath}/xk/testServer",
            dataType:"json",
            success:function(data) {
                //重启成功则关闭加载层并回到登录界面
                layer.close(loadingIndex);
                layer.msg("服务器重启成功,请重新登录!");
                setTimeout("location.href='${pageContext.request.contextPath}/xk'", 800);
            },
            error:function() {
                //失败则继续测试服务器是否重启成功
                setTimeout("testServer();", 5000);
            }
        });
    }

    //弹出选择系统资源窗口
    function doSelectSr(title, filter) {

        //移除上次的选择
        $("#sridSelect").removeAttr("id");
        $("#srnameSelect").removeAttr("id");

        //标记本次修改
        $("input[xkfilter='" + filter +"id']").attr("id", "sridSelect");
        $("input[xkfilter='" + filter +"name']").attr("id", "srnameSelect");

        layer.open({
            type: 2,
            title: title,
            shadeClose: true,
            shade: 0.8,
            area: ['1200px', '600px'],
            content: '${pageContext.request.contextPath}/xk/super/systemResourcePage/systemResourceControl?select=select'
        });
    }


</script>
