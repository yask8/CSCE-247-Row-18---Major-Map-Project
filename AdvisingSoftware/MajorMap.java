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
      ArrayList<Course> appArea) {
    this.id = id;
    this.major = major;
    this.majorCourses = majorCourses;
    this.majorElective = majorElective;
    this.coreEdu = coreEdu;
    this.appArea = appArea;
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
      ArrayList<Course> appArea) {
    this.id = UUID.randomUUID();
    this.major = major;
    this.majorCourses = majorCourses;
    this.majorElective = majorElective;
    this.coreEdu = coreEdu;
    this.appArea = appArea;
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
    } else {
      System.out.println("No matching major found.");
    }
  }

  /**
   * Returns String of the details of the major map.
   */
  public String toString() {
    return "\n************ Major Map *************\n" +
        "Major: " + this.major + "\n" +
        "MajorMap ID: " + this.id + "\n" +
        "\n************ Major Courses *************\n" +
        "Major Courses: " + this.majorCourses + "\n" +
        "\n************ Major Electives *************\n" +
        "Major Elective: " + this.majorElective + "\n" +
        "\n************ Carolina Core  *************\n" +
        "Carolina Core: " + this.coreEdu + "\n" +
        "\n************ Application Area *************\n" +
        "Application Area: " + this.appArea + "\n";
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
