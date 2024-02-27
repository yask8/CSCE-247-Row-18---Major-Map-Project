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
    System.out.println("Scenario 1: Login and Signout");

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
    System.out.println("Scenario 2: Login Fail");

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
    System.out.println("Scenario 3: Sign Up");
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

    System.out.println("\nNew student will be signed out now\n");
    facade.signOut();
  }

  public void scenario4() {
    System.out.println();
  }

  /**
   * Scenario to test the MajorList
   * @author yask8(Yasmine Kennedy)
   */
  public void scenario5() {
    System.out.println("Scenario 5: Loading Majors and Printing Respective Major Map");
    System.out.println("--------------------------------------------");
    // Hardcoding the email and password
    String email = "";
    String password = "";
    // Creating a user object that operates the facade login method
    User loggingIn = facade.login(email, password);
    // Checking if the user is logged in
    if(loggingIn != null){
      System.out.println("Hello " + loggingIn.getFirstName() + "!");
    } else {
      System.out.println("Incorrect email or password. Please try again.");
    }
    // Displays the User Info
    System.out.println(loggingIn.getFirstName() + " Current Info:");
    System.out.println(loggingIn.toString());
    // User Loads Majors
    if(loggingIn.getUserType().equals("STUDENT")){
        ArrayList<MajorMap> major =  DataLoader.loadMajors();
        if(MajorList.getInstance().isLoaded()){
          
        }
    }
    // User Prints Respective Major Map
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
