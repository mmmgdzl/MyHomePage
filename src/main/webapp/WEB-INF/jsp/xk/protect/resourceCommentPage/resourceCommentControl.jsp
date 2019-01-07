<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2019/1/4
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 内容主体区域 -->
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <blockquote class="layui-elem-quote layui-text">
                点击修改修改当前行后其他行的数据会还原
            </blockquote>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>资源评论管理</legend>
            </fieldset>
            <div class="demoTable">
                <form class="layui-form layui-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">评论楼数:</label>
                        <div class="layui-input-inline">
                            <input type="number" id="rccount" name="rccount" placeholder="筛选评论楼数"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">回复楼数:</label>
                        <div class="layui-input-inline">
                            <input type="number" id="rcreply" name="rcreply" placeholder="筛选回复楼数"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">内容:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="rccontent" name="rccontent" placeholder="筛选内容"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">状态:</label>
                        <div class="layui-input-inline">
                            <select id="rcenable" name="rcenable">
                                <option value="">--所有有效--</option>
                                <option value="1">可用</option>
                                <option value="0">不可用</option>
                                <option value="2">删除</option>
                            </select>
                        </div>
                        <button type="button" class="layui-btn" data-type="reload">筛选</button>
                    </div>
                    <c:if test="${sessionScope.admin.alevel <= 0}">
                        <div class="layui-form-item">
                            <label class="layui-form-label">创建用户:</label>
                            <div class="layui-input-inline">
                                <input type="hidden" id="aidSelect" name="aid">
                                <input type="text" id="aaccountSelect" placeholder="筛选创建用户"
                                       autocomplete="off" class="layui-input" disabled>
                            </div>
                            <button type="button" class="layui-btn" onclick="doSelectRcreater()">选择创建用户</button>
                            <button type="button" class="layui-btn" onclick="$('#aidSelect').val('');$('#aaccountSelect').val('');">清除选择</button>
                        </div>
                    </c:if>
                    <div class="layui-form-item">
                        <label class="layui-form-label">筛选资源:</label>
                        <div class="layui-input-inline">
                            <input type="hidden" id="ridSelect" name="rid">
                            <input type="text" id="rtitleSelect" placeholder="筛选资源"
                                   autocomplete="off" class="layui-input" disabled>
                        </div>
                        <button type="button" class="layui-btn" onclick="doSelectResource()">选择资源</button>
                        <button type="button" class="layui-btn" onclick="$('#ridSelect').val('');$('#rtitleSelect').val('');">清除选择</button>
                    </div>
                </form>

            </div>
            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">删除选中行数据</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                </div>
            </script>
            <table class="layui-hide" id="table" lay-filter="table"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>
</div>
<script type="text/html" id="resourceInfoA">
    <a href="javascript:void(0);" lay-event="a">{{d.rcresource}}</a>
</script>
<script type="text/html" id="rcenableSwitch">
    <input type="radio" name="rcenable-{{d.rcid}}" value="1" title="可用" {{ d.rcenable == '可用' ? 'checked' : '' }} {{ d.rcenable == '删除' ? 'disabled' : '' }}>
    <input type="radio" name="rcenable-{{d.rcid}}" value="0" title="不可用" {{ d.rcenable == '不可用' ? 'checked' : '' }} {{ d.rcenable == '删除' ? 'disabled' : '' }}>
    <input type="radio" name="rcenable-{{d.rcid}}" value="2" title="删除" {{ d.rcenable == '删除' ? 'checked' : '' }} disabled>
