package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.Course;
import AdvisingSoftware.CourseList;
import AdvisingSoftware.Grades;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.Student;
import AdvisingSoftware.UserList;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoursePlannerTest {

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
  // Testing searchPlanner method
  @Test
  public void testSearchPlannerValidCourse() {}

  @Test
  public void testSearchPlannerCourseNotExist() {}
}
