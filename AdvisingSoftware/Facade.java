package AdvisingSoftware;

import java.util.ArrayList;

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
  private MajorMap majorMap;

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
      MajorMap majorMap) {
    this.courseList = courseList.getCourses();
    this.course = course;
    UserList userList = UserList.getInstance();
    this.userList = userList.getUsers();
    this.majorMap = majorMap;
  }

  public Facade() {

  }

  /**
   * Logs in a user with the specified email and password.
   * If the user list is not already loaded, it loads the users using data loader
   * Loads Course and Majors as well
   * 
   * Need to edit this method
   * 
   * @author @Spillmag
   *
   * @param email    The email of the user.
   * @param password The password of the user.
   * @return The logged-in user if successful.
   */
  public User login(String email, String password) {
    loadUserList();
    loadCourseList();
    loadMajorList();
    UserList userList = UserList.getInstance();

    User loggedInUser = userList.getUserByLoginInfo(email, password);

    this.user = loggedInUser;

    return loggedInUser;
  }

  private void loadCourseList() {
    CourseList courseListInstance = CourseList.getInstance();
    this.courseList = courseListInstance.getCourses();
  }

  private void loadMajorList() {
    MajorList majorListInstance = MajorList.getInstance();
    this.majorList = majorListInstance.getMajors();
  }

  private void loadUserList() {
    UserList courseListInstance = UserList.getInstance();
    this.userList = courseListInstance.getUsers();
  }

  /**
   * Signs out the currently logged-in user and saves any changes made during the
   * session.
   * 
   * @author @Spillmag
   */
  public void signOut() {
    user = null;
    DataWriter.saveUsers(getUserList());
  }

  /**
   * 
   * Signs up a new user
   * Checks if the email already exists
   * If the email already exists the sign-up fails
   * 
   * @author @Spillmag
   * 
   * @param firstName The first name of the user.
   * @param lastName  The last name of the user.
   * @param email     The email of the user.
   * @param password  The password of the user.
   * @param userType  The type of user ('STUDENT', 'ADMIN', or 'ADVISOR').
   */
  public void signUp(String firstName, String lastName, String email, String password, String userType) {
    loadUserList();
    UserList userList = UserList.getInstance();
    userList.signUp(firstName, lastName, email, password, userType);
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

  public void displayMap(String major) {
    if (majorMap == null) {
      majorMap = getMajorMap();
      if (majorMap == null) {
          System.out.println("User has not declared major.");
          return;
      }
  }
  majorMap.displayMajorMap(major);
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

  public MajorMap getMajorMap() {
    return majorMap;
  }

  public void displayAllCourses(ArrayList<Course> courseList) {
    if (courseList != null && !courseList.isEmpty()) {
      System.out.println("Courses Available:");
      for (Course course : courseList) {
        System.out.println(course.toString());
      }
    } else {
      System.out.println("No courses available.");
    }
  }

    public void showCourseByCode(String courseCode) {
      CourseList courseListInstance = CourseList.getInstance();
      Course course = courseListInstance.getCourse(courseCode);

      if (course != null) {
          System.out.println("Course Details for Code: " + courseCode);
          System.out.println("Name: " + course.getName());
          System.out.println("Code: " + course.getCode());
          System.out.println("Description: " + course.getDescription());
          System.out.println("Credit Hours: " + course.getCreditHours());
          System.out.println("Subject: " + course.getSubject());
          System.out.println("Passing Grade: " + course.getPassGrade());
          System.out.println("Elective: " + (course.isElective() ? "Yes" : "No"));
          System.out.println("Carolina Core: " + (course.isCarolinaCore() ? "Yes" : "No"));
          System.out.println("Prerequisites: " + course.getPreReqs());
      } else {
          System.out.println("Course with code " + courseCode + " not found.");
      }
  }

  // GETTER FOR USER INSTANCES
  /**
   * Gets the year of the logged-in student.
   *
   * Returns null if the logged-in user is not a student.
   * 
   * @return The year of the logged-in student.
   */
  public String getStudentYear() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getYear();
    } else {
      return null;
    }
  }

  /**
   * Gets the major of the logged-in student.
   * 
   * Returns null if the logged-in user is not a student.
   * 
   * @return The major of the logged-in student.
   */
  public String getStudentMajor() {
    if(user.getUserType().equals("STUDENT")) {
      return ((Student) user).getMajor();
    } else {
      return null;
    }
  }

  /**
   * Gets the credit hours of the logged-in student.
   * 
   * Returns -1 if the logged-in user is not a student.
   * 
   * @return The credit hours of the logged-in student.
   */
  public int getStudentCreditHours() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getCreditHours();
    } else {
      return -1;
    }
  }

  /**
   * Gets the completed courses of the logged-in student.
   * 
   * Returns null if the logged-in user is not a student.
   * 
   * @return The completed courses of the logged-in student.
   */
  public ArrayList<Grades> getStudentCompletedCourses() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getCompletedCourses();
    } else {
      return null;
    }
  }

  /**
   * Gets the GPA of the logged-in student.
   * 
   * Returns -1.0 if the logged-in user is not a student.
   * 
   * @return The GPA of the logged-in student.
   */
  public double getStudentGPA() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getGpa();
    } else {
      return -1.0;
    }
  }

  /**
   * Gets the course planner of the logged-in student.
   *
   * Returns null if the logged-in user is not a student.
   * 
   * @return The course planner of the logged-in student.
   */
  public CoursePlanner getStudentCoursePlanner() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getCoursePlanner();
    } else {
      return null;
    }
  }

  /**
   * Gets the degree progress of the logged-in student.
   * 
   * Returns null if the logged-in user is not a student.
   * 
   * @return The degree progress of the logged-in student.
   */
  public DegreeProgress getStudentDegreeProgress() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getDegreeProgress();
    } else {
      return null;
    }
  }

  /**
   * Gets the advisor notes of the logged-in student.
   * 
   * Returns null if the logged-in user is not a student.
   * 
   * @return The advisor notes of the logged-in student.
   */
  public ArrayList<Note> getStudentAdvisorNotes() {
    if(user.getUserType().equals("STUDENT")){
      return ((Student) user).getAdvisorNotes();
    } else {
      return null;
    }
  }
  /**
   * Gets the changes made list by a logged in Admin.
   * 
   * Returns null if the logged-in user is not a Admin.
   * 
   * @return the changes made list by a logged in Admin.
   */
  public ArrayList<String> getAdminChangesMade() {
    if(user.getUserType().equals("ADMIN")){
      return ((Admin) user).getChangesMade();
    } else {
      return null;
    }
  }

  /**
   * Gets the list of advisees for the advisor.
   * 
   * @return ArrayList of advisees.
   */
  public ArrayList<User> getListOfAdvisees() {
    if(user.getUserType().equals("ADVISOR")){
      Advisor advisor = (Advisor) user;
      return advisor.getListOfAdvisees();
    } else {
      return null;
    }
  }

  /**
   * Gets the list of failing students for the advisor.
   * 
   * @return ArrayList of failing students.
   */
  public ArrayList<User> getListOfFailingStudents() {
    if(user.getUserType().equals("ADVISOR")){
      Advisor advisor = (Advisor) user;
      return advisor.getListOfFailingStudents();
    } else {
      return null;
    }
  }
}
