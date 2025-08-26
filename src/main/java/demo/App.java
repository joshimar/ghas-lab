package demo;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello, CodeQL!");
    String cmd = args.length > 0 ? args[0] : "echo safe";
    // user-controlled command → Command Injection
    Runtime.getRuntime().exec(cmd);
  }
}