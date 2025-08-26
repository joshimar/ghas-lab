package demo;
import java.sql.*;
import javax.servlet.http.*;
public class Vulnerable extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) {
    String user = req.getParameter("user");
    try (Connection c = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
         Statement s = c.createStatement()) {
      // SQL injection sink (CodeQL should flag use of concatenated SQL):
      s.executeQuery("SELECT * FROM accounts WHERE user = '" + user + "'");
    } catch (Exception e) { /* ignore */ }
  }
}
