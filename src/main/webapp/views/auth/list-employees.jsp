<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Mujtaba Hossaini
  Date: 8/21/2021
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<div class="container">

    <table class="table table-striped" border="1px solid black" style="border-collapse: collapse" width="100%"  >

        <thead>
            <tr bgcolor="#deb887">
                <th>HRID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Birth Date</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstname}</td>
                    <td>${employee.lastname}</td>
                    <td>${employee.department}</td>
                    <td>${employee.email}</td>
                    <td>${employee.phone}</td>
                    <td>
                        <fmt:formatDate value="${employee.birth_date}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <a href="/employee/delete-employee?id=${employee.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

<br>
<br>

<a href="/employee/regform" class="btn btn-success">Add Employee</a><br>
<a href="/employee/list-employees" class="btn btn-success">Show All Employees</a><br>

</body>
</html>
