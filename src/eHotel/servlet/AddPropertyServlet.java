package eHotel.servlet;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Property;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class AddPropertyServlet extends HttpServlet {
    PostgreSqlConn connection = new PostgreSqlConn();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roleType = request.getParameter("roleType");
        String user_id = request.getParameter("user_id");
        System.out.println("host id:  " + user_id);
        Property newProperty = new Property(
                (String) request.getParameter("property_id"),
                user_id,
                (String) request.getParameter("city"),
                (String) request.getParameter("property_type"),
                (String) request.getParameter("avaliable_date"),
                (Float) Float.valueOf(request.getParameter("price")),
                true
        );
        connection.addNewProperty(newProperty);

        ArrayList<Property> propertiesByHost = connection.getPropertyByHost(user_id);
        System.out.println(propertiesByHost);
        session.setAttribute("propertiesByHost", propertiesByHost);
        response.sendRedirect("PropertyManager.jsp");
    }

}
