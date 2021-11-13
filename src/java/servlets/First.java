package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author abdel
 */
public class First extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("username");
        out.print("Welcome " + n);

        HttpSession session = request.getSession();
        session.setAttribute("uname", n);

        ServletContext ctx = getServletContext();
        int t = (Integer) ctx.getAttribute("totalusers");
        int c = (Integer) ctx.getAttribute("currentusers");
        out.print("<br>total users= " + t);
        out.print("<br>current users= " + c);

        out.print("<br><a href='LogoutServlet'>logout</a>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
