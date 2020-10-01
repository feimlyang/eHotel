package eHotel.servlet;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Property;
import eHotel.entities.RentalAgreement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
        import java.util.ArrayList;

public class BookingServlet extends javax.servlet.http.HttpServlet {
    PostgreSqlConn connection = new PostgreSqlConn();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roleType = request.getParameter("roleType");
        String user_id = request.getParameter("user_id");
        System.out.println("bookingservlet userid" + user_id);
        //String agreement_id, String start_date, String end_date, String guest_id, String host_id, String property_id
        RentalAgreement newAgreement = new RentalAgreement(
                (String) request.getParameter("agreement_id"),
                (String) request.getParameter("start_date"),
                (String) request.getParameter("end_date"),
                user_id,
                (String) request.getParameter("host_id"),
                (String) request.getParameter("property_id")
        );
        connection.addNewAgreement(newAgreement);

        ArrayList<RentalAgreement> AgreementList = connection.getAgreementByGuest(user_id);
        ArrayList<Property> allAvaPropertiesList = connection.getAllAvaProperties();
        System.out.println(allAvaPropertiesList);
        session.setAttribute("allAvaPropertiesList", allAvaPropertiesList);
        session.setAttribute("AgreementList", AgreementList);
        session.setAttribute("user_id", user_id);
        // guest can see all available property
        // guest can add a new booking
        response.sendRedirect("Booking.jsp");
    }
}
