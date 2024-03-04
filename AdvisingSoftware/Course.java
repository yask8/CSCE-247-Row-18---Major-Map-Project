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
 *         - preReqs: ArrayList <String>
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
  private ArrayList<String> preReqs;
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
  public Course(String id, String name, String code, String description, int creditHours,
      String subject, char passGrade, boolean elective, boolean carolinaCore,
      ArrayList<String> preReqs, String year, String semester) {
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
    this.semester = semester;
    this.year = year;
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
  public Course(String name, String code, String description, int creditHours,
      String subject, char passGrade, boolean elective, boolean carolinaCore,
      ArrayList<String> preReqs, String year, String semester) {
    this.id = name.split(" ")[0];
    this.name = name;
    this.code = code;
    this.description = description;
    this.creditHours = creditHours;
    this.subject = subject;
    this.passGrade = passGrade;
    this.elective = elective;
    this.carolinaCore = carolinaCore;
    this.preReqs = preReqs;
    this.semester = semester;
    this.year = year;
  }

  /**
   *
   * @return Course
   */
  public Course editCourse(String id) {
    return new Course(id, name, code, description, creditHours, subject, passGrade,
        elective, carolinaCore, preReqs, year, semester);
  }

  public void deleteCourse() {
  }

  /**
   * To string to view user details
   * Added by @Spillmag for tesing purposes
   */
  public String toString() {
    return ("\n********* COURSE INFO *********\n" +
        "id: " +
        id +
        '\n' +
        "name: " +
        name +
        '\n' +
        "code: " +
        code +
        '\n' +
        "description: " +
        description +
        '\n' +
        "creditHours: " +
        creditHours +
        '\n' +
        "subject: " +
        subject +
        '\n' +
        "passGrade: " +
        passGrade +
        '\n' +
        "elective: " +
        elective +
        '\n' +
        "carolinaCore: " +
        carolinaCore +
        '\n' +
        "preReqs: " +
        preReqs +
        '\n' +
        "semester: " +
        semester +
        '\n' +
        "year: " +
        year +
        '\n');
  }

  public String getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public int getCreditHours() {
    return creditHours;
  }

  public String getSubject() {
    return subject;
  }

  public char getPassGrade() {
    return passGrade;
  }

  public boolean isElective() {
    return elective;
  }

  public boolean isCarolinaCore() {
    return carolinaCore;
  }

  public ArrayList<String> getPreReqs() {
    return preReqs;
  }

  public String getSemester() {
    return semester;
  }

  public String getYear() {
    return year;
  }
}
