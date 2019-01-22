<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/24
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"> <!--<![endif]-->
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Site Meta -->
    <title>星空の幻域</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="${resourceServer }/images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="${resourceServer }/images/apple-touch-icon.png">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i" rel="stylesheet">

    <!-- Custom & Default Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">

    <!--[if lt IE 9]>
    <script src="js/vendor/html5shiv.min.js"></script>
    <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
    <style>
        #rcontentShow > p {

        }

    </style>

</head>
<body>

<!-- LOADER -->
<div id="preloader">
    <img class="preloader" src="${resourceServer }/images/loader.gif" alt="">
</div><!-- end loader -->
<!-- END LOADER -->

<input id="resourceId" type="hidden" value="${pageBean.data.rid}">
<input id="replyId" type="hidden">

<div id="wrapper">
    <jsp:include page="header.jsp"></jsp:include>
    <section class="section db p120">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="tagline-message page-title text-center">
                        <h3>${pageBean.data.rtitle}</h3>
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/">星空の幻域</a></li>
                            <li><a href="${pageContext.request.contextPath}/resourceList/${pageBean.resourceColumn}">${pageBean.data.rcolumn}</a></li>
                            <li class="active">${pageBean.data.rtitle}</li>
                        </ul>
                    </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section gb nopadtop">
        <div class="container">
            <div class="boxed">
                <div class="row">
                    <div class="col-md-8">
                        <div class="content blog-list">
                            <div class="blog-wrapper clearfix">
                                <div class="blog-meta">
                                    <small><a href="javascript:void(0);">${pageBean.data.rcolumn}</a></small>
                                    <h3>${pageBean.data.rtitle}</h3>
                                    <ul class="list-inline">
                                        <li><span>创建者:</span><a href="javascript:void(0);">${pageBean.data.rcreater}</a></li>
                                        <li><span>创建日期:</span><a href="javascript:void(0);">${pageBean.data.rcreatedate}</a></li>
                                        <li><span>最后修改:</span><a href="javascript:void(0);">${pageBean.data.rupdatedate}</a></li>
                                    </ul>
                                </div><!-- end blog-meta -->

                                <div id="rcontentShow" class="blog-desc-big" style="overflow: hidden;">
                                    ${pageBean.data.rcontent}
                                    <hr class="invis">
                                </div><!-- end desc -->
                            </div><!-- end blog -->
                        </div><!-- end content -->
                        <div class="authorbox">
                            <div class="site-publisher clearfix">
                                <img src="${resourceServer}/my/headImages/${pageBean.creater.aheadimg}" alt="" class="img-responsive img-circle" style="min-height:130px;max-height: 130px;">
                                <a href="javascript:void(0);" title=""><h4><small>CREATER</small> <span>${pageBean.creater.aname}</span></h4></a>
                                <p>${pageBean.creater.aintroduce}</p>
                            </div><!-- end publisher -->
                            <c:if test="${!empty pageBean.updater}">
                                <div class="site-publisher clearfix">
                                    <img src="${resourceServer}/my/headImages/${pageBean.updater.aheadimg}" alt="" class="img-responsive img-circle" style="min-height:130px;max-height: 130px;">
                                    <a href="javascript:void(0);" title=""><h4><small>LAST_UPDATER</small> <span>${pageBean.updater.aname}</span></h4></a>
                                    <p>${pageBean.updater.aintroduce}</p>
                                </div><!-- end publisher -->
                            </c:if>
                        </div><!-- end details -->
                        <div id="resourceComments" class="content boxed-comment clearfix">
                                暂无评论
                        </div><!-- end content -->
                    </div><!-- end col -->

                    <div class="sidebar col-md-4">
                        <div class="widget clearfix">
                            <div class="banner-widget">
                                <img src="${resourceServer }/my/resource/titleImages/${pageBean.data.rtitleimg}" alt="" class="img-responsive img-rounded">
                            </div>
                        </div>
                        <div class="widget clearfix">
                            <h3 class="widget-title">热度TOP5</h3>
                            <div class="post-widget">
                                <c:forEach items="${hot}" var="hotR">
                                    <div class="media">
