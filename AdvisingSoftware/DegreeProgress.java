package AdvisingSoftware;
/**
 * Creates a DegreeProgress for student
 * @author Garrett Spillman (@Spillmag), Lia Zhao (@zhaolia9), Stephon Johnson (@stephonj), Yasmine Kennedy (@yask8)
 */
import java.util.ArrayList;

public class DegreeProgress {
  /**
   * Attributes
   */
  private String major;
  private ArrayList<String> completeCourses;
  private ArrayList<String> incompleteCourses;
  private int totalCreditHours;
  /**
   * Constructor
   * @param major the major of the student
   * @param completeCourses the student's completed courses
   * @param incompleteCourses the student's incompleted courses
   */
  public DegreeProgress(
    String major,
    ArrayList<String> completeCourses,
    ArrayList<String> incompleteCourses
  ) {
    this.major = major;
    this.completeCourses = completeCourses;
    this.incompleteCourses = incompleteCourses;
  }

  /**
   * Displys the degree progress
   * @param majorMap the major map
   * @param completedCourses the completed courses
   * @return the string format of both the major map and completed courses
   */
  public String displayProgress(
    MajorMap majorMap,
    ArrayList<Grades> completedCourses
  ) {
    return "-----Degree Progress-----" + "Current Major: " + this.major;
  }
  /**
   * The display completed courses and incompleted courses
   * @return the string format of completed and incomplete courses
   */
  public String toString() {
    String result = "\n";
    result += "Current Major: " + this.major + "\n";

    result += "\n********* Completed Courses *********\n";
    if (completeCourses.isEmpty()) {
      result += "No completed courses specified.\n";
    } else {
      result += "Completed Courses: " + this.completeCourses + "\n";
    }

    result += "\n********* Incomplete Courses *********\n";
    if (incompleteCourses.isEmpty()) {
      result += "No incomplete courses specified.\n";
    } else {
      result += "Incomplete Courses: " + this.incompleteCourses + "\n";
    }

    return result;
  }
  /**
   * Gets the major
   * @return the major
   */
  public String getMajor() {
    return major;
  }
  /**
   * Gets list of completed courses
   * @return the completed courses
   */
  public ArrayList<String> getCompleteCourses() {
    return completeCourses;
  }
  /**
   * Saves the Completed courses along with their grade
   * @param xcompleteCourses the completed courses from the list of courses and grades
   */
  public void saveCompleteCourses(ArrayList<Grades> xcompleteCourses) {
    for (Grades course : xcompleteCourses) {
      boolean pass = course
        .checkPass(course.getGrade())
        .equalsIgnoreCase("PASS");
      if (!completeCourses.contains(course.getCourseName()) && pass) {
        completeCourses.add(course.getCourseName());
      }
    }
  }
  /**
   * Updates course completetion 
   * @param xcompleteCourses the courses from the list of courses and grade
   */
  public void updateCourseCompletion(ArrayList<Grades> xcompleteCourses) {
    saveCompleteCourses(xcompleteCourses);
    for (String course : incompleteCourses) {
      if (completeCourses.contains(course)) {
        incompleteCourses.remove(course);
      }
    }
    ArrayList<String> temp = new ArrayList<String>();
    for (String incomplete : incompleteCourses) {
      if (incomplete != null) {
        temp.add(incomplete);
      }
    }
    incompleteCourses = temp;
  }

