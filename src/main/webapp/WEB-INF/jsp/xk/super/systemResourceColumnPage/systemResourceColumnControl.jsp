<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2019/1/22
  Time: 0:25
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
                <legend>系统资源栏目管理</legend>
            </fieldset>
            <div class="demoTable">
                <form class="layui-form layui-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">栏目名:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="srcname" name="srcname" placeholder="筛选栏目名"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">栏目状态:</label>
                        <div class="layui-input-inline">
                            <select id="srcenable" name="srcenable">
                                <option value="">--所有有效--</option>
                                <option value="1">可用</option>
                                <option value="0">不可用</option>
                                <option value="2">删除</option>
                            </select>
                        </div>
                        <button type="button" class="layui-btn" data-type="reload">筛选</button>
                    </div>
                </form>
            </div>
            <table class="layui-hide" id="table" lay-filter="table"></table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>
</div>
<script type="text/html" id="srcenableSwitch">
    <input type="radio" name="srcenable-{{d.srcid}}" value="1" title="可用" {{ d.srcenable == '可用' ? 'checked' : '' }} {{ d.srcenable == '删除' ? 'disabled' : '' }}>
    <input type="radio" name="srcenable-{{d.srcid}}" value="0" title="不可用" {{ d.srcenable == '不可用' ? 'checked' : '' }} {{ d.srcenable == '删除' ? 'disabled' : '' }}>
    <input type="radio" name="srcenable-{{d.srcid}}" value="2" title="删除" {{ d.srcenable == '删除' ? 'checked' : '' }} disabled>
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
            ,url: '${pageContext.request.contextPath}/xk/super/systemResourceColumn'
            ,cols: [[
                {field:'srcid', title: 'ID', width:60}
                ,{field:'srcname', title: '栏目名(双击编辑)',edit: 'text'}
                ,{field:'srccreatedate', title: '创建日期'}
                ,{field:'srccreater', title: '创建用户'}
                ,{field:'srcenable', title:'栏目状态', templet: '#srcenableSwitch', unresize: true}
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
                        srcname: $('#srcname').val()
                        ,srcenable: $('#srcenable').val()
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
                var srcenable = getSrcenable(data.srcid);
                if(srcenable == 2) {
                    layer.msg("已删除的数据无法操作");
                    return;
                }
                layer.confirm('确定删除ID为' + data.srcid + '的资源栏目么', function(index){
                    layer.close(index);
                    del(data.srcid);
                });
            } else if(obj.event === 'edit'){
                var srcenable = getSrcenable(data.srcid);
                if(srcenable == 2) {
                    layer.msg("已删除的数据无法操作");
                    return;
                }

                edit(data.srcid, data.srcname, srcenable);
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //执行编辑
    function edit(id, newName, srcenable) {
        //ajax请求编辑数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/super/systemResourceColumn'
            ,type:'PUT'
            ,dataType:'json'
            ,data:{srcid: id, srcname:newName, srcenable:srcenable}
            ,async:false//关闭异步,
            ,headers: {"ClientCallMode": "ajax"} //添加请求头部
            ,success:function(data) {
                if(data.code == 200) {
                    layer.msg("编辑成功!");
                } else {
                    layer.msg("编辑失败:" + data.msg);
                }
                //成功与否都刷新页面
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/systemResourceColumnPage/systemResourceColumnControl')", 500);
            }
        });
    }

    //执行删除
    function del(id) {
        //ajax请求删除数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/super/systemResourceColumn/' + id
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
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/systemResourceColumnPage/systemResourceColumnControl')", 500);
            }
        });
    }

    //获取当前行的srcenable
    function getSrcenable(srcid) {
        var srcenable;
        //获取选中的srcenable
        $.each($("input[name='srcenable-" + srcid + "']"),
            function(key, value) {
                //获取选择项
                if($(value).next().hasClass("layui-form-radioed")){
                    if(key == 0) {
                        srcenable = 1;
                    } else if(key == 1) {
                        srcenable = 0;
                    } else {
                        srcenable = 2;
                    }
                }
            }
        );
        return srcenable;
    }
</script>