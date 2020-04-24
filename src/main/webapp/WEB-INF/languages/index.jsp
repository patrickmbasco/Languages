<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<title>Languages</title>
</head>
<body>
	<div id="container">
	<h1>Languages</h1>
		<table class="table table-striped table-hover table-bordered tblbrd">
			<thead>
				<tr>
		            <th scope="col">Name</th>
		            <th scope="col">Creator</th>
		            <th scope="col">Version</th>
		            <th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
				<tr>
			        <td><a href="languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
			        <td><c:out value="${language.creator}"/></td>
			       	<td><c:out value="${language.currentVersion}"/></td>
					<td><a href="/languages/delete/<c:out value="${language.id}"/>">Delete</a> <a href="/languages/edit/<c:out value="${language.id}"/>">Edit</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="form">
			<form:form action="/languages" method="post" modelAttribute="addNew">
				<p>
			        <form:label cssClass="label" path="name">Name</form:label>
			        <form:input cssClass="box" path="name"/>
			        <form:errors cssClass="red" path="name"/>
			    </p>
			    <p>
			        <form:label cssClass="label" path="creator">Creator</form:label>
			        <form:input cssClass="box" path="creator"/>
    				<form:errors cssClass="red" path="creator"/>
			    </p>
			    <p>
			        <form:label cssClass="label" path="currentVersion">Version</form:label>
			        <form:input cssClass="box" path="currentVersion"/>
     		 		<form:errors cssClass="red" path="currentVersion"/>
			    </p>
			    <input id="btn" type="submit" value="Submit"/>	
			</form:form>		  
			
		</div>
	</div>

</body>
</html>