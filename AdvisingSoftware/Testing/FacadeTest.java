package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.CourseList;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacadeTest {

  private User user = null;
  private UserList userList = UserList.getInstance();
  private CourseList courseList = CourseList.getInstance();
  private MajorList majorList = MajorList.getInstance();

  /**
   * + login(String email, String password): User
   * + signOut(): void
   * + saveUsers(): void
   * + saveCourses(): void
   * + saveMajorMaps(): void
   * + writeStudentCoursePlanner(CoursePlanner coursePlanner, String name): void
   * + signUpStudent(String firstName, String lastName, String email, String password): void
   * + signUpAdmin(String firstName, String lastName, String email, String password): void
   * + signUpAdvisor(String firstName, String lastName, String email, String password): void
   * + getMajorMap(String string): void
   * + displayAllCourses(ArrayList<Course> courseList): void
   * + showCoursesByCode(String courseCode): void
   * + showAppAreaOptions(): void
   * + setAppArea(String xappArea): void
   * + addNoteToStudentAdvisor(UUID advisorID, UUID studentID, String noteContent): void
   * + addStudentToListOfAdvisees(UUID advisorID, UUID studentID): boolean
   */
  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}
  // Testing login method
  // Testing signOut method
  // Testing saveUsers method
  // Testing saveCourses method
  // Testing saveMajorMaps method
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
