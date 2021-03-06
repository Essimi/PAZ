<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
$(function() {
	
	var Toast = Swal.mixin({
		toast : true,
		position : 'top-end',
		showConfirmButton : false,
		timer : 3000
	});

	var message = "${status}";
	if (message != "") {
		switch (message) {
		case "PKDUPLICATED":
			toastr.error("회원님이 PL역할인 프로젝트가 존재해 탈퇴할 수 없습니다.");
			break;
		case "FAILED":
			toastr.error("서버상의 오류가 발생했습니다. 다시 시도해 주세요.");
			break;
		};
	};

	$("#memdelete").on("click", function() {
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			location.href = "${cPath }/mypage/memberDelete.do";
		}
	})
	
	/* 환불 관련(상세조회) script */

	// 초기화를 위한 변수명 지정
	let lastDate = null;
	let lastAmount = 0;
	let lastTool = null;

	$.ajax({
		url : '${cPath}/project/payInfo.do',
		dataType : 'json',
		method : 'POST',
		success : function(resp) {

			let array = resp;

			console.log(resp)

			$("#refundArea").empty();

			// 환불 리스트를 생성합니다.
			for (let i = 0; i < array.length; i++) {
				$("#refundArea").append(
					"<tr>"
						+ "<th>" + array[i].payDate + "</th>"
						+ "<th>" + array[i].payAmount + "</th>"
						+ "<th id ='th_" + i + "'>" + array[i].payMonth + "</th>"
						+ "<th>" + array[i].payProvider + "</th>"
						+ "<th style = 'width : 10%;'><button style = 'width : 125px; height : 40px;' id = 'btn_"
						+ i + "' class = 'btn btn-info refundBtn ' value ='" + array[i].payCode 
						+ "' data-toggle='modal' data-target='#modal-refund'>환불하기</button></th>"
						+ "</tr>");
			}

		},
		error : function(xhr, error, msg) {

		},
	});
});

// 변수를 생성해줍니다.
let refundPayCode = null;
let refundMonth = null;
let refundMonthStr = null;
let monthCount = null;

// 환불하기 버튼을 클릭한 경우 입니다.
// 동적으로 생성한 table 에서 정보들을 가져옵니다.
$('#refundArea').on('click', '.refundBtn', function() {

	// 환불 사유 저장을 위한 변수를 지정해줍니다.
	refundPayCode = $(this).val();
	refundMonth = $(this).prop("id");

	// 문자열을 자르기 위해 추출합니다.
	refundMonthStr = refundMonth.substring(4);
	monthCount = $("#th_" + refundMonthStr).text();
})

// modal 에서 환불하기 버튼을 클릭한 경우 입니다.
// 가져온 정보들을 controller 에 보내줍니다.
$('#realRefundBtn').on('click', function() {
		
	let reason = $('#refundText').val();
	
	$.ajax({
		url : '${cPath}/project/payRefund.do',
		method : 'POST',
		data : {
			"reason" : reason,
			"refundPayCode" : refundPayCode,
			"refundMonth" : monthCount
		},
		success : function(resp) {

			// 컨트롤러에서 모든 검증을 마치고 리턴받은 메세지를 출력합니다.
			alert(resp)
			location.replace(location.href);

		},
		error : function(xhr, error, msg) {

			// 실패했다면 에러메세지를 출력합니다.
			alert(resp.dateError);
			location.replace(location.href);
		}
	})
})

//추가 결제 관련 script
$('.payInfo').click(function() {
	let cost = $(this).val().split(',');

	let money = cost[0]; // 가격 지정
	let plat = cost[1]; // 플랫폼 이름 지정
	let platt = plat.trim() // 공백을 제거한 플랫폼 이름
	let months = cost[2] // 결제 달 지정

	let IMP = window.IMP; // 문서에는 생략 가능이라는데 생략할 경우 실행이 안됩니다.
	IMP.init('imp23458695');

	IMP.request_pay({
		pg : platt, // 동적인 플랫폼 이름
		merchant_uid : 'merchant_' + new Date().getTime(),
		name : '회원 결제',
		amount : money, // 동적인 가격
		buyer_email : 'daeduck@PAZ.LASTPROJECT',
		buyer_name : 'PAZ',
		buyer_tel : '010-1234-5678',
		buyer_addr : '대전 대덕인재개발원',
		buyer_postcode : '123-456'
	}, function(resp) {

		// 결제검증
		$.ajax({
			type : "POST",
			url : "${cPath}/project/PayController.do/" + resp.imp_uid
		}).done(function(data) {

			// 위의 resp.paid_amount 와 data.response.amount를 비교한후 로직 실행 (import 서버검증)

			if (resp.paid_amount == data.response.amount) {

				// 검증이 완료되었다면, 데이터베이스에 해당 결제 정보를 저장합니다.              
				$.ajax({
					url : "${cPath}/project/PayPlusAddition.do",
					method : 'POST',
					data : {
						"payCode" : data.response.impUid,
						"payAmount" : data.response.amount,
						"payMonth" : months,
						"payProvider" : data.response.pgProvider,
						"payMerUid" : data.response.merchantUid,
						"payPgSuccess" : data.response.pgTid
					},
					success : function(message) {

						alert(message);

						location.replace(location.href);
					},
					error : function(xhr, jQuery, error) {

						alert("결제가 실패했습니다..");
						console.log(jQuery);
						console.log(error);
						location.replace(location.href);
					}
				})
			} else {
				alert("결제가 실패하였습니다.(검증 실패)");
				location.replace(location.href);
			}
		});
	});
})
</script>