<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>${title }</title>
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
					<h1 class="display-5 fw-bolder mb-0">
						<span class="text-gradient d-inline">${title}</span>
					</h1>
				</div>

				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">

						<div class="card w-100 shadow">
							<div class="card-body">
								<h6>${dto.noticeNum}</h6>
								<h5 class="card-title">${dto.noticeTitle}</h5>
								<c:if test="${not empty dto.boardFiles}">
									<div id="carouselExample" class="carousel slide">
										<div class="carousel-indicators">
											<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
											<c:forEach begin="2"  end="${dto.boardFiles.size()}" var="i" >
											<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${i-1}" aria-label="Slide ${i}"></button>
											</c:forEach>
										</div>
										<div class="carousel-inner">
											<c:forEach items="${dto.boardFiles}" var="img">
												<div class="carousel-item">
													<img src="/resources/upload/${path }/${img.fileName}" width="100%" />
												</div>
											</c:forEach>
										</div>
										<button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
											<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
										</button>
										<button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
											<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
										</button>
									</div>
								</c:if>
								<p class="card-text">${dto.noticeContents}</p>
							</div>
							<ul class="list-group list-group-flush text-center">
							</ul>
							<div class="card-body">
							<c:if test="${bbs eq 1 }">
								<a class="btn btn-primary" href="reply?noticeNum=${dto.noticeNum}">답글달기</a>
							</c:if>
								<a id="delete" class="btn btn-outline-danger float-end">삭제하기</a> 
								<a id="update" class="btn btn-outline-success float-end">수정하기</a>
								<form id="submitForm" action="./update" method="get">
									<input type='hidden' name="noticeNum" value="${dto.noticeNum }">
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
