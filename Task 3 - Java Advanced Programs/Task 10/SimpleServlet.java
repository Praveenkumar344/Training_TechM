import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Simple Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome to Java Servlets!</h1>");
        out.println("<p>This content is served via a servlet.</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
