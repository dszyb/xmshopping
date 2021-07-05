<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>商品管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">

    <!--头部-->
    <div class="row">
        <div class="col-md-12" style="text-align:left;height: 60px;line-height: 60px;background-color: #dedede;color: blue;">
            <h3>商品管理</h3>
        </div>
    </div>

    <!--导航-->
    <div class="row" style="margin-top:20px;">
        <div class="col-md-12">
            <form class="form-inline" role="form" action="${pageContext.request.contextPath}/goods/queryName" method="get">
                <div class="form-group">
                    <label>商品名称</label>
                    <input type="text" class="form-control" name="name"/>
                </div>
                <input type="submit" class="btn btn-primary" value="查询" style="margin-left: 20px;"/>
                <input type="reset" class="btn btn-default" value="重置"/>
            </form>
        </div>
    </div>

    <!--添加按钮-->
    <div class="row" style="margin-top: 20px;">
        <button class="btn btn-primary" data-toggle="modal" data-target="#tianjia" data-backdrop>添加商品</button>
    </div>

    <!--表格内容显示-->
    <div class="row" style="margin-top: 10px;height: 320px;">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>商品ID</th>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品数量</th>
                <th>商品颜色</th>
                <th>商品版本</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfos.list}" var="g">
                <tr>
                    <td>${g.id}</td>
                    <td><img src="${g.cover}" height="40px"/></td>
                    <td>${g.name}</td>
                    <td>${g.price}</td>
                    <td>${g.quantity}</td>
                    <td>${g.color}</td>
                    <td>${g.edition}</td>
                    <td>
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#xiugai" onclick="editGoods(this)">修改</button>  
                        <a href="${pageContext.request.contextPath}/goods/deleteGoodsById/${g.id}">
                            <button class="btn btn-danger">删除</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!--分页-->
    <div class="row">
        <div class="col-md-12" align="center">
            <ul class="pagination">
                <li><a href="${pageContext.request.contextPath}/goods/getAllGoods?pageNum=1&pageSize=5" aria-label="Previous">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/goods/getAllGoods?pageNum=${pageInfos.pageNum-1}&pageSize=5">上一页</a></li>
                <c:forEach begin="1" end="${pageInfos.pages}" var="pageNumber">
                    <li><a href="${pageContext.request.contextPath}/goods/getAllGoods?pageNum=${pageNumber}&pageSize=5">${pageNumber}</a></li>
                </c:forEach>
                <li><a href="${pageContext.request.contextPath}/goods/getAllGoods?pageNum=${pageInfos.pageNum+1}&pageSize=5">下一页</a></li>
                <li><a href="${pageContext.request.contextPath}/goods/getAllGoods?pageNum=${pageInfos.pages}&pageSize=5">尾页</a></li>
            </ul>
        </div>
    </div>

</div>

<!--创建添加界面的模态框-->
<div class="modal fade" id="tianjia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
    	<form action="${pageContext.request.contextPath}/goods/insertGoods" method="post" enctype="multipart/form-data">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">添加商品</h4>
            </div>
            <div class="modal-body" align="center">
            		<div class="form-group form-inline">
                        <label>商品图片</label>
                        <input type="file" name="file"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品名称</label>
                        <input type="text" class="form-control" name="name"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品价格</label>
                        <input type="text" class="form-control" name="price"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品数量</label>
                        <input type="text" class="form-control" name="quantity"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品颜色</label>
                        <input type="text" class="form-control" name="color"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品版本</label>
                        <input type="text" class="form-control" name="edition"/>
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
    <form action="${pageContext.request.contextPath}/goods/updateGoods" method="post" enctype="multipart/form-data">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改商品</h4>
            </div>
            <div class="modal-body" align="center" style="text-align: center;">
            		<input type="hidden" name="id" id="gId"/>
                    <div class="form-group form-inline">
                        <label>商品名称</label>
                        <input type="text" class="form-control" name="name" id="gName" readonly="readonly"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品价格</label>
                        <input type="text" class="form-control" name="price" id="gPrice"/>
                    </div> 
                    <div class="form-group form-inline">
                        <label>商品数量</label>
                        <input type="text" class="form-control" name="quantity" id="gQuantity"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品颜色</label>
                        <input type="text" class="form-control" name="color" id="gColor"/>
                    </div>
                    <div class="form-group form-inline">
                        <label>商品版本</label>
                        <input type="text" class="form-control" name="edition" id="gEdition"/>
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
	function editGoods(obj) {
		var $td= $(obj).parents('tr').children('td');
		var td_id = $td.eq(0).text();
		var td_cover = $td.eq(1).text();
		var td_name = $td.eq(2).text();
		var td_price = $td.eq(3).text();
		var td_quantity = $td.eq(4).text();
		var td_color = $td.eq(5).text();
		var td_edition = $td.eq(6).text();
		$('#gId').val(td_id);
		$('#gCover').val(td_cover);
		$('#gName').val(td_name);
		$('#gPrice').val(td_price);
		$('#gQuantity').val(td_quantity);
		$('#gColor').val(td_color);
		$('#gEdition').val(td_edition);
	}
</script>
</html>
