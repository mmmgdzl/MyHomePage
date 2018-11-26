<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <!-- BEGIN # MODAL LOGIN -->
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Begin # DIV Form -->
                    <div id="div-forms">
                        <form id="login-form">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span class="flaticon-add" aria-hidden="true"></span>
                            </button>
                            <div class="modal-body" style="display:inline-block;">
                                <input class="form-control" type="text" placeholder="你 在 想 。。。" required>
                            </div>
                            <div class="modal-body" style="display:inline-block;">
                            	<img src="${resourceServer }/my/game/${gameWebSiteCatList[0].image }" />
                            </div>
                        </form><!-- End # Login Form -->
                    </div><!-- End # DIV Form -->
                </div>
            </div>
        </div>
        <!-- END # MODAL LOGIN -->

        <jsp:include page="header.jsp"></jsp:include>

        <section id="home" class="video-section js-height-full">
            <div class="overlay"></div>
            <div class="home-text-wrapper relative container">
                <div class="home-message">
                    <p>欢迎光临 <span>星空の幻域</span></p>
                    <small>该网站由mmmgdzl开发, 可能用于分享一些奇奇怪怪的资源和网站<br>(快乐就完事了)</small>
                    <div class="btn-wrapper">
                        <div class="text-center">
                            <a href="#" class="btn btn-default wow slideInRight" style="padding-top:0;padding-bottom:0;font-size:20px;line-height: 50px; width: 400px;height: 50px;">现在开始游览历程</a>
                        </div>
                    </div><!-- end row -->
                </div>
            </div>
            <div class="slider-bottom">
                <span>Copyright &copy; 2018 - 2018  MMMGDZL 执行</span>
            </div>
        </section>

    </div><!-- end wrapper -->

    <!-- jQuery Files -->
    <script type="text/javascript">
    	//获取服务器地址
    	var resourceServer = "${resourceServer}";
    </script>
    <script src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/carousel.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/animate.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/custom.js"></script>
    <!-- VIDEO BG PLUGINS -->
    <script src="${pageContext.request.contextPath }/static/js/videobg.js"></script>
	<script type="text/javascript">
		function gameChange(obj) {
			var href=$(obj).attr("href");
			var logo=$(obj).attr("logo");
			var label=$(obj).html();
			
			$("#gameHref1").attr("href", href);
			$("#gameHref2").attr("href", href);
			$("#gameLogo").attr("src", "${resourceServer }/my/game/" + logo);
			$("#gameLabel").html(label);
		}
	</script>
	
</body>
</html>