</script>
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
            ,url: '${pageContext.request.contextPath}/xk/protect/resourceComment'
            ,toolbar: '#toolbarDemo'
            ,cols: [[
                {checkbox: true},
                {field:'rcid', title: 'ID', width: 50}
                ,{field:'rcresource', title: '资源标题(点击跳转)', templet: '#resourceInfoA', unresize: true}
                ,{field:'rccount', title: '楼数', width: 60}
                ,{field:'rcreply', title: '回复', width: 60}
                ,{field:'rccreater', title: '创建用户'}
                ,{field:'rccreatedate', title: '创建日期'}
                ,{field:'rcupdater', title: '修改用户'}
                ,{field:'rcupdatedate', title: '修改日期'}
                ,{field:'rccontent', title: '内容'}
                ,{field:'rcenable', title: '状态', templet: '#rcenableSwitch', unresize: true, width: 220}
                ,{field:'right', title: '操作',toolbar:"#barDemo"}
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
                        rccount: $('#rccount').val()
                        ,rcreply: $('#rcreply').val()
                        ,rccontent: $("#rccontent").val()
                        ,rcenable: $("#rcenable").val()
                        ,rccreater: $("#aidSelect").val()
                        ,rcresource: $("#ridSelect").val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //头工具栏事件
        table.on('toolbar(table)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    delSelect(data);
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(table)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                if(data.rcenable == "删除") {
                    layer.msg("已删除的数据无法操作!");
                    return;
                }
                layer.confirm('确定删除ID为' + data.rcid + '的资源么', function(index){
                    layer.close(index);
                    del(data.rcid);
                });
            } else if(obj.event === 'edit'){
                if(data.rcenable == "删除") {
                    layer.msg("已删除的数据无法操作!");
                    return;
                }
                //执行编辑
                edit(data.rcid, getEnable(data.rcid));
            } else if(obj.event === 'a'){
                window.open("${pageContext.request.contextPath}/resourceInfo/" + data.rcresourcehref, "_blank");
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //执行编辑
    function edit(id, rcenable) {
        //ajax请求编辑数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/protect/resourceComment'
            ,type:'PUT'
            ,dataType:'json'
            ,data:{rcid: id, rcenable:rcenable}
            ,async:false//关闭异步,
            ,headers: {"ClientCallMode": "ajax"} //添加请求头部
            ,success:function(data) {
                if(data.code == 200) {
                    layer.msg("编辑成功!");
                } else {
                    layer.msg("编辑失败:" + data.msg);
                }
                //成功与否都刷新页面
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/protect/resourceCommentPage/resourceCommentControl')", 500);
            }
        });
    }

    //执行删除
    function del(id) {
        var idArray = new Array();
        idArray[0] = id;
        //ajax请求删除数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/protect/resourceComment'
            ,type:'DELETE'
            ,dataType:'json'
            ,data:{ids:JSON.stringify(idArray)}
            ,async:false//关闭异步,
            ,headers: {"ClientCallMode": "ajax"} //添加请求头部
            ,success:function(data) {
                if(data.code == 200) {
                    layer.msg("删除成功!");
                } else {
                    layer.msg("删除失败:" + data.msg);
                }
                //成功与否都刷新页面
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/protect/resourceCommentPage/resourceCommentControl')", 500);
            }
        });
    }

    //执行多选删除
    function delSelect(data) {
        if(data.length == 0) {
            layer.msg("未选中行!");
        } else if(data[0].rcenable == "删除") {
            layer.msg("已删除的数据无法操作!");
        } else {
            layer.confirm('确定删除已选中的' + data.length + '行么?', function(index){
                layer.close(index);
                var idArray = new Array();
                for(var i=0; i<data.length; i++) {
                    idArray[i] = data[i].rcid;
                }
                //执行删除
                $.ajax({
                    url:'${pageContext.request.contextPath}/xk/protect/resourceComment'
                    ,type:'DELETE'
                    ,dataType:'json'
                    ,data:{ids:JSON.stringify(idArray)}
                    ,async:false//关闭异步
                    ,headers: {"ClientCallMode": "ajax"} //添加请求头部
                    ,success:function(data1) {
                        if(data1.code == '200') {
                            layer.msg("已成功删除" + data.length + "行!");
                        } else {
                            layer.msg("删除失败:" + data1.msg);
                        }
                        setTimeout("loadPage('${pageContext.request.contextPath}/xk/protect/resourceCommentPage/resourceCommentControl')", 500);
                    }
                });
            });
        }
    }

    //获取当前行的rcenable
    function getEnable(rcid) {
        var rcenable;
        //获取选中的rcenable
        $.each($("input[name='rcenable-" + rcid + "']"),
            function(key, value) {
                //获取选择项
                if($(value).next().hasClass("layui-form-radioed")){
                    if(key == 0) {
                        rcenable = 1;
                    } else if(key == 1) {
                        rcenable = 0;
                    } else {
                        rcenable = 2;
                    }
                }
            }
        );
        return rcenable;
    }

    //弹出选择创建者窗口
    function doSelectRcreater() {
        layer.open({
            type: 2,
            title: '选择创建者',
            shadeClose: true,
            shade: 0.8,
            area: ['1200px', '600px'],
            content: '${pageContext.request.contextPath}/xk/super/adminPage/adminControl?select=select'
        });
    }
    //弹出选择资源窗口
    function doSelectResource() {
        layer.open({
            type: 2,
            title: '选择资源',
            shadeClose: true,
            shade: 0.8,
            area: ['1200px', '600px'],
            content: '${pageContext.request.contextPath}/xk/protect/resourcePage/resourceControl?select=select'
        });
    }

</script>