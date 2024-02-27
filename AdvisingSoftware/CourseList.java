package AdvisingSoftware;

import java.util.ArrayList;

/**
 * Represents a list of courses in the system.
 * 
 * @author Stephon Johnson
 */
public class CourseList {

  private static CourseList courseList;
  private ArrayList<Course> courses;

  /**
   * Private constructor Initializes the list of courses
   */
  private CourseList() {
    courses = new ArrayList<Course>();
  }

  /**
   * Returns an instance of the CourseList class.
   *
   * @return The CourseList instance.
   */
  public static CourseList getInstance() {
    if (courseList == null) {
      courseList = new CourseList();
    }
    return courseList;
  }

  /**
   * Gets a course based on the given course code.
   *
   * @param code The course code to search for.
   * @return The course with the matching code, or null if not found.
   */
  public Course getCourse(String code) {
    for (Course course : courses) {
      if (course.getCode().equals(code)) {
        return course;
      }
    }
    return null; // Course not found
  }

  /**
   * Removes a course from the course list based on the course code.
   *
   * @param code The course code to remove.
   * @return true if the course was found and removed, false otherwise.
   */
  public boolean removeCourse(String code) {
    Course courseToRemove = null;
    for (Course course : courses) {
      if (course.getCode().equals(code)) {
        courseToRemove = course;
        break;
      }
    }
    if (courseToRemove != null) {
      courses.remove(courseToRemove);
      return true; // Course removed successfully
    }
    return false; // Course not found
  }

  /**
   * Adds a new course to the course list.
   *
   * @param name         The name of the course.
   * @param code         The code of the course.
   * @param description  The description of the course.
   * @param creditHours  The credit hours of the course.
   * @param subject      The subject of the course.
   * @param passGrade    The passing grade of the course.
   * @param elective     Indicates if the course is elective.
   * @param carolinaCore Indicates if the course is part of Carolina Core.
   * @param prereqs      The prerequisites of the course.
   */
  public void addCourse(
      String name,
      String code,
      String description,
      int creditHours,
      String subject,
      char passGrade,
      boolean elective,
      boolean carolinaCore,
      ArrayList<Course> prereqs
  ) {
    Course newCourse = new Course(
        name,
        code,
        description,
        creditHours,
        subject,
        passGrade,
        elective,
        carolinaCore,
        prereqs,
        null, // Default year, can be modified later
        null  // Default semester, can be modified later
    );
    courses.add(newCourse);
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }
}
