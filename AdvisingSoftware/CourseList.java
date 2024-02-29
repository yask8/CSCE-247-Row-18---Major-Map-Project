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
  private boolean loaded;

  /**
   * Private constructor Initializes the list of courses
   */
  private CourseList() {
    courses = new ArrayList<Course>();
    loaded = false;
  }

    /**
   * Get the singleton instance of CourseList.
   *
   * @return The singleton instance of CourseList.
   */
  public static CourseList getInstance() {
    if (courseList == null) {
      courseList = new CourseList();
      if (!courseList.isLoaded()) {
        ArrayList<Course> courseData = DataLoader.loadCourses();
        for (Course course : courseData) {
          courseList.addCourse(
              course.getName(),
              course.getCode(),
              course.getDescription(),
              course.getCreditHours(),
              course.getSubject(),
              course.getPassGrade(),
              course.isElective(),
              course.isCarolinaCore(),
              course.getPreReqs()
          );
        }
        courseList.setLoaded(true);
      }
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

  /**
   * Sets the loaded status of the course list.
   *
   * @param loaded The loaded status to set.
   */
  public void setLoaded(boolean loaded) {
    this.loaded = loaded;
  }

  /**
   * Checks if the course list is loaded.
   *
   * @return true if the course list is loaded, false otherwise.
   */
  public boolean isLoaded() {
    return loaded;
  }

  public void loadCourses(User user) {
    if (user != null && user.getUserType().equals("STUDENT")) {
        if (!loaded) {
            ArrayList<Course> courses = DataLoader.loadCourses();
            for (Course course : courses) {
                addCourse(
                    course.getName(),
                    course.getCode(),
                    course.getDescription(),
                    course.getCreditHours(),
                    course.getSubject(),
                    course.getPassGrade(),
                    course.isElective(),
                    course.isCarolinaCore(),
                    course.getPreReqs()
                );
            }
            loaded = true;
            System.out.println("Courses loaded successfully.");
        } else {
            System.out.println("Courses are already loaded.");
        }
    } else {
        System.out.println("Only students can load courses.");
    }
}

public void displayAllCourses() {
  System.out.println("Printing Course Details:");
  ArrayList<Course> allCourses = getCourses();
  for (Course course : allCourses) {
      System.out.println(course.toString());
  }
}

  /**
   * Gets the list of courses.
   *
   * @return The list of courses.
   */
  public ArrayList<Course> getCourses() {
    return courses;
  }

  /**
 * Show course details for a the course code given.
 *
 * @param code The course code to search for.
 */
public void showCourseByCode(String code) {
  Course course = getCourse(code);
  if (course != null) {
      System.out.println("Course Details for Code: " + code);
      System.out.println("Name: " + course.getName());
      System.out.println("Code: " + course.getCode());
      System.out.println("Description: " + course.getDescription());
      System.out.println("Credit Hours: " + course.getCreditHours());
      System.out.println("Subject: " + course.getSubject());
      System.out.println("Passing Grade: " + course.getPassGrade());
      System.out.println("Elective: " + (course.isElective() ? "Yes" : "No"));
      System.out.println("Carolina Core: " + (course.isCarolinaCore() ? "Yes" : "No"));
      System.out.println("Prerequisites: " + course.getPreReqs());
  } else {
      System.out.println("Course with code " + code + " not found.");
  }
}

}
