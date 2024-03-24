package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.CourseList;
import AdvisingSoftware.Grades;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.Student;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import java.util.ArrayList;
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
  public void setUp() {
    User user = UserList
      .getInstance()
      .getUserByLoginInfo("bwest@email.sc.edu", "bwest060903");

    student = UserList.getInstance().getStudentById(user.getID());
  }

  @AfterEach
  public void tearDown() {}

  // Testing displayProgress method
  @Test
  public void testDisplayProgressValid() {
    MajorMap major = MajorList.getInstance().getMajorByName(student.getMajor());
    String progress = student
      .getDegreeProgress()
      .displayProgress(
        major,
        student.getCompletedCourses(),
        CourseList.getInstance().getAllCourses()
      );
    assertEquals(
      (
        "-----Degree Progress-----" +
        "\nCurrent Major: " +
        student.getMajor() +
        "\nProgress Made: " +
        student.getDegreeProgress().getProgressPercentage() +
        "%"
      ),
      progress
    );
  }

  @Test
  public void testDisplayProgressNullCompletedCourses() {
    MajorMap major = MajorList.getInstance().getMajorByName(student.getMajor());
    String progress = student
      .getDegreeProgress()
      .displayProgress(major, null, CourseList.getInstance().getAllCourses());
  }

  // Testing calculateGPA method
  @Test
  public void testCalculateGPAValid() {
    double GPA = student
      .getDegreeProgress()
      .calculateGPA(
        CourseList.getInstance().getAllCourses(),
        student.getCompletedCourses()
      );
    assertEquals(3.78, GPA);
  }

  @Test
  public void testCalculateGPANull() {
    double GPA = student
      .getDegreeProgress()
      .calculateGPA(CourseList.getInstance().getAllCourses(), null);
    assertEquals(0, GPA);
  }

  @Test
  public void testCalculateGPANoneComplete() {
    ArrayList<Grades> empty = new ArrayList<Grades>();
    double GPA = student
      .getDegreeProgress()
      .calculateGPA(CourseList.getInstance().getAllCourses(), empty);
    assertEquals(0, GPA);
  }
}
