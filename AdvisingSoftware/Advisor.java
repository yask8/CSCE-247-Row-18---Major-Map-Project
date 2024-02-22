package AdvisingSoftware;

import java.util.ArrayList;

public class Advisor extends User{

    private ArrayList<Student> listOfAdvisees;
    private ArrayList<Student> listOfFailingStudents;

    /**
     * Advisor Constructor
     * @param listOfAdvisees List of advisors advisees
     * @param listOfFailingStudents List of advisors advisees at risk of failing
     */
    public Advisor(ArrayList<Student> listOfAdvisees, ArrayList<Student> listOfFailingStudents){
        this.listOfAdvisees = listOfAdvisees;
        this.listOfFailingStudents = listOfFailingStudents;
    }

    /**
     * Students under the advisor at risk of failing
     * @param listOfFailingStudents List of the students
     * @return ArrayList of the students at risk of failure
     */
    ArrayList<Student> riskOfFailure(ArrayList<Student> listOfFailingStudents){

    }

    /**
     * Allows the advisor to view a student's profile
     * @return The student profile
     */
    String viewStudentProfile(){

    }

    /**
     * Shows the course planner
     * @return returns Course instance
     */
    Course coursePlanner(){

    }

    /**
     * Allows advisor to remove a student from their list of advisees
     * @return Updated ArrayList of the advisors advisees
     */
    ArrayList<Student> removeStudent(){

    }

    /**
     * Allows advisor to search for a student
     * @param uscID uscID for the specific student
     * @return returns Student instance
     */
    Student studentLookUp(String uscID){

    }

    /**
     * Allows the advisor to add a note to an advisee
     * @param student specific student to add a note to
     * @param note note given
     */
    void addNote(Student student, String note){

    }

    /**
     * Allows the advisor to view their list of advisees
     * @param listOfAdvisees list of advisees for the advisor
     * @return List of students
     */
    String viewStudentList(ArrayList<Student> listOfAdvisees){

    }

    /**
     * Allows the advisor to view their list of failing advisees
     * @param listOfFailingStudents Advisors list of failing students
     * @return list of failing students
     */
    String viewFailingStudentList(ArrayList<Student> listOfFailingStudents){
        
    }

    /**
     * Allows advisor to see if a student is failing
     * @param gpa GPA of the student
     * @param minGPA minumum GPA requirement for passing
     * @return boolean of to recognize pass/fail
     */
    boolean checkStudentFailStatus(double gpa, double minGPA){

    }

    /**
     * Allows advisor to add a student to their list of advisees at risk of failure
     * @return Updated arraylist of advisees at risk of failure
     */
    ArrayList<Student> addStudentRiskOfFailure(){

    }
}
