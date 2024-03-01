package AdvisingSoftware;

import java.util.ArrayList;

/**
 * Helps the student stay organize by allowing to create their own ideal
 * 8-semester plan
 * 
 * @author yask8(Yasmine Kennedy)
 */
public class CoursePlanner {

  /**
   * Attributes
   */
  private ArrayList<ArrayList<Course>> semesters;

  /**
   * Constructor for the CoursePlanner
   */
  public CoursePlanner() {
    // Initialize semesters array list
    this.semesters = new ArrayList<>();

    // Add 8 semesters
    for (int i = 0; i < 8; i++) {
      this.semesters.add(new ArrayList<>());
    }
  }

  /**
   * Adds a course to the specified semester
   * 
   * @param semesterIndex the index of the semester (1-based)
   * @param course        the course to add
   */
  public void addCourse(int semesterIndex, Course course) {
    if (semesterIndex >= 1 && semesterIndex <= 8) {
      this.semesters.get(semesterIndex - 1).add(course);
    } else {
      System.out.println("Invalid semester index.");
    }
  }

  /**
   * Removes a course from the specified semester by its UUID
   * 
   * @param semesterIndex the index of the semester (1-based)
   * @param UUID          the UUID of the course to remove
   */
  public void removeCourse(int semesterIndex, String UUID) {
    if (semesterIndex >= 1 && semesterIndex <= 8) {
      ArrayList<Course> semesterCourses = this.semesters.get(semesterIndex - 1);
      for (Course course : semesterCourses) {
        if (course.getID().equals(UUID)) {
          semesterCourses.remove(course);
          return;
        }
      }
      System.out.println("Course with UUID " + UUID + " not found in semester " + semesterIndex);
    } else {
      System.out.println("Invalid semester index.");
    }
  }

  /**
   * Displays the planner for all semesters
   * 
   * @return the displayPlanner
   */
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 1; i <= 8; i++) {
      result.append("Semester ").append(i).append(":\n");
      ArrayList<Course> semesterCourses = this.semesters.get(i - 1);
      if (semesterCourses.isEmpty()) {
        result.append("No courses added to this semester.\n");
      } else {
        for (Course course : semesterCourses) {
          result.append(course.toString()).append("\n");
        }
      }
      result.append("\n");
    }
    return result.toString();
  }
}