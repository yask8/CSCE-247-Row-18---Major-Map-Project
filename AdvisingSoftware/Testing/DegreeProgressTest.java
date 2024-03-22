package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.Course;
import AdvisingSoftware.CourseList;
import AdvisingSoftware.DegreeProgress;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.UserList;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DegreeProgressTest {

  /**
   * Methods to Test
   * + displayProgress(MajorMap majorMap, ArrayList<Grades> completedCourses): String
   * + saveCompleteCourses(ArrayList<Grades> xcompleteCourses): void
   * + updateCourseCompletion(ArrayList<Grades> xcompleteCourses): void
   * + populateIncompleteCoursesFromMajorMap(MajorMap majorMap): void
   * + populateIncompleteCoursesFromAppArea(String xappArea): void
   * + calculateGPA(ArrayList<Course> courseList, ArrayList<Grades> completedCourses): double
   */

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  // Testing displayProgress method
  /**
   * Test displayProgress method:
   * Set up a MajorMap object with predefined semesters and credit hours.
   * Set up a list of completed courses with Grades objects containing course names and grades.
   * Call the displayProgress method with the MajorMap, completed courses, and a list of Course objects.
   * Verify that the output string contains the correct major, progress percentage, and other relevant information.
   */
  public void testDisplayProgressValid() {
    //DegreeProgress.displayProgress();
  }
  // Testing saveCompleteCourses method
  /**
   * Test saveCompleteCourses method:
   * Create an instance of DegreeProgress with an empty list of completed courses.
   * Create a list of Grades objects representing completed courses.
   * Call the saveCompleteCourses method with the list of completed courses.
   * Verify that the completed courses are correctly added to the list of completed courses.
   */
  // Testing updateCourseCompletion method
  /**
   * Test updateCourseCompletion method:
   * Create an instance of DegreeProgress with some completed and incomplete courses.
   * Create a list of Grades objects representing completed courses.
   * Call the updateCourseCompletion method with the list of completed courses.
   * Verify that the completed courses are moved from the incomplete courses list to the completed courses list.
   */
  // Testing populateIncompleteCoursesFromMajorMap method
  /**
   * Test populateIncompleteCoursesFromMajorMap method:
   * Create an instance of DegreeProgress.
   * Create a MajorMap object with predefined courses for the same major as the DegreeProgress.
   * Call the populateIncompleteCoursesFromMajorMap method.
   * Verify that the incomplete courses list is populated with the courses from the major map that are not already completed.
   **/

  // Testing populateIncompleteCoursesFromAppArea
  /** Test populateIncompleteCoursesFromAppArea method:
   * Create an instance of DegreeProgress.
   * Create an AppArea object with predefined courses.
   * Call the populateIncompleteCoursesFromAppArea method.
   * Verify that the incomplete courses list is populated with the courses from the application area that are not already completed.
   */
  // Testing calculateGPA method
  /**
   * Test calculateGPA method:
   * Set up a list of completed courses with Grades objects containing course names and grades.
   * Set up a list of Course objects representing all courses.
   * Call the calculateGPA method with the list of completed courses and the list of all courses.
   * Verify that it returns the correct GPA.
   */
}
