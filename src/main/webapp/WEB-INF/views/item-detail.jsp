<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ja">
<head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ピザ屋のネット注文</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/piza.css" rel="stylesheet">

<script src="../js/subTotal.js"></script>

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
					<a class="navbar-brand" href="Search"> <!-- 企業ロゴ --> <img
	 					alt="main log" src="../img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/showCartItem/showCart" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;

						<a href="order_history.html" class="navbar-link">注文履歴</a>&nbsp;&nbsp;
						<c:choose>
							<c:when test="${loginUser == null }">
								<a href="${pageContext.request.contextPath}/"
									class="navbar-link">ログイン</a>&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/logout"
									class="navbar-link">ログアウト</a>
							</c:otherwise>
						</c:choose>

					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<form:form modelAttribute="putItemIntoCartForm"
			action="${pageContext.request.contextPath}/putItemIntoCart/putItem">
			<div class="row">
				<div class="col-xs-offset-2 col-xs-8">
					<input type="hidden" value="${item.id}" name="itemId" />
					<h3 class="text-center">商品詳細</h3>
					<div class="row">
						<div class="col-xs-5">
							<img src="<c:out value="${item.imagePath}"/>" />
						</div>

						<div class="col-xs-8">
							<div class="bs-component">
								<c:out value="${item.name}" />
								<br> <br>
								<p>
									<c:out value="${item.description}" />
								</p>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-xs-offset-2 col-xs-8">
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="inputResponsibleCompany">サイズ</label>
									</div>
									<div class="col-sm-12">
										<label class="radio-inline"> <form:radiobutton

												path="size" value="M" class="size" checked="checked"/><span class="price">&nbsp;М&nbsp;</span>
									<input type="hidden" id="mPrice" value="${item.priceM}">
									<fmt:formatNumber
												value="${item.priceM}" pattern="###,###" />円(税抜き)<br>
										</label> <label class="radio-inline"> <form:radiobutton
												path="size" value="L" class="size" /> <span class="price">&nbsp;Ｌ&nbsp;</span> 
												<input type="hidden" id="lPrice" value="${item.priceL}"><fmt:formatNumber
												value="${item.priceL}" pattern="###,###" />円(税抜き)<br>
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
					
						<div class="col-xs-offset-2 col-xs-8">
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="inputResponsibleCompany">
											トッピング：&nbsp;1つにつき <span>&nbsp;М&nbsp;</span>&nbsp;&nbsp;200円(税抜)
											<span>&nbsp;Ｌ</span>&nbsp;&nbsp;300円(税抜)
										</label>
									</div>
									<div class="col-sm-12">																			
											 <form:checkboxes items="${toppingMap}" path="toppingList" class="toppingList checkbox-inline"/>											
									</div>
									<div class="row">
										<div class="col-xs-offset-2 col-xs-8">
											<div class="form-group">
												<div class="row">
													<div class="col-xs-5 col-sm-5">
														<label for="">数量:</label> <label class="control-label"
															style="color: red" for="inputError">数量を選択してください</label>
															 <select name="quantity" class="form-control">
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
															<option value="6">6</option>
															<option value="7">7</option>
															<option value="8">8</option>
															<option value="9">9</option>
															<option value="10">10</option>
															<option value="11">11</option>
															<option value="12">12</option>
														</select>
													</div>
												</div>
											</div>
										</div>
										<br>
										<div class="row">
											<div class="col-xs-offset-2 col-xs-10">
												<div class="form-group">
												

				
							
													<h2><span id="totalPrice"></span>円(税抜き)</h2>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-offset-2 col-xs-3">
												<div class="form-group">
													<p>
														<input class="form-control btn btn-warning btn-block"
															type="submit" value="カートに入れる">
													</p>

												</div>
											</div>
										</div>
									</div>
								</div>
		</form:form>

	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>