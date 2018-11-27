<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ピザ屋のネット注文</title>
<link href="../../css/bootstrap.css" rel="stylesheet">
<link href="../../css/piza.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${pageContext.request.contextPath}/SearchItem/Search"> <!-- 企業ロゴ --> <img
						alt="main log" src="../../img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/showCartItem/showCart" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
						<a href="order_history.html" class="navbar-link">注文履歴</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/" class="navbar-link">ログイン</a>&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath}/logout" class="navbar-link">ログアウト</a>
					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>


		<!-- table -->
		<div class="row">
			<div
				class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
				<h3 class="text-center">ショッピングカート</h3>
				<table class="table table-striped">
					<tbody>
						<tr>
							<th>
								<div class="text-center">
									商品名
								</div>
							</th>
							<th>
								<div class="text-center">
									サイズ、価格(税抜)、数量
								</div>
							</th>
							<th>
								<div class="text-center">
									トッピング、価格(税抜)
								</div>
							</th>
							<th>
								<div class="text-center">
									小計
								</div>
							</th>
							<th>
							</th>
						</tr>
						
						
						<c:forEach var="orderItem" items="${order.orderItemList}">
						<tr>
							<td>
								<div class="center">
									<div class="img-responsive img-rounded" width="100" height="300"><img src="<c:out value="${orderItem.item.imagePath}"/>"></div><br>
									  <c:out value="${orderItem.item.name}"/>
								</div>
							</td>
							<td>
								<span class="price">&nbsp;<c:out value="${orderItem.size}"/></span>&nbsp;&nbsp;<c:out value="${orderItem.item.priceM}"/>
								&nbsp;&nbsp;<c:out value="${orderItem.quantity}"/>
								&nbsp;&nbsp;
							</td>
							<td>
								<ul>
									<c:forEach var="ordertopping" items="${orderItem.orderToppingList}">
									<li><c:out value="${ordertopping.topping.name}"/><c:out value="${topping.priceM}"/></li>
								  </c:forEach>
								</ul>
							</td>
							<td>
								<div class="text-center">
									<c:out value="${orderItem.subTotal}"/>
								</div>
							</td>
							<td>
								<form:form  method="post" action="${pageContext.request.contextPath}/delete/item">
									<div class="text-center">
										<input type="hidden" name="orderItemId" value="${orderItem.id}" >
										<button type="submit" class="btn btn-primary">削除</button>
									</div>
								</form:form>
							</td>
						</tr>

					</c:forEach>

					</tbody>
			
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="form-group text-center"></div>
					<span id="total-price">税<c:out value="${order.tax}"/>円</span><br>
					<span id="total-price"><c:out value="${order.calcTotalPrice}"/>円（税込み）</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-offset-5 col-xs-3">
				<div class="form-group">
					<form action="${pageContext.request.contextPath}/order/order">
						<input class="form-control btn btn-warning btn-block"
							type="submit" value="注文に進む">
					</form>
				</div>
			</div>
		</div>

	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>