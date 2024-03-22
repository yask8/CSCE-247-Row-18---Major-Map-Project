package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.CoursePlanner;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.Student;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoursePlannerTest {

  private MajorMap major;
  private CoursePlanner coursePlanner;
  private Student student;

  /**
   * Methods to Test
   * + removeCourse(int semesterIndex, String courseName): void
   * + addCourse(int semesterIndex, String courseName): void
   * + generateFromMajorMap(MajorMap majorMap): void
   * + searchPlanner(String course): boolean
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

  // Testing removeCourse method
  @Test
  public void testRemoveCourseValid() {
    settingUpStudent();
    int index = 7;
    student.getCoursePlanner().addCourse(index, "CSCE580");
    student.getCoursePlanner().addCourse(index, "CSCE355");
    student.getCoursePlanner().removeCourse(index, "CSCE580");
    String[] courses = student.getCoursePlanner().getCoursesForSemester(index);
    boolean exists = false;
    if (courses != null) {
      for (String course : courses) {
        if (course.equalsIgnoreCase("CSCE580")) {
          exists = true;
          break;
        }
      }
    }

    assertEquals(false, exists);
  }

  @Test
  public void testAddCourseToSemester0() {
    settingUpStudent();
    int index = 0;
    student.getCoursePlanner().addCourse(index, "CSCE580");
    boolean exists = true;
    try {
      student.getCoursePlanner().getCoursesForSemester(index);
    } catch (Exception e) {
      // TODO: handle exception
      exists = false;
    }
    assertEquals(false, exists);
  }

  @Test
  public void testAddCourseToSemester9() {
    settingUpStudent();
    int index = 9;
    student.getCoursePlanner().addCourse(index, "CSCE580");
    boolean exists = true;
    try {
      student.getCoursePlanner().getCoursesForSemester(index);
    } catch (Exception e) {
      // TODO: handle exception
      exists = false;
    }
    assertEquals(false, exists);
  }

  // Testing generateFromMajorMap method
  @Test
  public void testGenerateFromMajorMapValidMajor() {
    major = MajorList.getInstance().getMajorByName("Computer Science");
    coursePlanner.generateFromMajorMap(major);
  }

  @Test
  public void testGenerateFromMajorMapInvalidMajor() {
    major = MajorList.getInstance().getMajorByName("Forensic Science");
    coursePlanner.generateFromMajorMap(major);
  }

  @Test
  public void testGenerateFromMajorMapNull() {
    major = MajorList.getInstance().getMajorByName(null);
    coursePlanner.generateFromMajorMap(major);
  }

  // Testing searchPlanner method
  @Test
  public void testSearchPlannerValidCourse() {
    settingUpStudent();
    assertEquals(true, student.getCoursePlanner().searchPlanner("CSCE145"));
  }

  @Test
  public void testSearchPlannerLowerCaseValidCourse() {
    settingUpStudent();
    assertEquals(true, student.getCoursePlanner().searchPlanner("csce145"));
  }

  @Test
  public void testSearchPlannerMixedCaseValidCourse() {
    settingUpStudent();
    assertEquals(true, student.getCoursePlanner().searchPlanner("cScE145"));
  }

  @Test
  public void testSearchPlannerCourseNotExist() {
    settingUpStudent();
    assertEquals(false, student.getCoursePlanner().searchPlanner("CSCE111"));
  }
}
