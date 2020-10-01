
<%@ page import="eHotel.entities.Property" %>
<%@ page import="java.util.ArrayList" %><%--

  Created by IntelliJ IDEA.
  User: manlin
  Date: 2020-04-04
  Time: 10:10 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

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
<h1>Your properties:</h1>
<%--<button value="guest" onclick="location.href='LoginServlet'" ;>Guest</button>--%>
<%--<button value="host" onclick="location.href='LoginServlet'">Host</button>--%>
<%--<button value="employee" onclick="location.href='LoginServlet'">Employee</button>--%>
<% Object obj1 = session.getAttribute("propertiesByHost");
    Object user_id = session.getAttribute("user_id");
    user_id = (String) user_id;
%>

<ul>
    <h4><%=user_id%></h4>
    <%
    ArrayList<Property> propList = null;
    if (obj1 instanceof ArrayList) {
        propList = (ArrayList<Property>) obj1;
        System.out.println("instanceof");
    }
    System.out.println(propList==null);
    if (propList != null) {
        for (Property row : propList) {
            String PropInfo = row.toString();
            System.out.println(PropInfo);
%>
    <li><%=PropInfo%></li>
    <%
            }
        }
    %>

</ul>
<h2>Add Property (if your id is not registered, you can't add) :</h2>
<div>
    <form method="post" action="AddPropertyServlet">
        property_id:<br><input type="text" id="property_id" name="property_id"><br><br>
        city:<br><input type="text" id="city" name="city"><br><br>
        property_type:<br><input type="text" id="property_type" name="property_type"><br><br>
        available_date(YYYY-MM-DD):<br><input type="date" id="avaliable_date" name="avaliable_date"><br><br>
        price:<br><input type="number" id="price" name="price"><br><br>
        your user_id: <%=user_id%>
        <input type="hidden" id="user_id" name="user_id" value = <%=user_id%> />

        <button type="Submit" value="newProp" id="confirm" >Confirm</button><br><br>
        <button type="Reset"  id="reset" >Reset</button><br><br>
    </form>
</div>
</body>
</html>
