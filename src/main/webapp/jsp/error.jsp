<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 04.03.2020
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error_styles.css">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/img/background_error.jpg)">
<div class="error-message-container">
    <p>Error</p>
    <p>Status: ${pageContext.errorData.statusCode}</p>
    <p>Request URI: ${pageContext.errorData.requestURI}</p>
    <p>Servlet: ${pageContext.errorData.servletName}</p>
</div>

</body>
</html>
