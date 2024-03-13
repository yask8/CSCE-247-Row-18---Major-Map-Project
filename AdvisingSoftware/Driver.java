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
    //Testing Scenarios
    //scenarioTesting();
    //scenarioAddingCourses();

    // Portias Scenarios
    // scenario1():
    // scenario2();

    System.err.println(facade.getMajors());
  }

  /*
   * @author @Spillmag
   * Tests login method
   */
  public void scenarioTesting() {
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
    facade.getStudentCoursePlanner().addCourse(2, "BIOL101");
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

  /**
   * 
   * @author Yasmine Kennedy (yask8)
   */
  public void scenario2() {
    // Logging in Osbert
    facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    System.out.println("Login Successful. \nCurrent User: " + facade.getUser().toString());

    System.out.println("...Searching for Student and adding to list");
    facade.getListOfAdvisees().add(facade.getUserList().getIDByName("Tawnie", "Hill"));

    System.out.println("...Student found and added to list...");
    System.out.println(facade.getListOfAdvisees().toString());
    System.out.println(facade.getUser().toString());
    facade.signOut();

    // TODO: create the advisor notes
  }

  public void scenarioAddingCourses() {
    String name = "MATH 141 Calculus 1";
    String code = "CC-ARP";
    String description = "Functions, limits, derivatives, introduction to integrals, and the Fundamental Theorem of Calculus";
    int creditHours = 4;
    String subject = "MATH";
    char passGrade = 'C';
    boolean elective = false;
    boolean carolinaCore = true;
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 112";
    String pre2 = "MATH 115";
    String pre3 = "MATH 116";
    preReqs.add(pre1);
    preReqs.add(pre2);
    preReqs.add(pre3);
    String year = "1";
    String semester = "1";

    facade.getCourseList().addCourse(name, code, description, creditHours, subject, passGrade, elective, carolinaCore,
        preReqs, year, semester);
    facade.saveCourses();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}