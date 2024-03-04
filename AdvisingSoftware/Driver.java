package AdvisingSoftware;

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
    //scenario1(); 
    //scenario2();
    //scenario3();
    //scenario4();
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

    facade.login(email, password);

    if (facade.getUser() != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(facade.getUser());
    } else {
      System.out.println("Login failed. Incorrect email or password.");
    }
     System.out.println("Student checks degree progress\n");
     System.out.println(facade.getStudentDegreeProgress());

     System.out.println("Student look at all courses in data base\n");
     System.out.println(facade.getCourseList());

     System.out.println("\nStudent did not see BIOL101 and looks it up\n");
     System.out.println(facade.getCourseById("BIOL101"));
     System.out.println("\nStudent did not see HIST101 and looks it up\n");
     System.out.println(facade.getCourseById("HIST101"));

     System.out.println("\nStudent adds BIOL101 into the course planner\n");
     facade.getStudentCoursePlanner().addCourse(2,facade.getCourseById("BIOL101"));
     System.out.println(facade.getStudentCoursePlanner().toString());

     System.out.println("\nStudent Signs out and changes are saved during sign out\n");
     facade.signOut();
  }

  public void scenario2() {
    System.out.println("\nScenario 2: Login Fail");

    // Hardcoded email and password (has a typo)
    String email = "rio.farrah204@gmail.com";
    String password = "Real?dejaneir0";

    facade.login(email, password);

    if (facade.getUser() != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(facade.getUser().toString());
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

    facade.login(email2, password2);

    if (facade.getUser() != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(facade.getUser().toString());
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
    System.out.println("\nScenario 3: Sign Up");
    // Hardcoded email and password for signup
    String signupEmail = "newstudent@example.com";
    String signupPassword = "newPassword";
    String signupFirstName = "John";
    String signupLastName = "Doe";

    System.out.println("\nSigning up a new student\n");
    facade.signUpStudent(
      signupFirstName,
      signupLastName,
      signupEmail,
      signupPassword
    );

    facade.signOut();
  }

  public void scenario4() {
    System.out.println(
      "\nScenario 4: Loading Courses and Printing Respective Course Details"
    );
    System.out.println("--------------------------------------------");

    // Hardcoding the email and password
    String email = "rio.farrah2004@gmail.com";
    String password = "Real?dejaneir0";

    facade.login(email, password);

    // Checking if the user is logged in
    if (facade.getUser() != null) {
      System.out.println("Hello " + facade.getUser().getFirstName() + "!");
      System.out.println(facade.getUser().getFirstName() + " Current Info:");
      System.out.println(facade.getUser().toString());
      facade.displayAllCourses(facade.getCourseList().getCourses());

      // Show course details by code
      String courseCodeToSearch = "PR"; // Example course code to search
      System.out.println("\nTrying to find course with code: " + courseCodeToSearch);
      facade.showCourseByCode(courseCodeToSearch);
  } else {
      System.out.println("Incorrect email or password. Please try again.");
    }
  }

  /**
   * Scenario to test the MajorList
   *
   * @author yask8(Yasmine Kennedy)
   */
   public void scenario5() {
    System.out.println("Scenario 5: Loading Majors and Printing Respective Major Map");
     System.out.println("--------------------------------------------");

     // Hardcoding the email and password
     String email = "rio.farrah2004@gmail.com";
     String password = "Real?dejaneir0";

     // Creating a user object that operates the facade login method
     facade.login(email, password);

     // Checking if the user is logged in
     if (facade.getUser() != null) {
       System.out.println("Hello " + facade.getUser().getFirstName() + "!");

       // Displays the User Info
       System.out.println(facade.getUser().getFirstName() + " Current Info:");
       System.out.println(facade.getUser().toString());

     

    
     } else {
       System.out.println("Incorrect email or password. Please try again.");
     }
     System.out.println(facade.getStudentMajor());
     System.out.println("\nPrinting Major Map");
     facade.getMajorMap(facade.getStudentMajor().toString());
   }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
