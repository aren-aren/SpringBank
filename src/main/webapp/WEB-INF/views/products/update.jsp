<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Product Update</title>
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
					<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product Update</span></h1>
				</div>
				
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">
						<form id="contactForm" action="update" method="post" enctype="multipart/form-data">
							<input type="hidden" name="productNum" value="${dto.productNum}">
							<!-- ProductName input -->
							<div class="form-floating mb-3">
								<input 
									id="ProductName" 
									name="productName" 
									class="form-control" 
									type="text" 
									placeholder="상품명을 입력하세요" 
									value="${dto.productName}"/> 
								<label for="ProductName">Product Name</label>
							</div>
							<!-- ProductContents input -->
							<div class="form-floating mb-3">
								<textarea id="summernoteContents" name="productContents">${dto.productContents}</textarea>
							</div>
							<!-- ProductRate input -->
							<div class="form-floating mb-3">
								<input 
									class="form-control" 
									name="productRate" 
									id="ProductRate" 
									type="text" 
									placeholder="이자율을 입력하세요" 
									value="${dto.productRate}"/> 
								<label for="ProductRate">Product Rate</label>
							</div>

							<!-- <div class="mb-3">
								<h5 class="fw-bolder mb-1">첨부파일</h5>
								<input type="file" class="form-control" name="attachs">
								<input type="file" class="form-control" name="attachs">
								<input type="file" class="form-control" name="attachs">
								<input type="file" class="form-control" name="attachs">
								<input type="file" class="form-control" name="attachs">
							</div> -->

							<div class="d-grid">
								<button class="btn btn-primary btn-lg" id="submitButton" type="submit">수정하기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<c:import url="../templates/footer.jsp"></c:import>
	<c:import url="../templates/summernote.jsp"></c:import>
    <script src="/resources/js/scripts.js" type="text/javascript"></script>
</body>
</html>
