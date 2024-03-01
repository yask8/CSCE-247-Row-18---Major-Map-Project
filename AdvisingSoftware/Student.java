package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {

  private String year;
  private String major;
  private int creditHours;
  private ArrayList<Grades> completedCourses;
  private double gpa;
  private CoursePlanner coursePlanner;
  private DegreeProgress degreeProgress;
  private ArrayList<Note> advisorNotes;

  /**
   * Student Constructor
   * 
   * @param year             Student's year/class
   * @param major            Student's major
   * @param creditHours      Student's number of credit hours taken
   * @param completedCourses2 Courses the student has completed
   * @param gpa              Student's GPA
   * @param coursePlanner    Student's courses planned for the future
   * @param degreeProgress   Student's degree progress
   * @param advisorNotes     Student's notes left by advisor
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
      ArrayList<Grades> completedCourses2,
      double gpa,
      CoursePlanner coursePlanner,
      DegreeProgress degreeProgress,
      ArrayList<Note> advisorNotes) {
    super(firstName, lastName, email, uscID, password, userType);
    this.year = year;
    this.major = major;
    this.creditHours = creditHours;
    this.completedCourses = completedCourses2;
    this.gpa = gpa;
    this.coursePlanner = coursePlanner;
    this.degreeProgress = degreeProgress;
    this.advisorNotes = advisorNotes;
  }

  /**
   * Allows student to view the details of their profile
   */
  public void viewProfile() {
  }

  /**
   * Allows student to edit their profile
   */
  public void editProfile() {
  }

  /**
   * Allows student to update their year/class
   * 
   * @param creditHours updated number of credit hours the student has taken
   * @return String of newly updated year/class
   */
  public String updateYear(int creditHours) {
    return year;
  }

  /**
   * Allows student to view their major map
   * 
   * @param major to identify which major map to view
   * @return the correct Major Map
   */
  public MajorMap viewMajorMap(String major) {
    return viewMajorMap(major);
  }

  /**
   * Allows student to view their completed courses
   * 
   * @param completedCourses ArrayList of students completed courses with their
   *                         respective grade
   */
  public void viewCompletedCourses(ArrayList<Grades> completedCourses) {
  }

  /**
   * Allows student to view their course planner
   * 
   * @return course planner
   */
  public String viewCoursePlanner() {
    return "";
  }

  /**
   * Allows student to view their degree progress
   * 
   * @return degree progress
   */
  public String viewDegreeProgress() {
    return "";
  }

  /**
   * Allows student to add a completed course
   * 
   * @param code  Course-specific code
   * @param grade Course grade
   */
  public void addCompleteCourse(String code, char grade) {
  }

  /**
   * Allows student to view advisor notes
   * 
   * @return ArrayList of advisor notes
   */
  public ArrayList<String> viewNotes() {
    return new ArrayList<String>();
  }

  /**
   * Allows student to update their GPA
   * 
   * @return returns updated gpa
   */
  public double updateGPA() {
    return 0;
  }

  public UUID getStudentsID() {
    return getID();
  }

  /**
   * Getter for year
   * 
   * @return the student's year/class
   */
  public String getYear() {
    return year;
  }

  /**
   * Getter for major
   * 
   * @return the student's major
   */
  public String getMajor() {
    return major;
  }

  /**
   * Getter for creditHours
   * 
   * @return the number of credit hours the student has taken
   */
  public int getCreditHours() {
    return creditHours;
  }

  /**
   * Getter for completedCourses
   * 
   * @return the courses the student has completed
   */
  public ArrayList<Grades> getCompletedCourses() {
    return completedCourses;
  }

  /**
   * Getter for gpa
   * 
   * @return the student's GPA
   */
  public double getGpa() {
    return gpa;
  }

  /**
   * Getter for coursePlanner
   * 
   * @return the student's course planner
   */
  public CoursePlanner getCoursePlanner() {
    return coursePlanner;
  }

  /**
   * Getter for degreeProgress
   * 
   * @return the student's degree progress
   */
  public DegreeProgress getDegreeProgress() {
    return degreeProgress;
  }

  /**
   * Getter for advisorNotes
   * 
   * @return the student's advisor notes
   */
  public ArrayList<Note> getAdvisorNotes() {
    return advisorNotes;
  }

  public String toString() {
    return "************** Student Profile **************\n" +
        super.toString() +
        "year: '" + year + "'\n" +
        "major: '" + major + "'\n" +
        "creditHours: " + creditHours + "\n" +
        "completedCourses: " + completedCourses + "\n" +
        "gpa: " + gpa + "\n" +
        "coursePlanner: " + coursePlanner.toString()+ "\n" +
        "degreeProgress: " + degreeProgress.toString()+ "\n" +
        "advisorNotes: " + advisorNotes.toString()+"\n";
  }
}
