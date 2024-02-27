package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Lia Zhao (zhaolia9)
 *         - courseList: ArrayList <Course>
 *         - course: Course
 *         - userList: ArrayList <User>
 *         - majorList ArrayList <MajorMap>
 *         - degreeProgress: DegreeProgress
 *         - coursePlan: CoursePlanner
 *         - majorMap: MajorMap
 *         - gradReq: GraduationRequirements
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

  /*
   * + Facade(CourseList courseList, Course course, UserList userList, User user,
   * degreeProgress degreeProgress, MajorMap majorMap, GraduationRequirements
   * gradReq)
   * + login(String email, String password): User
   * + signOut(): void
   * + checkDegreeProgress(String uscID): DegreeProgress
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
  public Facade(
      CourseList courseList,
      Course course,
      User user,
      DegreeProgress degreeProgress,
      MajorMap majorMap,
      GraduationRequirements gradReq) {
    this.courseList = courseList.getCourses();
    this.course = course;
    UserList userListInstance = UserList.getInstance();
    this.userList = userListInstance.getUsers();
    this.degreeProgress = degreeProgress;
    this.majorMap = majorMap;
    this.gradReq = gradReq;
  }

  public Facade() {

  }

  /**
   * Logs in a user with the specified email and password.
   * If the user list is not already loaded, it loads the users using data loader
   * 
   * @author @Spillmag
   *
   * @param email    The email of the user.
   * @param password The password of the user.
   * @return The logged-in user if successful.
   */
  public User login(String email, String password) {
    UserList userList = UserList.getInstance();
    return userList.getUser(email, password);
  }

  // Works for now might need to rework it becuase of overwriting
  public void signOut() {
    user = null;
    //ArrayList<User> userList = UserList.getInstance().getUsers();
    //DataWriter.saveUsers(userList);
  }

  public void signUp(String firstName, String lastName, String email, String password, String userType) {
    UserList userList = UserList.getInstance();
    UUID uscID = UUID.randomUUID();

    if (userType.equals("STUDENT")) {
      userList.addStudent(firstName, lastName, email, uscID, password, userType, null, null);
    } else if (userType.equals("ADMIN")) {
      userList.addAdmin(firstName, lastName, email, uscID, password, userType);
    } else if (userType.equals("ADVISOR")) {
      userList.addAdvisor(firstName, lastName, email, uscID, password, userType);
    } else {
      System.out.println("Invalid user type. Please specify either 'STUDENT', 'ADMIN', or 'ADVISOR'.");
      return;
    }

    User loggedInUser = userList.getUser(email, password);

    if (loggedInUser != null) {
      System.out.println("Sign up successful! Logged in as:");
      System.out.println(loggedInUser.toString());
    } else {
      System.out.println("Sign up failed. Unable to log in.");
    }
  }

  public DegreeProgress checkDegreeProgress(String uscID) {
    return degreeProgress;
  }

  public CoursePlanner checkCoursePlanner(String uscID) {
    return coursePlan;
  }

  public MajorMap checkMajorMap(String major) {
    return majorMap;
  }

  public User checkProfile(String uscID) {
    return user;
  }

  public Course chooseCourse(String UUID) {
    return course;
  }

  public boolean switchMajor(String uscID, String major) {
    return true;
  }

  public String viewCourse(ArrayList<Course> courseList, String UUID) {
    return "";
  }

  protected boolean removeProfile(String uscID) {
    return true;
  }

  protected Student searchStudentList(String uscID) {
    return null;
  }

  protected void moveStudentToAnotherList(String uscID, String advisorID) {
  }

  protected ArrayList<Student> modifyStudentList() {
    return new ArrayList<Student>();
  }

  protected void modifyStudentGrades(
      User user,
      DegreeProgress degreeProgress) {
  }

  // Getters
  public ArrayList<Course> getCourseList() {
    return courseList;
  }

  public Course getCourse() {
    return course;
  }

  public ArrayList<User> getUserList() {
    return userList;
  }

  public User getUser() {
    return user;
  }

  public ArrayList<MajorMap> getMajorList() {
    return majorList;
  }

  public DegreeProgress getDegreeProgress() {
    return degreeProgress;
  }

  public CoursePlanner getCoursePlan() {
    return coursePlan;
  }

  public MajorMap getMajorMap() {
    return majorMap;
  }

  public GraduationRequirements getGradReq() {
    return gradReq;
  }

}
