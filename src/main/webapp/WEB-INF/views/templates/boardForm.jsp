<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">
						<form id="contactForm" method="post" enctype="multipart/form-data">
							<input 
								type="hidden"
								name="noticeNum"
								value="${dto.noticeNum}"/>
							<!-- ProductName input -->
							<div class="form-floating mb-3">
								<input 
									id="NoticeTitle" 
									name="noticeTitle" 
									class="form-control" 
									type="text" 
									placeholder="제목을 입력하세요" 
									value="${dto.noticeTitle}"/> 
								<label for="NoticeTitle">Notice Title</label>
							</div>
							<!-- ProductContents input -->
							<div class="form-floating mb-3">
								<textarea id="summernoteContents" name="noticeContents">${dto.noticeContents}</textarea>
							</div>

 							<div class="mb-3" id="fileList">
								<button id="addBtn" class="btn btn-outline-dark mb-3">+</button>
								<span id="addNotice" class="d-none ms-2">파일은 5개 까지만 등록가능합니다.</span>
							</div>

							<div class="d-grid">
								<button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button>
							</div>
						</form>
					</div>
				</div>
			