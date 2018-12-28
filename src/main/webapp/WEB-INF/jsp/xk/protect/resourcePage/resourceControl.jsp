<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/23
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 内容主体区域 -->
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>资源管理</legend>
            </fieldset>
            <div class="demoTable">
                <form class="layui-form layui-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="rtitle" name="rtitle" placeholder="筛选标题"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">栏目:</label>
                        <div class="layui-input-inline">
                            <select id="rcolumn" name="rcolumn">
                                <option value="">--所有--</option>
                                <c:forEach items="${resourceColumnList}" var="resourceColumn" varStatus="vs">
                                    <option value="${resourceColumn.cid}">${resourceColumn.cname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
                <button class="layui-btn" data-type="reload" style="position:relative;top:-8px;">筛选</button>
            </div>
            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">删除选中行数据</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                </div>
            </script>
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
            ,url: '${pageContext.request.contextPath}/xk/protect/resource'
            ,toolbar: '#toolbarDemo'
            ,cols: [[
                {checkbox: true}
                ,{field:'rid', title: 'ID', width:60}
                ,{field:'rtitle', title: '标题', width:200}
                ,{field:'rcolumn', title: '所属栏目', width:100}
                <c:if test="${sessionScope.admin.alevel<2}">
                ,{field:'rupdater', title: '创建用户', width:100}
                </c:if>
                ,{field:'rcreatedate', title: '创建日期', width:120}
                ,{field:'rupdater', title: '修改用户', width:100}
                ,{field:'rupdatedate', title: '修改日期', width:120}
                ,{field:'rviews', title: '浏览量', width:100}
                ,{field:'renable', title: '是否可用', width:100}
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
                        rtitle: $('#rtitle').val()
                        ,rcolumn: $('#rcolumn').val()
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
                layer.confirm('确定删除ID为' + data.rid + '的资源么', function(index){
                    layer.close(index);
                    del(data.rid);
                });
            } else if(obj.event === 'edit'){
                //跳转至目标页面
               loadPage("${pageContext.request.contextPath}/xk/protect/resource/" + data.rid);
            }
        });
        //在页面完成加载后再次渲染
        form.render();
    });

    //执行删除
    function del(id) {
        var idArray = new Array();
        idArray[0] = id;
        //ajax请求删除数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/protect/resource'
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
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/protect/resourcePage/resourceControl')", 500);
            }
        });
    }

    //执行多选删除
    function delSelect(data) {
        if(data.length == 0) {
            layer.msg("未选中行!");
        } else {
            layer.confirm('确定删除已选中的' + data.length + '行么?', function(index){
                layer.close(index);
                var idArray = new Array();
                for(var i=0; i<data.length; i++) {
                    idArray[i] = data[i].rid;
                }
                //执行删除
                $.ajax({
                    url:'${pageContext.request.contextPath}/xk/protect/resource'
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
                        setTimeout("loadPage('${pageContext.request.contextPath}/xk/protect/resourcePage/resourceControl')", 500);
                    }
                });
            });
        }
    }

</script>