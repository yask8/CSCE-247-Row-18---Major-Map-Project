package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

/**
 * MajorMap Code
 *
 * @author Stephon Johnson
 */
public class MajorMap {

  private UUID id;
  private String major;
  private ArrayList<Course> majorCourses;
  private ArrayList<Course> majorElective;
  private ArrayList<Course> coreEdu;
  private ArrayList<Course> appArea;

  // Graduation Requirements
  private int minTotalHours;
  private int minGradHours;
  private int caroCoreHours;
  private Double minGPA;

  /**
   * Constructor with an ID for the MajorMap.
   *
   * @param id            The UUID of the MajorMap.
   * @param major         The name of the major.
   * @param majorCourses  The courses needed for the major.
   * @param majorElective The elective for the major.
   * @param coreEdu       The core courses for the major.
   * @param appArea       The courses for the major's application area.
   */
  public MajorMap(
      UUID id,
      String major,
      ArrayList<Course> majorCourses,
      ArrayList<Course> majorElective,
      ArrayList<Course> coreEdu,
      ArrayList<Course> appArea,
      int minTotalHours,
      int minGradHours,
      int caroCoreHours,
      Double minGPA) {
    this.id = id;
    this.major = major;
    this.majorCourses = majorCourses;
    this.majorElective = majorElective;
    this.coreEdu = coreEdu;
    this.appArea = appArea;
    this.minTotalHours = minTotalHours;
    this.minGradHours = minGradHours;
    this.caroCoreHours = caroCoreHours;
    this.minGPA = minGPA;
  }

  /**
   * Constructor without an ID for the MajorMap.
   *
   * @param major         The name of the major.
   * @param majorCourses  The courses needed for the major.
   * @param majorElective The elective courses for the major.
   * @param coreEdu       The core courses for the major.
   * @param appArea       The courses for the major's application area.
   */
  public MajorMap(
      String major,
      ArrayList<Course> majorCourses,
      ArrayList<Course> majorElective,
      ArrayList<Course> coreEdu,
      ArrayList<Course> appArea,
      int minTotalHours,
      int minGradHours,
      int caroCoreHours,
      Double minGPA) {
    this.id = UUID.randomUUID();
    this.major = major;
    this.majorCourses = majorCourses;
    this.majorElective = majorElective;
    this.coreEdu = coreEdu;
    this.appArea = appArea;
    this.minTotalHours = minTotalHours;
    this.minGradHours = minGradHours;
    this.caroCoreHours = caroCoreHours;
    this.minGPA = minGPA;
  }

  /**
   * Deletes the major from the system.
   *
   * @param major The name of the major to delete.
   */
  public void deleteMajor(String major) {
    if (this.major.equals(major)) {
      this.major = null;
      this.majorCourses = null;
      this.majorElective = null;
      this.coreEdu = null;
      this.appArea = null;
      this.id = null;
      this.minTotalHours = 0;
      this.minGradHours = 0;
      this.caroCoreHours = 0;
      this.minGPA = 0.0;
    }
  }

  /**
   * Displays the details of the major map.
   *
   * @param major The name of the major to display.
   */
  public void displayMajorMap(String major) {
    if (this.major.equals(major)) {
      System.out.println("\n************ Major Map *************");
      System.out.println("Major: " + this.major);
      System.out.println("MajorMap ID: " + this.id);
      System.out.println("Major Courses: " + this.majorCourses);
      System.out.println("Major Elective: " + this.majorElective);
      System.out.println("Carolina Core: " + this.coreEdu);
      System.out.println("Application Area: " + this.appArea);
      System.out.println("Minimum Total Hours: " + this.minTotalHours);
      System.out.println("Minimum Grad Hours: " + this.minGradHours);
      System.out.println("Carolina Core Hours: " + this.caroCoreHours);
      System.out.println("Minimum GPA: " + this.minGPA);
    } else {
      System.out.println("No matching major found.");
    }
  }

