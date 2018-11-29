<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ラクラクピザ　ユーザー登録フォーム</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/piza.css" rel="stylesheet">
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
						alt="main log" src="/img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/showCartItem/showCart" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		
		<!-- login form -->
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
				<div class="well">
					<form:form modelAttribute="updatePassword" action="${pageContext.request.contextPath}/register/updatePass">
						<fieldset>
							<legend>パスワード変更</legend>
						
							<div class="form-group">
								<label for="inputEmail">メールアドレス:</label>
								<form:input type="text" path="email" id="inputEmail" class="form-control" placeholder="Email"/>
								<form:errors path="email" cssStyle="color:red" />
							</div>
							
							<div class="form-group">
								<label for="inputPassword">パスワード:</label>
								<form:input type="password" path="password" id="inputPassword" class="form-control" placeholder="Password"/>
								<form:errors path="password" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<label for="inputConfirmationPassword">確認用パスワード:</label>
								<form:input type="password" path="conformationPassword" id="inputConfirmationPassword" class="form-control" placeholder="Confirmation Password"/>
								<form:errors path="conformationPassword" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">登録</button>
								<button type="reset" class="btn btn-primary">クリア</button>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>

	</div>
	<!-- end container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>

</body>
</html>