<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.css" rel="stylesheet">
</head>

<script>
// サンプル6 (ダミーフォームを作りボタンを横に並べる)
$(function(){
	$("#sample6Button").on("click",function(){ //ボタン押下時
		// sample6Formというidがつけられたフォームをサブミットする(サーバーへ送る)
		$("#sample6Form").submit();
	});
}); // end ready
</script>

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
						<a href="${pageContext.request.contextPath}/SearchItem/Search" class="navbar-link">トップページへ</a>&nbsp;&nbsp;
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
					
					<div class="form-group" style="text-align: center;">
					<form:form action="${pageContext.request.contextPath}/SearchItem/Search">
						<fieldset>
							<legend>
								パスワードを忘れた方
							</legend>
							<font color="red">ご入力いただいたメールアドレスに	<br>パスワード変更用URLを記載したメールをお送りいたしました。</font>
							<br><br>
								<button type="submit" class="btn btn-primary">トップページ　＞</button>
								<button type="button" class="btn btn-primary" id="sample6Button">ログイン　＞</button>
						</fieldset>
					</form:form>
					<form:form action="${pageContext.request.contextPath}/" path="sample6Form">
							
					</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>