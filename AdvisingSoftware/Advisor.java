package AdvisingSoftware;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Advisor extends User {

  private ArrayList<Student> listOfAdvisees;
  private ArrayList<Student> listOfFailingStudents;
  private ArrayList<Note> listOfAdvisorNotes;

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
    ArrayList<Student> listOfAdvisees,
    ArrayList<Student> listOfFailingStudents,
    ArrayList<Note> listOfAdvisorNotes
  ) {
    super(firstName, lastName, email, uscID, password, userType);
    this.listOfAdvisees = listOfAdvisees;
    this.listOfFailingStudents = listOfFailingStudents;
    this.listOfAdvisorNotes = listOfAdvisorNotes;
  }

  /**
   * Students under the advisor at risk of failing
   *
   * @param listOfFailingStudents List of the students
   * @return ArrayList of the students at risk of failure
   */
  public ArrayList<Student> riskOfFailure(
    ArrayList<Student> listOfFailingStudents
  ) {
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
   * Shows the course planner
   *
   * @return returns Course instance
   */
  public Course coursePlanner() {
    return null;
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
  public void addNote(Student student, String note) {}

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
    ArrayList<Student> listOfFailingStudents
  ) {
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
  public String toString() {
    return
    "\n********* ADVISOR PROFILE *********\n" +
    super.toString() +
    "\nList of Advisees: " + listOfAdvisees +
    "\nList of Failing Students: " + listOfFailingStudents +
    "\nList of Advisor Notes: " + listOfAdvisorNotes;
  }
}
