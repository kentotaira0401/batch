<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ピザ屋のネット注文</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/piza.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
	<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()">
	<sec:authentication var="userName" property="principal.user.name" />
	<c:out value="${userName}" />&nbsp;さん
	</sec:authorize>
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
					<a class="navbar-brand" href="Search"> <!-- 企業ロゴ -->
						<img alt="main log" src="../img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/showCartItem/showCart" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/showOrderHistory/showOrderHistory" class="navbar-link">注文履歴</a>&nbsp;&nbsp;
						
						<c:choose>
							<c:when test="${loginUser == null }">
							 	<a href="${pageContext.request.contextPath}/" class="navbar-link">ログイン</a>&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/logout" class="navbar-link">ログアウト</a>
							</c:otherwise>
						</c:choose>
					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<!-- search form -->
		<div class="row">
			<div
				class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">商品を検索する</div>
					</div>
					<div class="panel-body">
						<form:form method="post" action="${pageContext.request.contextPath}/SearchItem/FuzzySearch" class="form-horizontal">
							<div class="form-group">
								<label for="code" class="control-label col-sm-2">商品名</label>
								<div class="col-sm-9">
									<input type="text" name="name" id="code"
										class="form-control input-sm" />
								</div>
							</div>
							<div class="text-center">
								<button type="submit" value="検索" class="btn btn-primary">検索</button>
								<button type="reset" value="クリア" class="btn btn-default">クリア</button>
								
							   <c:if test="${isEmpty == true}">
							　　<label class="control-label"
										style="color: red" for="inputError">該当する商品はありません</label>　
							　　 </c:if>
							
						
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

		<!-- table -->
		<div class="row">
			<div
				class="col-lg-offset-0 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">


				<table class="table table-striped">

					<tbody>
						<tr>

                            
							<c:forEach var="item" items="${itemList}" varStatus="status">
							
							<c:if test="${status.index % 3 == 0}">
							</tr><tr>
							</c:if>
							
								<th><img src="<c:out value="${item.imagePath}"/>" /><br>
									<a href="${pageContext.request.contextPath}/SearchItem/detailItem?id=<c:out value="${item.id}"/>">
										<c:out value="${item.name}" /><br>
								</a> <span class="price">&nbsp;М&nbsp;</span>
								 <fmt:formatNumber value="${item.priceM}" pattern="###,###"/>円(税抜き)<br> <span class="price">&nbsp;Ｌ&nbsp;</span>
									<fmt:formatNumber value="${item.priceL}" pattern="###,###"/>円(税抜き)<br></th>
							</c:forEach>

						</tr>
					</tbody>

				</table>
			</div>
		</div>
	</div>
	<!-- end container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script>
  $( function() {

    var availableTags = [];
    <c:forEach var="item" items="${itemList}">
    	availableTags.push('<c:out value="${item.name}"/>');
    </c:forEach>
    
    
    		  $( "#code" ).autocomplete({
    		      source: availableTags,
    		      autoFocus: true,
    		      delay: 500,
    		      minLength: 1
    		    });
    	  
  } ); 
  </script>
</body>
</html>