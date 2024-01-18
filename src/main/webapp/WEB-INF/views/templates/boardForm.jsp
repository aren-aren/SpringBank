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
							<!-- ProductRate input -->
							<!-- <div class="form-floating mb-3">
								<input 
									class="form-control" 
									name="writer" 
									id="writer" 
									type="text" 
									placeholder="작성자를 입력하세요" 
									value="${member.userName}"
									readOnly
									/> 
								<label for="writer">Writer</label>
							</div> -->

 							<div class="mb-3">
								<h5 class="fw-bolder mb-1">첨부파일</h5>
								<input type="file" class="form-control" name="attachs" accept="image/*">
								<input type="file" class="form-control" name="attachs" accept="image/*">
								<input type="file" class="form-control" name="attachs" accept="image/*">
							</div>

							<div class="d-grid">
								<button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button>
							</div>
						</form>
					</div>
				</div>
			