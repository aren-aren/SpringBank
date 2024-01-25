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
					<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${title } 글쓰기</span></h1>
				</div>
				<!-- boardForm import -->
				<c:import url="../templates/boardForm.jsp"></c:import>
			</div>
		</div>
	</main>
	<c:import url="../templates/footer.jsp"></c:import>
    <script src="/resources/js/scripts.js" type="text/javascript"></script>
    <script src="/resources/js/commons/fileManager.js" type="text/javascript"></script>
	<c:import url="../templates/summernote.jsp"></c:import>
</body>
</html>
