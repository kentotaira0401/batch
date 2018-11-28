<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
						<a href="${pageContext.request.contextPath}/showCartItem/showCart"
							class="navbar-link">ショッピングカート</a>&nbsp;&nbsp; <a
							href="order_history.html" class="navbar-link">注文履歴</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/" class="navbar-link">ログイン</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/logout"
							class="navbar-link">ログアウト</a>
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
				<h3 class="text-center">注文内容確認</h3>

				<table class="table table-striped">
					<tbody>
						<tr>
							<th>
								<div class="text-center">商品名</div>
							</th>
							<th>
								<div class="text-center">サイズ、価格(税抜)、数量</div>
							</th>
							<th>
								<div class="text-center">トッピング、価格(税抜)</div>
							</th>
							<th>
								<div class="text-center">小計</div>
							</th>
						</tr>

						<c:forEach var="orderItem" items="${order.orderItemList}">
							<tr>
								<td>
									<div class="center">
										<div class="img-responsive img-rounded" width="50"
											height="100">
											<img src="<c:out value="${orderItem.item.imagePath}"/>">
										</div>
										<br>
										<c:out value="${orderItem.item.name}" />
									</div>
								</td>
								<td><span class="price">&nbsp;<c:out
											value="${orderItem.size}" /></span>&nbsp;&nbsp;<c:out
										value="${orderItem.item.priceM}" /> &nbsp;&nbsp;<c:out
										value="${orderItem.quantity}" /></td>
								<td>
									<ul>
										<c:forEach var="ordertopping"
											items="${orderItem.orderToppingList}">
											<li><c:out value="${ordertopping.topping.name}" />
												<c:out value="${topping.priceM}" /></li>
										</c:forEach>
									</ul>
								</td>
								<td>
									<div class="text-center"><c:out value="${orderItem.subTotal}"/></div>
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
				<span id="total-price">税<c:out value="${order.tax}" />円
				</span><br> <span id="total-price"><c:out
						value="${order.calcTotalPrice}" />円（税込み）</span>
			</div>
		</div>
	    </div>

	<!-- table -->
		<form:form modelAttribute="orderForm" action="${pageContext.request.contextPath}/order/orderConfirm" method="POST">
			<div class="row">
				<div
					class="table-responsive col-lg-offset-3 col-lg-6 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
					<h3 class="text-center">お届け先情報</h3>
					<table class="table table-striped">
						<tbody>
							<tr>
								<td>
									<div class="text-center">
										お名前
									</div>
								</td>
								<td>
								<form:errors path="destinationName" cssStyle="color:red" element="div"/>
									<form:input path="destinationName"/>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text-center">
										メールアドレス
									</div>
								</td>
								<td>
								<form:errors path="destinationEmail" cssStyle="color:red" element="div"/>
									<form:input path="destinationEmail"/>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text-center">
										郵便番号
									</div>
								</td>
								<td>
								<form:errors path="destinationZipcode" cssStyle="color:red" element="div"/>
									<form:input path="destinationZipcode"/>&nbsp;&nbsp;
									<button type="button" id="btn2">住所検索</button>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text-center">
										住所
									</div>
								</td>
								<td>
								<form:errors path="destinationAddress" cssStyle="color:red" element="div"/>
									<form:input path="destinationAddress"/>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text-center">
										電話番号
									</div>
								</td>
								<td>
								<form:errors path="destinationTel" cssStyle="color:red" element="div"/>
									<form:input path="destinationTel"/>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text-center">
										配達日時
									</div>
								</td>
								<td>
								
									<div class="form-group">
										<div class="row">
											<div class="col-sm-12">
												<form:errors path="deliverlyTime" cssStyle="color:red" element="div"/>
											</div>
											<div class="col-sm-5">
												<form:input path="deliverlyTime" type="date" name="name" id="name"
													class="form-control input-sm"/>
											</div>
											
										</div>
										<div class="row">
											<div class="col-sm-12">
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="10"
														name="responsibleCompany" checked="checked"/>
													10時
												</label>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="11"
														name="responsibleCompany"/> 
													11時
												</label>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="12"
														name="responsibleCompany"/> 
													12時
												</label><br>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="13"
														name="responsibleCompany"/> 
													13時
												</label>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="14"
														name="responsibleCompany"/> 
													14時
												</label>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="15"
														name="responsibleCompany"/> 
													15時
												</label><br>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="16"
														name="responsibleCompany"/> 
													16時
												</label>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="17"
														name="responsibleCompany"/> 
													17時
												</label>
												<label class="radio-inline"> 
													<form:radiobutton path="deliverlyTime" value="18"
														name="responsibleCompany"/> 
													18時
												</label><br>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
			<!-- table -->
			<div class="row">
				<div
					class="table-responsive col-lg-offset-3 col-lg-6 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
					<h3 class="text-center">お支払い方法</h3>
					<table class="table table-striped">
						<tbody>
							<tr>
								<td>
									<div class="text-center">
										代金引換
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-sm-12">
											<label class="radio-inline"> 
											<form:errors path="paymentMethod" cssStyle="color:red" element="div"/>
												<form:radiobutton value="1" path="paymentMethod"
													name="responsibleCompany" checked="checked"/>
												代金引換
											</label>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="text-center">
										クレジットカード決済
									</div>
								</td>
								<td align="center">
									<div class="row">
										<div class="col-sm-12">
											<label class="radio-inline"> 
												<form:radiobutton value="2" path="paymentMethod"
													name="responsibleCompany" checked="checked"/>
												クレジットカード
											</label><br><br>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-offset-4 col-xs-4">
					<div class="form-group">
						<input class="form-control btn btn-warning btn-block" type="submit" value="この内容で注文する">
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- end container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="/js/ajax-address.js" charset="UTF-8"></script><!-- ajaxによる住所の自動入力用 -->
	<script src="/js/jquery-3.3.1.min.js" charset="UTF-8"></script><!-- ajaxによる住所の自動入力用 -->
	<script src="/js/zip-code.js" charset="UTF-8"></script><!-- ajaxによる住所の自動入力用 -->
</body>
</html>