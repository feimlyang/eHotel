<%--
  Created by IntelliJ IDEA.
  User: manlin
  Date: 2020-04-06
  Time: 1:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>customer register page</title>

</head>
<body>
<form method = "post" action="RegisterServlet">
    <label for="roleType">Choose a role:</label>

    <select name= "roleType" id="roleType">
        <option value="guest">guest</option>
        <option value="host">host</option>
        <option value="employee">employee</option>
    </select>

    please input your ID:<input type="text" id="user_id" name="user_id"><br><br>
    please input your first name:<input type="text" id="first_name" name="first_name"><br><br>
    <button type="submit" value="submit" >submit</button>
    <button type="reset" value="reset">reset</button>
</form>

</body>
</html>