  /**
   * Returns String of the details of the major map.
   */
/**
 * Returns String of the details of the major map.
 */
public String toString() {
  return "\n********* MAJOR MAP *********\n" +
          "Major: " + this.major + "\n" +
          "MajorMap ID: " + this.id + "\n" +
          "\n********* Minimum Requirements *********\n" +
          "Minimum Total Hours: " + this.minTotalHours + "\n" +
          "Minimum Grad Hours: " + this.minGradHours + "\n" +
          "Carolina Core Hours: " + this.caroCoreHours + "\n" +
          "Minimum GPA: " + this.minGPA + "\n" +
          "\n********* Major Courses *********\n" +
          "Major Courses: " + this.majorCourses + "\n" +
          "\n********* Elective Courses *********\n" +
          "Major Elective: " + this.majorElective + "\n" +
          "\n********* Carolina Core *********\n" +
          "Carolina Core: " + this.coreEdu + "\n" +
          "\n********* Application Area *********\n" +
          "Application Area: " + this.appArea + "\n";
}

  /**
   * Get the UUID of the MajorMap.
   *
   * @return The UUID of the MajorMap.
   */
  public UUID getId() {
    return id;
  }

  /**
   * Get the name of the major.
   *
   * @return The name of the major.
   */
  public String getMajor() {
    return major;
  }

  /**
   * Get the list of major courses.
   *
   * @return The list of major courses.
   */
  public ArrayList<Course> getMajorCourses() {
    return majorCourses;
  }

  /**
   * Get the list of major elective courses.
   *
   * @return The list of major elective courses.
   */
  public ArrayList<Course> getElectives() {
    return majorElective;
  }

  /**
   * Get the list of core courses for the major.
   *
   * @return The list of core courses for the major.
   */
  public ArrayList<Course> getCoreEdu() {
    return coreEdu;
  }

    /**
   * Get the list of courses for the major's application area.
   *
   * @return The list of courses for the major's application area.
   */
  public ArrayList<Course> getAppArea() {
    return appArea;
  }

  /**
   * Get the minimum total hours required for graduation.
   *
   * @return The minimum total hours required for graduation.
   */
  public int getMinTotalHours() {
    return minTotalHours;
  }

  /**
   * Get the minimum graduation hours required.
   *
   * @return The minimum graduation hours required.
   */
  public int getMinGradHours() {
    return minGradHours;
  }

  /**
   * Get the Carolina Core hours required.
   *
   * @return The Carolina Core hours required.
   */
  public int getCaroCoreHours() {
    return caroCoreHours;
  }

  /**
   * Get the minimum GPA required for graduation.
   *
   * @return The minimum GPA required for graduation.
   */
  public Double getMinGPA() {
    return minGPA;
  }


  /**
     * Sets the minimum total hours
     * @param minTotalHr the hours given
     */
    public void setMinTotalHours(int minTotalHr){
        if( minTotalHr > 0){
            this.minTotalHours = minTotalHr;
        }
    }
    
    /**
     * Sets the minimum graduation hours
     * @param minGradHr the hours given
     */
    public void setMinGradHours(int minGradHr){
        if(minGradHr > 0){
            this.minGradHours = minGradHr;
        }
    }

  /**
     * Sets the Carolina Core Hours
     * @param minCaroCoreHr the hours given
     */
    public void setCaroCoreHours(int minCaroCoreHr){
      if(minCaroCoreHr > 0){
          this.caroCoreHours = minCaroCoreHr;
      }
  }

  /**
     * Sets the minimum GPA
     * @param minGPA the minimum GPA
     */
    public void setMinGPA(Double minGPA){
      if(minGPA > 0){
          this.minGPA = minGPA;
      }
  }

  public boolean containsCourse(Course course) {
    for (Course c : majorCourses) {
      if (c.equals(course)) {
        return true;
      }
    }
    for (Course c : majorElective) {
      if (c.equals(course)) {
        return true;
      }
    }
    for (Course c : coreEdu) {
      if (c.equals(course)) {
        return true;
      }
    }
    for (Course c : appArea) {
      if (c.equals(course)) {
        return true;
      }
    }
    return false;
  }
}
