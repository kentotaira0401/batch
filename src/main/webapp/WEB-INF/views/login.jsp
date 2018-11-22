<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.css" rel="stylesheet">
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
					<a class="navbar-brand" href="item_list.html"> <!-- 企業ロゴ --> <img
						alt="main log" src="img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="cart_list.html" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
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
					<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/login">
						<fieldset>
							<legend>
								ログイン
							</legend>
							<label
									class="control-label" style="color: red" for="inputError">メールアドレス、またはパスワードが間違っています</label>
							<div class="form-group">
								<label for="inputEmail">メールアドレス:</label>
								<form:input path="email" id="email" class="form-control" placeholder="Email"></form:input>
							</div>
							<div class="form-group">
								<label for="inputPassword">パスワード:</label>
								<form:input path="password" id="password" class="form-control" placeholder="Password"></form:input>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">ログイン</button>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="text-center">
				<a href="register_user.html">ユーザ登録はこちら</a>
			</div>
		</div>
		
	</div>
</body>
</html>