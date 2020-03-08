<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 04.03.2020
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result_styles.css">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/img/background3.png);
        background-repeat: no-repeat; background-size: cover; background-position: center center;">
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Origin</th>
            <th>Soil</th>
            <th>Stem colour</th>
            <th>Leaves colour</th>
            <th>Average size(cm)</th>
            <th>Photophilous</th>
            <th>Growth Temperature(celsius)</th>
            <th>Weekly watering(ml)</th>
            <th>Multiplying type</th>
            <th>Wild only</th>
        </tr>
        <c:forEach var="flower" items="${result}">
            <tr>
                <td>${flower.id}</td>
                <td>${flower.name}</td>
                <td>${flower.origin}</td>
                <td>${flower.soilType.value}</td>
                <td>${flower.visualDescription.stemColour.value}</td>
                <td>${flower.visualDescription.leavesColour.value}</td>
                <td>${flower.visualDescription.averageSize}</td>
                <td>${flower.growingTip.photophilous}</td>
                <td>${flower.growingTip.growthTemperature}</td>
                <td>${flower.growingTip.weeklyWatering}</td>
                <td>${flower.multiplyingType.value}</td>
                <td>${flower.wildOnly}</td>
            </tr>

        </c:forEach>
    </table>
</div>
<div class="home-link-container">
    <a class = "home-link" href=${pageContext.request.contextPath}/index.jsp>Home</a>
</div>

</body>
</html>
