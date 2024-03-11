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

  private CourseList courseList;
  private UserList userList;
  private User user;
  private MajorList majorList;

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
  public Facade() {
    this.courseList = CourseList.getInstance();
    this.userList = UserList.getInstance();
    this.majorList = MajorList.getInstance();

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
    User loggedInUser = userList.getUserByLoginInfo(email, password);
    this.user = loggedInUser;
    return loggedInUser;
  }

  /**
   * Signs out the currently logged-in user and saves any changes made during the
   * session.
   * 
   * @author @Spillmag
   */
  public void signOut() {
    user = null;
    DataWriter.saveUsers(getUsers());
    DataWriter.saveCourses(getCourses());
    DataWriter.saveMajorMaps(getMajors());
  }

  /**
   * Signs up a new student.
   *
   * @param firstName The first name of the student.
   * @param lastName  The last name of the student.
   * @param email     The email of the student.
   * @param password  The password of the student.
   */
  public void signUpStudent(String firstName, String lastName, String email, String password) {
    userList.signUp(firstName, lastName, email, password, "STUDENT");
  }

  /**
   * Signs up a new administrator.
   *
   * @param firstName The first name of the administrator.
   * @param lastName  The last name of the administrator.
   * @param email     The email of the administrator.
   * @param password  The password of the administrator.
   */
  public void signUpAdmin(String firstName, String lastName, String email, String password) {
    userList.signUp(firstName, lastName, email, password, "ADMIN");
  }

  /**
   * Signs up a new advisor.
   *
   * @param firstName The first name of the advisor.
   * @param lastName  The last name of the advisor.
   * @param email     The email of the advisor.
   * @param password  The password of the advisor.
   */
  public void signUpAdvisor(String firstName, String lastName, String email, String password) {
    userList.signUp(firstName, lastName, email, password, "ADVISOR");
  }
  public void getMajorMap(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMajorMap'");
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
    System.out.println(course.toString());
    }
    System.out.println("Course with code " + courseCode + " not found.");
  }

  // Getters
  public CourseList getCourseList() {
    return courseList;
  }

  public UserList getUserList() {
    return userList;
  }

  public User getUser() {
    return user;
  }

  public MajorList getMajorList() {
    return majorList;
  }

  // GETTERS FOR THE SINGLETONS
  /**
   * Gets the list of courses from the CourseList singleton instance.
   * 
   * @return The list of courses.
   */
  public ArrayList<Course> getCourses() {
    return courseList.getCourses();
  }

  /**
   * Gets the list of users from the UserList singleton instance.
   * 
   * @return The list of users.
   */
  public ArrayList<User> getUsers() {
    return userList.getUsers();
  }

  /**
   * Gets the list of majors from the MajorList singleton instance.
   * 
   * @return The list of majors.
   */
  public ArrayList<MajorMap> getMajors() {
    return majorList.getMajors();
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
    if (user.getUserType().equals("STUDENT")) {
      return ((Student) user).getYear();
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
    if (user.getUserType().equals("STUDENT")) {
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
    if (user.getUserType().equals("STUDENT")) {
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
    if (user.getUserType().equals("STUDENT")) {
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
    if (user.getUserType().equals("STUDENT")) {
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
    if (user.getUserType().equals("STUDENT")) {
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
    if (user.getUserType().equals("STUDENT")) {
      return ((Student) user).getAdvisorNotes();
    } else {
      return null;
    }
  }

  /**
   * Gets the major of the logged-in student.
   * Returns null if the logged-in user is not a student.
   * 
   * @return The major of the logged-in student.
   */
  public String getStudentMajor() {
    if (user.getUserType().equals("STUDENT")) {
      return ((Student) user).getMajor();
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
    if (user.getUserType().equals("ADMIN")) {
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
    if (user.getUserType().equals("ADVISOR")) {
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
    if (user.getUserType().equals("ADVISOR")) {
      Advisor advisor = (Advisor) user;
      return advisor.getListOfFailingStudents();
    } else {
      return null;
    }
  }

  /**
   * Gets a course based on the given course code.
   *
   * @param code The course code to search for.
   * @return The course with the matching code, or null if not found.
   */
  public Course getCourseById(String code) {
    CourseList courseListInstance = CourseList.getInstance();
    return courseListInstance.getCourseById(code);
  }
}