<a href="${pageContext.request.contextPath}/resourceInfo/${hotR.rid}">
    <img src="${resourceServer }/my/resource/titleImages/${hotR.rtitleimg}" style="max-width:80px; max-height: 80px;" alt="" class="img-responsive alignleft img-rounded">
</a>
<div class="media-body">
    <h5 class="mt-0"><a href="${pageContext.request.contextPath}/resourceInfo/${hotR.rid}">${hotR.rtitle}</a></h5>
    <div class="blog-meta">
        <ul class="list-inline">
            <li>${hotR.rupdatedate}</li>
            <li><span>by</span> <a href="javascript:void(0);">${hotR.rcreater}(${hotR.rviews})</a></li>
        </ul>
    </div><!-- end blog-meta -->
</div>
                                    </div>
                                </c:forEach>
                            </div><!-- end post-widget -->
                        </div><!-- end widget -->
                    </div><!-- end sidebar -->
                </div><!-- end row -->
            </div><!-- end boxed -->
        </div><!-- end container -->
    </section>

    <div class="copyrights">
        <div class="container">
            <div class="clearfix">
                <div class="pull-left">
                    <div class="cop-logo">
                        <a href="#"><img src="${resourceServer}/images/logo.png" alt=""></a>
                    </div>
                </div>

                <div class="pull-right">
                    <div class="footer-links">
                        <ul class="list-inline">
                            <li>执行 : <a href="javascript:void(0);">MMMGDZL</a></li>
                            <c:if test="${empty sessionScope.admin}">
                                <li>资源共享入口 : <a href="${pageContext.request.contextPath}/xk" target="_blank" title="星空の聚合">星空の聚合</a></li>
                            </c:if>
                            <c:if test="${!empty sessionScope.admin}">
                                <li>资源共享入口 : <a href="${pageContext.request.contextPath}/xk/protect/index" target="_blank" title="星空の聚合">星空の聚合</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- end container -->
    </div><!-- end copy -->
</div><!-- end wrapper -->

