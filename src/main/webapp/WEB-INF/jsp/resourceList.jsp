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
                        <h3>Blog & News</h3>
                        <ul class="breadcrumb">
                            <li><a href="javascript:void(0)">Edulogy</a></li>
                            <li class="active">Blog</li>
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
                            <div class="col-md-6">
                                <div class="course-box">
                                    <div class="image-wrap entry">
                                        <img src="${resourceServer }/base/blog_02.jpg" alt="" class="img-responsive">
                                        <div class="magnifier">
                                            <a href="blog-single.html" title=""><i class="flaticon-add"></i></a>
                                        </div>
                                    </div><!-- end image-wrap -->
                                    <div class="course-details">
                                        <h4>
                                            <small>Language</small>
                                            <a href="blog-single.html" title="">Learn English Online with our professional teachers</a>
                                        </h4>
                                        <p>Integer pellentesque justo vitae nisl sagittis, nec tristique erat tincidunt. Nunc varius euismod arcu ut volutpat. Praesent massa ex, sodales nullam. </p>
                                    </div><!-- end details -->
                                    <div class="course-footer clearfix">
                                        <div class="pull-left">
                                            <ul class="list-inline">
                                                <li><a href="#"><i class="fa fa-user"></i> Amanda</a></li>
                                                <li><a href="#"><i class="fa fa-clock-o"></i> 14 Jun</a></li>
                                                <li><a href="#"><i class="fa fa-eye"></i> 455 Views</a></li>
                                            </ul>
                                        </div><!-- end left -->
                                    </div><!-- end footer -->
                                </div><!-- end box -->
                            </div><!-- end col -->

                            <div class="col-md-6">
                                <div class="course-box">
                                    <div class="image-wrap entry">
                                        <a href="blog-single.html" title="">
                                            <img src="${resourceServer }/base/blog_03.jpg" alt="" class="img-responsive">
                                        </a>
                                    </div><!-- end image-wrap -->
                                    <div class="course-details">
                                        <h4>
                                            <small>Tips & Tricks</small>
                                            <a href="blog-single.html" title="">Working with team members for new projects</a>
                                        </h4>
                                        <p>Duis id aliquam metus, et consectetur risus. Praesent dictum augue id velit mattis aliquet. Aliquam faucibus sollicitudin libero, sit amet massa nunc. </p>
                                    </div><!-- end details -->
                                    <div class="course-footer clearfix">
                                        <div class="pull-left">
                                            <ul class="list-inline">
                                                <li><a href="#"><i class="fa fa-user"></i> Bob DOE</a></li>
                                                <li><a href="#"><i class="fa fa-clock-o"></i> 13 Jun</a></li>
                                                <li><a href="#"><i class="fa fa-eye"></i> 444 Views</a></li>
                                            </ul>
                                        </div><!-- end left -->
                                    </div><!-- end footer -->
                                </div><!-- end box -->
                            </div><!-- end col -->

                            <div class="col-md-6">
                                <div class="course-box">
                                    <div class="image-wrap entry">
                                        <img src="${resourceServer }/base/blog_01.jpg" alt="" class="img-responsive">
                                        <div class="magnifier">
                                            <a href="blog-single.html" title=""><i class="flaticon-add"></i></a>
                                        </div>
                                    </div><!-- end image-wrap -->
                                    <div class="course-details">
                                        <h4>
                                            <small>Tips & Tricks</small>
                                            <a href="blog-single.html" title="">Buy a Macbook and learn code today like a pro</a>
                                        </h4>
                                        <p>Nulla nisl velit, lobortis vel luctus eu, rutrum ac elit. Donec nec condimentum libero. Maecenas rutrum sit amet mi vel hendrerit. Praesent tempor id. </p>
                                    </div><!-- end details -->
                                    <div class="course-footer clearfix">
                                        <div class="pull-left">
                                            <ul class="list-inline">
                                                <li><a href="#"><i class="fa fa-user"></i> Edulogy</a></li>
                                                <li><a href="#"><i class="fa fa-clock-o"></i> 12 Jun</a></li>
                                                <li><a href="#"><i class="fa fa-eye"></i> 444 Views</a></li>
                                            </ul>
                                        </div><!-- end left -->
                                    </div><!-- end footer -->
                                </div><!-- end box -->
                            </div><!-- end col -->
                        </div><!-- end row -->

                        <hr class="invis">

                        <div class="row">
                            <div class="col-md-12">
                                <ul class="pagination" style="margin: 0 auto;">
                                    <li class="disabled"><a href="javascript:void(0)">&laquo;</a></li>
                                    <li class="active"><a href="javascript:void(0)">1</a></li>
                                    <li><a href="javascript:void(0)">2</a></li>
                                    <li><a href="javascript:void(0)">3</a></li>
                                    <li><a href="javascript:void(0)">...</a></li>
                                    <li><a href="javascript:void(0)">&raquo;</a></li>
                                </ul>
                            </div><!-- end col -->
                        </div><!-- end row -->
                    </div><!-- end col -->

                    <div class="sidebar col-md-4">
                        <div class="widget clearfix">
                            <h3 class="widget-title">Popular Posts</h3>
                            <div class="post-widget">
                                <div class="media">
                                    <img src="${resourceServer }/base/blog_small_01.jpg" alt="" class="img-responsive alignleft img-rounded">
                                    <div class="media-body">
                                        <h5 class="mt-0"><a href="blog-single.html">Learning English Like a Pro..</a></h5>
                                        <div class="blog-meta">
                                            <ul class="list-inline">
                                                <li>4 days ago</li>
                                                <li><span>by</span> <a href="#">Edulogy Team</a></li>
                                            </ul>
                                        </div><!-- end blog-meta -->
                                    </div>
                                </div>

                                <div class="media">
                                    <img src="${resourceServer }/base/blog_small_02.jpg" alt="" class="img-responsive alignleft img-rounded">
                                    <div class="media-body">
                                        <h5 class="mt-0"><a href="blog-single.html">How to create a beautiful website with Bootstrap</a></h5>
                                        <div class="blog-meta">
                                            <ul class="list-inline">
                                                <li>5 days ago</li>
                                                <li><span>by</span> <a href="#">Boby DOE</a></li>
                                            </ul>
                                        </div><!-- end blog-meta -->
                                    </div>
                                </div>

                                <div class="media">
                                    <img src="${resourceServer }/base/blog_small_03.jpg" alt="" class="img-responsive alignleft img-rounded">
                                    <div class="media-body">
                                        <h5 class="mt-0"><a href="blog-single.html">Don't forget to update your Google web master tools</a></h5>
                                        <div class="blog-meta">
                                            <ul class="list-inline">
                                                <li>6 days ago</li>
                                                <li><span>by</span> <a href="#">Martin</a></li>
                                            </ul>
                                        </div><!-- end blog-meta -->
                                    </div>
                                </div>
                            </div><!-- end post-widget -->
                        </div><!-- end widget -->
                    </div><!-- end sidebar -->
                </div><!-- end row -->
            </div><!-- end boxed -->
        </div><!-- end container -->
    </section>

    <footer class="section footer noover">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="widget clearfix">
                        <h3 class="widget-title">Join us today</h3>
                        <p>Would you like to earn your profits by joining our team? Join us without losing time.</p>
                        <a href="#" class="readmore">Became a Teacher</a>
                    </div><!-- end widget -->
                </div><!-- end col -->

                <div class="col-lg-4 col-md-4">
                    <div class="widget clearfix">
                        <h3 class="widget-title">Popular Tags</h3>
                        <div class="tags-widget">
                            <ul class="list-inline">
                                <li><a href="#">course</a></li>
                                <li><a href="#">web design</a></li>
                                <li><a href="#">development</a></li>
                                <li><a href="#">language</a></li>
                                <li><a href="#">teacher</a></li>
                                <li><a href="#">speaking</a></li>
                                <li><a href="#">material</a></li>
                                <li><a href="#">css3</a></li>
                                <li><a href="#">html</a></li>
                                <li><a href="#">learning</a></li>
                            </ul>
                        </div><!-- end list-widget -->
                    </div><!-- end widget -->
                </div><!-- end col -->

                <div class="col-lg-4 col-md-4">
                    <div class="widget clearfix">
                        <h3 class="widget-title">Support</h3>
                        <div class="list-widget">
                            <ul>
                                <li><a href="#">Terms of Use</a></li>
                                <li><a href="#">Copyrights</a></li>
                                <li><a href="#">Create a Ticket</a></li>
                                <li><a href="#">Pricing & Plans</a></li>
                                <li><a href="#">Carrier</a></li>
                                <li><a href="#">Trademark</a></li>
                            </ul>
                        </div><!-- end list-widget -->
                    </div><!-- end widget -->
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </footer><!-- end footer -->

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