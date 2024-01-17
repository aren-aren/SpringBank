<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>${title }List</title>
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
					<span class="text-gradient d-inline">${title } List</span>
				</h1>
			</div>

			<div class="row gx-5 justify-content-center">


				<div class="col-lg-11 col-xl-9 col-xxl-8">
					<form action="list" method="get">
						<div class="row">
							<div class="col-auto px-1">
								<select id="kindBy" class="form-select form-select-sm" name="kind">
									<option value="kind4">전체</option>
									<option value="kind1">제목</option>
									<option value="kind2">내용</option>
									<option value="kind3">글쓴이</option>

								</select>
							</div>
							<div class="col-auto px-1">
								<input class="form-control form-control-sm" value="${pager.search}" name="search" type="text">
							</div>
							<div class="col-auto px-1">
								<button class="btn btn-primary btn-sm">Search</button>
							</div>
						</div>
					</form>
					<div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th style="width: 8%">번호</th>
									<th style="width: 62%">제목</th>
									<th style="width: 11%">작성자</th>
									<th style="width: 12%">날짜</th>
									<th style="width: 7%">조회수</th>
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
									<c:set var="f" value="0"></c:set>
									<c:catch>
										<c:set var="f" value="${dto.flag }"></c:set>
									</c:catch>
									<c:if test="${f eq 1 }">
										<tr>
											<td></td>
											<td>삭제된 글 입니다</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</c:if>
									<c:if test="${f eq 0 }">
										<tr>
											<td>${dto.noticeNum}</td>
											<td><c:catch>
													<c:forEach begin="1" end="${dto.noticeDepth}">
													&nbsp;&nbsp;&nbsp;&nbsp;
													</c:forEach>
													<c:if test="${dto.noticeDepth ne 0}">
                                        			re:
                                        			</c:if>
												</c:catch> <a href="./detail?noticeNum=${dto.noticeNum}"> ${dto.noticeTitle} </a></td>
											<td>${dto.writer}</td>
											<td>${dto.noticeDate }</td>
											<td>${dto.noticeViews }</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>

						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center">
								<c:if test="${!pager.start}">
									<li class="page-item"><a class="page-link" href="?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>

								<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
									<li class="page-item"><a class="page-link" href="?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
								</c:forEach>

								<c:if test="${!pager.last}">
									<li class="page-item"><a class="page-link" href="?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
					</div>

					<div>
						<a class="btn btn-primary" href="add">글쓰기</a>
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
