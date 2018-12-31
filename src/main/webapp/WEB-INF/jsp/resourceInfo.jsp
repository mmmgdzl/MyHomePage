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

<div id="wrapper">
    <jsp:include page="header.jsp"></jsp:include>

    <section class="section db p120">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="tagline-message page-title text-center">
                        <h3>资源详情</h3>
                        <ul class="breadcrumb">
                            <li><a href="javascript:void(0)">星空の幻域</a></li>
                            <li class="active">资源详情</li>
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

                                <div class="blog-media">
                                    <img src="upload/blog_01.jpg" alt="" class="img-responsive img-rounded">
                                </div><!-- end media -->

                                <div id="rcontentShow" class="blog-desc-big" style="overflow: hidden;">
                                    ${pageBean.data.rcontent}
                                    <hr class="invis">
                                </div><!-- end desc -->
                            </div><!-- end blog -->
                        </div><!-- end content -->
                        <div class="authorbox">
                            <div class="site-publisher clearfix">
                                <img src="${resourceServer}/my/headImages/${pageBean.creater.aheadimg}" alt="" class="img-responsive img-circle">
                                <a href="single-agency.html" title=""><h4><small>CREATER</small> <span>${pageBean.creater.aname}</span></h4></a>
                                <p>${pageBean.creater.aintroduce}</p>
                            </div><!-- end publisher -->
                            <c:if test="${!empty pageBean.updater}">
                                <div class="site-publisher clearfix">
                                    <img src="${resourceServer}/my/headImages/${pageBean.updater.aheadimg}" alt="" class="img-responsive img-circle">
                                    <a href="single-agency.html" title=""><h4><small>LAST_UPDATER</small> <span>${pageBean.updater.aname}</span></h4></a>
                                    <p>${pageBean.updater.aintroduce}</p>
                                </div><!-- end publisher -->
                            </c:if>
                        </div><!-- end details -->
                    </div><!-- end col -->

                    <div class="sidebar col-md-4">
                        <div class="widget clearfix">
                            <div class="banner-widget">
                                <img src="${resourceServer }/my/resource/titleImages/${pageBean.data.rtitleimg}" alt="" class="img-responsive img-rounded">
                            </div>
                        </div>
                        <div class="widget clearfix">
                            <h3 class="widget-title">热门TOP5</h3>
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
                        <a href="#"><img src="images/logo.png" alt=""></a>
                    </div>
                </div>

                <div class="pull-right">
                    <div class="footer-links">
                        <ul class="list-inline">
                            <li>执行 : <a href="javascript:void(0);">MMMGDZL</a></li>
                            <li>资源共享入口 : <a href="${pageContext.request.contextPath}/xk" target="_blank" title="星空の聚合">星空の聚合</a></li>
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

</body>
</html>