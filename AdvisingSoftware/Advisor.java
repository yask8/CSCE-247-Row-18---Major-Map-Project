package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {

  private ArrayList<UUID> listOfAdvisees;
  private ArrayList<UUID> listOfFailingStudents;


  /**
   * Advisor Constructor
   *
   * @param listOfAdvisees        List of advisors advisees
   * @param listOfFailingStudents List of advisors advisees at risk of failing
   */
  public Advisor(
      String firstName,
      String lastName,
      String email,
      UUID uscID,
      String password,
      String userType,
      ArrayList<UUID> listOfAdvisees,
      ArrayList<UUID> listOfFailingStudents) {
    super(firstName, lastName, email, uscID, password, userType);
    this.listOfAdvisees = listOfAdvisees;
    this.listOfFailingStudents = listOfFailingStudents;
      }

  /**
   * Students under the advisor at risk of failing
   *
   * @param listOfFailingStudents List of the students
   * @return ArrayList of the students at risk of failure
   */
  public ArrayList<User> riskOfFailure(
      ArrayList<User> listOfFailingStudents) {
    return null;
  }

  /**
   * Allows the advisor to view a student's profile
   *
   * @return The student profile
   */
  public String viewStudentProfile() {
    return "";
  }
  /**
   * Allows advisor to add a student to their list of advisees
   */
  public void addStudent (UUID uuid) {
     listOfAdvisees.add(uuid);
  }
  /**
   * Allows advisor to remove a student from their list of advisees
   *
   * @return Updated ArrayList of the advisors advisees
   */
  public ArrayList<Student> removeStudent() {
    return null;
  }

  /**
   * Allows advisor to search for a student
   *
   * @param uscID uscID for the specific student
   * @return returns Student instance
   */
  public Student studentLookUp(String uscID) {
    return null;
  }

  /**
   * Allows the advisor to add a note to an advisee
   *
   * @param student specific student to add a note to
   * @param note    note given
   */
  public void addNote(Student student, String note) {
  }

  /**
   * Allows the advisor to view their list of advisees
   *
   * @param listOfAdvisees list of advisees for the advisor
   * @return List of students
   */
  public String viewStudentList(ArrayList<Student> listOfAdvisees) {
    return "";
  }

  /**
   * Allows the advisor to view their list of failing advisees
   *
   * @param listOfFailingStudents Advisors list of failing students
   * @return list of failing students
   */
  public String viewFailingStudentList(
      ArrayList<Student> listOfFailingStudents) {
    return "";
  }

  /**
   * Allows advisor to see if a student is failing
   *
   * @param gpa    GPA of the student
   * @param minGPA minumum GPA requirement for passing
   * @return boolean of to recognize pass/fail
   */
  public boolean checkStudentFailStatus(double gpa, double minGPA) {
    if(gpa<minGPA){
      System.out.println("Failing");
      
    }
    else{
      System.out.println("Passing");
    }
    return true;
  }

  /**
   * Allows advisor to add a student to their list of advisees at risk of failure
   *
   * @return Updated arraylist of advisees at risk of failure
   */
  public ArrayList<Student> addStudentRiskOfFailure() {
    return null;
  }
   /**
   * Getter for listOfAdvisees
   *
   * @return ArrayList of advisees under the advisor
   */
  public ArrayList<UUID> getListOfAdvisees() {
    return listOfAdvisees;
  }

  /**
   * Getter for listOfFailingStudents
   *
   * @return ArrayList of failing students under the advisor
   */
  public ArrayList<UUID> getListOfFailingStudents() {
    return listOfFailingStudents;
  }


  /**
   * To string to view user details
   * 
   * @author @Spillmag
   */
  public String toString() {
    return "\n********* ADVISOR PROFILE *********\n" +
        super.toString() +
        "\nList of Advisees: " + listOfAdvisees +
        "\nList of Failing Students: " + listOfFailingStudents;
  }
}
