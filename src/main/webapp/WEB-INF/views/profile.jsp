<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.userName}" /><br/>
<c:out value="${spitter.firstName}" />
<c:out value="${spitter.lastName}" />
</body>
</html>
