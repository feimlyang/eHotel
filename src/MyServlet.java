import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Property;
import org.postgresql.Driver;

public class MyServlet extends javax.servlet.http.HttpServlet {
    PostgreSqlConn connection = new PostgreSqlConn();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>MyServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");
            //Class.forName("org.postgresql.Driver");
            //db = DriverManager.getConnection("jdbc:postgresql://yourdb", "youruser", "yourpassword");
            //writer.println(db.getCatalog());



            ArrayList<Property> testData = connection.getAllAvaProperties();
            for (Property line : testData){
                writer.println(line.toString());
                writer.println("\n\n");
            }

            writer.println("<h1>This is a simple java servlet.</h1>");

            writer.println("</body>");
            writer.println("</html>");


        }catch (Exception e)
        {
            System.out.println("failed to connect");
            System.out.println(e.getMessage());
        }
    }
}
