package AdvisingSoftware;

import java.util.ArrayList;

// TODO JAVA DOC AUTHOR GARRETT SPILLMAN
public class DegreeProgress {

  private String major;
  private ArrayList<String> completeCourses;
  private ArrayList<String> incompleteCourses;
  private int totalCreditHours;

  /**
   * DegreeProgress constructor
   * @param major String Student's major
   * @param completeCourses ArrayList<String> list of courses that the student has completed
   * @param incompleteCourses ArrayList<String> list of courses that have yet to be completed
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
   * returns a String representation of degree progress
   * @param majorMap MajorMap major map
   * @param completedCourses ArrayList<Grades> completedCourses
   * @return String
   */
  public String displayProgress(
    MajorMap majorMap,
    ArrayList<Grades> completedCourses
  ) {
    return "-----Degree Progress-----" + "Current Major: " + this.major;
  }

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
   *
   * @return String major
   */
  public String getMajor() {
    return major;
  }

  /**
   *
   * @return ArrayList<String> completeCourses
   */
  public ArrayList<String> getCompleteCourses() {
    return completeCourses;
  }

  /**
   * adds courses to completeCourses list if it has a passing grade
   * @param xcompleteCourses ArrayList<Grades> list of courses and grades
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
   * removes complete courses from incomplete courses list
   * @param xcompleteCourses ArrayList<Grades> list of courses and grades
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
   * populate incomplete courses list with courses from the given major map
   * @param majorMap
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
   * populate incomplete courses list with courses from the given application area
   * @param xappArea String application area
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

  public void displayAllAppAreas() {
    AppArea appArea = new AppArea("Science");
    System.out.println(appArea.getAppAreaOptions());
    for (String option : appArea.getAppAreaOptions()) {
      appArea = new AppArea(option);
      System.out.println(appArea.toString());
    }
  }

  /**
   *
   * @return
   */
  public ArrayList<String> getIncompleteCourses() {
    return incompleteCourses;
  }

  /**
   * depending on the grade of a course, the method
   * returns the corresponding grade point
   * @param courseGrade double grade of completed course
   * @return double grade point
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
   * @param courseList ArrayList<Course> list of all the courses
   * @param completedCourses ArrayList<Grades> list of course names and grades
   * @return double GPA of student
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
   *
   * @return int total credit hours taken by student
   */
  public int getTotalCreditHours() {
    return totalCreditHours;
  }

  /**
   * retrieves number of credit hours for a given course
   * @param completeCourse Grades course name and grade
   * @param courseList ArrayList<Course> list of all the courses
   * @return int credit hours of a single course
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
