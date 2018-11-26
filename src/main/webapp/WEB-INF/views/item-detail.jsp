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
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/piza.css" rel="stylesheet">
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
					<a class="navbar-brand" href="Search"> <!-- 企業ロゴ -->
						<img alt="main log" src="../img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="cart_list.html" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
						<a href="order_history.html" class="navbar-link">注文履歴</a>&nbsp;&nbsp;
						<a href="login.html" class="navbar-link">ログイン</a>&nbsp;&nbsp;
						<a href="item_list.html" class="navbar-link">ログアウト</a>
					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<form action="cart_list.html">
		<div class="row">
			<div class="col-xs-offset-2 col-xs-8">

				<h3 class="text-center">商品詳細</h3>
				<div class="row">
					<div class="col-xs-5">
						<img src="<c:out value="${item.imagePath}"/>" />
					</div>

					<div class="col-xs-8">
						<div class="bs-component">
							<c:out value="${item.name}" /><br>
							<br>
							<p><c:out value="${item.description}" /></p>
						</div>
					</div>
				</div><br>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="inputResponsibleCompany">サイズ</label>
								</div>
								<div class="col-sm-12">
									<label class="radio-inline"> 
										<input type="radio"
											name="responsibleCompany" checked="checked">
									<span class="price">&nbsp;М&nbsp;</span>
								 <fmt:formatNumber value="${item.priceM}" pattern="###,###"/>円(税抜き)<br> 
									</label>
									<label class="radio-inline"> 
										<input type="radio"
											name="responsibleCompany"> 
								<span class="price">&nbsp;Ｌ&nbsp;</span>
										<fmt:formatNumber value="${item.priceL}" pattern="###,###"/>円(税抜き)<br>
									</label>
								</div>
							</div>
						</div>
					</div>
				</div><br>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="inputResponsibleCompany">
										トッピング：&nbsp;1つにつき
										<span>&nbsp;М&nbsp;</span>&nbsp;&nbsp;200円(税抜)
										<span>&nbsp;Ｌ</span>&nbsp;&nbsp;300円(税抜)
									</label>
								</div>
								<div class="col-sm-12">
									<label class="checkbox-inline">
										<input type="checkbox" value="1" name="toppingList">オニオン
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="2" name="toppingList">ツナマヨ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="3" name="toppingList">イタリアンポテト
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="4" name="toppingList">イカ
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="5" name="toppingList">プルコギ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="6" name="toppingList">アンチョビ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="7" name="toppingList">エビ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="8" name="toppingList">コーン
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="9" name="toppingList">ピーマン
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="10" name="toppingList">フレッシュスライストマト
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="11" name="toppingList">ベーコン
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="12" name="toppingList">ペパロニ・サラミ
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="13" name="toppingList">熟成ベーコン
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="14" name="toppingList">特性マヨソース
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="15" name="toppingList">カマンベールチーズ
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="16" name="toppingList">フレッシュモッツアレラチーズ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="17" name="toppingList">イタリアンソーセージ
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="18" name="toppingList">ガーリックスライス
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="19" name="toppingList">あらびきスライスソーセージ
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="20" name="toppingList">ブロッコリー
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="21" name="toppingList">グリーンアスパラ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="22" name="toppingList">パルメザンチーズ
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="23" name="toppingList">パイナップル
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="24" name="toppingList">ハラペーニョ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="25" name="toppingList">もち
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="26" name="toppingList">ポテト
									</label><br>
									<label class="checkbox-inline">
										<input type="checkbox" value="27" name="toppingList">ブラックオリーブ
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" value="28" name="toppingList">チーズ増量
									</label><br>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<div class="row">
								<div class="col-xs-5 col-sm-5">
									<label for="">数量:</label>
									<label class="control-label"
										style="color: red" for="inputError">数量を選択してください</label> <select
										name="quantity" class="form-control">
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
				</div>
				<br>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-10">
						<div class="form-group">
							<span id="total-price">この商品金額："後でやる"(税抜)</span>
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
		</form>

	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>