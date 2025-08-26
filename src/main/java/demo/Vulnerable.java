package demo;
import java.sql.*;

public class Vulnerable {
  // Intentionally unsafe: SQL built via string concatenation
  public static void run(String user) throws Exception {
    try (Connection c = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
         Statement s = c.createStatement()) {
      String sql = "SELECT * FROM accounts WHERE user = '" + user + "'";
      s.executeQuery(sql);
    }
  }
}
