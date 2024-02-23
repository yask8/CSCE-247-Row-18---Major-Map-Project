package AdvisingSoftware;

import java.util.ArrayList;


/**
 * @author Lia Zhao (zhaolia9)
 *         - id: UUID()
 *         - name: String
 *         - code: String
 *         - description: String
 *         - creditHours: int
 *         - subject: String
 *         - passGrade: Char
 *         - elective: boolean
 *         - carolinaCore: boolean
 *         - preReqs: ArrayList <Course>
 *         - semester: String
 *         - year: String
 *         + Course(UUID id, String name, String code, String description, int
 *         creditHours, string subject, char passGrade, Boolean elective,
 *         Boolean carolinaCore, ArrayList <Course> prereqs)
 *         + Course(String name, String code, String description, int
 *         creditHours, string subject, char passGrade, Boolean elective,
 *         Boolean carolinaCore, ArrayList <Course> prereqs)
 *         + editCourse(String name, String code, String description, int
 *         creditHours, string subject, char passGrade, Boolean elective,
 *         Boolean carolinaCore, ArrayList <Course> prereqs): Course
 *         + deleteCourse(String code)
 */
public class Course {

  private String id;
  private String name;
  private String code;
  private String description;
  private int creditHours;
  private String subject;
  private char passGrade;
  private boolean elective;
  private boolean carolinaCore;
  private ArrayList<Course> preReqs;
  private String semester;
  private String year;

  /**
   *
   * @param id           UUID
   * @param name         String
   * @param code         String
   * @param description  String
   * @param creditHours  int
   * @param subject      String
   * @param passGrade    char
   * @param elective     boolean
   * @param carolinaCore boolean
   * @param preReqs      ArrayList<Course>
   */
  public Course(
      String id,
      String name,
      String code,
      String description,
      int creditHours,
      String subject,
      char passGrade,
      boolean elective,
      boolean carolinaCore,
      ArrayList<Course> preReqs,
      String year,
      String semester) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.description = description;
    this.creditHours = creditHours;
    this.subject = subject;
    this.passGrade = passGrade;
    this.elective = elective;
    this.carolinaCore = carolinaCore;
    this.preReqs = preReqs;
    this.year = year;
    this.semester = semester;
  }

  /**
   *
   * @param name         String
   * @param code         String
   * @param description  String
   * @param creditHours  int
   * @param subject      String
   * @param passGrade    char
   * @param elective     boolean
   * @param carolinaCore boolean
   * @param preReqs      ArrayList<Course>
   */
  public Course(
      String name,
      String code,
      String description,
      int creditHours,
      String subject,
      char passGrade,
      boolean elective,
      boolean carolinaCore,
      ArrayList<Course> preReqs,
      String year,
      String semester) {
    this.name = name;
    this.code = code;
    this.description = description;
    this.creditHours = creditHours;
    this.subject = subject;
    this.passGrade = passGrade;
    this.elective = elective;
    this.carolinaCore = carolinaCore;
    this.preReqs = preReqs;
    this.year = year;
    this.semester = semester;
  }

  /**
   *
   * @return Course
   */
  public Course editCourse(String id) {
    Course course = new Course(
        this.id = id,
        name,
        code,
        description,
        creditHours,
        subject,
        passGrade,
        elective,
        carolinaCore,
        preReqs,
        year,
        semester);
    return course;
  }

  public void deleteCourse() {
  }

  /**
   * To string to view user details
   * Added by @Spillmag for tesing purposes
   */
  public String toString() {
    return "id: " + id + '\n' +
        "name: " + name + '\n' +
        "code: " + code + '\n' +
        "description: " + description + '\n' +
        "creditHours: " + creditHours + '\n' +
        "subject: " + subject + '\n' +
        "passGrade: " + passGrade + '\n' +
        "elective: " + elective + '\n' +
        "carolinaCore: " + carolinaCore + '\n' +
        "preReqs: " + preReqs + '\n' +
        "semester: " + semester + '\n' +
        "year: " + year + '\n';
  }

  /**
   * Getter method for retrieving the UUID of the course.
   * 
   * @return The UUID of the course.
   */
  public String getID() {
    return id;
  }

  /**
   * Checks if the course is an elective.
   * 
   * @return {@code true} if the course is an elective, {@code false} otherwise.
   */
  public boolean isElective() {
    return elective;
  }

  /**
   * Checks if the course is a Carolina Core course.
   * 
   * @return {@code true} if the course is a Carolina Core course, {@code false}
   *         otherwise.
   */
  public boolean isCarolinaCore() {
    return carolinaCore;
  }
}