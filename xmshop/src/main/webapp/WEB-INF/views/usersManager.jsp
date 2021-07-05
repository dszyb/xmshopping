<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	</head>
<body>
<div class="container-fluid">
			<!--头部-->
			<div class="row">
				<div class="col-md-12" style="text-align:left;height: 60px;line-height: 60px;background-color: #dedede;color: blue;">
					<h3>用户管理</h3>
				</div>
			</div>
			<!--导航-->
			<div class="row" style="margin-top:20px;">
				<div class="col-md-12">
					<form class="form-inline" role="form" action="${pageContext.request.contextPath}/users/queryAddress" method="get">
						<div class="form-group" style="margin-left: 20px;">
							<label>用户地址</label>
							<input type="text" class="form-control" name="address"/>
						</div>
						<input type="submit" class="btn btn-primary" value="查询" style="margin-left: 20px;"/>
						<input type="reset" class="btn btn-default" value="重置"/>
					</form>
				</div>
			</div>
			<!--添加按钮-->
			<div class="row" style="margin-top: 20px;">
				<button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#tianjia" data-backdrop>添加用户</button>
			</div>
			<!--表格内容显示-->
			<div class="row" style="margin-top: 10px;height: 320px;">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户姓名</th>
							<th>用户手机号码</th>
							<th>用户地址</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfos.list}" var="u">
                			<tr>
                    			<td>${u.id}</td>
                    			<td>${u.username}</td>
                    			<td>${u.phone}</td>
                    			<td>${u.address}</td>
                    			<td>
                    				<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#xiugai" onclick="editUsers(this)">修改</button>  
                        			<a href="${pageContext.request.contextPath}/users/deleteUsersById/${u.id}">
                            			<button class="btn btn-danger">删除</button>
                        			</a>
                    			</td>
                    		</tr>
            			</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-md-12" align="center">
					<ul class="pagination">
                		<li><a href="${pageContext.request.contextPath}/users/getAllUsers?pageNum=1&pageSize=5" aria-label="Previous">首页</a></li>
                		<li><a href="${pageContext.request.contextPath}/users/getAllUsers?pageNum=${pageInfos.pageNum-1}&pageSize=5">上一页</a></li>
                		<c:forEach begin="1" end="${pageInfos.pages}" var="pageNumber">
                    		<li><a href="${pageContext.request.contextPath}/users/getAllUsers?pageNum=${pageNumber}&pageSize=5">${pageNumber}</a></li>
                		</c:forEach>
               			<li><a href="${pageContext.request.contextPath}/users/getAllUsers?pageNum=${pageInfos.pageNum+1}&pageSize=5">下一页</a></li>
                		<li><a href="${pageContext.request.contextPath}/users/getAllUsers?pageNum=${pageInfos.pages}&pageSize=5">尾页</a></li>
            		</ul>
				</div>
			</div>
		</div>
		
		<!--创建添加界面的模态框-->
		<div class="modal fade" id="tianjia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
    <form action="${pageContext.request.contextPath}/users/insertUsers" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">添加用户</h4>
            </div>
            <div class="modal-body" align="center">
                    <div class="form-group form-inline">
                        <label>用户姓名</label>
                        <input type="text" class="form-control" name="username"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>用户密码</label>
                        <input type="text" class="form-control" name="password"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>用户手机号码</label>
                        <input type="text" class="form-control" name="phone"/>
                    </div>
                     <div class="form-group form-inline">
                        <label>用户地址</label>
                        <input type="text" class="form-control" name="address"/>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">添加</button>
                <button class="btn btn-primary" data-dismiss="modal">取消</button>
            </div>
        </div>
        </form>
    </div>
</div>
		
		<!--创建修改界面的模态框-->
		<div class="modal fade" id="xiugai" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <form action="${pageContext.request.contextPath}/users/updateUsers" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改用户</h4>
            </div>
            <div class="modal-body" align="center">
                	<input type="hidden" name="id" id="uId"/>
                    <div class="form-group form-inline">
                        <label>用户姓名</label>
                        <input type="text" class="form-control" name="username" id="uUsername"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>用户地址</label>
                        <input type="text" class="form-control" name="address" id="uAddress"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>用户手机号码</label>
                        <input type="text" class="form-control" name="phone" id="uPhone"/>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">提交</button>
                <button class="btn btn-primary" data-dismiss="modal">取消</button>
            </div>
        </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
	function editUsers(obj) {
		var $td= $(obj).parents('tr').children('td');
		var td_id = $td.eq(0).text();
		var td_name = $td.eq(1).text();
		var td_phone = $td.eq(2).text();
		var td_address = $td.eq(3).text();
		$('#uId').val(td_id);
		$('#uUsername').val(td_name);
		$('#uPhone').val(td_phone);
		$('#uAddress').val(td_address);
	}
</script>
</html>