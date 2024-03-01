package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {

  private ArrayList<String> changesMade;

  /**
   * constructor
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
  public Course addCourse() {
    // admin adds a course to courselist? courses.json
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
  public void deleteCourse() {
  }

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
   * 
   * @author @Spillmag
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
