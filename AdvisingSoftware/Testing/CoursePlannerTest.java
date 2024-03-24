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
  private CoursePlanner coursePlanner = new CoursePlanner();
  private Student student;

  /**
   * Methods to Test
   * + removeCourse(int semesterIndex, String courseName): void
   * + addCourse(int semesterIndex, String courseName): void
   * + generateFromMajorMap(MajorMap majorMap): void
   * + searchPlanner(String course): boolean
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

  public void settingUpStudent() {}

  // Testing removeCourse method
  @Test
  public void testRemoveCourseValid() {
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
    int index = 0;
    student.getCoursePlanner().addCourse(index, "CSCE580");
    boolean exists = true;
    try {
      student.getCoursePlanner().getCoursesForSemester(index);
    } catch (Exception e) {
      // TODO: handle exception
      exists = false;
    }
    assertFalse(exists);
  }

  @Test
  public void testAddCourseToSemester9() {
    int index = 9;
    student.getCoursePlanner().addCourse(index, "CSCE580");
    boolean exists = true;
    try {
      student.getCoursePlanner().getCoursesForSemester(index);
    } catch (Exception e) {
      // TODO: handle exception
      exists = false;
    }
    assertFalse(exists);
  }

  // Testing generateFromMajorMap method
  @Test
  public void testGenerateFromMajorMapValidMajor() {
    major = MajorList.getInstance().getMajorByName("Computer Science");
    boolean generated = true;
    try {
      coursePlanner.generateFromMajorMap(major);
    } catch (Exception e) {
      // TODO: handle exception
      generated = false;
    }
    assertTrue(generated);
  }

  @Test
  public void testGenerateFromMajorMapInvalidMajor() {
    major = MajorList.getInstance().getMajorByName("Forensic Science");
    boolean generated = true;
    try {
      coursePlanner.generateFromMajorMap(major);
    } catch (Exception e) {
      // TODO: handle exception
      generated = false;
    }
    assertTrue(generated);
  }

  @Test
  public void testGenerateFromMajorMapNull() {
    major = MajorList.getInstance().getMajorByName(null);
    boolean generated = true;
    try {
      coursePlanner.generateFromMajorMap(major);
    } catch (Exception e) {
      // TODO: handle exception
      generated = false;
    }
    assertTrue(generated);
  }

  // Testing searchPlanner method
  @Test
  public void testSearchPlannerValidCourse() {
    assertTrue(student.getCoursePlanner().searchPlanner("CSCE145"));
  }

  @Test
  public void testSearchPlannerLowerCaseValidCourse() {
    assertTrue(student.getCoursePlanner().searchPlanner("csce145"));
  }

  @Test
  public void testSearchPlannerMixedCaseValidCourse() {
    assertTrue(student.getCoursePlanner().searchPlanner("cScE145"));
  }

  @Test
  public void testSearchPlannerCourseNotExist() {
    assertFalse(student.getCoursePlanner().searchPlanner("CSCE111"));
  }
}
