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

	<section class="container mt-4 d-flex justify-content-center">
		<div class="card w-25">
			<div class="card-header">${dto.productNum }</div>
			<div class="card-body">

				<h5 class="card-title fs-3">${dto.productName }</h5>

				<c:if test="${dto.productFileDTOs.size() > 0 }">
					<div id="carouselExample" class="carousel slide">
						<div class="carousel-indicators">
    						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    						<c:forEach begin="1" end="${dto.productFileDTOs.size()-1}" var="i">
    							<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${i}" aria-label="Slide ${i+1}"></button>
    						</c:forEach>
  						</div>
					
						<div class="carousel-inner">
							<c:forEach items="${dto.productFileDTOs}" var="file">
								<div class="carousel-item">
									<img src="/resources/upload/products/${file.fileName}" class="d-block w-100" alt="${file.oriName }">
								</div>
							</c:forEach>
						</div>
						<button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span> 
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</c:if>

				<p class="card-text fs-4">${dto.productContents }</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<div class="small">이자율</div>
					<div class="fs-3">${dto.productRate}</div>
				</li>
				<li class="list-group-item">
					<div class="small">평점</div>
					<div class="fs-3">${dto.productJumsu}</div>
				</li>
				<li class="list-group-item">
					<form action="./delete" method="post">
						<input type=hidden name="productNum" value="${dto.productNum}">
						<button id="deleteBtn" class="btn btn-secondary">삭제</button>
					</form>
				</li>
			</ul>
		</div>

	</section>

	<script type="text/javascript">
		document.querySelector(".carousel-item").classList.add("active");
	</script>

	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>