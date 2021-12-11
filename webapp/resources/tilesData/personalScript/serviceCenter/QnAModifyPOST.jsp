<!-- Summernote -->
<script src="${cPath }/resources/adminLTE3/summernote/summernote-bs4.min.js"></script>


<script> 
$(function () {
	//Add text editor
    $('#compose-textarea').summernote();
})

// summerNotest 의 값을 전송합니다.
$('#checkQna').on('click', function(){
		
	$('#qandaTitle').val($('#ttitle').val());
	
	$('#qandaCode').val('${qnaCode}');
	
	$('#qandaContent').val($('#compose-textarea').val());
	
	$('#qnaWrite').get(0).submit();
	 
})

</script>	
