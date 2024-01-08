<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/boot_css.jsp"></c:import>
</head>
<body>
<c:import url="../templates/header.jsp"></c:import>

<section class="mt-4 container-fluid">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Discription</th>
				<th>rate</th>
				<th>jumsu</th>
			</tr>
			
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.getProductNum() }</td>
					<td><a href="detail?productNum=${dto.getProductNum() }">${dto.getProductName() }</a></td>
					<td>${dto.getProductContents() }</td>
					<td>${dto.getProductRate() }</td>
					<td>${dto.getProductJumsu() }</td>
				</tr>
			</c:forEach>
			
		</thead>
		<tbody></tbody>
	</table>
</section>

<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>