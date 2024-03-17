package AdvisingSoftware;

import java.util.ArrayList;

/**
 * Class that creates a course
 * @author Garrett Spillman (@Spillmag), Lia Zhao (@zhaolia9), Stephon Johnson (@stephonj), Yasmine Kennedy (@yask8)
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
  /**
   * Attributes
   */
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
   * Course Constructor
   * @param id           UUID
   * @param name         name of course
   * @param code         the course code (CMS, PR, etc)
   * @param description  the description of the course
   * @param creditHours  course credit hours
   * @param subject      course sibject (MATH, CSCE, etc)
   * @param passGrade    course required passing grade
   * @param elective     is the course an elective
   * @param carolinaCore is the course a CarolinaCore
   * @param preReqs      list of pre-required courses before taking the course
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
   * Course overloaded constructor
   * @param name         name of course
   * @param code         the course code (CMS, PR, etc)
   * @param description  the description of course
   * @param creditHours  the course credit hours
   * @param subject      the subject of the course (MATH, CSCE, etc)
   * @param passGrade    the passing grade for the course
   * @param elective     is the course an elective
   * @param carolinaCore is the course an carolina core requirement
   * @param preReqs      list of pre-required courses before taking the course
   */
  public Course(String name, String code, String description, int creditHours,
      String subject, char passGrade, boolean elective, boolean carolinaCore,
      ArrayList<String> preReqs, String year, String semester) {
    this.id = name.split("\\s+")[0] + name.split("\\s+")[1].replaceAll("\\s+", "");
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
   * Allows course to be edited
   * @return edited course
   */
  public Course editCourse(String id) {
    return new Course(id, name, code, description, creditHours, subject, passGrade,
        elective, carolinaCore, preReqs, year, semester);
  }
  /**
   * Deletes the course
   */
  public void deleteCourse() {
  }

  /**
   * To string to view user details
   * @return the string format of course info
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
  /**
   * Gets the id of the course
   * @return the id
   */
  public String getID() {
    return id;
  }
  /**
   * Gets the name of the course
   * @return the name 
   */
  public String getName() {
    return name;
  }
  /**
   * Gets the code of the course
   * @return the code
   */
  public String getCode() {
    return code;
  }
  /**
   * Gets the description of the course
   * @return the description
   */
  public String getDescription() {
    return description;
  }
  /**
   * Gets the course credit hours
   * @return the credit hours
   */
  public int getCreditHours() {
    return creditHours;
  }
  /**
   * Gets the course subject
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }
  /**
   * Gets the passing grade for course
   * @return the passing grade
   */
  public char getPassGrade() {
    return passGrade;
  }
  /**
   * Checks if course is elective
   * @return return true or false
   */
  public boolean isElective() {
    return elective;
  }
  /**
   * Checks if course is carolina core
   * @return true or false
   */
  public boolean isCarolinaCore() {
    return carolinaCore;
  }
  /**
   * Gets the list of prerequired course
   * @return the prerequired courses
   */
  public ArrayList<String> getPreReqs() {
    return preReqs;
  }
  /**
   * Gets the semester
   * @return the semester
   */
  public String getSemester() {
    return semester;
  }
  /**
   * Gets the year
   * @return the year
   */
  public String getYear() {
    return year;
  }
}
