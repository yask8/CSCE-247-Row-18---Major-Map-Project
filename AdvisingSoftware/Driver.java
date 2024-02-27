package AdvisingSoftware;

import java.util.ArrayList;

/**
 * @author Lia Zhao (zhaolia9)
 *         - facade: Facade
 *         + run(): void
 *         - displayMainMenu(): void
 */
public class Driver {

  private Facade facade;

  Driver() {
    facade = new Facade();
  }

  public void run() {
    scenario1();
    scenario2();
    scenario3();
    scenario4();
    scenario5();
  }

  /*
   * @author @Spillmag
   * Tests login method
   */
  public void scenario1() {
    System.out.println("\nScenario 1: Login and Signout");

    // Hardcoded email and password
    String email = "rio.farrah2004@gmail.com";
    String password = "Real?dejaneir0";

    User loggedInStudent = facade.login(email, password);

    if (loggedInStudent != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(loggedInStudent.toString());
    } else {
      System.out.println("Login failed. Incorrect email or password.");
    }
    System.out.println("\nStudent will be signed out now\n");
    facade.signOut();

    // Hardcoded email and password
    String email2 = "thebillybob@gmail.com";
    String password2 = "Guiy#ghawe";

    User loggedInAdmin = facade.login(email2, password2);

    if (loggedInAdmin != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(loggedInAdmin.toString());
    } else {
      System.out.println("Login failed. Incorrect email or password.");
    }
    System.out.println("\nAdmin will be signed out now\n");
    facade.signOut();
  }

  public void scenario2() {
    System.out.println("\nScenario 2: Login Fail");

    // Hardcoded email and password (has a typo)
    String email = "rio.farrah204@gmail.com";
    String password = "Real?dejaneir0";

    User loggedInStudent = facade.login(email, password);

    if (loggedInStudent != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(loggedInStudent.toString());
    } else {
      System.out.println(
        "Login failed for email " +
        email +
        " and/or " +
        password +
        ". Incorrect email or password."
      );
    }
    facade.signOut();

    // Hardcoded email and password (has a typo)
    String email2 = "thebillybob@gmail.com";
    String password2 = "guiy#ghawe";

    User LoggedInAdmin = facade.login(email2, password2);

    if (loggedInStudent != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(LoggedInAdmin.toString());
    } else {
      System.out.println(
        "Login failed for email " +
        email2 +
        " and/or " +
        password2 +
        ". Incorrect email or password."
      );
    }
    facade.signOut();
  }

  public void scenario3() {
    System.out.println("\n Scenario 3: Sign Up");
    // Hardcoded email and password for signup
    String signupEmail = "newstudent@example.com";
    String signupPassword = "newPassword";
    String signupFirstName = "John";
    String signupLastName = "Doe";
    String signupUserType = "STUDENT";

    System.out.println("\nSigning up a new student\n");
    facade.signUp(
      signupFirstName,
      signupLastName,
      signupEmail,
      signupPassword,
      signupUserType
    );
    facade.signOut();
  }

  public void scenario4() {
    System.out.println();
  }

  public void scenario5() {
    System.out.println();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
