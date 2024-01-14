<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Personal - Start Bootstrap Theme</title>
    <!-- 사용전 경로 수정 -->
    <c:import url="../templates/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
    <!-- 사용전 경로 수정 -->
    <c:import url="../templates/header.jsp"></c:import>

    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product List</span></h1>
        </div>
    </div>

    <div class="row justify-content-center">


        <div class="w-75">
            <form action="list" method="get">
                <div class="row">
                    <input type="hidden" name="page" value="${pager.page}">
                    <div class="col-auto px-1">
                        <select class="form-select" name="kind">
                            <option value="kind3">전체</option>
                            <option value="kind1">이름</option>
                            <option value="kind2">내용</option>
                        </select>
                    </div>
                    <div class="col-auto px-1">
                        <input class="form-control" name="search" type="text">
                    </div>
                    <div class="col-auto px-1">
                        <button class="btn btn-primary">Search</button>
                    </div>
                </div>
            </form>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>이자율</th>
                    <th>평점</th>
                    <th>판매횟수</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="dto">
                    <tr>
                        <td>${dto.productNum}</td>
                        <td><a href="detail?productNum=${dto.productNum}">${dto.productName}</a></td>
                        <td>${dto.productRate}</td>
                        <td>${dto.productJumsu}</td>
                        <td>${dto.productCount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:if test="${!pager.start}">
                        <li class="page-item">
                            <a class="page-link"
                               href="?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                        <li class="page-item"><a class="page-link"
                                                 href="?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${!pager.last}">
                        <li class="page-item">
                            <a class="page-link"
                               href="?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>

            <div>
                <a class="btn btn-primary" href="add">상품등록</a>
            </div>
        </div>
    </div>

</main>
<!-- 사용전 경로 수정 -->
<c:import url="../templates/footer.jsp"></c:import>
</body>
</html>
