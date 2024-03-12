package AdvisingSoftware;

import java.util.UUID;
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
    // scenario1();
    // scenario2();
    // scenario3();
    // scenario4();
    // scenario5(); idk its still not printing the major map
    scenario7();
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

    System.out.println("\nStudent adds BIOL101 into the course planner for semester 2\n");
    facade.getStudentCoursePlanner().addCourse(2, facade.getCourseById("BIOL101"));
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println(
        "\nStudent wants to switch from BIOL101 and trys to remove it from semester 2 but makes a typo and inputs the wrong semester\n");
    facade.getStudentCoursePlanner().removeCourse(1, "BIOL101");

    System.out.println("\nStudent wants to switch from BIOL101 and removes it from the course planner semester 2\n");
    facade.getStudentCoursePlanner().removeCourse(2, "BIOL101");
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
              ". Incorrect email or password.");
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
              ". Incorrect email or password.");
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
        signupPassword);

    facade.signOut();
  }

  public void scenario4() {
    System.out.println(
        "\nScenario 4: Loading Courses and Printing Respective Course Details");
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
    System.out.println("Printing Major Map");
    facade.getMajorMap(facade.getStudentMajor().toString());
  }

  public void scenario6() {
  }

  /**
   * Listed as Scenario 2 on sheet
   * 
   * @author Yasmine Kennedy (yask8)
   */
  public void scenario7() {
    // Signing up Tawnie
    facade.signUpStudent("Tawnie", "Hill", "thill@email.sc.edu", "bi117");
    facade.signOut();

    // Logging in Osbert
    facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    if (facade.getUser() != null) {
      System.out.println("Login Successful. \nCurrent User: ");
      System.out.println(facade.getUser());
    } else {
      System.out.println("Login Failed.");
    }

    // Searching for student
    if (facade.getUserList().getIDByName("Tawnie", "Hill") != null) {
      System.out.println("...Searching Student...");
      System.out.println("Student Found. \nStudent: ");
      // Temporary spot to make code look simplistic
      UUID studentUSCID = facade.getUserList().getIDByName("Tawnie", "Hill");
      System.out.println(studentUSCID);
      System.out.println(facade.getUserList().getUserbyUSCID(studentUSCID));
      facade.getListOfAdvisees().add(studentUSCID);
      System.out.println(facade.getListOfAdvisees().toString());
    } else {
      System.out.println("Student not found");
    }
    facade.signOut();

    // TODO: add Twanie to advisor list and create the advisor notes

    // System.out.println("Scenario 7: Advisor Osbert Odden");
    // System.out.println("---------------------");
    // System.out.println(".....Signing up Osbert Odden.....");
    // facade.signUpAdvisor("Osbert", "Odden", "osberto@mailbox.sc.edu",
    // "h3110m0m!2");

    // System.out.println("...Osbert searches for student by their ID...");
    // facade.getUserList().getUserbyUSCID(uscID);
    // User twanie = facade.getUserList().getUserbyUSCID(uscID);

    // System.out.println("...Osbert adds student to list of advisees...");
    // if(facade.getListOfAdvisees() != null){
    // facade.getListOfAdvisees().add(twanie);
    // } else {
    // System.out.println("Error: Trouble with adding user.");
    // }

    // System.out.println("...Obsert looks through student degree progress...");
    // facade.getStudentDegreeProgress();

    // System.out.println("Osbert adds a note to Twanie's profile");
    // String suggestion = "I suggest declaring STATS as an application area, you
    // have taken 2 elective classes, adding another will statisfy your application
    // area";
    // Note note = new Note(suggestion, null);
    // facade.getStudentAdvisorNotes().add(note);
    // facade.signOut();

    // facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    // if (facade.getUser() != null) {
    // System.out.println("Login successful!");
    // System.out.println("Current user:");
    // System.out.println(facade.getUser());
    // } else {
    // System.out.println("Login failed. Incorrect email or password.");
    // }
  }
  public void scenario8(){
    String name = "MATH 141 Calculus 1";
    String code = "CC-ARP";
    String description = "Functions, limits, derivatives, introduction to integrals, and the Fundamental Theorem of Calculus";
    int creditHours = 4;
    String subject = "MATH";
    char passGrade = 'C';
    boolean elective = false;
    boolean carolinaCore = false;
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 112";
    String pre2 = "MATH 115";
    String pre3 = "MATH 116";
    preReqs.add(pre1);
    preReqs.add(pre2);
    preReqs.add(pre3);
    String year = "2024 - 2025" ;
    String semester = "Fall and Spring";

    Course t = new Course(name, code, description, creditHours, subject, passGrade, elective, carolinaCore,preReqs, year, semester);
    facade.getCourses().add(t);
    facade.signOut();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}