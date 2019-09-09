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
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <h2>Available stored procedures</h2>
    </header>
    <table class="blueTable">
        <thead>
            <tr>
                <th>Database ID</th>
                <th>Procedure ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>*</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="procedure" items="${proceduresList}">
                <tr>
                    <td>${procedure.databaseId}</td>
                    <td>${procedure.procedureId}</td>
                    <td>${procedure.procedureName}</td>
                    <td>${procedure.procedureDescription}</td>
                    <td><a href="/edit/${procedure.databaseId}-${procedure.procedureId}">edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5">
                    <div class="links">
                        <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
                            <c:url value="/" var="url">
                                <c:param name="page" value="${i.index}"/>
                            </c:url>
                            <a href="${url}">${i.index}</a>
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </tfoot>
    </table>
</body>
</html>
