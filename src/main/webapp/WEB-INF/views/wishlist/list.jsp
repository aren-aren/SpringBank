<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>WishList</title>
<!-- 사용전 경로 수정 -->
<c:import url="../templates/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- 사용전 경로 수정 -->
		<c:import url="../templates/header.jsp"></c:import>

		<section class="py-5">
			<div class="text-center mb-5">
				<h1 class="display-5 fw-bolder mb-0">
					<span class="text-gradient d-inline">WishList</span>
				</h1>
			</div>

			<div class="row gx-5 justify-content-center">
				<div class="col-lg-11 col-xl-9 col-xxl-8">
					<div id="tableAndPager">
						<c:import url="./ajaxWishlist.jsp"></c:import>
						<button id="addBtn" class="btn btn-primary disabled">가입하기</button>
					</div>
				</div>
			</div>
		</section>
	</main>
	<!-- 사용전 경로 수정 -->
	<script src="/resources/js/wishlist/list.js"></script>
	<c:import url="../templates/footer.jsp"></c:import>
</body>
</html>
