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

		<div class="container px-5">
			<div class="bg-light rounded-4 py-5 px-4 px-md-5">
				<div class="text-center mb-5">
					<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product Detail</span></h1>
				</div>
				
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">

						<div class="card w-50">
							<div class="card-body">
								<h6>${dto.productNum}</h6>
								<h5 class="card-title">${dto.productName}</h5>
								<c:if test="${not empty dto.productFiles}">
									<span>Files</span>
									<c:forEach items="${dto.productFiles}" var="img">
										<a href="/resources/upload/products/${img.fileName}">${img.oriName}</a>
									</c:forEach>
								</c:if>
								<p class="card-text">${dto.productContents}</p>
							</div>
							<ul class="list-group list-group-flush text-center">
								<li class="list-group-item">이자율 : ${dto.productRate}</li>
								<li class="list-group-item">평점 : ${dto.productJumsu}</li>
								<li class="list-group-item">판매횟수 : ${dto.productCount}</li>
							</ul>
							<div class="card-body">
								<a id="delete" class="btn btn-outline-danger float-end btn-sm">삭제하기</a> 
								<a id="update" class="btn btn-outline-success float-end btn-sm">수정하기</a>
								<form id="submitForm" action="./update" method="get">
									<input type='hidden' name="productNum" value="${dto.productNum }">
								</form>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>
	<c:import url="../templates/footer.jsp"></c:import>
    <script src="/resources/js/detailjs.js" type="text/javascript"></script>
</body>
</html>
