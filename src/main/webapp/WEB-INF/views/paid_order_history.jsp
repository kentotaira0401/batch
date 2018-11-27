<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/bootstrap.css" rel="stylesheet">
<link href="../../css/piza.css" rel="stylesheet">
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
						<a href="${pageContext.request.contextPath}/showOrderHistory/notPaymentOrderHistory" class="navbar-link">未入金注文履歴</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/showOrderHistory/alreadySentOrderHistory" class="navbar-link">配送済み注文履歴</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/" class="navbar-link">ログイン</a>&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath}/logout" class="navbar-link">ログアウト</a>
					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>


<div class="row">
			<div
				class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
				<h3 class="text-center">入金済み</h3>
				<table class="table table-striped">
					<tbody>
						<tr>
						    <th>
								<div class="text-center">
									注文日
								</div>
							</th>
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
						<c:forEach var="paid-order" items="${paidOrderList}">
						<tr>
							<td>
								<span class="price">&nbsp;<c:out value="${paid-order.orderDate}"/></span>
							</td>
							<c:forEach var="orderItem" items="${paid-order.orderItemList}">
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
							
								</div>
							</td>
						</c:forEach>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>