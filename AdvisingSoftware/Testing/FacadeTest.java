/**
 * @author Lia Zhao
 */
package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.Admin;
import AdvisingSoftware.Course;
import AdvisingSoftware.CourseList;
import AdvisingSoftware.Facade;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.Student;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacadeTest {

  private Facade facade = new Facade();
  private User user = null;
  private UUID uuid = UUID.randomUUID();
  private UserList userList;
  private MajorList majorList;
  private CourseList courseList;

  /**
   * + login(String email, String password): User
   * + writeStudentCoursePlanner(CoursePlanner coursePlanner, String name): void
   * + signUpStudent(String firstName, String lastName, String email, String password): void
   * + signUpAdmin(String firstName, String lastName, String email, String password): void
   * + signUpAdvisor(String firstName, String lastName, String email, String password): void
   * + displayAllCourses(ArrayList<Course> courseList): void
   * + showCoursesByCode(String courseCode): void
   * + showAppAreaOptions(): void
   * + addNoteToStudentAdvisor(UUID advisorID, UUID studentID, String noteContent): void
   * + addStudentToListOfAdvisees(UUID advisorID, UUID studentID): boolean
   */
  @BeforeEach
  public void setUp() {
    userList = userList.getInstance();
    majorList = majorList.getInstance();
    courseList = courseList.getInstance();
  }

  @AfterEach
  public void tearDown() {
    user = null;
    UserList.getInstance().removeUser(uuid);
  }

  // Testing login method
  @Test
  public void testLoginValid() {
    user = facade.login("rio.farrah2004@gmail.com", "Real?dejaneir0");
    boolean logged = false;
    if (user != null) {
      logged = true;
    }
    assertTrue(logged);
    assertEquals("Farrah Rio", user.getFirstName() + " " + user.getLastName());
  }

  @Test
  public void testLoginMixedCaseInvalid() {
    user = facade.login("rio.faRrah2004@gmail.com", "real?dejaNeir0");
    boolean logged = false;
    if (user != null) {
      logged = true;
    }
    assertFalse(logged);
  }

  @Test
  public void testLoginIncorrectPassword() {
    user = facade.login("rio.farrah2004@gmail.com", "real?dejaNeir0");
    boolean logged = false;
    if (user != null) {
      logged = true;
    }
    assertFalse(logged);
  }

  // Testing writeStudentCoursePlanner method
  @Test
  public void testWriteStudentCoursePlannerValid() {
    user = facade.login("rio.farrah2004@gmail.com", "Real?dejaneir0");
    facade.writeStudentCoursePlanner("Farrah Rio");
    File f = new File("StudentCoursePlanners\\Farrah Rio_CoursePlanner.txt");
    boolean exists = f.exists();
    f.delete();
    assertTrue(exists);
  }

  @Test
  public void testWriteStudentCoursePlannerNullStudentName() {
    user = facade.login("rio.farrah2004@gmail.com", "Real?dejaneir0");
    facade.writeStudentCoursePlanner(null);
    File f = new File("StudentCoursePlanners\\null_CoursePlanner.txt");
    boolean exists = f.exists();
    f.delete();
    assertTrue(exists);
  }

  @Test
  public void testWriteStudentCoursePlannerEmptyName() {
    user = facade.login("rio.farrah2004@gmail.com", "Real?dejaneir0");
    facade.writeStudentCoursePlanner("");
    File f = new File("StudentCoursePlanners\\_CoursePlanner.txt");
    boolean exists = f.exists();
    f.delete();
    assertTrue(exists);
  }

  // Testing signUpStudent method
  @Test
  public void testSignUpStudentValid() {
    facade.signUpStudent(
      "Stuart",
      "Neuman",
      "stuartneuman@email.sc.edu",
      "Password123?"
    );
    user =
      userList.getUserByLoginInfo("stuartneuman@email.sc.edu", "Password123?");
    assertTrue(user != null);
    assertTrue(user.getUserType().equalsIgnoreCase("STUDENT"));
    assertTrue(user.getFirstName().equals("Stuart"));
    assertTrue(user.getLastName().equals("Neuman"));
  }

  @Test
  public void testSignUpStudentExistingName() {
    facade.signUpStudent(
      "Farrah",
      "Rio",
      "stuartneuman@email.sc.edu",
      "Password123?"
    );
    user = facade.login("stuartneuman@email.sc.edu", "Password123?");
    assertTrue(user != null);
    assertTrue(user.getUserType().equalsIgnoreCase("STUDENT"));
    assertTrue(user.getFirstName().equals("Farrah"));
    assertTrue(user.getLastName().equals("Rio"));
  }

  @Test
  public void testSignUpStudentExistingEmail() {
    facade.signUpStudent(
      "Farrah",
      "Rio",
      "stuartneuman@email.sc.edu",
      "Password123?"
    );
    User userOg = facade.login("stuartneuman@email.sc.edu", "Password123?");
    facade.signUpStudent(
      "Mary",
      "Lambert",
      "stuartneuman@email.sc.edu",
      "AnotherPassword!"
    );
    try {
      user = facade.login("stuartneuman@email.sc.edu", "AnotherPassword!");
    } catch (Exception e) {
      // TODO: handle exception
      user = null;
    }

    assertTrue(userOg != null);
    assertTrue(user == null);
    assertTrue(userOg.getUserType().equalsIgnoreCase("STUDENT"));
  }

  // Testing signUpAdmin method
  @Test
  public void testSignUpAdminValid() {
    facade.signUpAdmin(
      "Stuart",
      "Neuman",
      "stuartneuman@email.sc.edu",
      "Password123?"
    );
    user =
      userList.getUserByLoginInfo("stuartneuman@email.sc.edu", "Password123?");
    assertTrue(user != null);
    assertTrue(user.getUserType().equalsIgnoreCase("ADMIN"));
  }

  // Testing signUpAdvisor method
  @Test
  public void testSignUpAdvisorValid() {
    facade.signUpAdvisor(
      "Stuart",
      "Neuman",
      "stuartneuman@email.sc.edu",
      "Password123?"
    );
    user =
      userList.getUserByLoginInfo("stuartneuman@email.sc.edu", "Password123?");
    assertTrue(user != null);
    assertTrue(user.getUserType().equalsIgnoreCase("ADVISOR"));
  }

  // Testing displayAllCourses method
  @Test
  public void testDisplayAllCoursesValid() {
    boolean error = false;
    try {
      facade.displayAllCourses(courseList.getAllCourses());
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testDisplayAllCoursesEmpty() {
    ArrayList<Course> empty = new ArrayList<Course>();
    boolean error = false;
    try {
      facade.displayAllCourses(empty);
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testDisplayAllCoursesNull() {
    boolean error = false;
    try {
      facade.displayAllCourses(null);
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  // Testing showCoursesByCode method
  @Test
  public void testShowCoursesByCodeValid() {
    boolean error = false;
    try {
      facade.showCoursesByCode("GFL");
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testShowCoursesByCodeInvalid() {
    boolean error = false;
    try {
      facade.showCoursesByCode("APPLE");
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testShowCoursesByCodeEmpty() {
    boolean error = false;
    try {
      facade.showCoursesByCode("");
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  // Testing showAppAreaOptions method
  @Test
  public void testShowAppAreaOptionsValid() {
    user = facade.login("rio.farrah2004@gmail.com", "Real?dejaneir0");
    boolean printed = true;
    try {
      facade.showAppAreaOptions();
    } catch (Exception e) {
      // TODO: handle exception
      printed = false;
    }
    assertTrue(user.getUserType().equalsIgnoreCase("STUDENT"));
    assertTrue(printed);
  }

  @Test
  public void testShowAppAreaOptionsAdmin() {
    user = facade.login("thebillybob@gmail.com", "Guiy#ghawe");
    boolean printed = true;
    try {
      facade.showAppAreaOptions();
    } catch (Exception e) {
      // TODO: handle exception
      printed = false;
    }
    assertTrue(user.getUserType().equalsIgnoreCase("ADMIN"));
    assertTrue(printed);
  }

  @Test
  public void testShowAppAreaOptionsAdvisor() {
    user = facade.login("FlanaganMichael@gmail.com", "philly$Gr33n");
    boolean printed = true;
    try {
      facade.showAppAreaOptions();
    } catch (Exception e) {
      // TODO: handle exception
      printed = false;
    }
    assertTrue(user.getUserType().equalsIgnoreCase("ADVISOR"));
    assertTrue(printed);
  }

  // Testing addNoteToStudentAdvisor method
  @Test
  public void testAddNoteToStudentAdvisorValid() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    try {
      facade.addNoteToStudentAdvisor(
        user.getID(),
        userList.getAdvisorById(user.getID()).getListOfAdvisees().get(0),
        "Note: on track"
      );
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testAddNoteToStudentAdvisorEmptyNote() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    try {
      facade.addNoteToStudentAdvisor(
        user.getID(),
        userList.getAdvisorById(user.getID()).getListOfAdvisees().get(0),
        ""
      );
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testAddNoteToStudentAdvisorNull() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    try {
      facade.addNoteToStudentAdvisor(null, null, null);
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  @Test
  public void testAddNoteToStudentAdvisorNullStudent() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    try {
      facade.addNoteToStudentAdvisor(user.getID(), null, null);
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(error);
  }

  // Testing addStudentToListOfAdvisees method
  @Test
  public void testAddStudentToListOfAdviseesValidStudent() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    //User user1 = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    boolean achieved = false;
    try {
      facade.signUpStudent(
        "Olivia",
        "Olivia",
        "doubleOlivia@gmail.com",
        "OOlliivviiaa!"
      );
      User temp = facade.login("doubleOlivia@gmail.com", "OOlliivviiaa!");
      facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
      achieved = facade.addStudentToListOfAdvisees(user.getID(), temp.getID());
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertTrue(achieved);
    assertTrue(facade.getListOfAdvisees().size() > 1);
    assertFalse(error);
  }

  @Test
  public void testAddStudentToListOfAdviseesAddAdmin() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    boolean achieved = true;
    try {
      facade.signUpAdmin(
        "Olivia",
        "Olivia",
        "doubleOlivia@gmail.com",
        "OOlliivviiaa!"
      );
      User temp = facade.login("doubleOlivia@gmail.com", "OOlliivviiaa!");
      facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
      achieved = facade.addStudentToListOfAdvisees(user.getID(), temp.getID());
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(achieved);
    assertFalse(facade.getListOfAdvisees().size() > 1);
    assertFalse(facade.getListOfAdvisees().get(1) != null);
    assertFalse(error);
  }

  @Test
  public void testAddStudentToListOfAdviseesAddAdvisor() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    boolean achieved = true;
    try {
      facade.signUpAdvisor(
        "Olivia",
        "Olivia",
        "doubleOlivia@gmail.com",
        "OOlliivviiaa!"
      );
      User temp = facade.login("doubleOlivia@gmail.com", "OOlliivviiaa!");
      facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
      achieved = facade.addStudentToListOfAdvisees(user.getID(), temp.getID());
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(achieved);
    assertFalse(facade.getListOfAdvisees().size() > 1);
    assertFalse(facade.getListOfAdvisees().get(1) != null);
    assertFalse(error);
  }

  @Test
  public void testAddStudentToListOfAdviseesExistingStudent() {
    user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    boolean achieved = true;
    try {
      achieved =
        facade.addStudentToListOfAdvisees(
          user.getID(),
          userList.getAdvisorById(user.getID()).getListOfAdvisees().get(0)
        );
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(achieved);
    assertFalse(facade.getListOfAdvisees().size() > 1);
    assertFalse(error);
  }

  @Test
  public void testAddStudentToListOfAdviseesNull() {
    User user = facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    boolean error = false;
    boolean achieved = true;
    try {
      achieved = facade.addStudentToListOfAdvisees(null, null);
    } catch (Exception e) {
      // TODO: handle exception
      error = true;
    }
    assertFalse(achieved);
    assertFalse(facade.getListOfAdvisees().size() > 1);
    assertFalse(error);
  }
}
