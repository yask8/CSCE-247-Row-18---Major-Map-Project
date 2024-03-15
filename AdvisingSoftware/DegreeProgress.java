package AdvisingSoftware;

import java.util.ArrayList;
import java.util.HashMap;

// TODO JAVA DOC AUTHOR GARRETT SPILLMAN
public class DegreeProgress {

  private String major;
  private ArrayList<String> completeCourses;
  private ArrayList<String> incompleteCourses;

  public DegreeProgress(
    String major,
    ArrayList<String> completeCourses,
    ArrayList<String> incompleteCourses
  ) {
    this.major = major;
    this.completeCourses = completeCourses;
    this.incompleteCourses = incompleteCourses;
  }

  public String displayProgress(
    MajorMap majorMap,
    HashMap<String, ArrayList<Course>> completedCourses
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

  public String getMajor() {
    return major;
  }

  public ArrayList<String> getCompleteCourses() {
    return completeCourses;
  }

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
    for (String option : appArea.getAppAreaOptions()) {
      appArea = new AppArea(option);
      System.out.println(appArea.toString());
    }
  }

  public ArrayList<String> getIncompleteCourses() {
    return incompleteCourses;
  }

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

  public double calculateGPA(
    ArrayList<Course> courseList,
    ArrayList<Grades> completedCourses
  ) {
    double gpa = 0.0;
    double totalPoints = 0;
    double totalCreditHours = 0;

    for (Grades completeCourse : completedCourses) {
      totalCreditHours += getCreditHours(completeCourse, courseList);
      totalPoints +=
        getCreditHours(completeCourse, courseList) *
        getGradePoint(completeCourse.getGrade());
    }
    gpa = totalPoints / totalCreditHours;
    return gpa;
  }

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
