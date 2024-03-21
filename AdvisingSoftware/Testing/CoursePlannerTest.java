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
  public void testRemoveCourseMethodValid() {}

  @Test
  public void testRemoveCourseMethodSemester0() {}

  @Test
  public void testRemoveCourseMethodSemester9() {}

  @Test
  public void testRemoveCourseMethodCourseNotExist() {}

  // Testing addCourse method
  @Test
  public void testAddCourseMethodValid() {}

  @Test
  public void testAddCourseMethodSemester0() {}

  @Test
  public void testAddCourseMethodSemester9() {}

  @Test
  public void testAddCourseMethodCourseNotExist() {}

  @Test
  public void testAddCourseMethodCourseExist() {}
  // Testing generateFromMajorMap method
  // Testing searchPlanner method
}
