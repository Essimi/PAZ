<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
$(document).ready(function() {
	$(".navbar a, footer a[href='#myPage']").on('click', function(event) {
		if (this.hash !== "") {
			event.preventDefault();

			var hash = this.hash;

			$('html, body').animate({
				scrollTop : $(hash).offset().top
			}, 900, function() {

				window.location.hash = hash;
			});
		}
	});

	$(window).scroll(function() {
		$(".slideanim").each(function() {
			var pos = $(this).offset().top;

			var winTop = $(window).scrollTop();
			if (pos < winTop + 600) {
				$(this).addClass("slide");
			}
		});
	});
})

// 회원의 결제 상태를 판단하는 script 입니다.
// controller 에서 판단한 조건에 따라 페이지로 이동됩니다.
// 미결제 회원일시 결제 관련 modal 을 출력합니다.
$("#project").on('click', function() {

	$.ajax({
		url : "${cPath}/makeProject.do",
		method : "post",
		success : function(resp) {

			if (resp[1] == "결제") {

				location.href = "${cPath}" + resp[0];

			} else if (resp[1] == "미결제") {

				$('#payHiddenBtn').trigger("click");

			} else if (resp[1] == "비로그인") {

				location.href = "${cPath}" + resp[0];

			}
		},
		error : function(xhr, jQuery, error) {
			console.log(jQuery);
			console.log(error);
		}
	})
})

// 결제 관련 script
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
					url : "${cPath}/project/PayAddition.do",
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
	
	$(function() {
	    var Toast = Swal.mixin({
	      toast: true,
	      position: 'top-end',
	      showConfirmButton: false,
	      timer: 3000
	    });
	    
	    var message = "${status}";
	    if(message == "OK"){
	    	toastr.success("회원님의 탈퇴요청이 성공적으로 처리되었습니다.");
	    };
		
	});
})
</script>	