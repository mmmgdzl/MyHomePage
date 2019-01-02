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
                        <input class="form-control" type="text" placeholder="你 在 想 。。。(别想了,这个还没做好)" required>
                    </div>
                </form><!-- End # Login Form -->
            </div><!-- End # DIV Form -->
        </div>
    </div>
</div>
<!-- END # MODAL LOGIN -->
<header id="header" class="header header-normal">
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
                    <a class="navbar-brand" href="javascript:void(0);"><img id="logoImage" src="${resourceServer }/images/logo-dark.png" alt=""></a>
                </div>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath }/">主页</a></li>
                    <%--<li class="dropdown yamm-fw yamm-half"><a href="${pageContext.request.contextPath }/resourceList/1" class="dropdown-toggle" xkfilter="flag">游戏 <b class="fa fa-angle-down"></b></a>
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
                    </li>--%>
                    <c:forEach items="${headerResourceColumnList}" var="headerResourceColumn">
                        <li class="dropdown yamm-fw yamm-half"><a href="${pageContext.request.contextPath }/resourceList/${headerResourceColumn.cid}" class="dropdown-toggle" xkfilter="flag">${headerResourceColumn.cname} <b class="fa fa-angle-down"></b></a>
                            <ul class="dropdown-menu" style="min-width: 120px;margin: 5px 10px; padding:5px 10px;">
                                <c:if test="${resourceColumnWebsiteMap[headerResourceColumn.cid].size() == 0}">
                                    <li>
                                        <div class="yamm-content clearfix">
                                            <h4 style="margin:0; padding:0;text-align:center;">暂无资源网站数据</h4>
                                        </div>
                                    </li>
                                </c:if>
                                <c:if test="${resourceColumnWebsiteMap[headerResourceColumn.cid].size() != 0}">
                                    <li>
                                        <div class="yamm-content clearfix">
                                            <div class="row-fluid">
                                                <div class="col-md-5 col-sm-5">
                                                    <h4>${headerResourceColumn.cname}资源站</h4>
                                                    <ul>
                                                        <c:forEach items="${resourceColumnWebsiteMap[headerResourceColumn.cid] }" var="resourceColumnWebsite">
                                                            <li><a href="${resourceColumnWebsite.rcwhref }" logo="${resourceColumnWebsite.rcwlogo }" target="_blank" onmouseover="websiteChange(this, ${headerResourceColumn.cid})">${resourceColumnWebsite.rcwname }</a></li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                                <div class="col-md-7 col-sm-7">
                                                    <div class="menu-widget text-center">
                                                        <a id="${headerResourceColumn.cid}-websiteHref1" href="${resourceColumnWebsiteMap[headerResourceColumn.cid][0].rcwhref }" target="_blank">
                                                            <div style="width:170px;height:170px;line-height:170px;border:1px dotted #ff0000;background-color: #f0f0f0">
                                                                <img id="${headerResourceColumn.cid}-websiteLogo" src="${resourceServer }/my/resourceColumnWebsiteLogo/${resourceColumnWebsiteMap[headerResourceColumn.cid][0].rcwlogo }" alt="" class="img-responsive" style="padding:0; margin:0;display: inline-block; vertical-align: middle;" >
                                                            </div><!-- end image-wrap -->
                                                        </a>
                                                        <h5 id="${headerResourceColumn.cid}-websiteLabel" style="width:170px;margin:0 auto">${resourceColumnWebsiteMap[headerResourceColumn.cid][0].rcwname }</h5>
                                                        <div style="width:170px;">
                                                            <a id="${headerResourceColumn.cid}-websiteHref2" style="margin:0 auto;" href="${resourceColumnWebsiteMap[headerResourceColumn.cid][0].rcwhref }" class="menu-button" target="_blank">前往</a>
                                                        </div >
                                                    </div><!-- end widget -->
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:if>
                            </ul>
                        </li>
                    </c:forEach>
                    <li class="dropdown yamm-fw yamm-half"><a href="${pageContext.request.contextPath }/xk" target="_blank" class="dropdown-toggle">资源分享<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu" style="min-width: 120px;margin: 5px 10px; padding:5px 10px;">
                            <li>
                                <div class="yamm-content clearfix">
                                    <h4 style="margin:0; padding:0;text-align:center;">老铁们帮我刷<br>多点测试数据呗</h4>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown yamm-fw yamm-half"><a href="javascript:void(0);" target="_blank" class="dropdown-toggle">关于本站 <b class="fa fa-angle-down"></b></a>
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
<script type="text/javascript">
    function websiteChange(obj, columnId) {
        var href=$(obj).attr("href");
        var logo=$(obj).attr("logo");
        var label=$(obj).html();

        $("#" + columnId + "-websiteHref1").attr("href", href);
        $("#" + columnId + "-websiteHref2").attr("href", href);
        $("#" + columnId + "-websiteLogo").attr("src", "${resourceServer }/my/resourceColumnWebsiteLogo/" + logo);
        $("#" + columnId + "-websiteLabel").html(label);
    }


</script>