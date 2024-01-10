<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<c:import url="../templates/boot_css.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../templates/header.jsp"></c:import>
	<section id="contents" class="container">
		<div class="row mt-4">
			<form action="/products/add" method="post" enctype="multipart/form-data">
					<label for="ProductName" class="form-label">ProductName</label> <input type="text" class="form-control" id="ProductName" name="productName" placeholder="product Name">
			
					<label for="content-area" class="form-label">Content</label>
					<textarea id="content-area" name="productContents" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>

					<label for="productRate" class="form-label">Product Rate</label> <input type="text" class="form-control" id="productRate" name="productRate" placeholder="product Rate">					
	
					<label for="productJumsu" class="form-label">Product Jumsu</label> <input type="text" class="form-control" id="productJumsu" name="productJumsu" placeholder="product Jumsu">					
	
					<label for="productFile" class="form-label">Product File</label> <input type="file" class="form-control" id="productFile" name="productFile" placeholder="product File">					

				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	</section>

	<c:import url="../templates/bootstrap_js.jsp"></c:import>
	
	<script type="text/javascript">
		$('#content-area').summernote();
	</script>
</body>
</html>