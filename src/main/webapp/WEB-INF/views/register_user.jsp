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
					<form:form modelAttribute="registerUserForm" action="${pageContext.request.contextPath}/register/create">
						<fieldset>
							<legend>ユーザ登録</legend>
							<div class="form-group">
								<label for="inputName">名前:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">名前を入力してください</label> -->
								<form:input type="text" path="name" id="inputName" class="form-control" placeholder="Name"/>
								<form:errors path="name" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<label for="inputEmail">メールアドレス:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">メールアドレスを入力してください</label> -->
								<form:input type="text" path="email" id="inputEmail" class="form-control" placeholder="Email"/>
								<form:errors path="email" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<label for="inputZipcode">郵便番号:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">郵便番号を入力してください</label> -->
									<!-- <input type="button" value="住所検索"> -->
									
								<form:input path="zipcode" id="inputZipcode" class="form-control" placeholder="Zipcode"></form:input>
								<button type="button" id="btn">住所検索</button>
									<!-- <input type="text" id="zip" name="zip" size="8" maxlength="8">&nbsp;&nbsp;
									<button type="button" id="btn">住所検索</button> -->
								<form:errors path="zipcode" cssStyle="color:red" />
								
							</div>
							<div class="form-group">
								<label for="inputAddress">住所:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">住所を入力してください</label> -->
								<form:input type="text" path="address" id="inputAddress" class="form-control" placeholder="Address"/>
								<form:errors path="address" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<label for="inputTel">電話番号:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">電話番号を入力してください</label> -->
								<form:input type="text" path="telephone" id="inputTel" class="form-control" placeholder="Tel"/>
								<form:errors path="telephone" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<label for="inputPassword">パスワード:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">パスワードを入力してください</label> -->
								<form:input type="password" path="password" id="inputPassword" class="form-control" placeholder="Password"/>
								<form:errors path="password" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<label for="inputConfirmationPassword">確認用パスワード:</label>
								<!-- <label class="control-label" style="color: red" for="inputError">確認用パスワードを入力してください</label> -->
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
	<script src="/js/ajax-address.js" charset="UTF-8"></script><!-- ajaxによる住所の自動入力用 -->
	<script src="/js/jquery-3.3.1.min.js" charset="UTF-8"></script><!-- ajaxによる住所の自動入力用 -->
	<script src="/js/zip-code.js" charset="UTF-8"></script><!-- ajaxによる住所の自動入力用 -->
</body>
</html>