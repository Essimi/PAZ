<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 선택한 멤버의 정보를 조회하는 스크립트 -->

<script>

	$('.marginClass').click(function() {
		
		$('#profileModal').modal();
		
		var memId = $(this).attr("id");

		$.ajax({

			data : {
				memId : memId
			},
			dataType : "json",
			url : "${cPath}/chat/chattingProfile.do",

			success : function(resp) {
				$('#getChoiceMemNickname').val(resp.memNickname);
				$('#getChoiceMemId').val(resp.memId);

				$('#nameSpace').text(resp.memNickname);
				$('#aboutSpace').text(resp.pTitle + "/" + resp.position);
				$('#companySpace').text(resp.memCompany);
				$('#telSpace').text(resp.memTel);
				$("#SpaceIMG").attr("src", "${cPath }/resources/file/profileImage/" + resp.saveName);
			},
			error : function(error) {
				console.log("실패");
			}

		});

	});
	
</script>

<!-- ************************* -->

<!-- 선택한 1명의 멤버를 대상으로 채팅을 진행한다. -->

<script>

	$('#startChat').click(function() {
		
		// 현재 선택된 멤버의 정보를 가져온다.
		let yourId = $('#getChoiceMemId').val();
		let yourNickname = $('#getChoiceMemNickname').val();
		
		let chatroomCode = null;

		$.ajax({

			data : {
				"yourId" : yourId,
				"yourNickname" : yourNickname
			},
			dataType : "json",
			url : "${cPath}/chat/oneMakeChat.do",
			method : "POST",
			async:false,
			success : function(resp) {
				
				chatroomCode = resp.chatroomCode;
				
			},
			error : function(error) {
				console.log("실패");
			}

		});

		conWebsocket(chatroomCode);
		
		$('#profileModal').modal("hide");
		$('#chatModal').modal();
		
	});
	
</script>

<!-- ************************* -->

<!-- 이미 만들어진 채팅방에 진입할 경우 -->

<script>
	
	$('.startChatroom').click(function() {
		
		$('.receive').remove();
		let chatroomCode = $(this).attr('id');
		
		conWebsocket(chatroomCode);
		
		$('#chatModal').modal();

	});
	
</script>

<!-- ************************* -->

<!-- 채팅이 진행되는 함수 -->

<script type="text/javascript">

let webSocket = null;

function conWebsocket(chatroomCode){
	
	let messageTag = $("#messageTag");
	let messageArea = $("#messageArea");
	
	$('.receive').remove();
	let myId = $('#myId').val();

	//채팅방 정보를 기반으로 웹소켓을 연결한다.
	webSocket = new WebSocket("ws://192.168.0.167${cPath}/websocket/echo/" + chatroomCode + "/" + myId);

	webSocket.onopen = function(event) {

		console.log(event);
		console.log("웹소켓 오픈");
		webSocket.send(myId + " 님이 들어왔습니다."); 

	}
	webSocket.onclose = function(event) {
		console.log(event);
	}
	webSocket.onerror = function(event) {
		console.log(event);
	}

	webSocket.onmessage = function(event) {

		// 서버에서 가져오는 메시지의 정보
		// 서버에서 메시지가 들어올 때 실행된다.

		// 화면에 메시지를 표현한다.

		let msg = event.data; // 이벤트에서 가져온 json 형식 데이터
		
		let data = JSON.parse(msg); // json 형식의 값을 변환
		
		let chatTag = "";
		
		if (data.memId == myId ) {
			
			chatTag = "<div class='direct-chat-msg right'>";
			chatTag += "<div class='direct-chat-infos clearfix'>";
			chatTag += "<span class='direct-chat-name float-right'>";
			chatTag += "ME";
			chatTag += "</span>";
			chatTag += "<span class='direct-chat-timestamp float-left'>";
			chatTag += data.chatTime;
			chatTag += "</span>";
			chatTag += "</div>";
			chatTag += "<img class='direct-chat-img'";
			chatTag += "src='${cPath }/resources/file/profileImage/BMO-1.jpg'>";
			chatTag += "<div class='direct-chat-text'>";
			chatTag += data.content;
			chatTag += "</div>";
			chatTag += "</div>";
			
		} else {
			
			chatTag = "<div class='direct-chat-msg'>";
			chatTag += "<div class='direct-chat-infos clearfix'>";
			chatTag += "<span class='direct-chat-name float-left'>";
			chatTag += data.memNickname;
			chatTag += "</span>";
			chatTag += "<span class='direct-chat-timestamp float-right'>";
			chatTag += data.chatTime;
			chatTag += "</span>";
			chatTag += "</div>";
			chatTag += "<img class='direct-chat-img'";
			chatTag += "src='${cPath }/resources/file/profileImage/BMO-1.jpg'>";
			chatTag += "<div class='direct-chat-text' style='background-color:#FFE4E1; border: 1px solid #FFE4E1;'>";
			chatTag += data.content;
			chatTag += "</div>";
			chatTag += "</div>";
			
		}
		
		messageArea.append($("<div>").addClass("receive").html(chatTag));

	}

	$("#sendMsg").on("click",function() {
		
		// 클라이언트의 메시지를 가장 먼저 가져오는 부분이다.
		// 클라이언트의 메시지를 서버에게 전달한다.

		let message = messageTag.val();

		if (!message) {
			return;
		}

		webSocket.send(message); // 서버 방향으로 메시지를 보낸다.
		messageTag.val("");
		
	});
	
}

$('#disconnectBtn').click(function() {
	
	console.log("웹소켓 종료 함수.");
	webSocket.close();
	
});

</script>

<!-- ************************* -->

<!-- 여러명의 멤버를 선택하여 채팅방을 개설한다. -->

<script>
	$('#multipleChat').click(function() {

		$('#multipleChatModal').modal();

	});
</script>

<!-- ************************* -->

<!-- 채팅방 개설을 위한 멤버 선택 -->

<script>

	var memberList = [];
	var chatTitle;

	$('#nextBtn').click(function() {

		// 선택된 체크박스의 배열을 가져온다.

		$("input[name=checkbox]:checked").each(function() {
			var member = $(this).val();
			memberList.push(member);
		})

		// 선택한 멤버의 수에 따라 모달을 띄운다.

		if (memberList.length <= 0) {
			$('#chatWarningModal').modal();
		} else {
			$('#multipleChatModal').modal("hide");
			$('#MakeMultipleChatModal').modal();
		}

	});

	$('#makeChatBtn').click(function() {
		
		// 채팅방을 만드는 요청 전송
		// 멤버 리스트와 채팅방의 타이틀을 검색해온다. - memberList,

		chatTitle = $('#chatTitle').val();

		$.ajax({

			data : {
				"memberList" : memberList,
				"chatTitle" : chatTitle
			},
			dataType : "json",
			url : "${cPath}/chat/makeChat.do",
			method : "POST",

			success : function(resp) {
				conWebsocket(resp.chatroomCode);
				
				$('#MakeMultipleChatModal').modal("hide");
				$('#chatModal').modal();
			},
			error : function(error) {
				console.log("실패");
			}

		});

	});
</script>

<!-- ************************* -->