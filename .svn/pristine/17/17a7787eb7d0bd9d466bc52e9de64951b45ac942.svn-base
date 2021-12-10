<!-- 삭제버튼 (작성자에게만 보여주도록 함) -->
<s:authorize access="isAuthenticated()">
	<div class="col-md-auto">
		<c:if test="${user.username eq vo.bUserId}">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal">삭제</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true"
			>
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">게시물 삭제</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">게시물을 삭제하시겠습니까?</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="clickDel(boardInfo)">삭제하기</button>
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
						</div>
					</div>
				</div>
			</div>
			<script>
				function clickDel(formName) {
					formName.action = "/board/contentDelAsk";
					formName.method = "post";
					formName.submit();
				}
			</script>
		</c:if>
	</div>
</s:authorize>