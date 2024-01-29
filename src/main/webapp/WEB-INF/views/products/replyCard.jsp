<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach  items="${list}" var="reply">
<div class="card">
	<div class="card-body">
    	<div class="card-title">
    		${reply.userName}
    		<p class="float-end">별점 : ${reply.replyJumsu}</p>
    	</div>
    	<p class="card-text fs-5">${reply.replyContents}</p>
		<c:if test="${reply.userName eq member.userName}"><button class="btn btn-outline-danger border-0 btn-sm">X</button></c:if>
    	<span class="float-end fs-6">${reply.replyDate}</span>
	</div>
</div>
</c:forEach>