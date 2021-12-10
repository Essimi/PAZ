<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
<!-- Summernote -->
<script src="${cPath }/resources/adminLTE3/summernote/summernote-bs4.min.js"></script>

<script>

$(function () {
	var Toast = Swal.mixin({
		toast : true,
		position : 'top-end',
		showConfirmButton : false,
		timer : 3000
	});

	var message = "${status}";
	if (message != "") {
		toastr.error("등록에 실패하셨습니다. 다시 시도해주세요.");
	};
	
    //Add text editor
    $('#compose-textarea').summernote({
    	 height: 300,
    	 minHeight: 300,            
         maxHeight: 300
    })
    
    function leftPad(value) { 
    	if (value >= 10) { return value; } 
    	return '0' + value; 
    } 
    
    function dateFormatting(source, delimiter = '-') { 
    	const year = source.getFullYear(); 
    	const month = leftPad(source.getMonth() + 1); 
    	const day = leftPad(source.getDate()); 
    	
    	return [year, month, day].join(delimiter); 
    }
    // 현재날짜 출력 포맷
    var str = dateFormatting(new Date(), '-');
    $("#currentDate").text(str);
    
    // 히든 form에 데이터 넣기
    var searchForm = $("#issueForm");
    $("#confirmIssue").on("click", function(){
		$("#searchUI").find(":input[name]").each(function(idx, input){
			let name = input.name;
			if(name == 'files'){
				return false;
			}
			let value = $(input).val();
			let form = searchForm.get(0);
			form[name].value = value;
		});
		var recipient = []; 
		$("input:checkbox[name='recipient']").each(function(){
			if($(this).is(":checked")){
				recipient.push($(this).val());				
			}
		})
		searchForm.find("input[name='Recipients']").val(recipient);
		searchForm.find("input[name='issueContents']").val($("#compose-textarea").val());
		
		searchForm.submit();
	});
    
    $("#cancelIssue").on("click", function(){
    	location.href="${cPath }/project/${project.pCode}/issue/issueList.do";
    })
    
    
	if("${issue.issueTypeCode}" != ""){
		$("select[name='issueTypeCode']").find("option[value='${issue.issueTypeCode}']").attr("selected", "selected");
	}
    
	if("${issue.importance}" != ""){
		$("select[name='importance']").find("option[value='${issue.importance}']").attr("selected", "selected");
	}
	
	// 기존에 체크되어있던 수신자 체크 
	<c:if test="${!empty issue }">
		<c:forEach items="${issue.issueRecipients}" var="recipient">
			$("input:checkbox[name='recipient']").each(function(idx, checkbox){
				if("${recipient.memId}" == $(checkbox).val()){
					$(checkbox).prop("checked", true);
				}
			})
			// 기존에 수신자로 체크되어있었지만 탈퇴된 회원
			if("${recipient.outStatus}" == "1"){
				$("#recipientList").append(
					$("<tr>").css("background-color", "rgba(255, 255, 255, 0.5)").append(
						$("<td>").append(
							$("<img>").addClass("img-circle img-size-32 mr-2")
									  .attr({ 
										  "src" : "${cPath }/resources/file/profileImage/${recipient.saveName }",
										  "onerror" : "this.src='${cPath }/resources/file/profileImage/profile.jpg'"
									  }),
							"${recipient.memNickname }"
						),
						$("<td>").text("${recipient.position }"),
						$("<td>").text("[탈퇴]")
					)
				)
			}
		</c:forEach>
	</c:if>
  })

$('#topWorkSearch').keyup(function () {
	  
	  var searchWorkName = $(this).val();
	  $.ajax ({
		  url : "${cPath}/task/taskSearch.do",
		  data : { searchWorkName : $(this).val() },
		  method : 'post',
		  success : function(resp) {
			   $('#searchListTable').empty();
			   
			  for(let i = 0; i < resp.length; i++){
				  
				  $('#searchListTable').append(
						  "<tr class='searchTr' style='margin-top:20px;'>" +
						  "<td style='text-align:center;'>" + resp[i].workCode + "</td>" +
						  "<td style='text-align:center;'>" + resp[i].workName + "</td>" +
						  "<td style='text-align:center;'><input type='button' value='선택' class='btn btn-info btn-sm btnCheck' " +
						  "data-value=' "+ resp[i].workCode + " - " + resp[i].workName + " '></input></td>" +
						  "</tr>"
					);
				  
				  $('.btnCheck').on('click', function () {
					 dataValue = $(this).attr('data-value');
					 
					 $('#topWorkCodeDiv').html("<p style='margin-top:10px;'><i style='color:#dc3545; margin-right:10px;'class='fas fa-check'></i>" + dataValue + "</p>");
					 $('#topWorkSpan').attr('data-value', dataValue)
					 
					 let workCode = $(this).closest("tr").children("td").eq(0).text();
					 $("#topWorkCodeDiv").append($("<input>").attr({"type" : "hidden", "name" : "workCode"})
							 								.val(workCode)
					 							);
							 
					 $('#myModal').modal('hide');
				  })

			  } 
			   
			   
				//$('.searchList').text(resp.workName);
				
			},
		  error: function(xhr, jQuery, error){
				console.log(jQuery);
				console.log(error);
		  }
	  })
})

</script>