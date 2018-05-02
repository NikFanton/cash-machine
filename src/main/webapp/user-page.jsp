<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
    Welcome, <c:out value="${role}"/>!
    <a href="${pageContext.request.contextPath}/api/logout">Logout</a>
</body>
</html>
