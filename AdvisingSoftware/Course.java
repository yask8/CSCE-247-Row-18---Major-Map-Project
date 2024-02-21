package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Lia Zhao (zhaolia9)
 * - id: UUID()
 * - name: String
 * - code: String
 * - description: String
 * - creditHours: int
 * - subject: String
 * - passGrade: Char
 * - elective: boolean
 * - carolinaCore: boolean
 * - preReqs: ArrayList <Course>
 * - semester: String
 * - year: String
 * + Course(UUID id, String name, String code, String description, int creditHours, string subject, char passGrade, Boolean elective, Boolean carolinaCore, ArrayList <Course> prereqs)
 * + Course(String name, String code, String description, int creditHours, string subject, char passGrade, Boolean elective, Boolean carolinaCore, ArrayList <Course> prereqs)
 * + editCourse(String name, String code, String description, int creditHours, string subject, char passGrade, Boolean elective, Boolean carolinaCore, ArrayList <Course> prereqs): Course
 * + deleteCourse(String code)
 */
public class Course {

  private UUID id;
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
   * @param id UUID
   * @param name String
   * @param code String
   * @param description String
   * @param creditHours int
   * @param subject String
   * @param passGrade char
   * @param elective boolean
   * @param carolinaCore boolean
   * @param preReqs ArrayList<Course>
   */
  public Course(
    UUID id,
    String name,
    String code,
    String description,
    int creditHours,
    String subject,
    char passGrade,
    boolean elective,
    boolean carolinaCore,
    ArrayList<Course> preReqs
  ) {
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
  }

  /**
   *
   * @param name String
   * @param code String
   * @param description String
   * @param creditHours int
   * @param subject String
   * @param passGrade char
   * @param elective boolean
   * @param carolinaCore boolean
   * @param preReqs ArrayList<Course>
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
    ArrayList<Course> preReqs
  ) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.code = code;
    this.description = description;
    this.creditHours = creditHours;
    this.subject = subject;
    this.passGrade = passGrade;
    this.elective = elective;
    this.carolinaCore = carolinaCore;
    this.preReqs = preReqs;
  }

  /**
   *
   * @return Course
   */
  public Course editCourse() {
    Course course = new Course(
      name,
      code,
      description,
      creditHours,
      subject,
      passGrade,
      elective,
      carolinaCore,
      preReqs
    );
    return course;
  }

  public void deleteCourse() {}
}
