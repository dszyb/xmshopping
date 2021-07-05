<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>收货地址管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">

    <!--头部-->
    <div class="row">
        <div class="col-md-12" style="text-align:left;height: 60px;line-height: 60px;background-color: #dedede;color: blue;">
            <h3>收货地址管理</h3>
        </div>
    </div>

    <!--导航-->
    <div class="row" style="margin-top:20px;">
        <div class="col-md-12">
            <form class="form-inline" role="form" action="${pageContext.request.contextPath}/receiver/queryProvince" method="get">
                <div class="form-group">
					<label>所在省份</label>
					<input type="text" class="form-control" name="receiverProvince"/>
				</div>
				<input type="submit" class="btn btn-primary" value="查询" style="margin-left: 20px;"/>
				<input type="reset" class="btn btn-default" value="重置" />
            </form>
        </div>
    </div>
    
    <!--表格内容显示-->
    <div class="row" style="margin-top: 10px;height: 320px;">
        <table class="table table-bordered">
            <thead>
            	<tr>
					<th>收货ID</th>
					<th>用户ID</th>
					<th>联系人</th>
					<th>联系电话</th>
					<th>所在省份</th>
					<th>所在市</th>
					<th>所在区</th>
				</tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfos.list}" var="r">
                <tr>
                    <td>${r.receiverId}</td>
                    <td>${r.usersId}</td>
                    <td>${r.receiverName}</td>
                    <td>${r.receiverPhone}</td>
                    <td>${r.receiverProvince}</td>
                    <td>${r.receiverCity}</td>
                    <td>${r.receiverDistrict}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!--分页-->
    <div class="row">
        <div class="col-md-12" align="center">
            <ul class="pagination">
                <li><a href="${pageContext.request.contextPath}/receiver/getAllReceiver?pageNum=1&pageSize=5" aria-label="Previous">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/receiver/getAllReceiver?pageNum=${pageInfos.pageNum-1}&pageSize=5">上一页</a></li>
                <c:forEach begin="1" end="${pageInfos.pages}" var="pageNumber">
                    <li><a href="${pageContext.request.contextPath}/receiver/getAllReceiver?pageNum=${pageNumber}&pageSize=5">${pageNumber}</a></li>
                </c:forEach>
                <li><a href="${pageContext.request.contextPath}/receiver/getAllReceiver?pageNum=${pageInfos.pageNum+1}&pageSize=5">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/receiver/getAllReceiver?pageNum=${pageInfos.pages}&pageSize=5">尾页</a></li>
            </ul>
        </div>
    </div>

</div>
</body>
</html>
