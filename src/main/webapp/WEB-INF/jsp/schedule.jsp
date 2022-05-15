<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="${pageContext.request.contextPath}css/style.css" rel="stylesheet" type="text/css"/>
    <title>Schedule</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Day</th>
        <th>Lecture</th>
        <th>Couple</th>
        <th>Group</th>
        <th>Lecture Room</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="scheduled" scope="request" type="java.util.List"/>
    <c:forEach var="schedule" items="${scheduled}">
        <tr>
            <td>${schedule.dayOfWeek}</td>
            <td>${schedule.lecture}</td>
            <td>${schedule.couple}</td>
            <td>${schedule.group}</td>
            <td>${schedule.lecture_room}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>