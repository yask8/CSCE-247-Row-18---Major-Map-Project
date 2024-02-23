package AdvisingSoftware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User {

  private String year;
  private String major;
  private int creditHours;
  private HashMap<Course, Character> completedCourses;
  private double gpa;
  private CoursePlanner coursePlanner;
  private DegreeProgress degreeProgress;
  // HashMap<String notes, String date>
  private ArrayList<Note> advisorNotes;

  /**
   * Student Constructor
   * @param year Student's year/class
   * @param major Student's major
   * @param creditHours Student's number of credit hours taken
   * @param completedCourses Courses the student has completed
   * @param gpa Student's GPA
   * @param coursePlanner Student's courses planned for the future
   * @param degreeProgress Student's degree progress
   * @param advisorNotes Student's notes left by advisor
   */
  public Student(
    String firstName,
    String lastName,
    String email,
    UUID uscID,
    String password,
    String userType,
    String year,
    String major,
    int creditHours,
    HashMap<Course, Character> completedCourses,
    double gpa,
    CoursePlanner coursePlanner,
    DegreeProgress degreeProgress,
    ArrayList<Note> advisorNotes
  ) {
    super(firstName, lastName, email, uscID, password, userType);
    this.year = year;
    this.major = major;
    this.creditHours = creditHours;
    this.completedCourses = completedCourses;
    this.gpa = gpa;
    this.coursePlanner = coursePlanner;
    this.degreeProgress = degreeProgress;
    this.advisorNotes = advisorNotes;
  }

  /**
   * Allows student to view the details of their profile
   */
  public void viewProfile() {}

  /**
   * Allows student to edit their profile
   */
  public void editProfile() {}

  /**
   * Allows student to update their year/class
   * @param creditHours updated number of credit hours the student has taken
   * @return String of newly updated year/class
   */
  public String updateYear(int creditHours) {
    return year;
  }

  /**
   * Allows student to view their major map
   * @param major to identify which major map to view
   * @return the correct Major Map
   */
  public MajorMap viewMajorMap(String major) {
    return viewMajorMap(major);
  }

  /**
   * Allows student to view their completed courses
   * @param completedCourses HashMap of students completed courses with their respective grade
   */
  public void viewCompletedCourses(
    HashMap<Course, Character> completedCourses
  ) {}

  /**
   * Allows student to view their course planner
   * @return course planner
   */
  public String viewCoursePlanner() {
    return "";
  }

  /**
   * Allows student to view their degree progress
   * @return degree progress
   */
  public String viewDegreeProgress() {
    return "";
  }

  /**
   * Allows student to add a completed course
   * @param code Course-specific code
   * @param grade Course grade
   */
  public void addCompleteCourse(String code, char grade) {}

  /**
   * Allows student to view advisor notes
   * @return ArrayList of advisor notes
   */
  public ArrayList<String> viewNotes() {
    return new ArrayList<String>();
  }

  /**
   * Allows student to update their GPA
   * @return returns updated gpa
   */
  public double updateGPA() {
    return 0;
  }

  public String toString() {
    return (
      super.toString() +
      "\nYear: " +
      year +
      "\nMajor: " +
      major +
      "\nCredit Hours: " +
      creditHours +
      "\nCompleted Courses: " +
      "\nGPA: " +
      gpa +
      "\nAdvisor Notes:"
    );
    /* 
    return "String year,\r\n" + //
            "    String major,\r\n" + //
            "    int creditHours,\r\n" + //
            "    HashMap<Course, Character> completedCourses,\r\n" + //
            "    double gpa,\r\n" + //
            "    CoursePlanner coursePlanner,\r\n" + //
            "    DegreeProgress degreeProgress,\r\n" + //
            "    ArrayList<Note> advisorNotes";*/
  }
}
