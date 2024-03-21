package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.Course;
import AdvisingSoftware.CourseList;
import AdvisingSoftware.CoursePlanner;
import AdvisingSoftware.Grades;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.Student;
import AdvisingSoftware.UserList;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoursePlannerTest {

  private MajorList majorList;
  private MajorMap major;
  private CourseList courseList;
  private CoursePlanner coursePlanner;
  private Course course;
  private Grades grades;

  /**
   * Methods to Test
   * + removeCourse(int semesterIndex, String courseName): void
   * + addCourse(int semesterIndex, String courseName): void
   * + generateFromMajorMap(MajorMap majorMap): void
   * + searchPlanner(String course): boolean
   */

  @BeforeEach
  public void setUp() {
    coursePlanner = new CoursePlanner();
  }

  @AfterEach
  public void tearDown() {}

  // Testing removeCourse method
  @Test
  public void testRemoveCourseValid() {}

  @Test
  public void testRemoveCourseFromSemester0() {}

  @Test
  public void testRemoveCourseFromSemester9() {}

  @Test
  public void testRemoveCourseCourseNotExist() {}

  // Testing addCourse method
  @Test
  public void testAddCourseValid() {}

  @Test
  public void testAddCourseToSemester0() {}

  @Test
  public void testAddCourseToSemester9() {}

  @Test
  public void testAddCourseCourseNotExist() {}

  @Test
  public void testAddCourseCourseExist() {}

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
  public void testSearchPlannerValidCourse() {}

  @Test
  public void testSearchPlannerALLCAPSValidCourse() {}

  @Test
  public void testSearchPlannerLowerCaseValidCourse() {}

  @Test
  public void testSearchPlannerMixedCaseValidCourse() {}

  @Test
  public void testSearchPlannerCourseNotExist() {}
}