  /**
   * Populates incomplete courses from major map
   * @param majorMap the major map
   */
  public void populateIncompleteCoursesFromMajorMap(MajorMap majorMap) {
    ArrayList<String> majorCourses = majorMap.getCoursesForMajor(major);
    for (String course : majorCourses) {
      if (
        !completeCourses.contains(course) && !incompleteCourses.contains(course)
      ) {
        incompleteCourses.add(course);
      }
    }
  }
  /**
   * Populates Incomplete Courses from AppArea
   * @param xappArea the app area
   */
  public void populateIncompleteCoursesFromAppArea(String xappArea) {
    AppArea appArea = new AppArea(xappArea);
    ArrayList<String> majorElectives = appArea.getmajorElectives();
    ArrayList<String> appAreaCourses = appArea.getAppAreaCourses();

    for (String course : majorElectives) {
      if (
        !completeCourses.contains(course) && !incompleteCourses.contains(course)
      ) {
        incompleteCourses.add(course);
      }
    }

    for (String course : appAreaCourses) {
      if (
        !completeCourses.contains(course) && !incompleteCourses.contains(course)
      ) {
        incompleteCourses.add(course);
      }
    }
  }
  /**
   * Displays all of the application areas
   */
  public void displayAllAppAreas() {
    AppArea appArea = new AppArea("Science");
    System.out.println(appArea.getAppAreaOptions());
    for (String option : appArea.getAppAreaOptions()) {
      appArea = new AppArea(option);
      System.out.println(appArea.toString());
    }
  }
  /**
   * Gets the list incomplete courses
   * @return the list of incomplete courses
   */
  public ArrayList<String> getIncompleteCourses() {
    return incompleteCourses;
  }
  /**
   * Calculates the Grade Point Average
   * @param courseGrade the grade received
   * @return the grade point
   */
  public double getGradePoint(double courseGrade) {
    double gradePoint = 0;
    boolean gradeA = courseGrade <= 90;
    boolean gradeBPlus = (courseGrade <= 85 && courseGrade >= 89.99);
    boolean gradeB = (courseGrade <= 80 && courseGrade >= 84.99);
    boolean gradeCPlus = (courseGrade <= 75 && courseGrade >= 79.99);
    boolean gradeC = (courseGrade <= 70 && courseGrade >= 74.99);
    boolean gradeDPlus = (courseGrade <= 65 && courseGrade >= 69.99);
    boolean gradeD = (courseGrade <= 60 && courseGrade >= 64.99);
    boolean gradeF = courseGrade < 59.99;

    if (gradeF) {
      gradePoint = 0;
    }
    if (gradeD) {
      gradePoint = 1.0;
    }
    if (gradeDPlus) {
      gradePoint = 1.5;
    }
    if (gradeC) {
      gradePoint = 2.0;
    }
    if (gradeCPlus) {
      gradePoint = 2.5;
    }
    if (gradeB) {
      gradePoint = 3.0;
    }
    if (gradeBPlus) {
      gradePoint = 3.5;
    }
    if (gradeA) {
      gradePoint = 4.0;
    }
    return gradePoint;
  }
  /**
   * Calculates the GPA
   * @param courseList the list of courses
   * @param completedCourses the list of completed courses
   * @return the GPA
   */
  public double calculateGPA(
    ArrayList<Course> courseList,
    ArrayList<Grades> completedCourses
  ) {
    double gpa = 0.0;
    double totalPoints = 0;
    totalCreditHours = 0;
    for (Grades completeCourse : completedCourses) {
      totalCreditHours += getCreditHours(completeCourse, courseList);
      totalPoints +=
        getCreditHours(completeCourse, courseList) *
        getGradePoint(completeCourse.getGrade());
    }
    gpa = totalPoints / totalCreditHours;
    gpa = Math.floor(gpa * 100) / 100;
    return gpa;
  }
  /**
   * Gets the total credit hours
   * @return the total credit hours
   */
  public int getTotalCreditHours() {
    return totalCreditHours;
  }
  /**
   * Gets the CreditHours
   * @param completeCourse the list of completed courses
   * @param courseList the list of courses
   * @return credit hours
   */
  public int getCreditHours(
    Grades completeCourse,
    ArrayList<Course> courseList
  ) {
    int creditHours = 0;
    for (Course searched : courseList) {
      if (searched.getID().equalsIgnoreCase(completeCourse.getCourseName())) {
        return searched.getCreditHours();
      }
    }
    return creditHours;
  }
}
