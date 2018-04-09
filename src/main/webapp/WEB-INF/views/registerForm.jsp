<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" modelAttribute="spitter">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="firstName" cssErrorClass="error">First Name: </sf:label>
    <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName" cssErrorClass="error">Last Name:</sf:label>
    <sf:input path="lastName" cssErrorClass="error"/><br/>
    <sf:label path="userName" cssErrorClass="error">Username:</sf:label>
    <sf:input path="userName" cssErrorClass="error"/><br/>
    <sf:label path="password" cssErrorClass="error">Password: </sf:label>
    <sf:password path="password" cssErrorClass="error"/><br/>
    <input type="submit" value="Register" />
</sf:form>
</body>
</html>
