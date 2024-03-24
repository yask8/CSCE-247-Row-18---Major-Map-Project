package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.CourseList;
import AdvisingSoftware.Facade;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacadeTest {

  private Facade facade = new Facade();
  private User user = null;
  private UserList userList = UserList.getInstance();
  private CourseList courseList = CourseList.getInstance();
  private MajorList majorList = MajorList.getInstance();

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
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

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
  /* 2. **Test `login` method with valid credentials:**
   - Create a user with valid credentials in the user list.
   - Call the `login` method with the valid email and password.
   - Verify that the method returns the logged-in user.

3. **Test `login` method with invalid credentials:**
   - Create a user with invalid credentials in the user list.
   - Call the `login` method with invalid email and password.
   - Verify that the method returns null. */

  // Testing writeStudentCoursePlanner method
  // Testing signUpStudent method
  // Testing signUpAdmin method
  // Testing getMajorMap method
  // Testing displayAllCourses method
  // Testing showCoursesByCode method
  // Testing showAppAreaOptions method
  // Testing addNoteToStudentAdvisor method
  // Testing addStudentToListOfAdvisees method

}
