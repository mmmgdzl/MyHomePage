<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2019/1/23
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${!empty param.select}">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css?t=1542630986927" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/layui/css/global.css?t=1542630986927-6" media="all">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.4.4.min.js"></script>
    <script async src="${pageContext.request.contextPath}/static/admin/layui/fromOtherWebSite/adsbygoogle.js"></script>
    <script src="${pageContext.request.contextPath}/static/admin/layui/layui.js?t=1542630986927" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-form.js" charset="utf-8"></script>
</c:if>
<!-- 内容主体区域 -->
<div class="layui-tab-item layui-show">
    <div class="layui-main">
        <div id="LAY_preview">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>系统资源管理</legend>
            </fieldset>
            <div class="demoTable">
                <form class="layui-form layui-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">系统资<br>源名称:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="srname" name="srname" placeholder="筛选系统资源名称"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">所属栏目:</label>
                        <div class="layui-input-inline">
                            <select id="srcolumn" name="srcolumn">
                                <option value="">--所有--</option>
                                <c:forEach items="${systemResourceColumnList}" var="systemResourceColumn" varStatus="vs">
                                    <option value="${systemResourceColumn.srcid}">${systemResourceColumn.srcname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">系统资<br>源状态:</label>
                        <div class="layui-input-inline">
                            <select id="srenable" name="srenable">
                                <option value="">--所有有效--</option>
                                <option value="1">可用</option>
                                <option value="0">不可用</option>
                                <option value="2">删除</option>
                            </select>
                        </div>
                        <label class="layui-form-label">创建用户:</label>
                        <div class="layui-input-inline">
                            <input type="hidden" id="aidSelect" name="aid">
                            <input type="text" id="aaccountSelect" placeholder="筛选创建用户"
                                   autocomplete="off" class="layui-input" disabled>
                        </div>
                        <button type="button" class="layui-btn" onclick="doSelectRcreater()">选择创建用户</button>
                        <button type="button" class="layui-btn" onclick="$('#aidSelect').val('');$('#aaccountSelect').val('');">清除选择</button>
                        <button type="button" class="layui-btn" data-type="reload">筛选</button>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">备注:</label>
                        <div class="layui-input-inline">
                            <input type="text" id="srdesc" name="srdesc" placeholder="筛选备注"
                                   autocomplete="off" class="layui-input">
                        </div>
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
                <c:if test="${empty param.select}">
                    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                </c:if>
                <c:if test="${!empty param.select}">
                    <a class="layui-btn layui-btn-xs" lay-event="select">选择</a>
                </c:if>
            </script>
        </div>
    </div>
</div>
<script type="text/html" id="fileA">
    <a href="javascript:void(0);" lay-event="a">{{d.srname}}</a>
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
            ,url: '${pageContext.request.contextPath}/xk/super/systemResource'
            ,toolbar: '#toolbarDemo'
            ,cols: [[
                {checkbox: true}
                ,{field:'srid', title: 'ID', width:60}
                ,{field:'srname', title: '文件名称(点击下载)', templet: '#fileA', unresize: true}
                ,{field:'srcreater', title: '创建用户'}
                ,{field:'srcreatedate', title: '创建日期', width:200}
                ,{field:'srcolumn', title: '所属栏目'}
                ,{field:'srenable', title: '状态'}
                ,{field:'srdesc', title: '备注'}
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
                        srname: $('#srname').val()
                        ,srcolumn: $('#srcolumn').val()
                        ,srcreater: $("#aidSelect").val()
                        ,srenable: $("#srenable").val()
                        ,srdesc:$("#srdesc").val()
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
                if(data.srenable == "删除") {
                    layer.msg("已删除的数据无法操作!");
                    return;
                }
                layer.confirm('确定删除ID为' + data.srid + '的系统资源么', function(index){
                    layer.close(index);
                    del(data.srid);
                });
            } else if(obj.event === 'edit'){
                if(data.srenable == "删除") {
                    layer.msg("已删除的数据无法操作!");
                    return;
                }
                //跳转至目标页面
               loadPage("${pageContext.request.contextPath}/xk/super/systemResource/" + data.srid);
            } else if(obj.event === 'a'){
                if(data.srenable == "删除") {
                    layer.msg("已删除的数据无法查看!");
                    return false;
                } else if(data.srenable == "不可用") {
                    layer.msg("不可用的数据无法查看!");
                    return false;
                }
                window.open(data.srfilename);
            } else if(obj.event === "select") {
                if(data.aenable == "删除") {
                    layer.msg("已删除的数据无法选择!");
                    return;
                }
                //将选择的数据传输至父页面
                parent.$("#sridSelect").val(data.srid);
                parent.$("#srnameSelect").val(data.srname);
                var index1 = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index1);//关闭窗口
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
            url:'${pageContext.request.contextPath}/xk/super/systemResource'
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
                setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/systemResourcePage/systemResourceControl')", 500);
            }
        });
    }

    //执行多选删除
    function delSelect(data) {
        if(data.length == 0) {
            layer.msg("未选中行!");
        } else if(data[0].srenable == "删除") {
            layer.msg("已删除的数据无法操作!");
        } else {
            layer.confirm('确定删除已选中的' + data.length + '行么?', function(index){
                layer.close(index);
                var idArray = new Array();
                for(var i=0; i<data.length; i++) {
                    idArray[i] = data[i].srid;
                }
                //执行删除
                $.ajax({
                    url:'${pageContext.request.contextPath}/xk/super/systemResource'
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
                        setTimeout("loadPage('${pageContext.request.contextPath}/xk/super/systemResourcePage/systemResourceControl')", 500);
                    }
                });
            });
        }
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

</script>