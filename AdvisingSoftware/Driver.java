package AdvisingSoftware;

/**
 * @author Lia Zhao (zhaolia9)

 */
public class Driver {

  private Facade facade;

  Driver() {
    facade = new Facade();
  }

  public void run() {
    //Testing Scenarios
    //scenarioTesting();
    // Portias Scenarios
    scenario1();
    //scenario2();
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

    System.out.println(
      "\nStudent adds BIOL101 into the course planner for semester 2\n"
    );
    facade.getStudentCoursePlanner().addCourse(2, "BIOL101");
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println(
      "\nStudent wants to switch from BIOL101 and trys to remove it from semester 2 but makes a typo and inputs the wrong semester\n"
    );
    facade.getStudentCoursePlanner().removeCourse(1, "BIOL101");

    System.out.println(
      "\nStudent wants to switch from BIOL101 and removes it from the course planner semester 2\n"
    );
    facade.getStudentCoursePlanner().removeCourse(2, "BIOL101");
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println(
      "\nStudent Signs out and changes are saved during sign out\n"
    );
    facade.signOut();
  }

  /**
   *
   * @author Yasmine Kennedy (yask8) and Garrett Spillman (Spillmag)
   */
  public void scenario2() {
    facade.signUpAdvisor("Osbert","Odden","osberto@mailbox.sc.edu", "h3110m0m!2");
    System.out.println(
      "Sign Up Successful. \nCurrent User: " + facade.getUser().toString()
    );

    System.out.println("\nSearching for Student and adding to list");
    facade.addStudentToListOfAdvisees(
      facade.getCurrentUserId(),
      facade.getUserIdByName("Tawnie", "Hill")
    );

    System.out.println("\nStudent found and added to list");
    System.out.println(facade.getListOfAdvisees().toString());
    System.out.println(
      "\nOsbert looks at Tawnie's current degree progress and sees two stat classes"
    );
    System.out.println(
      facade
        .getStudentByAdvisor(facade.getUser().getID(),facade.getUserIdByName("Tawnie", "Hill"))
        .getDegreeProgress()
        .toString()
    );

    System.out.println(
      "\nObsert goes to add the note to her profile\nList of notes before not added\n"
    );
    System.out.println(
      facade
        .getStudentByAdvisor(facade.getUser().getID(),facade.getUserIdByName("Tawnie", "Hill"))
        .getAdvisorNotes()
    );
    System.out.println("\nNote added");
    facade.addNoteToStudentAdvisor(facade.getUser().getID(),
      (facade.getUserIdByName("Tawnie", "Hill")),
      "Make Stats Your Application Area"
    );
    System.out.println("\nList of notes after note is made\n");
    System.out.println(
      facade
        .getStudentByAdvisor(facade.getUser().getID(),facade.getUserIdByName("Tawnie", "Hill"))
        .getAdvisorNotes() +
      "\n"
    );

    facade.signOut();
  }

  public void scenario1() {
    // Student: Brax West
    // Junior Computer Science major

    facade.login("bwest@email.sc.edu", "bwest060903");
    System.out.println(
      "Login Successful. \nCurrent User: " + facade.getUser().toString()
    );
    // Choosing the Application Area
    System.out.println(
      "\nBrax West looks at the following application areas.\n"
    );
    facade.showAppAreaOptions();
    System.out.println(
      "Brax decides to choose Digital Design as his application area.\n"
    );
    facade.setAppArea("Digital Design");

    // Choosing a GFL class to take
    System.out.println("\nBrax searches for his Major Map by name.");
    System.out.println(facade.getMajorMap("Computer Science"));
    System.out.println("\nBrax notices he did not take a GFL elective yet.");
    System.out.println(
      "\nBrax searches for the elective courses by their code."
    );
    facade.showCoursesByCode("GFL");
    System.out.println("Brax decides to pick SPAN 109 as his GFL elective.");
   
    facade.getStudentCoursePlanner().addCourse(6,"SPAN109");
    facade.signOut();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
