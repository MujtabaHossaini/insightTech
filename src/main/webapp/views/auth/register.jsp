<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mujtaba Hossaini
  Date: 8/21/2021
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register</title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

</head>
<body>

<h3>Register Form</h3>

<div class="container">

    <h2>Add Employee</h2>

    <form action="register" method="post" >
        firstname:<input type="text" name="firstname" autocomplete="off"><br><br>
        lastname:<input type="text" name="lastname" autocomplete="off"><br><br>
        email:<input type="text" name="email" autocomplete="off"><br><br>
        phone:<input type="text" name="phone" autocomplete="off"><br><br>
        department:<input type="text" name="department" autocomplete="off"><br><br>
        birth date(yyyy/MM/dd):<input type="text" name="birth_date" autocomplete="off"><br><br>
        <input type="submit" value="send ....">
    </form>


</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
