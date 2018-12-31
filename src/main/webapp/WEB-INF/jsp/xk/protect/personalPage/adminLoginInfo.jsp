<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/31
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 内容主体区域 -->
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>用户登录记录</legend>
            </fieldset>
            <div class="demoTable">
                <form class="layui-form layui-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">IP地址:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="alip" name="alip" placeholder="筛选IP地址"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">登录城市:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="aladdress" name="aladdress" placeholder="筛选登录城市"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <button type="button" class="layui-btn" data-type="reload">筛选</button>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">创建者:</label>
                        <div class="layui-input-inline">
                            <input type="hidden" id="aid" name="aid">
                            <input type="text" id="aaccount" placeholder="筛选创建者"
                                   autocomplete="off" class="layui-input" disabled>
                        </div>
                        <button type="button" class="layui-btn" onclick="doSelectRcreater()">选择用户</button>
                        <button type="button" class="layui-btn" onclick="$('#aid').val('');$('#aaccount').val('');">清除选择</button>
                    </div>
                </form>
            </div>
            <table class="layui-hide" id="table" lay-filter="table"></table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>
</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "${pageContext.request.contextPath}/static/admin/layui/fromOtherWebSite/hm.js";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script>
    layui.use(['form', 'table'], function(){
        var table = layui.table;
        var form = layui.form;
        //方法级渲染
        table.render({
            elem: '#table'
            ,url: '${pageContext.request.contextPath}/xk/protect/getAdminLoginInfo'
            ,cols: [[
                <c:if test="${sessionScope.admin.alevel<2}">
                    {field:'aaccount', title: '用户账号', width:180},
                </c:if>
                {field:'alip', title: 'IP地址', width:150}
                ,{field:'aldate', title: '登陆时间', width:200}
                ,{field:'aladdress', title: '登陆城市', width:250}
            ]]
            ,id: 'testReload'
            ,page: {
                // layout: ['count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            }
        });

        var $ = layui.$, active = {
            reload: function(){
                table.reload('testReload', {
                    where: {
                        alip: $('#alip').val()
                        ,aladdress: $('#aladdress').val()
                        ,aid:$("#aid").val()
                    }
                });
            }
        };
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //弹出选择用户窗口
    function doSelectRcreater() {
        layer.open({
            type: 2,
            title: '选择用户',
            shadeClose: true,
            shade: 0.8,
            area: ['1200px', '600px'],
            content: '${pageContext.request.contextPath}/xk/super/adminPage/adminControl?select=select'
        });
    }

</script>