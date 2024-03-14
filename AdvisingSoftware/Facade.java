package AdvisingSoftware;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author Lia Zhao (zhaolia9)
 * 
 **/

public class Facade {

  private CourseList courseList;
  private UserList userList;
  private User user;
  private MajorList majorList;

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
    saveUsers();
    saveCourses();
    saveMajorMaps();
  }

  /**
   * Saves the list of users.
   */
  public void saveUsers() {
    DataWriter.saveUsers(getUsers());
  }

  /**
   * Saves the list of courses.
   */
  public void saveCourses() {
    DataWriter.saveCourses(getCourses());
  }

  /**
   * Saves the list of major maps.
   */
  public void saveMajorMaps() {
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

  /**
   * Retrieves the MajorMap object corresponding to the specified major name.
   * 
   * @param majorName The name of the major for which to retrieve the MajorMap.
   * @return The MajorMap object if found, or null if not found.
   */
  public MajorMap getMajorMap(String majorName) {
    MajorMap majorMap = majorList.getMajorByName(majorName);
    if (majorMap != null) {
      return majorMap;
    } else {
      System.out.println("Major map not found for " + majorName);
      return null;
    }
  }

  /**
   * Displays information about all the courses in the provided list.
   * 
   * @param courseList The list of courses to display.
   */
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

  /**
   * Displays information about the course with the specified course code.
   * 
   * @param courseCode The code of the course to display.
   */
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
  public ArrayList<UUID> getListOfAdvisees() {
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
  public ArrayList<UUID> getListOfFailingStudents() {
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

  /**
   * Gets a student user by ID if the logged-in user is an advisor.
   *
   * @param studentId The ID of the student to retrieve.
   * @return The student user if found, or null if not found or if the logged-in
   *         user is not an advisor.
   */
  public Student getStudentByAdvisor(UUID studentId) {
    if (user.getUserType().equals("ADVISOR")) {
      Advisor advisor = (Advisor) user;
      ArrayList<UUID> adviseeIds = advisor.getListOfAdvisees();
      if (adviseeIds.contains(studentId)) {
        User studentUser = userList.getUserbyUSCID(studentId);
        if (studentUser != null && studentUser.getUserType().equals("STUDENT")) {
          return (Student) studentUser;
        }
      }
    }
    return null;
  }

  public void addNoteToStudentAdvisor(UUID studentId, String noteContent) {
    Student student = getStudentByAdvisor(studentId);
    if (student != null) {
      Note newNote = new Note(noteContent, new Date());
      student.getAdvisorNotes().add(newNote);
    }

  }

  /**
   * Adds a student to the list of advisees for the advisor.
   * 
   * @param advisorId The ID of the advisor.
   * @param studentId The ID of the student to add.
   * @return True if the student is successfully added, false if the student is
   *         already in the list of advisees or if the logged-in user is not an
   *         advisor.
   */
  public boolean addStudentToListOfAdvisees(UUID advisorId, UUID studentId) {
    if (user.getUserType().equals("ADVISOR")) {
      Advisor advisor = (Advisor) user;
      if (!advisor.getListOfAdvisees().contains(studentId)) {
        advisor.getListOfAdvisees().add(studentId);
        return true;
      }
    }
    return false;
  }

  /**
   * Gets the ID of a user by their first name and last name.
   * 
   * @param firstName The first name of the user.
   * @param lastName  The last name of the user.
   * @return The ID of the user if found, or null if not found.
   */
  public UUID getUserIdByName(String firstName, String lastName) {
    return userList.getIDByName(firstName, lastName);
  }
  /**
 * Gets the ID of the currently logged-in user.
 * 
 * @return The ID of the currently logged-in user if available, or null if no user is logged in.
 */
public UUID getCurrentUserId() {
  if (user != null) {
      return user.getID();
  } else {
      return null;
  }
}
}
