package demo;
import java.io.IOException;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello, CodeQL!");
    String cmd = args.length > 0 ? args[0] : "echo safe";
    try {
      // intentionally vulnerable: user-controlled command
      Runtime.getRuntime().exec(cmd);
    } catch (IOException e) {
      // log or rethrow as unchecked if you prefer
      throw new RuntimeException("exec failed", e);
    }
  }
}
