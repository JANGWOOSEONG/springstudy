<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var ="contextPath" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>
<div>
	<h1>사원 목록</h1>
	<div>
	<table border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>사원번호</th>
				<th>사원명</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일자</th>
				<th>직업</th>
				<th>연봉</th>
				<th>커미션</th>
				<th>매니저</th>
				<th>부서번호</th>
				<th>부서명</th>
			</tr>
		</thead>
		<c:forEach items="${employees}" var="emp" varStatus="vs"> 
			<tr>
				<td>${vs.index + 1}</td>
				<td>${emp.employeeId}</td>
				<td>${emp.firstName} ${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.phoneNumber}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.jobId}</td>
				<td>${emp.salary}</td>
				<td>${emp.commissionPct}</td>
				<td>${emp.managerId}</td>
				<td>${emp.deptDTO.departmentId}</td>
				<td>${emp.deptDTO.departmentName}</td>			
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>