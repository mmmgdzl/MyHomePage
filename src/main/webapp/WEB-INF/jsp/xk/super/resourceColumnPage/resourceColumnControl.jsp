<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/22
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 内容主体区域 -->
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>资源栏目管理</legend>
            </fieldset>
            <div class="demoTable">
                <form class="layui-form layui-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">栏目名:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="cname" name="cname" placeholder="筛选栏目名(小于10个字符)"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </form>
                <button class="layui-btn" data-type="reload" style="position:relative;top:-8px;">筛选</button>
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
            ,url: '${pageContext.request.contextPath}/xk/super/resourceColumn'
            ,cols: [[
                {field:'cid', title: 'ID', width:60}
                ,{field:'cname', title: '栏目名', width:160,edit: 'text'}
                ,{field:'ccreatedate', title: '创建日期', width:150}
                ,{field:'ccreater', title: '创建者账号', width:150}
                ,{field:'right', title: '操作', width:170,toolbar:"#barDemo"}
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
                        cname: $('#cname').val()
                        ,cisparent: $('#cisparent').val()
                        ,cparent: $('#cparent').val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听行工具事件
        table.on('tool(table)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('确定删除ID为' + data.cid + '的行么', function(index){
                    layer.close(index);
                    del(data.cid);
                });
            } else if(obj.event === 'edit'){
                edit(data.cid, data.cname);
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //执行编辑
    function edit(id, newName) {
        //ajax请求编辑数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/super/resourceColumn'
            ,type:'PUT'
            ,dataType:'json'
            ,data:{cid: id, cname:newName}
            ,async:false//关闭异步,
            ,headers: {"ClientCallMode": "ajax"} //添加请求头部
            ,success:function(data) {
                if(data.code == 200) {
                    layer.msg("编辑成功!");
                } else {
                    layer.msg("编辑失败:" + data.msg);
                }
                //成功与否都刷新页面
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/resourceColumnPage/resourceColumnControl')", 500);
            }
        });
    }

    //执行删除
    function del(id) {
        //ajax请求删除数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/super/resourceColumn/' + id
            ,type:'DELETE'
            ,dataType:'json'
            ,async:false//关闭异步,
            ,headers: {"ClientCallMode": "ajax"} //添加请求头部
            ,success:function(data) {
                if(data.code == 200) {
                    layer.msg("删除成功!");
                } else {
                    layer.msg("删除失败:" + data.msg);
                }
                //成功与否都刷新页面
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/resourceColumnPage/resourceColumnControl')", 500);
            }
        });
    }
</script>