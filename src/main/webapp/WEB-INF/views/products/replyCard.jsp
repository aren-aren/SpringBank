<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach  items="${list}" var="dto">
<div class="card">
	<div class="card-body">
    	<div class="card-title">
    		${dto.userName}
    		<p class="float-end">별점 : ${dto.replyJumsu}</p>
    	</div>
    	<p class="card-text fs-5">${dto.replyContents}</p>
		<c:if test="${dto.userName eq member.userName}"><button class="btn btn-outline-danger border-0 btn-sm">X</button></c:if>
    	<span class="float-end fs-6">${dto.replyDate}</span>
	</div>
</div>
</c:forEach>