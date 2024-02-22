package AdvisingSoftware;

import java.util.ArrayList;

public class Admin extends User {

  /**
   * Private constructor
   */
  private Admin(
    String firstName,
    String lastName,
    String email,
    String uscID,
    String password
  ) {
    super(firstName, lastName, email, uscID, password);
  }

  /**
   * Allows admin to add a course
   * @return the Course instance
   */
  public Course addCourse() {}

  /**
   * Allows admin to edit a course
   * @return the Course instance
   */
  public Course editCourse() {}

  /**
   * Allows admin to delete a course
   */
  public void deleteCourse() {}

  /**
   * Allows admin to search for a student
   * @return the Student instance
   */
  public Student studentLookUp() {}

  /**
   * Allows an admin to view the details of a student
   * @return ArrayList of student details
   */
  public ArrayList<Student> viewStudentProfile() {}
}
