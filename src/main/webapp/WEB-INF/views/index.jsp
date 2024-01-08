<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<!-- bootstrap css -->
<c:import url="./templates/boot_css.jsp"></c:import>
</head>
<body>
	<!-- header -->
	<c:import url="./templates/header.jsp"></c:import>
	<div class="container-fluid border border-success-subtle mt-3">
		<section>
			<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/resources/images/fnc1.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/resources/images/fnc2.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/resources/images/fnc3.jpg" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
				</button>
			</div>
		</section>
	</div>

	<c:import url="./templates/bootstrap_js.jsp"></c:import>
</body>
</html>