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
    First Name: <sf:input path="firstName" />
    <sf:errors path="firstName" cssClass="error"/><br/>
    Last Name: <sf:input path="lastName" />
    <sf:errors path="lastName" cssClass="error"/><br/>
    Username: <sf:input path="userName" />
    <sf:errors path="userName" cssClass="error"/><br/>
    Password: <sf:password path="password" />
    <sf:errors path="password" cssClass="error"/><br/>
    <input type="submit" value="Register" />
</sf:form>
</body>
</html>
