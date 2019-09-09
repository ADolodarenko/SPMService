<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 15.08.2019
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit procedure</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <h2>${procedure.procedureName}</h2>
    </header>
    <c:url value="/edit" var="edit"/>
    <form action="${edit}" method="POST">
        <table class="blueTable">
            <thead>
                <tr>
                    <th>Parameter name</th>
                    <th>Parameter value</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Database ID</td>
                    <td>${procedure.databaseId}</td>
                </tr>
                <input type="hidden" name="databaseId" value="${procedure.databaseId}">
                <tr>
                    <td>Procedure ID</td>
                    <td>${procedure.procedureId}</td>
                </tr>
                <input type="hidden" name="procedureId" value="${procedure.procedureId}">
                <tr>
                    <td>Name</td>
                    <td>${procedure.procedureName}</td>
                </tr>
                <input type="hidden" name="procedureName" value="${procedure.procedureName}">
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="procedureDescription" id="procedureDescription" value="${procedure.procedureDescription}"></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"><a href="/?page=${page}"><input type="button" value="Cancel"></a></td>
                </tr>
            </tfoot>
        </table>
    </form>
</body>
</html>
