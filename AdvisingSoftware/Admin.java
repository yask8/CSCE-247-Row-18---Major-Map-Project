package AdvisingSoftware;

/**
 * Class that creates an Admin User
 * @author Garrett Spillman (@Spillmag), Lia Zhao (@zhaolia9), Stephon Johnson (@stephonj), Yasmine Kennedy (@yask8), Owen Shumate (@oshumate)
 */
import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {

  /**
   * Attributes
   */
  private ArrayList<String> changesMade;

  /**
   * constructor
   *
   * @param firstName   String Admin's first name
   * @param lastName    String Admin's last name
   * @param email       String Admin's email
   * @param uscID       UUID Admin's uscID
   * @param password    String Admin's password
   * @param userType    String userType
   * @param changesMade ArrayList<String> changes made by Admin
   */
  public Admin(
      String firstName,
      String lastName,
      String email,
      UUID uscID,
      String password,
      String userType,
      ArrayList<String> changesMade) {
    super(firstName, lastName, email, uscID, password, userType);
    this.changesMade = changesMade;
  }

/**
 * Allows admin to add a course
 *
 * @return the Course instance
 */
public boolean addCourse(String name, String code, String description, int creditHours, String subject,
    char passGrade, boolean elective, boolean carolinaCore, ArrayList<String> prereqs, String year, String semester) {
  CourseList courseList = CourseList.getInstance();
  courseList.addCourse(name, code, description, creditHours, subject, passGrade, elective, carolinaCore, prereqs,
      year, semester);
  changesMade.add("added course: " + code);
  return true;
}

  /**
   * Edits the details of a course identified by its code.
   * 
   * @param code            The code of the course to be edited.
   * @param newName         The new name for the course.
   * @param newDescription  The new description for the course.
   * @param newCreditHours  The new credit hours for the course.
   * @param newSubject      The new subject for the course.
   * @param newPassGrade    The new passing grade for the course.
   * @param newElective     Indicates if the course is elective.
   * @param newCarolinaCore Indicates if the course is part of Carolina Core.
   * @param newPrereqs      The new prerequisites for the course.
   * @param newYear         The new default year for the course.
   * @param newSemester     The new default semester for the course.
   * @return true if the course is successfully edited, false otherwise.
   */
  public boolean editCourse(String code, String newName, String newDescription, int newCreditHours, String newSubject,
      char newPassGrade, boolean newElective, boolean newCarolinaCore, ArrayList<String> newPrereqs, String newYear,
      String newSemester) {
    CourseList courseList = CourseList.getInstance();
    Course courseToEdit = courseList.getCourse(code);
    if (courseToEdit != null) {
      courseList.removeCourse(code);

      courseToEdit.setName(newName);
      courseToEdit.setDescription(newDescription);
      courseToEdit.setCreditHours(newCreditHours);
      courseToEdit.setSubject(newSubject);
      courseToEdit.setPassGrade(newPassGrade);
      courseToEdit.setElective(newElective);
      courseToEdit.setCarolinaCore(newCarolinaCore);
      courseToEdit.setPrereqs(newPrereqs);
      courseToEdit.setYear(newYear);
      courseToEdit.setSemester(newSemester);

      courseList.addCourseObject(courseToEdit);

      changesMade.add("edited course: " + code);
      return true;
    } else {
      System.out.println("Course with code " + code + " not found.");
      return false;
    }
  }

  /**
   * Deletes a course identified by its code.
   * 
   * @param code The code of the course to be deleted.
   * @return true if the course is successfully deleted, false otherwise.
   */
  public boolean deleteCourse(String code) {
    CourseList courseList = CourseList.getInstance();
    boolean isDeleted = courseList.removeCourse(code);
    if (isDeleted) {
      changesMade.add("deleted course: " + code);
      return true;
    } else {
      System.out.println("Course with code " + code + " not found.");
      return false;
    }
  }

  /**
   * Prints the profile of a student identified by their USC ID.
   * 
   * @param uscId The USC ID of the student.
   */
  public void printStudentProfile(UUID uscId) {
    User student = UserList.getInstance().getUserbyUSCID(uscId);
    if (student != null && student instanceof Student) {
      System.out.println(student.toString());
    } else {
      System.out.println("Student with ID " + uscId + " not found.");
    }
  }

  /**
   * Getter for changesMade
   *
   * @return ArrayList of changes made by the admin
   */
  public ArrayList<String> getChangesMade() {
    return changesMade;
  }

  /**
   * To string to view user details
   * 
   * @return the string format of the ADMIN User Profile
   */
  public String toString() {
    String changesMadeString = "";
    if (changesMade != null && !changesMade.isEmpty()) {
      for (String change : changesMade) {
        changesMadeString += "\n- " + change;
      }
    } else {
      changesMadeString = "None";
    }
    return ("\n********* ADMIN PROFILE *********\n" +
        super.toString() +
        "\n********* Change log *********\n" +
        "Changes Made:" +
        changesMadeString);
  }
}
