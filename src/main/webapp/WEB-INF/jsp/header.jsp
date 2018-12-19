<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <div class="modal-body">
                        <input class="form-control" type="text" placeholder="你 在 想 。。。(按ESC退出)" required>
                    </div>
                </form><!-- End # Login Form -->
            </div><!-- End # DIV Form -->
        </div>
    </div>
</div>
<!-- END # MODAL LOGIN -->
<header id="header" class="header header-normal">
	<audio src="${resourceServer }/my/music/christmas-bg.mp3" autoplay="autoplay" loop="loop"></audio>
    <div class="topbar clearfix">
        <div class="container">
            <div class="row-fluid">
                <div class="col-md-6 col-sm-6 text-left">
                    <p>
                        <strong><i class="fa fa-phone"></i></strong> <a href="javascript:void(0);"> +13556510714</a> &nbsp;&nbsp;
                        <strong><i class="fa fa-envelope"></i></strong> <a href="javascript:void(0);">738272815@qq.com</a>
                    </p>
                </div><!-- end left -->
                <div class="col-md-6 col-sm-6 hidden-xs text-right">
                    <div class="social">
                        <a class="facebook" href="javascript:void(0);" data-tooltip="tooltip" data-placement="bottom" title="这些"><i class="fa fa-facebook"></i></a>              
                        <a class="twitter" href="javascript:void(0);" data-tooltip="tooltip" data-placement="bottom" title="是拿来"><i class="fa fa-twitter"></i></a>
                        <a class="google" href="javascript:void(0);" data-tooltip="tooltip" data-placement="bottom" title="装饰(逼)的"><i class="fa fa-google-plus"></i></a>
                        <a class="linkedin" href="javascript:void(0);" data-tooltip="tooltip" data-placement="bottom" title="就别想着"><i class="fa fa-linkedin"></i></a>
                        <a class="pinterest" href="javascript:void(0);" data-tooltip="tooltip" data-placement="bottom" title="点啦"><i class="fa fa-pinterest"></i></a>
                    </div><!-- end social -->
                </div><!-- end left -->
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end topbar -->

    <div class="container">
        <nav class="navbar navbar-default yamm">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="logo-normal">
                    <a class="navbar-brand" href="index.html"><img id="logoImage" src="${resourceServer }/images/logo-dark.png" alt=""></a>
                </div>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath }">主页</a></li>
                    <li class="dropdown yamm-fw yamm-half"><a href="${pageContext.request.contextPath }/index" class="dropdown-toggle active">游戏 <b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="yamm-content clearfix">
                                    <div class="row-fluid">
                                        <div class="col-md-5 col-sm-5">
                                            <h4>游戏资源站</h4>
                                            <ul>
                                            	<c:forEach items="${gameWebSiteCatList }" var="item">
                                                	<li><a href="${item.url }" logo="${item.image }" target="_blank" onmouseover="gameChange(this)">${item.name }</a></li>
                                            	</c:forEach>
                                            </ul>
                                        </div>
                                        <div class="col-md-7 col-sm-7">
                                            <div class="menu-widget text-center">
                                                <a id="gameHref1" href="${gameWebSiteCatList[0].url }" target="_blank">
                                               		 <div style="width:170px;height:170px;line-height:170px;border:1px dotted #ff0000;background-color: #f0f0f0">
                                                    	<img id="gameLogo" src="${resourceServer }/my/game/${gameWebSiteCatList[0].image }" alt="" class="img-responsive" style="padding:0; margin:0;display: inline-block; vertical-align: middle;" >
                                                	</div><!-- end image-wrap -->
                                                </a>
                                                <h5 id="gameLabel" style="width:170px;margin:0 auto">${gameWebSiteCatList[0].name }</h5>
                                                <div style="width:170px;">
                                               	 <a id="gameHref2" style="margin:0 auto;" href="${gameWebSiteCatList[0].url }" class="menu-button" target="_blank">前往</a>
                                            	</div >
                                            </div><!-- end widget -->
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown yamm-fw yamm-half"><a href="${resourceServer }/index" class="dropdown-toggle active">视频 <b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu" style="min-width: 120px;margin: 5px 10px; padding:5px 10px;">
                            <li>
                                <div class="yamm-content clearfix">
                                    <h4 style="margin:0; padding:0;text-align:center;">暂未开放</h4>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown yamm-fw yamm-half"><a href="${resourceServer }/index" class="dropdown-toggle active">音乐 <b class="fa fa-angle-down"></b></a>
                         <ul class="dropdown-menu" style="min-width: 120px;margin: 5px 10px; padding:5px 10px;">
                            <li>
                                <div class="yamm-content clearfix">
                                    <h4 style="margin:0; padding:0;text-align:center;">暂未开放</h4>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown yamm-fw yamm-half"><a href="${resourceServer }/index" class="dropdown-toggle active">学习 <b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu" style="min-width: 120px;margin: 5px 10px; padding:5px 10px;">
                            <li>
                                <div class="yamm-content clearfix">
                                    <h4 style="margin:0; padding:0;text-align:center;">不存在的</h4>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown yamm-fw yamm-half"><a href="${pageContext.request.contextPath }/about" class="dropdown-toggle active">关于本站 <b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu" style="min-width: 300px;margin: 5px 10px; padding:5px 10px;">
                            <li>
                                <div class="col-md-12 col-sm-12">
                                    <h4>站点统计</h4>
                                    <ul>
                                       	<li><span style="color:black;">网站总访问量:</span>${TOTAL_REQUEST }</li>
                                       	<li><span style="color:black;">网站总访问人数:</span>${TOTAL_VISITOR }</li>
                                       	<li><span style="color:black;">网站当前在线人数:</span>${CURRENT_VISITOR }</li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="iconitem"><a href="#" data-toggle="modal" data-target="#login-modal"><i class="fa fa-search"></i></a></li>
                </ul>
            </div>
        </nav><!-- end navbar -->
    </div><!-- end container -->
</header>
