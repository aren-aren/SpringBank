<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Member</title>
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
						<span class="text-gradient d-inline">Member Detail</span>
					</h1>
				</div>

				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">

						<div class="card">
							<div class="card-body">
								<h6>${member.userName}</h6>
								<h5 class="card-title">${member.name}</h5>
								<c:if test="${not empty member.avatar}">
									<div>
										<span>My Avatar</span> <img class="card-img-top rounded-circle" src="/resources/upload/avatar/${member.avatar.fileName}">
									</div>
								</c:if>
							</div>
							<ul class="list-group list-group-flush text-center">
								<li class="list-group-item">
									<div class="d-flex w-100 justify-content-center">
										<h5 class="mb-1">주소</h5>
									</div>
									<p class="mb-1">${member.address}</p> 
									<div id="map" style="width:500px;height:400px;"></div>
								</li>
								<li class="list-group-item">
									<div class="d-flex w-100 justify-content-center">
										<h5 class="mb-1">전화번호</h5>
									</div>
									<p class="mb-1">${member.phone}</p> 
								</li>
								<li class="list-group-item">
									<div class="d-flex w-100 justify-content-center">
										<h5 class="mb-1">이메일</h5>
									</div>
									<p class="mb-1">${member.email}</p> 
								</li>
								<li class="list-group-item">
									<div class="btn-group" role="group" aria-label="Basic example">
										<a class="btn btn-outline-primary" href="update">정보 수정</a>
										<a class="btn btn-outline-primary" href="updatePassword">비밀번호 변경</a>
										<a class="btn btn-outline-danger" href="delete">회원 탈퇴</a>
									</div>
								</li>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>
	<c:import url="../templates/footer.jsp"></c:import>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c5d3142b32fe85131261af1fb1aaf26c&libraries=services"></script>
	<script type="text/javascript">
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		let geocoder = new kakao.maps.services.Geocoder();
		/* let map; */
		
	
		 //지도 생성 및 객체 리턴
		
		let callback = function(result, status) {
		    if (status === kakao.maps.services.Status.OK) {
		        console.log(result);
		        console.log(result[0].x);
		        console.log(result[0].y);
		        
		        var options = { //지도를 생성할 때 필요한 기본 옵션
		    			/* center: new kakao.maps.LatLng(126.887662, 37.468416), //지도의 중심좌표. */
   						center: new kakao.maps.LatLng(result[0].y, result[0].x), //지도의 중심좌표.

		    			level: 3 //지도의 레벨(확대, 축소 정도)
		    		};
		        
		        var map = new kakao.maps.Map(container, options);
		        console.log(map)
		    }
		};

		
		geocoder.addressSearch('${member.address}', callback);
		
		
	</script>
</body>
</html>
