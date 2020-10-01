package eHotel.servlet;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Property;
import eHotel.entities.RentalAgreement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    PostgreSqlConn connection = new PostgreSqlConn();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();
//		employee account = new employee();
//        String role = request.getParameter("role");
//        String user_id = request.getParameter("user_id");

//		[0]:name,[1]:pwd

//        ArrayList<Property> allAvaProperties = connection.getAllAvaProperties();
//            //ArrayList<Room> bookedRooms = con.getbookedRooms(userSSN);
//            //ArrayList<Room> allRooms = con.getAllAvailRooms();
//        request.setAttribute("allAvaProperties", allAvaProperties);

        //String guest_id = request.getParameter("user_id");
        HttpSession session = request.getSession();
        String roleType = request.getParameter("roleType");
        String user_id = request.getParameter("user_id");
        if (roleType.equals("guest")){
            ArrayList<RentalAgreement> AgreementList = connection.getAgreementByGuest(user_id);
            ArrayList<Property> allAvaPropertiesList = connection.getAllAvaProperties();
            System.out.println(allAvaPropertiesList);
            session.setAttribute("allAvaPropertiesList", allAvaPropertiesList);
            session.setAttribute("AgreementList", AgreementList);
            session.setAttribute("user_id", user_id);
            // guest can see all available property
            // guest can add a new booking
            response.sendRedirect("Booking.jsp");}
        else if (roleType.equals("host")) {
            ArrayList<Property> propertiesByHost = connection.getPropertyByHost(user_id);
            System.out.println(propertiesByHost);
            session.setAttribute("propertiesByHost", propertiesByHost);
            session.setAttribute("user_id", user_id);
            // host can see their own properties
            // host can add a new property
            response.sendRedirect("PropertyManager.jsp");}
        else{
            session.setAttribute("user_id", user_id);
            //listing all properties has been booked
            ArrayList<Property> allAvaPropertiesList = connection.getAllAvaProperties();
            session.setAttribute("allAvaPropertiesList", allAvaPropertiesList);
            System.out.println(allAvaPropertiesList);
            ArrayList<Property> allUnavaPropertiesList = connection.getAllUnavaProperties();
            session.setAttribute("allUnavaPropertiesList", allUnavaPropertiesList);
            System.out.println(allUnavaPropertiesList);
            response.sendRedirect("PropertyListing.jsp");
            //listing all properties that not booked
            }
    }

}
