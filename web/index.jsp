<%--
  Created by IntelliJ IDEA.
  User: manlin
  Date: 2020-04-04
  Time: 10:10 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>Customer Login</title>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta http-equiv="Content-Language" content="ch-cn">
  <script>

    function validate() {
      var user_id = document.getElementById("user_id");
      //var upass = document.getElementById("upass");
      if(user_id.value == ""){
        alert("username can't be null");
        return false;
      }
      else
        return true;
    }

  </script>
</head>

<body>
<h1>Group_30 welcome you to our online booking system! </h1>
<%--<button value="guest" onclick="location.href='LoginServlet'" ;>Guest</button>--%>
<%--<button value="host" onclick="location.href='LoginServlet'">Host</button>--%>
<%--<button value="employee" onclick="location.href='LoginServlet'">Employee</button>--%>
<div class="container">
  <h2>Login: </h2>
  <h3> Pre registered test account: </h3>
  <h3> guest user: g001 </h3>
  <h3> host user: h001 </h3>
  <h3> employee user: e001 </h3>

  <!-- when we click SUBMIT, only "return validate();" is true, the form will be submited -->
  <!--login is here -->
  <form method="post" action='LoginServlet' onSubmit="return validate();">
    <label for="roleType">Choose a role:</label>

    <select name= "roleType" id="roleType">
      <option value="guest">guest</option>
      <option value="host">host</option>
      <option value="employee">employee</option>
    </select>

    <div class="input-container">
      <input type="text" id="user_id" name="user_id" required=""/>
      <label>ID</label>
    </div>
    <button class="btn loginBtn" type="submit" value="Login">Login</button>
  </form>
  <button class="btn regBtn" type="button" value="Register" onclick="location.href='Register.jsp'">Register</button>
</div>
</body>

</html>

<%--<html>--%>
<%--<head>--%>
<%--  <title>Hello, I am a Java web app!</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Select your role</h1>--%>
<%--<button onclick="location.href='LoginServlet'">Guest</button>--%>
<%--<button onclick="location.href='LoginServlet'">Host</button>--%>
<%--<button onclick="location.href='LoginServlet'">Employee</button>--%>
<%--&lt;%&ndash;<p>To invoke the java servlet click <a href="MyServlet">here</a></p>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>