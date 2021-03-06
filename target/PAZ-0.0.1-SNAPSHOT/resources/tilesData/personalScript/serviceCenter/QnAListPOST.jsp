<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- DataTables  & Plugins -->
<script src="${cPath }/resources/adminLTE3/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/jszip/jszip.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/pdfmake/pdfmake.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/pdfmake/vfs_fonts.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${cPath }/resources/adminLTE3/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>

<!-- 파일 저장 처리 관련 스크립트  -->
<script>
	$(function() {
		$("#example1").DataTable({
			"lengthChange" : false,
			"searching" : false,
			"info" : false,
			"ordering" : false,
			"paging" : false,
			"buttons" : [ "copy", "csv", "excel", "print" ]
		}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
	}); 
</script> 