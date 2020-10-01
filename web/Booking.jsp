
<%@ page import="eHotel.entities.Property" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="eHotel.entities.RentalAgreement" %><%--

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
<h2>Your bookings: </h2>
<%--<button value="guest" onclick="location.href='LoginServlet'" ;>Guest</button>--%>
<%--<button value="host" onclick="location.href='LoginServlet'">Host</button>--%>
<%--<button value="employee" onclick="location.href='LoginServlet'">Employee</button>--%>
<%
    Object obj0 = session.getAttribute("AgreementList");
    Object user_id = session.getAttribute("user_id"); %>
<ul>
    <h2>
        Your ID: <%= user_id %>
    </h2>
    <%
        ArrayList<RentalAgreement> AgreementList = null;
        if (obj0 instanceof ArrayList) {
            AgreementList = (ArrayList<RentalAgreement>) obj0;
        }
        System.out.println(AgreementList==null);
        if (AgreementList != null) {
            for (RentalAgreement row : AgreementList) {
                String AgreementInfo = row.toString();
    %>
    <li><%=AgreementInfo%></li>
    <%
            }
        }
    %>
</ul>


<h2>All available properties you can book:</h2>
<%--<button value="guest" onclick="location.href='LoginServlet'" ;>Guest</button>--%>
<%--<button value="host" onclick="location.href='LoginServlet'">Host</button>--%>
<%--<button value="employee" onclick="location.href='LoginServlet'">Employee</button>--%>
<%
    Object obj1 = session.getAttribute("allAvaPropertiesList");
     %>
<ul>
    <%
    ArrayList<Property> propList = null;
    if (obj1 instanceof ArrayList) {
        propList = (ArrayList<Property>) obj1;
    }
    System.out.println(propList==null);
    if (propList != null) {
        for (Property row : propList) {
            String PropInfo = row.toString();

%>
    <li><%=PropInfo%></li>
    <%
            }
        }
    %>

</ul>
<h2>Book a property(if your id is not registered, you can't book): </h2>
<div>
    <form method="post" action="BookingServlet">
        agreement_id:<br><input type="text" id="agreement_id" name="agreement_id"><br><br>
<%--        guest_id:<br><input type="text" id="guest_id" name="guest_id"><br><br>--%>
        property_id:<br><input type="text" id="property_id" name="property_id"><br><br>
        host_id:<br><input type="text" id="host_id" name="host_id"><br><br>
        start_date(YYYY-MM-DD):<br><input type="date" id="start_date" name="start_date"><br><br>
        end_date(YYYY-MM-DD):<br><input type="date" id="end_date" name="end_date"><br><br>
        your user_id: <%=user_id%>
        <input type="hidden" id="user_id" name="user_id" value = <%=user_id%> />

        <button type="Submit" value="newBooking" id="confirm" >Confirm</button><br><br>
        <button type="Reset"  id="reset" >Reset</button><br><br>
    </form>
</div>
</body>
</html>


