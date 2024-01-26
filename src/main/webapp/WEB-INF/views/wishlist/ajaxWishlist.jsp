<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th style="width: 13%"><input id="checkAll" class="my-2 form-check-input" type="checkbox">
				<button id="delAllBtn" type="button" class="d-none btn btn-outline-danger border-0 btn-sm">선택 삭제</button></th>
			<th style="width: 32%">상품이름</th>
			<th style="width: 21%">이자율</th>
			<th style="width: 21%">평점</th>
			<th style="width: 13%">삭제</th>
		</tr>
	</thead>
	<tbody class="table-group-divider">
		<c:if test="${list.isEmpty()}">
			<tr>
				<td></td>
				<td colspan="4">검색 결과가 없습니다.</td>
			</tr>
		</c:if>
		<form id="deleteForm">
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><input class="form-check-input checks" type="checkbox" value="${dto.productNum}"></td>
				<td><a href="/products/detail?productNum=${dto.productNum}">${dto.productName }</a></td>
				<td>${dto.productRate }</td>
				<td>${dto.productJumsu }</td>
				<td><button type="button" data-pNum="${dto.productNum}" class="delBtn btn border-0 btn-outline-danger btn-sm">X</button></td>
			</tr>
		</c:forEach>
		</form>
	</tbody>
</table>

<nav aria-label="Page navigation">
	<input type="hidden" value="${pager.page}" id="nowPageNum">
	<ul class="pagination justify-content-center">
		<c:if test="${!pager.start}">
			<li class="page-item"><a class="page-link" href="?page=${pager.startNum-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
		</c:forEach>

		<c:if test="${!pager.last}">
			<li class="page-item"><a class="page-link" href="?page=${pager.lastNum+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>
</nav>