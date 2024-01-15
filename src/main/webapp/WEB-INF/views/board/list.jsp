<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Board List</title>
        <!-- 사용전 경로 수정 -->
        <c:import url="../templates/head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- 사용전 경로 수정 -->
			<c:import url="../templates/header.jsp"></c:import>
			
			<section class="py-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Board List</span></h1>
                </div>

                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-11 col-xl-9 col-xxl-8">
                        <div>
                            <table class="table table-striped table-warning table-hover">
                                <thead>
                                    <tr>
                                        <th style="width: 8%">번호</th>
                                        <th style="width: 62%">제목</th>
                                        <th style="width: 11%">작성자</th>
                                        <th style="width: 12%">날짜</th>
                                        <th style="width: 7%">조회수</th>
                                    </tr>
                                </thead>
                                <tbody class="table-group-divider">
                                    <c:forEach items="${list}" var="dto">
                                    <tr>
                                        <td>${dto.noticeNum}</td>
                                        <td>${dto.noticeTitle}</td>
                                        <td>${dto.writer}</td>
                                        <td>${dto.noticeDate }</td>
                                        <td>${dto.noticeViews }</td>
                                    </tr>
									</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!-- 사용전 경로 수정 -->
		<c:import url="../templates/footer.jsp"></c:import>
    </body>
</html>
