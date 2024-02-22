package AdvisingSoftware;

import java.util.ArrayList;

/**
 * @author Lia Zhao (zhaolia9)
 * - courseList: ArrayList <Course>
 * - course: Course
 * - userList: ArrayList <User>
 * - majorList ArrayList <MajorMap>
 * - degreeProgress: DegreeProgress
 * - coursePlan: CoursePlanner
 * - majorMap: MajorMap
 * - gradReq: GraduationRequirements
 */

public class Facade {

  private ArrayList<Course> courseList;
  private Course course;
  private ArrayList<User> userList;
  private User user;
  private ArrayList<MajorMap> majorList;
  private DegreeProgress degreeProgress;
  private CoursePlanner coursePlan;
  private MajorMap majorMap;
  private GraduationRequirements gradReq;

  /* + Facade(CourseList courseList, Course course, UserList userList, User user, degreeProgress degreeProgress, MajorMap majorMap, GraduationRequirements gradReq)
   * + login(String email, String password): User
   * + signOut(): void
   * + checkDegreeProgress(String uscID): DegreePlanner
   * + checkCoursePlanner(String uscID): CoursePlanner
   * + checkMajorMap(String major): MajorMap
   * + checkProfile(String uscID): User
   * + chooseCourse(String UUID): Course
   * + removeCourse(String UUID): boolean
   * + switchMajor(String uscID, String Major):boolean
   * + viewCourse(Arraylist <course> courseList , String UUID) : String
   * # removeProfile(String uscID): boolean
   * # searchStudentList(String uscID): Student
   * # moveStudentToAnotherList(String uscID, String advisorID): void
   * # modifyStudentList(): ArrayList<Student>
   * # modifyStudentGrades(User user, DegreeProgress degreeProgress): void
   */
  //public Facade() {}

  public Facade(
    CourseList courseList,
    Course course,
    UserList userList,
    User user,
    degreeProgress degreeProgress,
    MajorMap majorMap,
    GraduationRequirements gradReq
  ) {
    this.courseList = courseList.getCourses();
    this.course = course;
    this.user = user;
    this.degreeProgress = degreeProgress;
    this.majorMap = majorMap;
    this.gradReq = gradReq;
  }

  public User login() {}

  public void signOut() {}

  public DegreePlanner checkDegreeProgress(String uscID) {}

  public CoursePlanner checkCoursePlanner(String uscID) {}

  public MajorMap checkMajorMap(String major) {}

  public User checkProfile(String uscID) {}

  public Course chooseCourse(String UUID) {}

  public boolean switchMajor(String uscID, String major) {}

  public String viewCourse(ArrayList<Course> courseList, String UUID) {}

  protected boolean removeProfile(String uscID) {}

  protected Student searchStudentList(String uscID) {}

  protected void moveStudentToAnotherList(String uscID, String advisorID) {}

  protected ArrayList<Student> modifyStudentList() {}

  protected void modifyStudentGrades(
    User user,
    DegreeProgress degreeProgress
  ) {}
}
