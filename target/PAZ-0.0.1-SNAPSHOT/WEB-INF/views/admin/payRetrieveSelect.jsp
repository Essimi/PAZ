<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .content-wrapper,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-footer,
	body:not(.sidebar-mini-md):not(.sidebar-mini-xs):not(.layout-top-nav) .main-header
	{
	margin-left: 0px;
}

.col-md-9 {
	max-width: 100%;
}

#content {
	padding:30px 100px;
}

.mailbox-read-info, .mailbox-controls, .mailbox-read-message, .refundNo {
	padding: 20px;
}

.payP {
	font-weight: bolder;
}

.cardBorderTop {
	border-top: 3px solid #3f6791;
}
</style>


 <div class="col-md-9">
          <div class="card cardBorderTop">
            <div class="card-header">
              <h2 class="card-title">결제 상세조회</h2>
            	<h10 style="float: right">글 번호  : ${payVO.payCode }</h10>
              
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <div class="mailbox-read-info">
                <h5><sapn>${payVO.memId} </sapn> 회원님</h5>
                <h6><span class="mailbox-read-time float-right">${payVO.payDate}</span></h6>
              
              </div>
              <!-- 내용 -->
              <div class="mailbox-controls with-border">
                <p class="payP"><i style="color:#fd7e14; margin-right: 10px;" class="fas fa-check"></i> 결제된 프로젝트</p>
                <p>&nbsp&nbsp&nbsp - 회원 아이디 : ${payVO.memId}</p>
               
              </div>
              <!-- 결제 내용 -->
              <div class="mailbox-read-message">
				<p class="payP"><i style="color:#fd7e14; margin-right: 10px;" class="fas fa-check"></i> 결제 정보</p>
                <p>&nbsp&nbsp&nbsp - 결제날짜 : ${payVO.payDate }</p>
                <p>&nbsp&nbsp&nbsp - 결제금액 : <fmt:formatNumber value="${payVO.payAmount}" pattern="#,###"/>원</p>
                <p>&nbsp&nbsp&nbsp - 결제개월 : ${payVO.payMonth}</p>
                <p>&nbsp&nbsp&nbsp - 결제 플랫폼 : ${payVO.payProvider}</p>
              </div>
              
              <!-- 환불 코드가 있으면 밑에있는 환불 정보를 나타내게 한다 -->
              <c:choose>
					<c:when test="${not empty payVO.refundInfo.refundCode}">
		               <div class="mailbox-read-message">
						 <p class="payP"><i style="color:#25a383; margin-right: 10px;" class="fas fa-money-bill-wave"></i>환불 정보</p><!-- 환불정보 데이터 다시 넣기 -->
		                <p>&nbsp&nbsp&nbsp - 환불날짜 : ${payVO.refundInfo.refundDate}</p>
		                <p>&nbsp&nbsp&nbsp - 환불내역 : ${payVO.refundInfo.refundDetail}</p>
		               </div>
					</c:when>
					<c:otherwise>
						<div class="refundNo">
						  <p style="color:gray;">환불내역 없음</p>
						</div>
					</c:otherwise>
			  </c:choose>
              
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.card-body -->
            <div class="card-footer bg-white">
              <ul class="mailbox-attachments d-flex align-items-stretch clearfix">


              </ul>
            </div>
            <!-- /.card-footer -->
            <div class="card-footer">
            	<input type="button" class="btn btn-default" value="뒤로가기" onclick="location.href='${cPath }/admin/payRetrieve/List.do'">
           	
            </div>
            <!-- /.card-footer -->
          </div>
          <!-- /.card -->
        </div>
        



	