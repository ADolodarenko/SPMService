<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 15.08.2019
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Procedures</title>
</head>
<body>
    <h2>Available stored procedures</h2>
    <table>
        <tr>
            <th>Database ID</th>
            <th>Procedure ID</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <c:forEach var="procedure" items="${proceduresList}">
            <tr>
                <td>${procedure.databaseId}</td>
                <td>${procedure.procedureId}</td>
                <td>${procedure.procedureName}</td>
                <td>${procedure.procedureDescription}</td>
                <td><a href="/edit/${procedure.databaseId}-${procedure.procedureId}">edit</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
