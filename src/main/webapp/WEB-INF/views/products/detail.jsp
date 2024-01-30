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
					<h1 class="display-5 fw-bolder mb-0">
						<span class="text-gradient d-inline">Product Detail</span>
					</h1>
				</div>

				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">

						<div class="card">
							<div class="card-body">
								<div>
									<h6 id="productNum" class="d-inline">${dto.productNum}</h6>
									<button id="addWishBtn" type="button" class="btn btn-outline-primary float-end btn-sm">관심상품 등록</button>
								</div>
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
								<c:if test="${not empty member}">
									<a href="/account/add?productNum=${dto.productNum}" class="btn btn-primary float-start btn-sm">가입하기</a>
								</c:if>

								<a id="delete" class="btn btn-outline-danger float-end btn-sm">삭제하기</a> <a id="update" class="btn btn-outline-success float-end btn-sm">수정하기</a>
								<form id="submitForm" action="./update" method="get">
									<input type='hidden' name="productNum" value="${dto.productNum }">
								</form>
							</div>
						</div>
						
					
						<div class="mt-5 mb-3" >
							<div id="replyList" class="mb-1" data-user-name="${member.userName}" data-page="1">
							</div>
							<button type="button" id="moreReplyBtn" class="btn btn-outline-primary w-100">더보기</button>
						</div>

						<c:if test="${not empty member}">
						<div>
							<form id="replyForm">
								<input type="hidden" name="productNum" value="${dto.productNum}">
								<div class="mb-3">
									<label for="replyContents" class="form-label">후기 작성</label>
									<textarea class="form-control" name="replyContents" id="replyContents" rows="3"></textarea>
								</div>
								<div>
									<input class="form-check-input ms-1" type="radio" name="replyJumsu" value="5" id="replyJumsu5"> 
									<label class="form-check-label me-1" for="replyJumsu5"> 5 </label>
									|
									<input class="form-check-input ms-1" type="radio" name="replyJumsu" value="4" id="replyJumsu4"> 
									<label class="form-check-label me-1" for="replyJumsu4"> 4 </label>
									|
									<input class="form-check-input ms-1" type="radio" name="replyJumsu" value="3" id="replyJumsu3"> 
									<label class="form-check-label me-1" for="replyJumsu3"> 3 </label>
									|
									<input class="form-check-input ms-1" type="radio" name="replyJumsu" value="2" id="replyJumsu2"> 
									<label class="form-check-label me-1" for="replyJumsu2"> 2 </label>
									|
									<input class="form-check-input ms-1" type="radio" name="replyJumsu" value="1" id="replyJumsu1"> 
									<label class="form-check-label me-3" for="replyJumsu1"> 1 </label>
									<button type="button" class="btn btn-primary btn-sm" id="replyAdd">후기 입력</button>
								</div>
							</form>
						</div>
					</c:if>

					</div>
				</div>
			</div>
		</div>
	</main>
  
  <!-- Modal -->
  <div class="modal fade" id="replyUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	  <div class="modal-content">
		<div class="modal-header">
		  <h1 class="modal-title fs-5" id="exampleModalLabel">후기 수정</h1>
		  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body">
			<div class="mb-3">
				<input type="hidden" id="replyUpdateNum" value="">
				<textarea class="form-control" name="replyUpdateContents" id="replyUpdateContent" rows="3"></textarea>
			</div>
			<div>
				<input class="form-check-input ms-1" type="radio" name="replyUpdate" value="5" id="replyUpdate5"> 
				<label class="form-check-label me-1" for="replyUpdate5"> 5 </label>
				|
				<input class="form-check-input ms-1" type="radio" name="replyUpdate" value="4" id="replyUpdate4"> 
				<label class="form-check-label me-1" for="replyUpdate4"> 4 </label>
				|
				<input class="form-check-input ms-1" type="radio" name="replyUpdate" value="3" id="replyUpdate3"> 
				<label class="form-check-label me-1" for="replyUpdate3"> 3 </label>
				|
				<input class="form-check-input ms-1" type="radio" name="replyUpdate" value="2" id="replyUpdate2"> 
				<label class="form-check-label me-1" for="replyUpdate2"> 2 </label>
				|
				<input class="form-check-input ms-1" type="radio" name="replyUpdate" value="1" id="replyUpdate1"> 
				<label class="form-check-label me-3" for="replyUpdate1"> 1 </label>
			</div>
		</div>
		<div class="modal-footer">
		  <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Close</button>
		  <button id="replyUpdateBtn" type="button" class="btn btn-primary">수정하기</button>
		</div>
	  </div>
	</div>
  </div>
	<c:import url="../templates/footer.jsp"></c:import>
	<script src="/resources/js/detailjs.js" type="text/javascript"></script>
</body>
</html>
