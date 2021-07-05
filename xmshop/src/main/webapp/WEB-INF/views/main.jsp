<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>小米商城-后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrapValidator.min.css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrapValidator.min.js"></script>

    <style type="text/css">
        .welcome {
            width: auto;
        }
        .myLi{
            cursor: pointer;
        }

    </style>

    <script type="text/javascript">
        $(function () {
            // 点击切换页面
            $("#users-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/users/getAllUsers");
            });
            $("#goods-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/goods/getAllGoods");
            });
            $("#orders-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/orders/getAllOrders");
            });
            $("#carts-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/carts/getAllCarts");
            });
            $("#receiver-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/receiver/getAllReceiver");
            });
            $('.list-group li').click(function(){
            	$('.list-group li').removeClass('active');
            	$(this).addClass('active');
            });
        });

        //TODO: 设置固定在底部的 footer 可以自适应高度
        function autoFooterHeight() {
            // 获取内容的高度
            var bodyHeight = $("body").height();
            // 获取底部导航的高度
            var navHeight = $(".footer").height();
            // 获取显示屏的高度
            var iHeight = document.documentElement.clientHeight || document.body.clientHeight;
            // 如果内容的高度大于（窗口的高度 - 导航的高度）,移除属性样式
            if (bodyHeight > (iHeight - navHeight)) {
                $("#footer").removeClass("navbar-fixed-bottom");
            }
        }

    </script>
</head>

<body>
<div class="wrapper-cc clearfix">
    <div class="content-cc">
        <!-- header start -->
        <div class="clear-bottom head">
            <div class="container head-cc">
                <p>小米商城<span>后台管理系统</span></p>
                <div class="welcome">
                    <div class="left">欢迎您：<span>${adminName}</span></div>
                    <a href="${pageContext.request.contextPath}/logins/LoginOut">
                    <button style="background: #337AB7; border-style: none;color:white;">退出</button>
                    </a>
                </div>
            </div>
        </div>
        <!-- header end -->
        
        <!-- content start -->
        <div class="container-flude flude-cc" id="a">
            <div class="row user-setting">
                <div class="col-md-2 user-wrap">
                    <ul class="list-group">
                        <li class="list-group-item myLi" id="users-set">
                            <i class="glyphicon glyphicon-user"></i> &nbsp;用户管理
                        </li>
                        <li class="list-group-item myLi" id="goods-set">
                            <i class="glyphicon glyphicon-gift"></i> &nbsp;商品管理
                        </li>
                        <li class="list-group-item myLi" id="orders-set">
                            <i class="glyphicon glyphicon-bookmark"></i> &nbsp;订单管理
                        </li>
                        <li class="list-group-item myLi" id="carts-set">
                            <i class="glyphicon glyphicon-shopping-cart"></i> &nbsp;购物车管理
                        </li>
                        <li class="list-group-item myLi" id="receiver-set">
                            <i class="glyphicon glyphicon-flag"></i> &nbsp;收货地址管理
                        </li>
                    </ul>
                </div>
                <div class="col-md-10" id="userPanel">
                    <iframe id="frame-id" src="${pageContext.request.contextPath}/users/getAllUsers"
                            width="100%" height="100%">
                    </iframe>
                </div>
            </div>
        </div>
        <!-- content end-->
    </div>
</div>

<!-- footers start -->
<footer id="footer" class="footer navbar-fixed-bottom">
    <div class="container-fluid footers">
        @2021  软件大专1904
    </div>
</footer>
<!-- footers end -->
</body>

</html>
