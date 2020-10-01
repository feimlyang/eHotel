
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

<%--<button value="guest" onclick="location.href='LoginServlet'" ;>Guest</button>--%>
<%--<button value="host" onclick="location.href='LoginServlet'">Host</button>--%>
<%--<button value="employee" onclick="location.href='LoginServlet'">Employee</button>--%>
<%  Object obj0 = session.getAttribute("allAvaPropertiesList");
    Object obj1 = session.getAttribute("allUnavaPropertiesList");
    Object user_id = session.getAttribute("user_id");
    user_id = (String) user_id;
%>
<h4> your ID: <%=user_id%></h4>
<h1>All available properties:</h1>
<ul>
    <%
        ArrayList<Property> avaPropList = null;
        if (obj0 instanceof ArrayList) {
            avaPropList = (ArrayList<Property>) obj0;
            System.out.println("instanceof");
        }
        System.out.println(avaPropList==null);
        if (avaPropList != null) {
            for (Property row : avaPropList) {
                String avaPropInfo = row.toString();
                System.out.println(avaPropInfo);
    %>
    <li><%=avaPropInfo%></li>
    <%
            }
        }
    %>
</ul>

<h1>All unavailable properties:</h1>
<ul>
    <%
        ArrayList<Property> unAvaPropList = null;
        if (obj1 instanceof ArrayList) {
            unAvaPropList = (ArrayList<Property>) obj1;
            System.out.println("instanceof");
        }
        System.out.println(unAvaPropList==null);
        if (unAvaPropList != null) {
            for (Property row : unAvaPropList) {
                String unAvaProp = row.toString();
                System.out.println(unAvaPropList);
    %>
    <li><%=unAvaProp%></li>
    <%
            }
        }
    %>
</ul>
<%--<h2>Add Property</h2>--%>
<%--<div>--%>
<%--    <form method="post" action="AddPropertyServlet">--%>
<%--        property_id:<br><input type="text" id="property_id" name="property_id"><br><br>--%>
<%--        city:<br><input type="text" id="city" name="city"><br><br>--%>
<%--        property_type:<br><input type="text" id="property_type" name="property_type"><br><br>--%>
<%--        available_date(YYYY-MM-DD):<br><input type="date" id="avaliable_date" name="avaliable_date"><br><br>--%>
<%--        price:<br><input type="number" id="price" name="price"><br><br>--%>
<%--        your user_id: <%=user_id%>--%>
<%--        <input type="hidden" id="user_id" name="user_id" value = <%=user_id%> />--%>

<%--        <button type="Submit" value="newProp" id="confirm" >Confirm</button><br><br>--%>
<%--        <button type="Reset"  id="reset" >Reset</button><br><br>--%>
<%--    </form>--%>
<%--</div>--%>
</body>
</html>
