package demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Vulnerable extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    String user = req.getParameter("user"); // user-controlled source
    try (Connection c = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
         Statement s = c.createStatement()) {
      s.executeQuery("SELECT * FROM accounts WHERE user = '" + user + "'"); // SQLi sink
    } catch (Exception ignored) {}
  }
}
