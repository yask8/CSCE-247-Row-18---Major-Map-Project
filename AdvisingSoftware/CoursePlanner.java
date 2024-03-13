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
  private ArrayList<ArrayList<String>> semesters;

  /**
   * Constructor for the CoursePlanner
   */
  public CoursePlanner() {
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
   * @param courseName    the name of the course to add
   */
  public void addCourse(int semesterIndex, String courseName) {
    if (semesterIndex >= 1 && semesterIndex <= 8) {
      this.semesters.get(semesterIndex - 1).add(courseName);
    } else {
      System.out.println("Invalid semester index.");
    }
  }

  /**
   * Removes a course from the specified semester by its name
   * 
   * @param semesterIndex the index of the semester (1-based)
   * @param courseName    the name of the course to remove
   */
  public void removeCourse(int semesterIndex, String courseName) {
    if (semesterIndex >= 1 && semesterIndex <= 8) {
      ArrayList<String> semesterCourses = this.semesters.get(semesterIndex - 1);
      if (semesterCourses.contains(courseName)) {
        semesterCourses.remove(courseName);
      } else {
        System.out.println("Course '" + courseName + "' not found in semester " + semesterIndex);
      }
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
    String result = "\n";
    for (int i = 1; i <= 8; i++) {
      result += "********** Semester " + i + " *********" + "\n";
      ArrayList<String> semesterCourses = this.semesters.get(i - 1);
      if (semesterCourses.isEmpty()) {
        result += "No courses added to this semester.\n";
      } else {
        for (String courseName : semesterCourses) {
          result += courseName + "\n";
        }
      }
      result += "\n";
    }
    return result;
  }

  /**
   * Getter for the semesters attribute
   * 
   * @return the semesters
   */
  public ArrayList<ArrayList<String>> getSemesters() {
    return semesters;
  }
}