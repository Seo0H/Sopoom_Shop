<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>requestBody test</h1>
<a>${member.getUserID()}</a> 
<a>${member.getPostcode()}</a> 
<a>${member.getAddress()}</a>
<a>${member.getDetailAddress()}</a>


</body>
</html>