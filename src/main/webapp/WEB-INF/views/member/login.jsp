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
					<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${title } 로그인</span></h1>
				</div>

				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">
						<form id="contactForm" method="post" enctype="multipart/form-data">
							<!-- ProductName input -->
							<div class="form-floating mb-3">
								<input 
									id="userName"
									name="userName" 
									class="form-control" 
									type="text" 
									placeholder="아이디를 입력하세요"
									value="moveone"
									/> 
								<label for="userName">아이디</label>
							</div>
							<div class="form-floating mb-3">
								<input 
									id="memberPassword"
									name="password" 
									class="form-control" 
									type="password" 
									placeholder="비밀번호를 입력하세요"
									value="qwer"
									/> 
								<label for="memberPassword">비밀번호</label>
							</div>
							<div>${msg}</div>
							<div class="d-grid">
								<button class="btn btn-primary btn-lg" id="submitButton" type="submit">로그인</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<c:import url="../templates/footer.jsp"></c:import>
</body>
</html>
