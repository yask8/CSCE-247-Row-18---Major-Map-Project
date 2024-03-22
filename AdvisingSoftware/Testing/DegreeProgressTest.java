package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.CourseList;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.Student;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DegreeProgressTest {

  private Student student;

  /**
   * Methods to Test
   * + displayProgress(MajorMap majorMap, ArrayList<Grades> completedCourses): String
   * + calculateGPA(ArrayList<Course> courseList, ArrayList<Grades> completedCourses): double
   */

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  public void settingUpStudent() {
    User user = UserList
      .getInstance()
      .getUserByLoginInfo("bwest@email.sc.edu", "bwest060903");

    student = UserList.getInstance().getStudentById(user.getID());
  }

  // Testing displayProgress method
  @Test
  public void testDisplayProgressValid() {
    settingUpStudent();
    MajorMap major = MajorList.getInstance().getMajorByName(student.getMajor());
    String progress = student
      .getDegreeProgress()
      .displayProgress(
        major,
        student.getCompletedCourses(),
        CourseList.getInstance().getAllCourses()
      );
    System.out.println(progress);
  }

  @Test
  public void testDisplayProgressNullCompletedCourses() {
    settingUpStudent();
    MajorMap major = MajorList.getInstance().getMajorByName(student.getMajor());
    String progress = student
      .getDegreeProgress()
      .displayProgress(major, null, CourseList.getInstance().getAllCourses());
    System.out.println(progress);
  }

  // Testing calculateGPA method
  @Test
  public void testCalculateGPAValid() {
    settingUpStudent();
    student
      .getDegreeProgress()
      .calculateGPA(
        CourseList.getInstance().getAllCourses(),
        student.getCompletedCourses()
      );
  }

  @Test
  public void testCalculateGPANull() {
    settingUpStudent();
    student.getDegreeProgress().calculateGPA(null, null);
  }
}
