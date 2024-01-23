<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
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
            <h1 class="display-5 fw-bolder mb-0">
              <span class="text-gradient d-inline">${title } 회원가입</span>
            </h1>
          </div>

          <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-8">
              <form
                id="contactForm"
                class="needs-validation"
                novalidate
                method="post"
                enctype="multipart/form-data"
              >
                <!-- ProductName input -->
                <div class="form-floating mb-3">
                  <input
                    id="userName"
                    name="userName"
                    class="form-control"
                    type="text"
                    placeholder="아이디를 입력하세요"
                    required
                  />
                  <label for="userName">아이디</label>
                  <div id="userNameResult"></div>
                </div>
                <div class="form-floating mb-3">
                  <input
                    id="memberPassword"
                    name="password"
                    class="form-control"
                    type="password"
                    placeholder="비밀번호를 입력하세요"
                    required
                  />
                  <label for="memberPassword">비밀번호</label>
                  <div id="passwordResult"></div>
                </div>
                <div class="form-floating mb-3">
                  <input
                    id="memberPasswordCheck"
                    class="form-control"
                    type="password"
                    placeholder="비밀번호를 한번 더 입력하세요"
                    required
                  />
                  <label for="memberPasswordCheck">비밀번호 확인</label>
                  <div id="passwordCheckResult"></div>
                </div>
                <div class="form-floating mb-3">
                  <input
                    id="memberName"
                    name="name"
                    class="form-control"
                    type="text"
                    placeholder="이름을 입력하세요"
                  />
                  <label for="memberName">이름</label>
                </div>
                <div class="form-floating mb-3">
                  <input
                    id="memberPhone"
                    name="phone"
                    class="form-control"
                    type="text"
                    placeholder="전화번호를 입력하세요"
                  />
                  <label for="memberPhone">전화번호</label>
                </div>
                <div class="form-floating mb-3">
                  <input
                    id="memberEmail"
                    name="email"
                    class="form-control"
                    type="email"
                    placeholder="이메일을 입력하세요"
                  />
                  <label for="memberEmail">이메일</label>
                </div>
                <div class="input-group mb-3">
                  <div class="form-floating">
                    <input
                      id="memberAddress"
                      name="address"
                      class="form-control"
                      type="text"
                      placeholder="주소를 입력하세요"
                    />
                    <label for="memberAddress">주소</label>
                  </div>
                  <input
                    id="findAddress"
                    type="button"
                    class="btn btn-outline-primary"
                    value="주소찾기"
                  />
                </div>
                <div id="addrNotice" class="d-none mb-3">
                  상세주소를 이어서 작성해주세요
                </div>

                <div class="mb-3">
                  <h5 class="fw-bolder mb-1">Avatar 사진</h5>
                  <input
                    type="file"
                    class="form-control"
                    name="file"
                    accept="image/*"
                  />
                </div>

                <div class="d-grid">
                  <button
                    class="btn btn-primary btn-lg"
                    id="submitButton"
                    type="submit"
                  >
                    가입하기
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </main>
    <c:import url="../templates/footer.jsp"></c:import>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="/resources/js/member/join.js"></script>
  </body>
</html>
