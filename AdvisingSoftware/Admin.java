package AdvisingSoftware;
/**
 * Class that creates an Admin User
 * @author Garrett Spillman (@Spillmag), Lia Zhao (@zhaolia9), Stephon Johnson (@stephonj), Yasmine Kennedy (@yask8)
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
   * @param firstName String Admin's first name
   * @param lastName String Admin's last name
   * @param email String Admin's email
   * @param uscID UUID Admin's uscID
   * @param password String Admin's password
   * @param userType String userType
   * @param changesMade ArrayList<String> changes made by Admin
   */
  public Admin(
    String firstName,
    String lastName,
    String email,
    UUID uscID,
    String password,
    String userType,
    ArrayList<String> changesMade
  ) {
    super(firstName, lastName, email, uscID, password, userType);
    this.changesMade = changesMade;
  }

  /**
   * Allows admin to add a course
   *
   * @return the Course instance
   */
  public Course addCourse() {
    return null;
  }

  /**
   * Allows admin to edit a course
   *
   * @return the Course instance
   */
  public Course editCourse() {
    return null;
  }

  /**
   * Allows admin to delete a course
   */
  public void deleteCourse() {}

  /**
   * Allows admin to search for a student
   *
   * @return the Student instance
   */
  public Student studentLookUp() {
    return null;
  }

  /**
   * Allows an admin to view the details of a student
   *
   * @return ArrayList of student details
   */
  public ArrayList<Student> viewStudentProfile() {
    return null;
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
    return (
      "\n********* ADMIN PROFILE *********\n" +
      super.toString() +
      "\n********* Change log *********\n" +
      "Changes Made:" +
      changesMadeString
    );
  }
}
