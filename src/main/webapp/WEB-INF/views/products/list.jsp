<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="../templates/header.jsp"></c:import>

	<section class="mt-4 container">
		<div>
			<form class="row g-3" action="./list" method="get">
				<div class="col-auto">
					<select class="form-select" name="kind" aria-label="Default select example">
						<option value="kind1">Name</option>
						<option value="kind2">Content</option>
						<option value="kind3">Name/Content</option>
					</select>
				</div>
				<div class="col-auto">
					<label for="search" class="visually-hidden">Search</label> 
					<input type="text" name="search" class="form-control" id="search">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">search</button>
				</div>
			</form>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Num</th>
					<th>Name</th>
					<th>rate</th>
					<th>jumsu</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.getProductNum() }</td>
						<td><a href="detail?productNum=${dto.getProductNum() }">${dto.getProductName() }</a></td>
						<td>${dto.getProductRate() }</td>
						<td>${dto.getProductJumsu() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:if test="${!pager.start }">
						<li class='page-item'><a class="page-link" href="?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
						<li class="page-item"><a class="page-link" href="?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
					</c:forEach>
					<c:if test="${!pager.last }">
						<li class='page-item'><a class="page-link" href="?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</section>

	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>