<!-- jQuery Files -->
<script src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/animate.js"></script>
<script src="${pageContext.request.contextPath }/static/js/custom.js"></script>
<script>

    //打开添加资源评论的窗口
    function toAddResourceComment(replyId, rccount) {
        if(replyId != null) {
            $("#replyId").val(replyId);
            layer.open({
                type: 2,
                title: '回复评论#'+rccount,
                shadeClose: true,
                shade: 0.8,
                area: ['400px', '380px'],
                content: '${pageContext.request.contextPath}/xk/protect/resourceCommentPage/addResourceComment'
            });
        } else {
            $("#replyId").val("");
            layer.open({
                type: 2,
                title: '添加评论',
                shadeClose: true,
                shade: 0.8,
                area: ['400px', '260px'],
                content: '${pageContext.request.contextPath}/xk/protect/resourceCommentPage/addResourceComment'
            });
        }

    }
    
    //执行ajax获取资源评论
    function getResourceComments(currentPage, pageSize) {
        
        $.ajax({
            url:"${pageContext.request.contextPath}/resourceInfo/resourceComments",
            data:{rid:${pageBean.data.rid}, currentPage:currentPage, pageSize:pageSize},
            type:'POST',
            dataType: 'json',
            success: function (data) {
                if(data.rcCount == 0) {
                    if(${empty sessionScope.admin})
                        $("#resourceComments").html("暂无评论&nbsp;<small>(评论或回复请先<a href=\"javascript:void(0);\" title=\"登录\" onclick=\"doLogin()\">登录</a>或<a href=\"javascript:void(0);\" title=\"注册\" onclick=\"doRegister()\">注册</a>)</small>");
                    else
                        $("#resourceComments").html("暂无评论<a href=\"javascript:void(0);\" style='float:right;min-height: 30px;max-height: 30px;line-height: 20px;padding:5px 10px;' class=\"btn btn-primary btn-sm\" onclick='toAddResourceComment()'>添加评论</a>");
                } else {
                    var resourceComment = "<h3 class=\"small-title\">共" + data.rcTotalPage + "页," + data.rcCount + "条评论";
                    if(${!empty sessionScope.admin})
                        resourceComment += "<a href=\"javascript:void(0);\" style='float:right;min-height: 30px;max-height: 30px;line-height: 20px;padding:5px 10px;' class=\"btn btn-primary btn-sm\" onclick='toAddResourceComment()'>添加评论</a>";
                    else
                        resourceComment += "&nbsp;<small>(评论或回复请先<a href=\"javascript:void(0);\" title=\"登录\" onclick=\"doLogin()\">登录</a>或<a href=\"javascript:void(0);\" title=\"注册\" onclick=\"doRegister()\">注册</a>)</small>";
                    resourceComment += "</h3>\n<div class=\"comments-list\">\n";
                    for(var i=0; i<data.resourceCommentList.length; i++) {
                        resourceComment +=
                            "<div class=\"media\">\n" +
                            "    <p class=\"pull-right\"><small>" + data.resourceCommentList[i].rccreatedate + "&nbsp;&nbsp;</small></p>\n" +
                            "    <a class=\"media-left\" href=\"javascript:void(0);\">\n" +
                            "        <img src=\"${resourceServer}/my/headImages/" + data.resourceCommentAdminMap[data.resourceCommentList[i].rcid].aheadimg + "\" alt=\"\" class=\"img-circle\" style=\"min-height: 80px;max-height: 80px;\">\n" +
                            "    </a>\n" +
                            "    <div class=\"media-body\" style=\"word-wrap:break-word;word-break:break-all;\">\n" +
                            "        <h4 class=\"media-heading user_name\" style=\"display:inline;\">" + data.resourceCommentAdminMap[data.resourceCommentList[i].rcid].aname + "</h4>\n" +
                            "        <p style=\"display:inline;\">" + "&nbsp;&nbsp;#" + data.resourceCommentList[i].rccount + (data.resourceCommentList[i].rcreply=='无'?"":("回复#"+data.resourceCommentList[i].rcreply)) + "</p>\n" +
                            "        <p id='reply-" + data.resourceCommentList[i].rcid + "'>" + data.resourceCommentList[i].rccontent + "</p>\n";
                        if(${!empty sessionScope.admin})
                            resourceComment += "        <a href=\"javascript:void(0);\" class=\"btn btn-primary btn-sm\" onclick='toAddResourceComment(" + data.resourceCommentList[i].rcid + ", " + data.resourceCommentList[i].rccount + ")'>回复</a>\n";
                            resourceComment += "    </div>\n" +
                            "</div>\n";
                    }
                    resourceComment += "</div>\n";
                    //评论分页
                    var pageSize = 5;
                    resourceComment += "<div class=\"row\">\n" +
                        "<div class=\"col-md-12\">\n" +
                        "<ul class=\"pagination\">\n";
                    //上一页
                    if(data.rcCurrentPage == 1) {
                        resourceComment += "<li class='disabled'><a href=\"javascript:void(0)\">&laquo;</a></li>\n";
                    } else {
                        resourceComment += "<li><a href=\"javascript:void(0)\" onclick=\"getResourceComments(" + (parseInt(data.rcCurrentPage)-1) + ", " + pageSize + ")\">&laquo;</a></li>\n";
                    }
                    //页数较少时
                    if(data.rcTotalPage < 10) {
                        for(var i=1; i<= data.rcTotalPage; i++) {
                            if(i == data.rcCurrentPage)
                                resourceComment += "<li class='active'><a style='cursor:pointer;' href=\"javascript:void(0)\" onclick='getResourceComments(" + i + ", " + pageSize + ")'>" + i+ "</a></li>\n";
                            else
                                resourceComment += "<li><a href=\"javascript:void(0)\" onclick='getResourceComments(" + i + ", " + pageSize + ")'>" + i + "</a></li>\n";
                        }
                    } else {
                        //页数较多时
                        //第一页
                        if(data.rcCurrentPage == 1)
                            resourceComment += "<li class='active'><a style='cursor:pointer;' href=\"javascript:void(0)\" onclick='getResourceComments(1, " + pageSize + ")'>1</a></li>\n";
                        else
                            resourceComment += "<li><a href=\"javascript:void(0)\" onclick='getResourceComments(1, " + pageSize + ")'>1</a></li>\n";

                        //如果与第一页衔接
                        if(data.rcCurrentPage -4 <= 1) {
                            //连接第一页
                            for(var i=2; i< data.rcCurrentPage; i++) {
                                resourceComment += "<li><a href=\"javascript:void(0)\" onclick='getResourceComments(" + i + ", " + pageSize + ")'>" + i + "</a></li>\n";
                            }
                            //如果当前页不是第一页则连接当前页
                            if(data.rcCurrentPage != 1)
                                resourceComment += "<li class='active'><a style='cursor:pointer;' href=\"javascript:void(0)\" onclick='getResourceComments(" + data.rcCurrentPage + ", " + pageSize + ")'>" + data.rcCurrentPage+ "</a></li>\n";
                            //延伸到第七位
                            for(var i=data.rcCurrentPage + 1; i<=7; i++) {
                                resourceComment += "<li><a href=\"javascript:void(0)\" onclick='getResourceComments(" + i + ", " + pageSize + ")'>" + i + "</a></li>\n";
                            }
                            //添加省略号并连接到最后一页
                            resourceComment += "<li><a href=\"javascript:void(0)\">...</a></li>\n";
                        } else {
                            //省略号连接第一页
                            resourceComment += "<li><a href=\"javascript:void(0)\">...</a></li>\n";
                            var startPage;
                            var endPage;
                            //如果与最后一页相邻
                            if(data.rcCurrentPage +4 >= data.rcTotalPage) {
                                startPage = data.rcTotalPage - 6;
                                endPage = data.rcTotalPage - 1;
                            } else {
                                startPage = data.rcCurrentPage - 2;
                                endPage = data.rcCurrentPage + 2;
                            }
                            for(var i = startPage; i<=endPage; i++) {
                                if(i == data.rcCurrentPage)
                                    resourceComment += "<li class='active'><a style='cursor:pointer;' href=\"javascript:void(0)\" onclick='getResourceComments(" + i + ", " + pageSize + ")'>" + i+ "</a></li>\n";
                                else
                                    resourceComment += "<li><a href=\"javascript:void(0)\" onclick='getResourceComments(" + i + ", " + pageSize + ")'>" + i + "</a></li>\n";
                            }
                            //如果无法连接到最后一页则用省略号连接最后一页
                            if(data.rcCurrentPage +4 < data.rcTotalPage) {
                                resourceComment += "<li><a href=\"javascript:void(0)\">...</a></li>\n";
                            }
                        }

                        //最后一页
                        if(data.rcCurrentPage == data.rcTotalPage)
                            resourceComment += "<li class='active'><a style='cursor:pointer;' href=\"javascript:void(0)\" onclick='getResourceComments(" + data.rcTotalPage + ", " + pageSize + ")'>" + data.rcTotalPage + "</a></li>\n";
                        else
                            resourceComment += "<li><a href=\"javascript:void(0)\" onclick='getResourceComments(" + data.rcTotalPage + ", " + pageSize + ")'>" + data.rcTotalPage + "</a></li>\n";
                    }
                    //下一页
                    if(data.rcCurrentPage == data.rcTotalPage) {
                        resourceComment += "<li class='disabled'><a href=\"javascript:void(0)\">&raquo;</a></li>\n";
                    } else {
                        resourceComment += "<li><a href=\"javascript:void(0)\" onclick=\"getResourceComments(" + (1+parseInt(data.rcCurrentPage)) + ", " + pageSize + ")\">&raquo;</a></li>\n";
                    }
                    resourceComment += "</ul>\n";
                    resourceComment += "</div>\n";
                    resourceComment += "</div>\n";
                    $("#resourceComments").html(resourceComment);
                }
            }
        });
        
    }
    
    window.onload = function() {
        //执行ajax获取资源评论
        getResourceComments(1, 5);
    }
    
</script>

</body>
</html>