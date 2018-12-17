<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/11/28
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 内容主体区域 -->
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>管理员管理</legend>
            </fieldset>
            <div class="demoTable">
                筛选账号：
                <form class="layui-form layui-inline">
                    <div class="layui-inline">
                        <input type="text" id="account" name="account" class="layui-input" lay-search>
                    </div>
                </form>
                <button class="layui-btn" data-type="reload">筛选</button>
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
    layui.use('table', function(){
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#table'
            ,url: '${pageContext.request.contextPath}/xk/super/admin'
            ,toolbar: '#toolbarDemo'
            ,cols: [[
                {checkbox: true}
                ,{field:'id', title: 'ID', width:150}
                ,{field:'account', title: '账号', width:150}
                ,{field:'level', title: '管理员等级', width:150}
                ,{field:'right', title: '操作', width:170,toolbar:"#barDemo"}
            ]]
            ,id: 'testReload'
            ,page: {
                // layout: ['count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            }
        });

        var $ = layui.$, active = {
            reload: function(){
                var account = $('#account');

                table.reload('testReload', {
                    where: {
                        account: account.val()
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
                layer.confirm('确定删除ID为' + data.id + '的行么', function(index){
                    layer.close(index);
                    del(data.id);
                });
            } else if(obj.event === 'edit'){
                //跳转至目标页面
               loadPage("${pageContext.request.contextPath}/xk/super/admin/" + data.id);
            }
        });
    });

    //执行删除
    function del(id) {
        var idArray = new Array();
        idArray[0] = id;
        //ajax请求删除数据
        $.ajax({
            url:'${pageContext.request.contextPath}/xk/super/admin'
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
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/adminControl')", 500);
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
                    idArray[i] = data[i].id;
                }
                //执行删除
                $.ajax({
                    url:'${pageContext.request.contextPath}/xk/super/admin'
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
                        setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/adminControl')", 500);
                    }
                });
            });
        }
    }

</script>