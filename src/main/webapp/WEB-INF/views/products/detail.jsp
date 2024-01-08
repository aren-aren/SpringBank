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

<section class="container-fluid mt-4">
 <div class="card" style="width: 18rem;">
 <div class="card-header">
    ${dto.getProductNum() }
  </div>
  <div class="card-body">
    <h5 class="card-title">${dto.getProductName() }</h5>
    <p class="card-text">${dto.getProductContents() }</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">${dto.getProductRate() }</li>
    <li class="list-group-item">${dto.getProductJumsu() }</li>
  </ul>
</div>

</section>

<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>