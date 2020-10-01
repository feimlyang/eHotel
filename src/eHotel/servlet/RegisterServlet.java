
package eHotel.servlet;

        import eHotel.connections.PostgreSqlConn;
        import eHotel.entities.Property;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.util.ArrayList;

public class RegisterServlet extends HttpServlet {
    PostgreSqlConn connection = new PostgreSqlConn();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String guest_id = request.getParameter("user_id");
        HttpSession session = request.getSession();
        String roleType = request.getParameter("roleType");
        String user_id = request.getParameter("user_id");
        String first_name = request.getParameter("first_name");
        System.out.println(roleType);
        System.out.println(user_id);
        System.out.println(first_name);
        connection.Register(roleType, user_id, first_name);
        response.sendRedirect("Register.jsp");

            //listing all properties has been booked
            //listing all properties that not booked}
    }

}
