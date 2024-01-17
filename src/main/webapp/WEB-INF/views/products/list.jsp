<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Personal - Start Bootstrap Theme</title>
<!-- 사용전 경로 수정 -->
<c:import url="../templates/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- 사용전 경로 수정 -->
		<c:import url="../templates/header.jsp"></c:import>

		<div class="container px-5 my-5">
			<div class="text-center mb-5">
				<h1 class="display-5 fw-bolder mb-0">
					<span class="text-gradient d-inline">Product List</span>
				</h1>
			</div>
		</div>

		<div class="row justify-content-center">


			<div class="col-lg-11 col-xl-9 col-xxl-8">
				<div class="row">
					<form class="col-9" action="list" method="get">
						<div class="row">
							<input type="hidden" name="sortBy" value="${pager.sortBy}">
							<div class="col-auto px-1">
								<select id="kindBy" data-kind="${pager.kind}" class="form-select form-select-sm" name="kind">
									<option value="kind3">전체</option>
									<option value="kind1">이름</option>
									<option value="kind2">내용</option>
								</select>
							</div>
							<div class="col-auto px-1">
								<input id="searchInput" class="form-control form-control-sm" value="${pager.search}" name="search" type="text">
							</div>
							<div class="col-auto px-1">
								<button class="btn btn-primary btn-sm">Search</button>
							</div>
						</div>
					</form>
					<div class="col-3">
						<select id="sortBy" class="form-select form-select-sm" data-url="?page=${pager.page}&search=${pager.search}&kind=${pager.kind}" aria-label="Small select example" data-sort="${pager.sortBy}">
							<option value="default">기본순</option>
							<option value="rate">이자율순</option>
							<option value="jumsu">평점순</option>
						</select>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>이자율</th>
							<th>평점</th>
							<th>판매횟수</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:if test="${list.isEmpty()}">
							<tr>
								<td></td>
								<td colspan="4">검색 결과가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto.productNum}</td>
								<td><a href="detail?productNum=${dto.productNum}">${dto.productName}</a></td>
								<td>${dto.productRate}</td>
								<td>${dto.productJumsu}</td>
								<td>${dto.productCount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:if test="${!pager.start}">
							<li class="page-item"><a class="page-link" href="?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}&sortBy=${pager.sortBy}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
							<li class="page-item"><a class="page-link" href="?page=${i}&search=${pager.search}&kind=${pager.kind}&sortBy=${pager.sortBy}">${i}</a></li>
						</c:forEach>

						<c:if test="${!pager.last}">
							<li class="page-item"><a class="page-link" href="?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}&sortBy=${pager.sortBy}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>

				<div>
					<a class="btn btn-primary" href="add">상품등록</a>
				</div>
			</div>
		</div>

	</main>
	<!-- 사용전 경로 수정 -->
	<script src="/resources/js/list.js" type="text/javascript"></script>
	<c:import url="../templates/footer.jsp"></c:import>
</body>
</html>
