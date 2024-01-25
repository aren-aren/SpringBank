<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>가입상품 List</title>
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
					<span class="text-gradient d-inline">가입상품 List</span>
				</h1>
			</div>

			<div class="row gx-5 justify-content-center">


				<div class="col-lg-11 col-xl-9 col-xxl-8">
					<div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th style="width: 30%">계좌번호</th>
									<th style="width: 30%">상품이름</th>
									<th style="width: 18%">잔액</th>
									<th style="width: 14%">가입일</th>
									<th style="width: 8%">이자율</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:if test="${list.isEmpty()}">
									<tr>
										<td></td>
										<td colspan="3">검색 결과가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${list}" var="dto">
										<tr>
											<td>${dto.accountNum }</td>
											<td>${dto.productDTO.productName }</td>
											<td>${dto.accountBalance }</td>
											<td>${dto.accountDate }</td>
											<td>${dto.productDTO.productRate }%</td>
										</tr>
								</c:forEach>
							</tbody>
						</table>

						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center">
								<c:if test="${!pager.start}">
									<li class="page-item">
										<a class="page-link" href="?page=${pager.startNum-1}" aria-label="Previous"> 
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:if>

								<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
									<li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
								</c:forEach>

								<c:if test="${!pager.last}">
									<li class="page-item">
										<a class="page-link" href="?page=${pager.lastNum+1}" aria-label="Next"> 
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
	</main>
	<!-- 사용전 경로 수정 -->
	<script src="/resources/js/list.js"></script>
	<c:import url="../templates/footer.jsp"></c:import>
</body>
</html>
