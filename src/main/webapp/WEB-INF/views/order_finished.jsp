<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<a class="navbar-brand"
					 	href="${pageContext.request.contextPath}/SearchItem/Search"> <!-- 企業ロゴ --> <img
						alt="main log" src="../../img/header_logo.png" height="35">
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


		<!-- table -->
		<div class="row">
			<div
				class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
				<h3 class="text-center">決済が完了しました！</h3>
				<div class="text-center">
					<p>この度はご注文ありがとうございます。</p>
					<p>お支払い先は、お送りしたメールに記載してありますのでご確認ください。</p>
					<p>メールが届かない場合は「注文履歴」からご確認ください。</p>
				</div>
			</div>
		</div>

		<br><br>
		<div class="row">
			<div class="col-xs-offset-5 col-xs-2">
				<div class="form-group">
					<form:form action="${pageContext.request.contextPath}/SearchItem/Search" method="post">
						<input class="form-control btn btn-warning btn-block"
							type="submit" value="トップ画面を表示する">
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>