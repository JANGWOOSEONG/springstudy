<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	function fnSearch(){
		$.ajax({
			type: 'post',
			url: '${contextPath}/search.json',
			data: $('#frm_search').serialize(),
			dataType: 'json',
			success: function(resData){		
				$('#staffList').empty();
				let str = '<tr>';
				str += '<td>' + resData.sno;
				str += '<td>' + resData.name;
				str += '<td>' + resData.dept;
				str += '<td>' + resData.salary;
				$('#staffList').append(str);
			},
			error: function(jqXHR){
				alert('조회된 사원 정보가 없습니다.')
				fnList();
				$('#query').val('');
			}
		})
}
</script>
</head>
<body>

</body>
</html>