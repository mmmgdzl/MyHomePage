<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmmgdzl
  Date: 2018/12/18
  Time: 13:34
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
    <meta name="keywords" content="星空の幻域">
    <meta name="description" content="星空の幻域">
    <meta name="author" content="mmmgdzl">

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
                        <h3>${pageBean.type}</h3>
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/">星空の幻域</a></li>
                            <li class="active">${pageBean.type}</li>
                        </ul>
                    </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section gb nopadtop">
        <div class="container">
            <div class="boxed boxedp4">
                <div class="row">
                    <div class="col-md-8">
                        <div class="row blog-grid">
                            <c:forEach items="${pageBean.data}" var="resource">
                                <div class="col-md-6">
                                    <div class="course-box">
                                        <div class="image-wrap entry">
                                            <a href="${pageContext.request.contextPath}/resourceInfo/${resource.rid}" title="">
                                                <img src="${resourceServer }/my/resource/titleImages/${resource.rtitleimg}" style="width: 400px;height: 228px;cursor:pointer;" alt="" class="img-responsive">
                                            </a>
                                        </div><!-- end image-wrap -->
                                        <div class="course-details" style="padding-bottom: 0;">
                                            <h4>
                                                <small>${resource.rcolumn}</small>
                                                <a href="${pageContext.request.contextPath}/resourceInfo/${resource.rid}" title="">${resource.rtitle}</a>
                                            </h4>
                                        </div><!-- end details -->
                                        <div class="course-footer clearfix">
                                            <div class="pull-left">
                                                <ul class="list-inline">
                                                    <li><a href="javascript:void(0);"><i class="fa fa-user"></i> ${resource.rcreater}</a></li>
                                                    <li><a href="javascript:void(0);"><i class="fa fa-clock-o"></i> ${resource.rupdatedate}</a></li>
                                                    <li><a href="javascript:void(0);"><i class="fa fa-eye"></i> ${resource.rviews}Views</a></li>
                                                </ul>
                                            </div><!-- end left -->
                                        </div><!-- end footer -->
                                    </div><!-- end box -->
                                </div><!-- end col -->
                            </c:forEach>
                        </div><!-- end row -->
                        <hr class="invis">
                        <div class="row">
                            <div class="col-md-12">
                                <ul class="pagination">
                                    <!-- 上一页 -->
                                    <c:if test="${pageBean.currentPage == 1}">
                                        <li class='disabled'><a href="javascript:void(0)">&laquo;</a></li>
                                    </c:if>
                                    <c:if test="${pageBean.currentPage != 1}">
                                        <li><a href="javascript:void(0)" onclick="toPage(1)">&laquo;</a></li>
                                    </c:if>
                                    <!--页数较少时 -->
                                    <c:if test="${pageBean.totalPage<10}">
                                        <c:forEach begin="1" end="${pageBean.totalPage}" var="num">
                                            <c:if test="${pageBean.currentPage==num}">
                                                <li class='active'><a href="javascript:void(0)">${num}</a></li>
                                            </c:if>
                                            <c:if test="${pageBean.currentPage!=num}">
                                                <li><a href="javascript:void(0)" onclick='toPage(${num})'>${num}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <!-- 页数较多时 -->
                                    <c:if test="${pageBean.totalPage>=10}">
                                        <c:forEach begin="${pageBean.currentPage-4>=1?(pageBean.currentPage+4<=pageBean.totalPage?pageBean.currentPage-4:pageBean.totalPage-8):1}"
                                                   end="${pageBean.currentPage-4>=1?(pageBean.currentPage+4<=pageBean.totalPage?pageBean.currentPage+4:pageBean.totalPage):9}"
                                                   var="num">
                                            <c:if test="${pageBean.currentPage==num}">
                                                <li class='active'><a href="javascript:void(0)">${num}</a></li>
                                            </c:if>
                                            <c:if test="${pageBean.currentPage!=num}">
                                                <li><a href="javascript:void(0)" onclick='toPage(${num})'>${num}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <!-- 下一页 -->
                                    <c:if test="${pageBean.currentPage+1>pageBean.totalPage}">
                                        <li class='disabled'><a href="javascript:void(0)">&raquo;</a></li>
                                    </c:if>
                                    <c:if test="${pageBean.currentPage+1<=pageBean.totalPage}">
                                        <li><a href="javascript:void(0)" onclick="toPage(${pageBean.currentPage+1})">&raquo;</a></li>
                                    </c:if>
                                </ul>
                            </div><!-- end col -->
                        </div><!-- end row -->
                    </div><!-- end col -->
                    <div class="sidebar col-md-4">
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
                        <a href="javascript:void(0);"><img src="${resourceServer }/images/logo.png" alt=""></a>
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
    
    function toPage(pageNum) {
        var cuurentHref = location.href;
        if(cuurentHref.indexOf("?") != -1) {
            cuurentHref = cuurentHref.substring(0, cuurentHref.indexOf("?"));
        }
        location.href = cuurentHref+"?currentPage=" + pageNum;
    }
    
</script>

</body>
</html>